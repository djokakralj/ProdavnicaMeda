/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.TeglaMeda;
import forme.FormaMod;
import forme.PrikazTegliMedaForma;
import forme.model.ModelTabeleTegleMeda;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class PrikazTegliMedaController {

    private final PrikazTegliMedaForma forma;

    public PrikazTegliMedaController(PrikazTegliMedaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    public void pripremiFormu() {
        try {
            List<TeglaMeda> tegle = Komunikacija.getInstance().ucitajTegleMeda();
            forma.getjTableTegle().setModel(new ModelTabeleTegleMeda(tegle));
        } catch (Exception ex) {
            Logger.getLogger(PrikazTegliMedaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private TeglaMeda odabranaTegla() {
        int red = forma.getjTableTegle().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Morate odabrati teglu meda", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        ModelTabeleTegleMeda model = (ModelTabeleTegleMeda) forma.getjTableTegle().getModel();
        return model.getLista().get(red);
    }

    private void addActionListeners() {
        forma.kreirajAddActionListener(e -> Coordinator.getInstance().otvoriDodajTegluMedaFormu(FormaMod.DODAJ));

        forma.detaljiAddActionListener(e -> {
            TeglaMeda tm = odabranaTegla();
            if (tm != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao teglu meda", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("teglaMeda", tm);
                Coordinator.getInstance().otvoriDodajTegluMedaFormu(FormaMod.DETALJI);
            }
        });

        forma.promeniAddActionListener(e -> {
            TeglaMeda tm = odabranaTegla();
            if (tm != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao teglu meda", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("teglaMeda", tm);
                Coordinator.getInstance().otvoriDodajTegluMedaFormu(FormaMod.PROMENI);
            }
        });

        forma.obrisiAddActionListener(e -> {
            TeglaMeda tm = odabranaTegla();
            if (tm != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao teglu meda", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("teglaMeda", tm);
                Coordinator.getInstance().otvoriDodajTegluMedaFormu(FormaMod.OBRISI);
            }
        });

        forma.pretraziAddActionListener(e -> {
            String vrstaMeda = forma.getjTextFieldVrstaMeda().getText().trim();
            String vrstaTegle = forma.getjTextFieldVrstaTegle().getText().trim();
            if (vrstaMeda.isEmpty() && vrstaTegle.isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Morate uneti barem jedan kriterijum", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ModelTabeleTegleMeda model = (ModelTabeleTegleMeda) forma.getjTableTegle().getModel();
            model.pretrazi(vrstaMeda, vrstaTegle);
            if (model.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje tegle meda po zadatim kriterijumima", "GRESKA", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao tegle meda po zadatim kriterijumima", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        forma.resetujAddActionListener(e -> {
            pripremiFormu();
            forma.getjTextFieldVrstaMeda().setText("");
            forma.getjTextFieldVrstaTegle().setText("");
        });
    }

}
