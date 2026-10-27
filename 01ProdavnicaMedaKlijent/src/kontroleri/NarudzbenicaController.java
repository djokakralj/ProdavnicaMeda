/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Kupac;
import domen.Narudzbenica;
import domen.Prodavac;
import domen.StavkaNarudzbenice;
import domen.TeglaMeda;
import forme.FormaMod;
import static forme.FormaMod.DETALJI;
import static forme.FormaMod.DODAJ;
import static forme.FormaMod.PROMENI;
import forme.NarudzbenicaForma;
import forme.model.ModelTabeleStavkeNarudzbenice;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class NarudzbenicaController {

    NarudzbenicaForma forma;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public NarudzbenicaController() {
    }

    public NarudzbenicaController(NarudzbenicaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu(FormaMod mod) {
        try {
            pripremiFormu(mod);
            forma.setVisible(true);
            if (mod == FormaMod.DODAJ) {
                JOptionPane.showMessageDialog(forma, "Sistem je kreirao narudzbenicu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            if (mod == FormaMod.DODAJ) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da kreira narudzbenicu", "GRESKA", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje narudzbenicu", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
            Logger.getLogger(NarudzbenicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pripremiFormu(FormaMod mod) throws Exception {
        List<Prodavac> prodavci = Komunikacija.getInstance().ucitajProdavce();
        for (Prodavac p : prodavci) {
            forma.getjComboBoxProdavac().addItem(p);
        }
        forma.getjComboBoxProdavac().setSelectedItem(Coordinator.getInstance().getUlogovaniProdavac());

        List<Kupac> kupci = Komunikacija.getInstance().ucitajKupce();
        for (Kupac k : kupci) {
            forma.getjComboBoxKupac().addItem(k);
        }
        forma.getjComboBoxKupac().setSelectedItem(null);

        List<TeglaMeda> tegle = Komunikacija.getInstance().ucitajTegleMeda();
        for (TeglaMeda tm : tegle) {
            forma.getjComboBoxTeglaMeda().addItem(tm);
        }
        forma.getjComboBoxTeglaMeda().setSelectedItem(null);

        ModelTabeleStavkeNarudzbenice model = new ModelTabeleStavkeNarudzbenice(new ArrayList<>());
        forma.getjTableStavke().setModel(model);

        switch (mod) {
            case DODAJ:
                forma.getjButtonZapamti().setVisible(false);
                break;

            case PROMENI:
                forma.getjButtonKreiraj().setVisible(false);
                popuniPolja(model);
                break;

            case DETALJI:
                forma.getjButtonKreiraj().setVisible(false);
                forma.getjButtonZapamti().setVisible(false);
                forma.getjButtonDodajStavku().setVisible(false);
                forma.getjButtonObrisiStavku().setVisible(false);
                popuniPolja(model);
                forma.getjTextFieldDatum().setEditable(false);
                forma.getjComboBoxProdavac().setEnabled(false);
                forma.getjComboBoxKupac().setEnabled(false);
                forma.getjComboBoxTeglaMeda().setEnabled(false);
                forma.getjTextFieldKolicina().setEditable(false);
                break;

            default:
                throw new AssertionError();
        }
    }

    private void popuniPolja(ModelTabeleStavkeNarudzbenice model) {
        Narudzbenica n = (Narudzbenica) Coordinator.getInstance().vratiParam("narudzbenica");
        forma.getjTextFieldId().setText(n.getIdNarudzbenica() + "");
        forma.getjTextFieldDatum().setText(sdf.format(n.getDatumIzdavanja()));
        forma.getjComboBoxProdavac().setSelectedItem(n.getProdavac());
        forma.getjComboBoxKupac().setSelectedItem(n.getKupac());
        model.setLista(n.getStavke());
        osveziUkupno(model);
    }

    private static final String NE_MOZE_DA_ZAPAMTI_NARUDZBENICU = "Sistem ne moze da zapamti narudzbenicu";

    private void addActionListeners() {
        forma.dodajStavkuAddActionListener(e -> {
            TeglaMeda tm = (TeglaMeda) forma.getjComboBoxTeglaMeda().getSelectedItem();
            String kolicinaString = forma.getjTextFieldKolicina().getText().trim();
            if (tm == null || kolicinaString.isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Morate odabrati teglu meda i uneti kolicinu", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int kolicina;
            try {
                kolicina = Integer.parseInt(kolicinaString);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(forma, "Kolicina mora biti ceo broj", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (kolicina <= 0) {
                JOptionPane.showMessageDialog(forma, "Kolicina mora biti veca od 0", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ModelTabeleStavkeNarudzbenice model = (ModelTabeleStavkeNarudzbenice) forma.getjTableStavke().getModel();

            StavkaNarudzbenice postojeca = nadjiStavkuSaTeglom(model, tm);
            if (postojeca != null) {
                postojeca.setKolicina(postojeca.getKolicina() + kolicina);
                postojeca.setCenaStavke(tm.getCena() * postojeca.getKolicina());
                model.fireTableDataChanged();
            } else {
                StavkaNarudzbenice sn = new StavkaNarudzbenice();
                sn.setTeglaMeda(tm);
                sn.setKolicina(kolicina);
                sn.setCenaStavke(tm.getCena() * kolicina);
                model.dodajStavku(sn);
            }
            osveziUkupno(model);
        });

        forma.obrisiStavkuAddActionListener(e -> {
            int red = forma.getjTableStavke().getSelectedRow();
            if (red == -1) {
                JOptionPane.showMessageDialog(forma, "Morate odabrati stavku za brisanje", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ModelTabeleStavkeNarudzbenice model = (ModelTabeleStavkeNarudzbenice) forma.getjTableStavke().getModel();
            model.obrisiStavku(model.getLista().get(red));
            osveziUkupno(model);
        });

        forma.kreirajAddActionListener(e -> {
            Narudzbenica n = procitajNarudzbenicu(false);
            if (n == null) {
                return;
            }
            try {
                Komunikacija.getInstance().kreirajNarudzbenicu(n);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio narudzbenicu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazNarudzbenica();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti narudzbenicu", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.zapamtiAddActionListener(e -> {
            Narudzbenica n = procitajNarudzbenicu(true);
            if (n == null) {
                return;
            }
            try {
                Komunikacija.getInstance().promeniNarudzbenicu(n);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio narudzbenicu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazNarudzbenica();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti narudzbenicu", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void osveziUkupno(ModelTabeleStavkeNarudzbenice model) {
        double ukupanIznos = 0;
        for (StavkaNarudzbenice sn : model.getLista()) {
            ukupanIznos += sn.getCenaStavke();
        }
        forma.getjTextFieldUkupanIznos().setText(ukupanIznos + "");
        forma.getjTextFieldUkupnoStavki().setText(model.getLista().size() + "");
    }

    private Narudzbenica procitajNarudzbenicu(boolean izmena) {
        if (forma.getjComboBoxProdavac().getSelectedItem() == null
                || forma.getjComboBoxKupac().getSelectedItem() == null
                || forma.getjTextFieldDatum().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(forma, NE_MOZE_DA_ZAPAMTI_NARUDZBENICU + "\nMorate popuniti sva polja", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        ModelTabeleStavkeNarudzbenice model = (ModelTabeleStavkeNarudzbenice) forma.getjTableStavke().getModel();
        List<StavkaNarudzbenice> stavke = model.getLista();
        if (stavke.isEmpty()) {
            JOptionPane.showMessageDialog(forma, NE_MOZE_DA_ZAPAMTI_NARUDZBENICU + "\nMorate dodati barem jednu stavku", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Narudzbenica n = new Narudzbenica();
        n.setStavke(stavke);
        n.setProdavac((Prodavac) forma.getjComboBoxProdavac().getSelectedItem());
        n.setKupac((Kupac) forma.getjComboBoxKupac().getSelectedItem());

        if (izmena) {
            n.setIdNarudzbenica(Integer.parseInt(forma.getjTextFieldId().getText().trim()));
        }

        double ukupanIznos = 0;
        for (StavkaNarudzbenice sn : stavke) {
            ukupanIznos += sn.getCenaStavke();
        }
        n.setUkupanIznos(ukupanIznos);
        n.setUkupnoStavki(stavke.size());

        Date datum;
        try {
            datum = sdf.parse(forma.getjTextFieldDatum().getText().trim());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, NE_MOZE_DA_ZAPAMTI_NARUDZBENICU + "\nDatum nije validan! Format: dd.MM.yyyy", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (datum.after(new Date())) {
            JOptionPane.showMessageDialog(forma, NE_MOZE_DA_ZAPAMTI_NARUDZBENICU + "\nDatum izdavanja ne moze biti u buducnosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        n.setDatumIzdavanja(datum);

        return n;
    }

    private StavkaNarudzbenice nadjiStavkuSaTeglom(ModelTabeleStavkeNarudzbenice model, TeglaMeda tm) {
        for (StavkaNarudzbenice sn : model.getLista()) {
            if (sn.getTeglaMeda() != null && sn.getTeglaMeda().getIdTeglaMeda() == tm.getIdTeglaMeda()) {
                return sn;
            }
        }
        return null;
    }
}
