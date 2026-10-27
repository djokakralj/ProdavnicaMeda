/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Kupac;
import domen.Narudzbenica;
import domen.Prodavac;
import domen.TeglaMeda;
import forme.FormaMod;
import forme.PrikazNarudzbenicaForma;
import forme.model.ModelTabeleNarudzbenice;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class PrikazNarudzbenicaController {
    private final PrikazNarudzbenicaForma forma;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public PrikazNarudzbenicaController(PrikazNarudzbenicaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    public void pripremiFormu() {
        try {
            List<Narudzbenica> narudzbenice = Komunikacija.getInstance().ucitajNarudzbenice();
            forma.getjTableNarudzbenice().setModel(new ModelTabeleNarudzbenice(narudzbenice));

            forma.getjComboBoxProdavac().removeAllItems();
            for (Prodavac p : Komunikacija.getInstance().ucitajProdavce()) {
                forma.getjComboBoxProdavac().addItem(p);
            }
            forma.getjComboBoxProdavac().setSelectedItem(null);

            forma.getjComboBoxKupac().removeAllItems();
            for (Kupac k : Komunikacija.getInstance().ucitajKupce()) {
                forma.getjComboBoxKupac().addItem(k);
            }
            forma.getjComboBoxKupac().setSelectedItem(null);

            forma.getjComboBoxTeglaMeda().removeAllItems();
            for (TeglaMeda tm : Komunikacija.getInstance().ucitajTegleMeda()) {
                forma.getjComboBoxTeglaMeda().addItem(tm);
            }
            forma.getjComboBoxTeglaMeda().setSelectedItem(null);
        } catch (Exception ex) {
            Logger.getLogger(PrikazNarudzbenicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Narudzbenica odabranaNarudzbenica() {
        int red = forma.getjTableNarudzbenice().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje narudzbenicu\nMorate odabrati narudzbenicu", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        ModelTabeleNarudzbenice model = (ModelTabeleNarudzbenice) forma.getjTableNarudzbenice().getModel();
        return model.getLista().get(red);
    }

    private void addActionListeners() {
        forma.pretraziAddActionListener(e -> pretrazi());

        forma.resetujAddActionListener(e -> {
            pripremiFormu();
            forma.getjTextFieldId().setText("");
            forma.getjTextFieldDatum().setText("");
            forma.getjTextFieldMaxIznos().setText("");
        });

        forma.detaljiAddActionListener(e -> {
            Narudzbenica n = odabranaNarudzbenica();
            if (n != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao narudzbenicu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("narudzbenica", n);
                Coordinator.getInstance().otvoriNarudzbenicaFormu(FormaMod.DETALJI);
            }
        });

        forma.promeniAddActionListener(e -> {
            Narudzbenica n = odabranaNarudzbenica();
            if (n != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao narudzbenicu", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("narudzbenica", n);
                Coordinator.getInstance().otvoriNarudzbenicaFormu(FormaMod.PROMENI);
            }
        });
    }

    private void pretrazi() {
        String idString = forma.getjTextFieldId().getText().trim();
        String datumString = forma.getjTextFieldDatum().getText().trim();
        String maxIznosString = forma.getjTextFieldMaxIznos().getText().trim();
        Prodavac prodavac = (Prodavac) forma.getjComboBoxProdavac().getSelectedItem();
        Kupac kupac = (Kupac) forma.getjComboBoxKupac().getSelectedItem();
        TeglaMeda teglaMeda = (TeglaMeda) forma.getjComboBoxTeglaMeda().getSelectedItem();

        if (idString.isEmpty() && datumString.isEmpty() && maxIznosString.isEmpty()
                && prodavac == null && kupac == null && teglaMeda == null) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje narudzbenice po zadatim kriterijumima\nMorate uneti barem jedan kriterijum", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Narudzbenica kriterijum = new Narudzbenica();
        try {
            if (!idString.isEmpty()) {
                kriterijum.setIdNarudzbenica(Integer.parseInt(idString));
            }
            if (!maxIznosString.isEmpty()) {
                kriterijum.setUkupanIznos(Double.parseDouble(maxIznosString));
            }
            if (!datumString.isEmpty()) {
                kriterijum.setDatumIzdavanja(sdf.parse(datumString));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje narudzbenice po zadatim kriterijumima\nKriterijumi nisu validni", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        kriterijum.setProdavac(prodavac);
        kriterijum.setKupac(kupac);

        try {
            List<Narudzbenica> pronadjene = Komunikacija.getInstance().pretraziNarudzbenice(kriterijum);
            ModelTabeleNarudzbenice model = new ModelTabeleNarudzbenice(pronadjene);
            forma.getjTableNarudzbenice().setModel(model);

            if (teglaMeda != null) {
                model.pretraziPoTegli(teglaMeda);
            }

            if (model.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje narudzbenice po zadatim kriterijumima", "GRESKA", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao narudzbenice po zadatim kriterijumima", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje narudzbenice po zadatim kriterijumima", "GRESKA", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PrikazNarudzbenicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
