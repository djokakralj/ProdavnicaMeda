/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.PravnoLice;
import forme.FormaMod;
import forme.PrikazPravnihLicaForma;
import forme.model.ModelTabelePravnaLica;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class PrikazPravnihLicaController {

    private final PrikazPravnihLicaForma forma;

    public PrikazPravnihLicaController(PrikazPravnihLicaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    public void pripremiFormu() {
        try {
            List<PravnoLice> pravnaLica = Komunikacija.getInstance().ucitajPravnaLica();
            forma.getjTablePravnaLica().setModel(new ModelTabelePravnaLica(pravnaLica));
        } catch (Exception ex) {
            Logger.getLogger(PrikazPravnihLicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PravnoLice odabranoPravnoLice() {
        int red = forma.getjTablePravnaLica().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Morate odabrati pravno lice", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        ModelTabelePravnaLica model = (ModelTabelePravnaLica) forma.getjTablePravnaLica().getModel();
        return model.getLista().get(red);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> Coordinator.getInstance().otvoriDodajPravnoLiceFormu(FormaMod.DODAJ));

        forma.detaljiAddActionListener(e -> {
            PravnoLice pl = odabranoPravnoLice();
            if (pl != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao pravno lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("pravnoLice", pl);
                Coordinator.getInstance().otvoriDodajPravnoLiceFormu(FormaMod.DETALJI);
            }
        });

        forma.promeniAddActionListener(e -> {
            PravnoLice pl = odabranoPravnoLice();
            if (pl != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao pravno lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("pravnoLice", pl);
                Coordinator.getInstance().otvoriDodajPravnoLiceFormu(FormaMod.PROMENI);
            }
        });

        forma.obrisiAddActionListener(e -> {
            PravnoLice pl = odabranoPravnoLice();
            if (pl != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao pravno lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("pravnoLice", pl);
                Coordinator.getInstance().otvoriDodajPravnoLiceFormu(FormaMod.OBRISI);
            }
        });

        forma.pretraziAddActionListener(e -> {
            String kupac = forma.getjTextFieldKupac().getText().trim();
            String pib = forma.getjTextFieldPIB().getText().trim();
            if (kupac.isEmpty() && pib.isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Morate uneti barem jedan kriterijum", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ModelTabelePravnaLica model = (ModelTabelePravnaLica) forma.getjTablePravnaLica().getModel();
            model.pretrazi(kupac, pib);
            if (model.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje pravna lica po zadatim kriterijumima", "GRESKA", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao pravna lica po zadatim kriterijumima", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        forma.resetujAddActionListener(e -> {
            pripremiFormu();
            forma.getjTextFieldKupac().setText("");
            forma.getjTextFieldPIB().setText("");
        });
    }

}
