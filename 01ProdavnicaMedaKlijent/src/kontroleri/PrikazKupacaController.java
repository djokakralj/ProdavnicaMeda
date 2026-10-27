/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Kupac;
import forme.FormaMod;
import forme.PrikazKupacaForma;
import forme.model.ModelTabeleKupci;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class PrikazKupacaController {

    private final PrikazKupacaForma forma;

    public PrikazKupacaController(PrikazKupacaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    public void pripremiFormu() {
        try {
            List<Kupac> kupci = Komunikacija.getInstance().ucitajKupce();
            forma.getjTableKupci().setModel(new ModelTabeleKupci(kupci));
        } catch (Exception ex) {
            Logger.getLogger(PrikazKupacaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Kupac odabraniKupac() {
        int red = forma.getjTableKupci().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje kupca\nMorate odabrati kupca", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        ModelTabeleKupci model = (ModelTabeleKupci) forma.getjTableKupci().getModel();
        return model.getLista().get(red);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> Coordinator.getInstance().otvoriDodajKupcaFormu(FormaMod.DODAJ));

        forma.detaljiAddActionListener(e -> {
            Kupac k = odabraniKupac();
            if (k != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao kupca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("kupac", k);
                Coordinator.getInstance().otvoriDodajKupcaFormu(FormaMod.DETALJI);
            }
        });

        forma.promeniAddActionListener(e -> {
            Kupac k = odabraniKupac();
            if (k != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao kupca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("kupac", k);
                Coordinator.getInstance().otvoriDodajKupcaFormu(FormaMod.PROMENI);
            }
        });

        forma.obrisiAddActionListener(e -> {
            Kupac k = odabraniKupac();
            if (k != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao kupca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("kupac", k);
                Coordinator.getInstance().otvoriDodajKupcaFormu(FormaMod.OBRISI);
            }
        });

        forma.pretraziAddActionListener(e -> {
            String ime = forma.getjTextFieldIme().getText().trim();
            String prezime = forma.getjTextFieldPrezime().getText().trim();
            if (ime.isEmpty() && prezime.isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje kupce po zadatim kriterijumima\nMorate uneti barem jedan kriterijum", "GRESKA", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ModelTabeleKupci model = (ModelTabeleKupci) forma.getjTableKupci().getModel();
            model.pretrazi(ime, prezime);
            if (model.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje kupce po zadatim kriterijumima", "GRESKA", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao kupce po zadatim kriterijumima", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        forma.resetujAddActionListener(e -> {
            pripremiFormu();
            forma.getjTextFieldIme().setText("");
            forma.getjTextFieldPrezime().setText("");
        });
    }

}
