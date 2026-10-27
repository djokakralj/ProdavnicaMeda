/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class StavkaNarudzbenice implements ApstraktniDomenskiObjekat {

    private int idNarudzbenica;
    private int rb;
    private double cenaStavke;
    private int kolicina;
    private TeglaMeda teglaMeda;

    public StavkaNarudzbenice() {
    }

    public StavkaNarudzbenice(int idNarudzbenica, int rb,
            double cenaStavke, int kolicina, TeglaMeda teglaMeda) {
        this.idNarudzbenica = idNarudzbenica;
        this.rb = rb;
        this.cenaStavke = cenaStavke;
        this.kolicina = kolicina;
        this.teglaMeda = teglaMeda;
    }

    public int getIdNarudzbenica() {
        return idNarudzbenica;
    }

    public void setIdNarudzbenica(int idNarudzbenica) {
        this.idNarudzbenica = idNarudzbenica;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public TeglaMeda getTeglaMeda() {
        return teglaMeda;
    }

    public void setTeglaMeda(TeglaMeda teglaMeda) {
        this.teglaMeda = teglaMeda;
    }

    @Override
    public String toString() {
        return "StavkaNarudzbenice{" + "idNarudzbenica=" + idNarudzbenica + ", rb=" + rb
                + ", cenaStavke=" + cenaStavke + ", kolicina=" + kolicina + ", teglaMeda=" + teglaMeda + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkanarudzbenice";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int idNarudzbenica = rs.getInt("stavkanarudzbenice.idNarudzbenica");
            int rb = rs.getInt("stavkanarudzbenice.rb");
            double cenaStavke = rs.getDouble("stavkanarudzbenice.cenaStavke");
            int kolicina = rs.getInt("stavkanarudzbenice.kolicina");

            int idTeglaMeda = rs.getInt("t.idTeglaMeda");
            int gramaza = rs.getInt("t.gramaza");
            String vrstaTegle = rs.getString("t.vrstaTegle");
            String vrstaMeda = rs.getString("t.vrstaMeda");
            double cenaPoGramu = rs.getDouble("t.cenaPoGramu");
            double cena = rs.getDouble("t.cena");
            TeglaMeda tm = new TeglaMeda(idTeglaMeda, gramaza, vrstaTegle, vrstaMeda, cena, cenaPoGramu);

            StavkaNarudzbenice stavka = new StavkaNarudzbenice(idNarudzbenica, rb, cenaStavke, kolicina, tm);
            lista.add(stavka);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idNarudzbenica,rb,cenaStavke,kolicina,idTeglaMeda";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return idNarudzbenica + ", " + rb + ", " + cenaStavke + ", " + kolicina + ", " + teglaMeda.getIdTeglaMeda();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkanarudzbenice.idNarudzbenica=" + idNarudzbenica + " AND stavkanarudzbenice.rb=" + rb;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "cenaStavke=" + cenaStavke + ", kolicina=" + kolicina + ", idTeglaMeda=" + teglaMeda.getIdTeglaMeda();
    }

}
