/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Prodavac;
import forme.DodajProdavcaForma;
import forme.FormaMod;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class DodajProdavcaController {

    private final DodajProdavcaForma forma;

    public DodajProdavcaController(DodajProdavcaForma forma) {
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
        Prodavac p = (Prodavac) Coordinator.getInstance().vratiParam("prodavac");
        forma.getjTextFieldId().setText(p.getIdProdavac() + "");
        forma.getjTextFieldIme().setText(p.getIme());
        forma.getjTextFieldPrezime().setText(p.getPrezime());
        forma.getjTextFieldKorisnickoIme().setText(p.getKorisnickoIme());
        forma.getjTextFieldSifra().setText(p.getSifra());
    }

    private void zakljucajPolja() {
        forma.getjTextFieldIme().setEditable(false);
        forma.getjTextFieldPrezime().setEditable(false);
        forma.getjTextFieldKorisnickoIme().setEditable(false);
        forma.getjTextFieldSifra().setEditable(false);
    }

    private Prodavac procitajProdavca(boolean saId) {
        String ime = forma.getjTextFieldIme().getText().trim();
        String prezime = forma.getjTextFieldPrezime().getText().trim();
        String korisnickoIme = forma.getjTextFieldKorisnickoIme().getText().trim();
        String sifra = forma.getjTextFieldSifra().getText().trim();

        if (ime.isEmpty() || prezime.isEmpty() || korisnickoIme.isEmpty() || sifra.isEmpty()) {
            JOptionPane.showMessageDialog(forma, "Morate popuniti sva polja", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        int id = saId ? Integer.parseInt(forma.getjTextFieldId().getText().trim()) : -1;
        return new Prodavac(id, ime, prezime, korisnickoIme, sifra);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> {
            Prodavac p = procitajProdavca(false);
            if (p == null) {
                return;
            }
            try {
                Komunikacija.getInstance().kreirajProdavca(p);
                JOptionPane.showMessageDialog(forma, "Sistem je kreirao prodavca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazProdavaca();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da kreira prodavca", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.promeniAddActionListener(e -> {
            Prodavac p = procitajProdavca(true);
            if (p == null) {
                return;
            }
            try {
                Komunikacija.getInstance().promeniProdavca(p);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio prodavca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazProdavaca();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti prodavca", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.obrisiAddActionListener(e -> {
            try {
                Prodavac p = (Prodavac) Coordinator.getInstance().vratiParam("prodavac");
                Komunikacija.getInstance().obrisiProdavca(p);
                JOptionPane.showMessageDialog(forma, "Sistem je obrisao prodavca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazProdavaca();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da obrise prodavca", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
