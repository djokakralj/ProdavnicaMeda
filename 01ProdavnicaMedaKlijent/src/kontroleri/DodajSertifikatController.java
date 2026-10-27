/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Sertifikat;
import forme.DodajSertifikatForma;
import forme.FormaMod;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class DodajSertifikatController {

    private final DodajSertifikatForma forma;

    public DodajSertifikatController(DodajSertifikatForma forma) {
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
                forma.getjTextFieldNaziv().setEditable(false);
                break;

            case DETALJI:
                forma.getjButtonKreiraj().setVisible(false);
                forma.getjButtonPromeni().setVisible(false);
                forma.getjButtonObrisi().setVisible(false);
                popuniPolja();
                forma.getjTextFieldNaziv().setEditable(false);
                break;

            default:
                throw new AssertionError();
        }
    }

    private void popuniPolja() {
        Sertifikat s = (Sertifikat) Coordinator.getInstance().vratiParam("sertifikat");
        forma.getjTextFieldId().setText(s.getIdSertifikat() + "");
        forma.getjTextFieldNaziv().setText(s.getNaziv());
    }

    private Sertifikat procitajSertifikat(boolean saId) {
        String naziv = forma.getjTextFieldNaziv().getText().trim();
        if (naziv.isEmpty()) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti Sertifikat\nMorate uneti naziv", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        int id = saId ? Integer.parseInt(forma.getjTextFieldId().getText().trim()) : -1;
        return new Sertifikat(id, naziv);
    }

    private void addActionListeners() {
        forma.dodajAddActionListener(e -> {
            Sertifikat s = procitajSertifikat(false);
            if (s == null) {
                return;
            }
            try {
                Komunikacija.getInstance().ubaciSertifikat(s);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio Sertifikat", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazSertifikata();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti Sertifikat", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.promeniAddActionListener(e -> {
            Sertifikat s = procitajSertifikat(true);
            if (s == null) {
                return;
            }
            try {
                Komunikacija.getInstance().promeniSertifikat(s);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio Sertifikat", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazSertifikata();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da zapamti Sertifikat", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });

        forma.obrisiAddActionListener(e -> {
            try {
                Sertifikat s = (Sertifikat) Coordinator.getInstance().vratiParam("sertifikat");
                Komunikacija.getInstance().obrisiSertifikat(s);
                JOptionPane.showMessageDialog(forma, "Sistem je obrisao Sertifikat", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                Coordinator.getInstance().osveziPrikazSertifikata();
                forma.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, "Sistem ne moze da obrise Sertifikat", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
