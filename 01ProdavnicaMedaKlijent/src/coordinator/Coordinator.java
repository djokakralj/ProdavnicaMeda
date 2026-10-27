/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinator;

import domen.Prodavac;
import forme.*;
import java.util.HashMap;
import java.util.Map;
import kontroleri.*;

/**
 *
 * @author Korisnik
 */
public class Coordinator {

    private static Coordinator instance;
    private Prodavac ulogovaniProdavac;
    private Map<String, Object> parametri;

    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;
    private NarudzbenicaController narudzbenicaController;
    private PrikazNarudzbenicaController prikazNarudzbenicaController;
    private PrikazKupacaController prikazKupacaController;
    private DodajKupcaController dodajKupcaController;
    private PrikazFizickihLicaController prikazFizickihLicaController;
    private DodajFizickoLiceController dodajFizickoLiceController;
    private PrikazPravnihLicaController prikazPravnihLicaController;
    private DodajPravnoLiceController dodajPravnoLiceController;
    private PrikazProdavacaController prikazProdavacaController;
    private DodajProdavcaController dodajProdavcaController;
    private PrikazTegliMedaController prikazTegliMedaController;
    private DodajTegluMedaController dodajTegluMedaController;
    private PrikazSertifikataController prikazSertifikataController;
    private DodajSertifikatController dodajSertifikatController;

    private Coordinator() {
        parametri = new HashMap<>();
    }

    public static Coordinator getInstance() {
        if (instance == null) {
            instance = new Coordinator();
        }
        return instance;
    }

    public Prodavac getUlogovaniProdavac() {
        return ulogovaniProdavac;
    }

    public void setUlogovaniProdavac(Prodavac ulogovaniProdavac) {
        this.ulogovaniProdavac = ulogovaniProdavac;
    }

    public void dodajParam(String s, Object o) {
        parametri.put(s, o);
    }

    public Object vratiParam(String s) {
        return parametri.get(s);
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaController = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();
    }

    public void otvoriNarudzbenicaFormu(FormaMod mod) {
        narudzbenicaController = new NarudzbenicaController(new NarudzbenicaForma());
        narudzbenicaController.otvoriFormu(mod);
    }

    public void otvoriPrikazNarudzbenicaFormu() {
        prikazNarudzbenicaController = new PrikazNarudzbenicaController(new PrikazNarudzbenicaForma());
        prikazNarudzbenicaController.otvoriFormu();
    }

    public void otvoriPrikazKupacaFormu() {
        prikazKupacaController = new PrikazKupacaController(new PrikazKupacaForma());
        prikazKupacaController.otvoriFormu();
    }

    public void otvoriDodajKupcaFormu(FormaMod mod) {
        dodajKupcaController = new DodajKupcaController(new DodajKupcaForma());
        dodajKupcaController.otvoriFormu(mod);
    }

    public void otvoriPrikazFizickihLicaFormu() {
        prikazFizickihLicaController = new PrikazFizickihLicaController(new PrikazFizickihLicaForma());
        prikazFizickihLicaController.otvoriFormu();
    }

    public void otvoriDodajFizickoLiceFormu(FormaMod mod) {
        dodajFizickoLiceController = new DodajFizickoLiceController(new DodajFizickoLiceForma());
        dodajFizickoLiceController.otvoriFormu(mod);
    }

    public void otvoriPrikazPravnihLicaFormu() {
        prikazPravnihLicaController = new PrikazPravnihLicaController(new PrikazPravnihLicaForma());
        prikazPravnihLicaController.otvoriFormu();
    }

    public void otvoriDodajPravnoLiceFormu(FormaMod mod) {
        dodajPravnoLiceController = new DodajPravnoLiceController(new DodajPravnoLiceForma());
        dodajPravnoLiceController.otvoriFormu(mod);
    }

    public void otvoriPrikazProdavacaFormu() {
        prikazProdavacaController = new PrikazProdavacaController(new PrikazProdavacaForma());
        prikazProdavacaController.otvoriFormu();
    }

    public void otvoriDodajProdavcaFormu(FormaMod mod) {
        dodajProdavcaController = new DodajProdavcaController(new DodajProdavcaForma());
        dodajProdavcaController.otvoriFormu(mod);
    }

    public void otvoriPrikazTegliMedaFormu() {
        prikazTegliMedaController = new PrikazTegliMedaController(new PrikazTegliMedaForma());
        prikazTegliMedaController.otvoriFormu();
    }

    public void otvoriDodajTegluMedaFormu(FormaMod mod) {
        dodajTegluMedaController = new DodajTegluMedaController(new DodajTegluMedaForma());
        dodajTegluMedaController.otvoriFormu(mod);
    }

    public void otvoriPrikazSertifikataFormu() {
        prikazSertifikataController = new PrikazSertifikataController(new PrikazSertifikataForma());
        prikazSertifikataController.otvoriFormu();
    }

    public void otvoriDodajSertifikatFormu(FormaMod mod) {
        dodajSertifikatController = new DodajSertifikatController(new DodajSertifikatForma());
        dodajSertifikatController.otvoriFormu(mod);
    }

    public void osveziPrikazKupaca() {
        if (prikazKupacaController != null) {
            prikazKupacaController.pripremiFormu();
        }
    }

    public void osveziPrikazFizickihLica() {
        if (prikazFizickihLicaController != null) {
            prikazFizickihLicaController.pripremiFormu();
        }
    }

    public void osveziPrikazPravnihLica() {
        if (prikazPravnihLicaController != null) {
            prikazPravnihLicaController.pripremiFormu();
        }
    }

    public void osveziPrikazProdavaca() {
        if (prikazProdavacaController != null) {
            prikazProdavacaController.pripremiFormu();
        }
    }

    public void osveziPrikazTegliMeda() {
        if (prikazTegliMedaController != null) {
            prikazTegliMedaController.pripremiFormu();
        }
    }

    public void osveziPrikazSertifikata() {
        if (prikazSertifikataController != null) {
            prikazSertifikataController.pripremiFormu();
        }
    }

    public void osveziPrikazNarudzbenica() {
        if (prikazNarudzbenicaController != null) {
            prikazNarudzbenicaController.pripremiFormu();
        }
    }

}
