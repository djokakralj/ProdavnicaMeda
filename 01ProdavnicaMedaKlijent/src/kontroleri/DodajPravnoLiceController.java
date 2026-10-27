/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Kupac;
import domen.PravnoLice;
import forme.DodajPravnoLiceForma;
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
public class DodajPravnoLiceController {

    private final DodajPravnoLiceForma forma;

    public DodajPravnoLiceController(DodajPravnoLiceForma forma) {
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
            Logger.getLogger(DodajPravnoLiceController.class.getName()).log(Level.SEVERE, null, ex);
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
        PravnoLice pl = (PravnoLice) Coordinator.getInstance().vratiParam("pravnoLice");
        forma.getjComboBoxKupac().setSelectedItem(pl.getKupac());
        forma.getjTextFieldPib().setText(pl.getPib());
    }

    private void zakljucajPolja() {
        forma.getjComboBoxKupac().setEnabled(false);
        forma.getjTextFieldPib().setEditable(false);
    }

    private PravnoLice procitajPravnoLice() {
        Kupac k = (Kupac) forma.getjComboBoxKupac().getSelectedItem();
        String pib = forma.getjTextFieldPib().getText().trim();

        if (k == null || pib.isEmpty()) {
            JOptionPane.showMessageDialog(forma, "Morate popuniti sva polja", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (pib.length() != 9 || !pib.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(forma, "PIB mora imati tacno 9 cifara", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return new PravnoLice(k, pib);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> {
            PravnoLice pl = procitajPravnoLice();
            if (pl == null) {
                return;
            }
            try {
                Komunikacija.getInstance().kreirajPravnoLice(pl);
                JOptionPane.showMessageDialog(forma, "Sistem je kreirao pravno lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazPravnihLica();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da kreira pravno lice", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.promeniAddActionListener(e -> {
            PravnoLice pl = procitajPravnoLice();
            if (pl == null) {
                return;
            }
            try {
                Komunikacija.getInstance().promeniPravnoLice(pl);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio pravno lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazPravnihLica();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti pravno lice", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.obrisiAddActionListener(e -> {
            try {
                PravnoLice pl = (PravnoLice) Coordinator.getInstance().vratiParam("pravnoLice");
                Komunikacija.getInstance().obrisiPravnoLice(pl);
                JOptionPane.showMessageDialog(forma, "Sistem je obrisao pravno lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazPravnihLica();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da obrise pravno lice", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
