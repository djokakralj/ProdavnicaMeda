/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.FizickoLice;
import domen.Kupac;
import forme.DodajFizickoLiceForma;
import forme.FormaMod;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class DodajFizickoLiceController {

    private final DodajFizickoLiceForma forma;

    public DodajFizickoLiceController(DodajFizickoLiceForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
        forma.setVisible(true);
    }

    private void pripremiFormu(FormaMod mod) {
        try {
            List<Kupac> kupci = Komunikacija.getInstance().ucitajKupce();
            for (Kupac k : kupci) {
                forma.getjComboBoxKupac().addItem(k);
            }
            forma.getjComboBoxKupac().setSelectedItem(null);
        } catch (Exception ex) {
            Logger.getLogger(DodajFizickoLiceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (mod) {
            case DODAJ:
                forma.getjButtonPromeni().setVisible(false);
                forma.getjButtonObrisi().setVisible(false);
                break;

            case PROMENI:
                forma.getjButtonKreiraj().setVisible(false);
                forma.getjButtonObrisi().setVisible(false);
                popuniPolja();
                forma.getjComboBoxKupac().setEnabled(false);
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
        FizickoLice fl = (FizickoLice) Coordinator.getInstance().vratiParam("fizickoLice");
        forma.getjComboBoxKupac().setSelectedItem(fl.getKupac());
        forma.getjTextFieldJmbg().setText(fl.getJmbg());
    }

    private void zakljucajPolja() {
        forma.getjComboBoxKupac().setEnabled(false);
        forma.getjTextFieldJmbg().setEditable(false);
    }

    private FizickoLice procitajFizickoLice() {
        Kupac k = (Kupac) forma.getjComboBoxKupac().getSelectedItem();
        String jmbg = forma.getjTextFieldJmbg().getText().trim();

        if (k == null || jmbg.isEmpty()) {
            JOptionPane.showMessageDialog(forma, "Morate popuniti sva polja", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (jmbg.length() != 13 || !jmbg.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(forma, "JMBG mora imati tacno 13 cifara", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return new FizickoLice(k, jmbg);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> {
            FizickoLice fl = procitajFizickoLice();
            if (fl == null) {
                return;
            }
            try {
                Komunikacija.getInstance().kreirajFizickoLice(fl);
                JOptionPane.showMessageDialog(forma, "Sistem je kreirao fizicko lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazFizickihLica();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da kreira fizicko lice", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.promeniAddActionListener(e -> {
            FizickoLice fl = procitajFizickoLice();
            if (fl == null) {
                return;
            }
            try {
                Komunikacija.getInstance().promeniFizickoLice(fl);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio fizicko lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazFizickihLica();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti fizicko lice", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.obrisiAddActionListener(e -> {
            try {
                FizickoLice fl = (FizickoLice) Coordinator.getInstance().vratiParam("fizickoLice");
                Komunikacija.getInstance().obrisiFizickoLice(fl);
                JOptionPane.showMessageDialog(forma, "Sistem je obrisao fizicko lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazFizickihLica();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da obrise fizicko lice", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
