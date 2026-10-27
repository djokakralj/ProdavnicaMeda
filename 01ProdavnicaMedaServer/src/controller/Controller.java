/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.FizickoLice;
import domen.Kupac;
import domen.Narudzbenica;
import domen.PravnoLice;
import domen.Prodavac;
import domen.Sertifikat;
import domen.TeglaMeda;
import java.util.List;
import operacija.fizickalica.*;
import operacija.kupci.*;
import operacija.login.LoginOperacija;
import operacija.narudzbenice.*;
import operacija.pravnalica.*;
import operacija.prodavci.*;
import operacija.sertifikati.*;
import operacija.teglemeda.*;

/**
 *
 * @author Korisnik
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // ******** LOGIN ********
    public Prodavac login(Prodavac p) throws Exception {
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(p, null);
        return operacija.getProdavac();
    }

    // ******** PRODAVAC ********
    public List<Prodavac> ucitajProdavce() throws Exception {
        UcitajProdavceSO operacija = new UcitajProdavceSO();
        operacija.izvrsi(null, null);
        return operacija.getProdavci();
    }

    public void kreirajProdavca(Prodavac p) throws Exception {
        KreirajProdavcaSO operacija = new KreirajProdavcaSO();
        operacija.izvrsi(p, null);
    }

    public void promeniProdavca(Prodavac p) throws Exception {
        PromeniProdavcaSO operacija = new PromeniProdavcaSO();
        operacija.izvrsi(p, null);
    }

    public void obrisiProdavca(Prodavac p) throws Exception {
        ObrisiProdavcaSO operacija = new ObrisiProdavcaSO();
        operacija.izvrsi(p, null);
    }

    // ******** KUPAC ********
    public List<Kupac> ucitajKupce() throws Exception {
        UcitajKupceSO operacija = new UcitajKupceSO();
        operacija.izvrsi(null, null);
        return operacija.getKupci();
    }

    public void kreirajKupca(Kupac k) throws Exception {
        KreirajKupcaSO operacija = new KreirajKupcaSO();
        operacija.izvrsi(k, null);
    }

    public void promeniKupca(Kupac k) throws Exception {
        PromeniKupcaSO operacija = new PromeniKupcaSO();
        operacija.izvrsi(k, null);
    }

    public void obrisiKupca(Kupac k) throws Exception {
        ObrisiKupcaSO operacija = new ObrisiKupcaSO();
        operacija.izvrsi(k, null);
    }

    // ******** FIZICKO LICE ********
    public List<FizickoLice> ucitajFizickaLica() throws Exception {
        UcitajFizickaLicaSO operacija = new UcitajFizickaLicaSO();
        operacija.izvrsi(null, null);
        return operacija.getFizickaLica();
    }

    public void kreirajFizickoLice(FizickoLice fl) throws Exception {
        KreirajFizickoLiceSO operacija = new KreirajFizickoLiceSO();
        operacija.izvrsi(fl, null);
    }

    public void promeniFizickoLice(FizickoLice fl) throws Exception {
        PromeniFizickoLiceSO operacija = new PromeniFizickoLiceSO();
        operacija.izvrsi(fl, null);
    }

    public void obrisiFizickoLice(FizickoLice fl) throws Exception {
        ObrisiFizickoLiceSO operacija = new ObrisiFizickoLiceSO();
        operacija.izvrsi(fl, null);
    }

    // ******** PRAVNO LICE ********
    public List<PravnoLice> ucitajPravnaLica() throws Exception {
        UcitajPravnaLicaSO operacija = new UcitajPravnaLicaSO();
        operacija.izvrsi(null, null);
        return operacija.getPravnaLica();
    }

    public void kreirajPravnoLice(PravnoLice pl) throws Exception {
        KreirajPravnoLiceSO operacija = new KreirajPravnoLiceSO();
        operacija.izvrsi(pl, null);
    }

    public void promeniPravnoLice(PravnoLice pl) throws Exception {
        PromeniPravnoLiceSO operacija = new PromeniPravnoLiceSO();
        operacija.izvrsi(pl, null);
    }

    public void obrisiPravnoLice(PravnoLice pl) throws Exception {
        ObrisiPravnoLiceSO operacija = new ObrisiPravnoLiceSO();
        operacija.izvrsi(pl, null);
    }

    // ******** TEGLA MEDA ********
    public List<TeglaMeda> ucitajTegleMeda() throws Exception {
        UcitajTegleMedaSO operacija = new UcitajTegleMedaSO();
        operacija.izvrsi(null, null);
        return operacija.getTegleMeda();
    }

    public void kreirajTegluMeda(TeglaMeda tm) throws Exception {
        KreirajTegluMedaSO operacija = new KreirajTegluMedaSO();
        operacija.izvrsi(tm, null);
    }

    public void promeniTegluMeda(TeglaMeda tm) throws Exception {
        PromeniTegluMedaSO operacija = new PromeniTegluMedaSO();
        operacija.izvrsi(tm, null);
    }

    public void obrisiTegluMeda(TeglaMeda tm) throws Exception {
        ObrisiTegluMedaSO operacija = new ObrisiTegluMedaSO();
        operacija.izvrsi(tm, null);
    }

    // ******** SERTIFIKAT ********
    public List<Sertifikat> ucitajSertifikate() throws Exception {
        UcitajSertifikateSO operacija = new UcitajSertifikateSO();
        operacija.izvrsi(null, null);
        return operacija.getSertifikati();
    }

    public void ubaciSertifikat(Sertifikat s) throws Exception {
        UbaciSertifikatSO operacija = new UbaciSertifikatSO();
        operacija.izvrsi(s, null);
    }

    public void promeniSertifikat(Sertifikat s) throws Exception {
        PromeniSertifikatSO operacija = new PromeniSertifikatSO();
        operacija.izvrsi(s, null);
    }

    public void obrisiSertifikat(Sertifikat s) throws Exception {
        ObrisiSertifikatSO operacija = new ObrisiSertifikatSO();
        operacija.izvrsi(s, null);
    }

    // ******** NARUDZBENICA ********
    public List<Narudzbenica> ucitajNarudzbenice() throws Exception {
        UcitajNarudzbeniceSO operacija = new UcitajNarudzbeniceSO();
        operacija.izvrsi(null, null);
        return operacija.getNarudzbenice();
    }

    public void kreirajNarudzbenicu(Narudzbenica n) throws Exception {
        KreirajNarudzbenicuSO operacija = new KreirajNarudzbenicuSO();
        operacija.izvrsi(n, null);
    }

    public void promeniNarudzbenicu(Narudzbenica n) throws Exception {
        PromeniNarudzbenicuSO operacija = new PromeniNarudzbenicuSO();
        operacija.izvrsi(n, null);
    }

    public List<Narudzbenica> pretraziNarudzbenice(Narudzbenica n) throws Exception {
        PretraziNarudzbeniceSO operacija = new PretraziNarudzbeniceSO();
        operacija.izvrsi(n, null);
        return operacija.getNarudzbenice();
    }

}
