/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.TeglaMeda;
import forme.DodajTegluMedaForma;
import forme.FormaMod;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class DodajTegluMedaController {

    private final DodajTegluMedaForma forma;

    public DodajTegluMedaController(DodajTegluMedaForma forma) {
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
        TeglaMeda tm = (TeglaMeda) Coordinator.getInstance().vratiParam("teglaMeda");
        forma.getjTextFieldId().setText(tm.getIdTeglaMeda() + "");
        forma.getjTextFieldGramaza().setText(tm.getGramaza() + "");
        forma.getjTextFieldVrstaTegle().setText(tm.getVrstaTegle());
        forma.getjTextFieldVrstaMeda().setText(tm.getVrstaMeda());
        forma.getjTextFieldCenaPoGramu().setText(tm.getCenaPoGramu() + "");
        forma.getjTextFieldCena().setText(tm.getCena() + "");
    }

    private void zakljucajPolja() {
        forma.getjTextFieldGramaza().setEditable(false);
        forma.getjTextFieldVrstaTegle().setEditable(false);
        forma.getjTextFieldVrstaMeda().setEditable(false);
        forma.getjTextFieldCenaPoGramu().setEditable(false);
    }

    private TeglaMeda procitajTeglu(boolean saId) {
        String gramazaString = forma.getjTextFieldGramaza().getText().trim();
        String vrstaTegle = forma.getjTextFieldVrstaTegle().getText().trim();
        String vrstaMeda = forma.getjTextFieldVrstaMeda().getText().trim();
        String cenaPoGramuString = forma.getjTextFieldCenaPoGramu().getText().trim();

        if (gramazaString.isEmpty() || vrstaTegle.isEmpty() || vrstaMeda.isEmpty() || cenaPoGramuString.isEmpty()) {
            JOptionPane.showMessageDialog(forma, "Morate popuniti sva polja", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        int gramaza;
        double cenaPoGramu;
        try {
            gramaza = Integer.parseInt(gramazaString);
            cenaPoGramu = Double.parseDouble(cenaPoGramuString);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(forma, "Gramaza i cena po gramu moraju biti brojevi", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        if (gramaza <= 0 || cenaPoGramu <= 0) {
            JOptionPane.showMessageDialog(forma, "Gramaza i cena po gramu moraju biti veci od 0", "UPOZORENJE", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        double cena = gramaza * cenaPoGramu;
        forma.getjTextFieldCena().setText(cena + "");

        int id = saId ? Integer.parseInt(forma.getjTextFieldId().getText().trim()) : -1;
        return new TeglaMeda(id, gramaza, vrstaTegle, vrstaMeda, cena, cenaPoGramu);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> {
            TeglaMeda tm = procitajTeglu(false);
            if (tm == null) {
                return;
            }
            try {
                Komunikacija.getInstance().kreirajTegluMeda(tm);
                JOptionPane.showMessageDialog(forma, "Sistem je kreirao teglu meda", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazTegliMeda();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da kreira teglu meda", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.promeniAddActionListener(e -> {
            TeglaMeda tm = procitajTeglu(true);
            if (tm == null) {
                return;
            }
            try {
                Komunikacija.getInstance().promeniTegluMeda(tm);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio teglu meda", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazTegliMeda();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti teglu meda", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.obrisiAddActionListener(e -> {
            try {
                TeglaMeda tm = (TeglaMeda) Coordinator.getInstance().vratiParam("teglaMeda");
                Komunikacija.getInstance().obrisiTegluMeda(tm);
                JOptionPane.showMessageDialog(forma, "Sistem je obrisao teglu meda", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazTegliMeda();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da obrise teglu meda", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
