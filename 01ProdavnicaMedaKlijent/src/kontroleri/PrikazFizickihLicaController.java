/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.FizickoLice;
import forme.FormaMod;
import forme.PrikazFizickihLicaForma;
import forme.model.ModelTabeleFizickaLica;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class PrikazFizickihLicaController {

    private final PrikazFizickihLicaForma forma;

    public PrikazFizickihLicaController(PrikazFizickihLicaForma forma) {
        this.forma = forma;
        addActionListeners();
    }

    public void otvoriFormu() {
        pripremiFormu();
        forma.setVisible(true);
    }

    public void pripremiFormu() {
        try {
            List<FizickoLice> fizickaLica = Komunikacija.getInstance().ucitajFizickaLica();
            forma.getjTableFizickaLica().setModel(new ModelTabeleFizickaLica(fizickaLica));
        } catch (Exception ex) {
            Logger.getLogger(PrikazFizickihLicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private FizickoLice odabranoFizickoLice() {
        int red = forma.getjTableFizickaLica().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Morate odabrati fizicko lice", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        ModelTabeleFizickaLica model = (ModelTabeleFizickaLica) forma.getjTableFizickaLica().getModel();
        return model.getLista().get(red);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> Coordinator.getInstance().otvoriDodajFizickoLiceFormu(FormaMod.DODAJ));

        forma.detaljiAddActionListener(e -> {
            FizickoLice fl = odabranoFizickoLice();
            if (fl != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao fizicko lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("fizickoLice", fl);
                Coordinator.getInstance().otvoriDodajFizickoLiceFormu(FormaMod.DETALJI);
            }
        });

        forma.promeniAddActionListener(e -> {
            FizickoLice fl = odabranoFizickoLice();
            if (fl != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao fizicko lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("fizickoLice", fl);
                Coordinator.getInstance().otvoriDodajFizickoLiceFormu(FormaMod.PROMENI);
            }
        });

        forma.obrisiAddActionListener(e -> {
            FizickoLice fl = odabranoFizickoLice();
            if (fl != null) {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao fizicko lice", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().dodajParam("fizickoLice", fl);
                Coordinator.getInstance().otvoriDodajFizickoLiceFormu(FormaMod.OBRISI);
            }
        });

        forma.pretraziAddActionListener(e -> {
            String kupac = forma.getjTextFieldKupac().getText().trim();
            String jmbg = forma.getjTextFieldJmbg().getText().trim();
            if (kupac.isEmpty() && jmbg.isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Morate uneti barem jedan kriterijum", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ModelTabeleFizickaLica model = (ModelTabeleFizickaLica) forma.getjTableFizickaLica().getModel();
            model.pretrazi(kupac, jmbg);
            if (model.getLista().isEmpty()) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da nadje fizicka lica po zadatim kriterijumima", "GRESKA", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forma, "Sistem je nasao fizicka lica po zadatim kriterijumima", "USPEH", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        forma.resetujAddActionListener(e -> {
            pripremiFormu();
            forma.getjTextFieldKupac().setText("");
            forma.getjTextFieldJmbg().setText("");
        });
    }

}
