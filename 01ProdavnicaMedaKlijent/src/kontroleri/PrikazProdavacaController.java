/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Prodavac;
import forme.FormaMod;
import forme.PrikazProdavacaForma;
import forme.model.ModelTabeleProdavci;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class PrikazProdavacaController {

    private final PrikazProdavacaForma forma;

    public PrikazProdavacaController(PrikazProdavacaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    public void pripremiFormu() {
        try {
            List<Prodavac> prodavci = Komunikacija.getInstance().ucitajProdavce();
            forma.getjTableProdavci().setModel(new ModelTabeleProdavci(prodavci));
        } catch (Exception ex) {
            Logger.getLogger(PrikazProdavacaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Prodavac odabraniProdavac() {
        int red = forma.getjTableProdavci().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Morate odabrati prodavca", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        ModelTabeleProdavci model = (ModelTabeleProdavci) forma.getjTableProdavci().getModel();
        return model.getLista().get(red);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> Coordinator.getInstance().otvoriDodajProdavcaFormu(FormaMod.DODAJ));

        forma.detaljiAddActionListener(e -> {
            Prodavac p = odabraniProdavac();
            if (p != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao prodavca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("prodavac", p);
                Coordinator.getInstance().otvoriDodajProdavcaFormu(FormaMod.DETALJI);
            }
        });

        forma.promeniAddActionListener(e -> {
            Prodavac p = odabraniProdavac();
            if (p != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao prodavca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("prodavac", p);
                Coordinator.getInstance().otvoriDodajProdavcaFormu(FormaMod.PROMENI);
            }
        });

        forma.obrisiAddActionListener(e -> {
            Prodavac p = odabraniProdavac();
            if (p != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao prodavca", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("prodavac", p);
                Coordinator.getInstance().otvoriDodajProdavcaFormu(FormaMod.OBRISI);
            }
        });

        forma.pretraziAddActionListener(e -> {
            String ime = forma.getjTextFieldIme().getText().trim();
            String prezime = forma.getjTextFieldPrezime().getText().trim();
            if (ime.isEmpty() && prezime.isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Morate uneti barem jedan kriterijum", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ModelTabeleProdavci model = (ModelTabeleProdavci) forma.getjTableProdavci().getModel();
            model.pretrazi(ime, prezime);
            if (model.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje prodavce po zadatim kriterijumima", "GRESKA", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao prodavce po zadatim kriterijumima", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        forma.resetujAddActionListener(e -> {
            pripremiFormu();
            forma.getjTextFieldIme().setText("");
            forma.getjTextFieldPrezime().setText("");
        });
    }

}
