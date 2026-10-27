/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Sertifikat;
import forme.FormaMod;
import forme.PrikazSertifikataForma;
import forme.PrikazTegliMedaForma;
import forme.model.ModelTabeleSertifikati;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class PrikazSertifikataController {

    private final PrikazSertifikataForma forma;

    public PrikazSertifikataController(PrikazSertifikataForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    public void pripremiFormu() {
        try {
            List<Sertifikat> sertifikati = Komunikacija.getInstance().ucitajSertifikate();
            forma.getjTableSertifikati().setModel(new ModelTabeleSertifikati(sertifikati));
        } catch (Exception ex) {
            Logger.getLogger(PrikazSertifikataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Sertifikat odabraniSertifikat() {
        int red = forma.getjTableSertifikati().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Morate odabrati sertifikat", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        ModelTabeleSertifikati model = (ModelTabeleSertifikati) forma.getjTableSertifikati().getModel();
        return model.getLista().get(red);
    }

    private void addActionListeners() {
        forma.kreirajAddActionListener(e -> Coordinator.getInstance().otvoriDodajSertifikatFormu(FormaMod.DODAJ));

        forma.detaljiAddActionListener(e -> {
            Sertifikat s = odabraniSertifikat();
            if (s != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao sertifikat", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("sertifikat", s);
                Coordinator.getInstance().otvoriDodajSertifikatFormu(FormaMod.DETALJI);
            }
        });

        forma.promeniAddActionListener(e -> {
            Sertifikat s = odabraniSertifikat();
            if (s != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao sertifikat", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("sertifikat", s);
                Coordinator.getInstance().otvoriDodajSertifikatFormu(FormaMod.PROMENI);
            }
        });

        forma.obrisiAddActionListener(e -> {
            Sertifikat s = odabraniSertifikat();
            if (s != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao sertifikat", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("sertifikat", s);
                Coordinator.getInstance().otvoriDodajSertifikatFormu(FormaMod.OBRISI);
            }
        });

        forma.pretraziAddActionListener(e -> {
            String naziv = forma.getjTextFieldNaziv().getText().trim();
            if (naziv.isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Morate uneti kriterijum", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ModelTabeleSertifikati model = (ModelTabeleSertifikati) forma.getjTableSertifikati().getModel();
            model.pretrazi(naziv);
            if (model.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje sertifikate po zadatim kriterijumima", "GRESKA", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao sertifikate po zadatim kriterijumima", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        forma.resetujAddActionListener(e -> {
            pripremiFormu();
            forma.getjTextFieldNaziv().setText("");
        });
    }

}
