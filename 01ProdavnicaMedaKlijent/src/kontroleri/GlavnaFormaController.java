/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;
import coordinator.Coordinator;
import domen.Prodavac;
import forme.FormaMod;
import forme.GlavnaForma;
import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class GlavnaFormaController {
    GlavnaForma gf;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    private void addActionListeners() {
        gf.kreirajNarudzbenicuAddActionListener(e -> Coordinator.getInstance().otvoriNarudzbenicaFormu(FormaMod.DODAJ));
        gf.pretraziNarudzbenicuAddActionListener(e -> Coordinator.getInstance().otvoriPrikazNarudzbenicaFormu());
        gf.prodavacAddActionListener(e -> Coordinator.getInstance().otvoriPrikazProdavacaFormu());
        gf.kupacAddActionListener(e -> Coordinator.getInstance().otvoriPrikazKupacaFormu());
        gf.pravnoLiceAddActionListener(e -> Coordinator.getInstance().otvoriPrikazPravnihLicaFormu());
        gf.fizickoLiceAddActionListener(e -> Coordinator.getInstance().otvoriPrikazFizickihLicaFormu());
        gf.sertifikatAddActionListener(e -> Coordinator.getInstance().otvoriPrikazSertifikataFormu());
        gf.teglaMedaAddActionListener(e -> Coordinator.getInstance().otvoriPrikazTegliMedaFormu());
        gf.oProgramuAddActionListener(e -> prikaziOProgramu());

    }

    private void prikaziOProgramu() {
        JOptionPane.showMessageDialog(gf,
                "Prodavnica meda\n\n"
                + "Projekat iz predmeta Projektovanje softvera\n"
                + "Klijent-server aplikacija",
                "O programu", JOptionPane.INFORMATION_MESSAGE);
    }

    public void otvoriFormu(){
        Prodavac ulogovani = Coordinator.getInstance().getUlogovaniProdavac();
        gf.getjLabelUlogovani().setText("Ulogovani prodavac: " + ulogovani.getIme() + " " + ulogovani.getPrezime());
        gf.setVisible(true);
    }

}
