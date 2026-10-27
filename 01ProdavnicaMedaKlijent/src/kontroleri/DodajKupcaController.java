/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Kupac;
import forme.DodajKupcaForma;
import forme.FormaMod;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class DodajKupcaController {

    private final DodajKupcaForma forma;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public DodajKupcaController(DodajKupcaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
        forma.setVisible(true);
    }

    private void pripremiFormu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                forma.getjButtonPromeni().setVisible(false);
                forma.getjButtonObrisi().setVisible(false);
                break;

            case PROMENI:
                forma.getjButtonKreiraj().setVisible(false);
                forma.getjButtonObrisi().setVisible(false);
                popuniPolja();
                break;

            case OBRISI:
                forma.getjButtonKreiraj().setVisible(false);
                forma.getjButtonPromeni().setVisible(false);
                popuniPolja();
                zakljucajPolja();
                break;

            case DETALJI:
                forma.getjButtonKreiraj().setVisible(false);
                forma.getjButtonPromeni().setVisible(false);
                forma.getjButtonObrisi().setVisible(false);
                popuniPolja();
                zakljucajPolja();
                break;

            default:
                throw new AssertionError();
        }
    }

    private void popuniPolja() {
        Kupac k = (Kupac) Coordinator.getInstance().vratiParam("kupac");
        forma.getjTextFieldId().setText(k.getIdKupac() + "");
        forma.getjTextFieldIme().setText(k.getIme());
        forma.getjTextFieldPrezime().setText(k.getPrezime());
        forma.getjTextFieldDatumRodjenja().setText(sdf.format(k.getDatumRodjenja()));
        forma.getjTextFieldStarost().setText(k.getStarost() + "");
    }

    private void zakljucajPolja() {
        forma.getjTextFieldIme().setEditable(false);
        forma.getjTextFieldPrezime().setEditable(false);
        forma.getjTextFieldDatumRodjenja().setEditable(false);
    }

    private Kupac procitajKupca(boolean saId) {
        String poruka = saId ? "Sistem ne moze da zapamti kupca" : "Sistem ne moze da kreira kupca";

        String ime = forma.getjTextFieldIme().getText().trim();
        String prezime = forma.getjTextFieldPrezime().getText().trim();
        String datumString = forma.getjTextFieldDatumRodjenja().getText().trim();

        if (ime.isEmpty() || prezime.isEmpty() || datumString.isEmpty()) {
            JOptionPane.showMessageDialog(forma, poruka + "\nMorate popuniti sva polja", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Date datumRodjenja;
        try {
            datumRodjenja = sdf.parse(datumString);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, poruka + "\nDatum nije validan! Format: dd.MM.yyyy", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (datumRodjenja.after(new Date())) {
            JOptionPane.showMessageDialog(forma, poruka + "\nDatum rodjenja ne moze biti u buducnosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Calendar rodjenje = Calendar.getInstance();
        rodjenje.setTime(datumRodjenja);
        int starost = Calendar.getInstance().get(Calendar.YEAR) - rodjenje.get(Calendar.YEAR);

        int id = saId ? Integer.parseInt(forma.getjTextFieldId().getText().trim()) : -1;
        return new Kupac(id, ime, prezime, datumRodjenja, starost);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> {
            Kupac k = procitajKupca(false);
            if (k == null) {
                return;
            }
            try {
                Komunikacija.getInstance().kreirajKupca(k);
                JOptionPane.showMessageDialog(forma, "Sistem je kreirao kupca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazKupaca();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da kreira kupca", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.promeniAddActionListener(e -> {
            Kupac k = procitajKupca(true);
            if (k == null) {
                return;
            }
            try {
                Komunikacija.getInstance().promeniKupca(k);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio kupca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazKupaca();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti kupca", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.obrisiAddActionListener(e -> {
            try {
                Kupac k = (Kupac) Coordinator.getInstance().vratiParam("kupac");
                Komunikacija.getInstance().obrisiKupca(k);
                JOptionPane.showMessageDialog(forma, "Sistem je obrisao kupca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazKupaca();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da obrise kupca", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
