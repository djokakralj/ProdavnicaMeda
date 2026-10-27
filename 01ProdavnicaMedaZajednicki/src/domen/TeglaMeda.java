/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class TeglaMeda implements ApstraktniDomenskiObjekat {

    private int idTeglaMeda;
    private int gramaza;
    private String vrstaTegle;
    private String vrstaMeda;
    private double cena;
    private double cenaPoGramu;

    public TeglaMeda() {
    }

    public TeglaMeda(int idTeglaMeda, int gramaza, String vrstaTegle, String vrstaMeda, double cena, double cenaPoGramu) {
        this.idTeglaMeda = idTeglaMeda;
        this.gramaza = gramaza;
        this.vrstaTegle = vrstaTegle;
        this.vrstaMeda = vrstaMeda;
        this.cena = cena;
        this.cenaPoGramu = cenaPoGramu;
    }

    public int getIdTeglaMeda() {
        return idTeglaMeda;
    }

    public int getGramaza() {
        return gramaza;
    }

    public String getVrstaTegle() {
        return vrstaTegle;
    }

    public String getVrstaMeda() {
        return vrstaMeda;
    }

    public double getCena() {
        return cena;
    }

    public double getCenaPoGramu() {
        return cenaPoGramu;
    }

    public void setIdTeglaMeda(int idTeglaMeda) {
        this.idTeglaMeda = idTeglaMeda;
    }

    public void setGramaza(int gramaza) {
        this.gramaza = gramaza;
    }

    public void setVrstaTegle(String vrstaTegle) {
        this.vrstaTegle = vrstaTegle;
    }

    public void setVrstaMeda(String vrstaMeda) {
        this.vrstaMeda = vrstaMeda;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setCenaPoGramu(double cenaPoGramu) {
        this.cenaPoGramu = cenaPoGramu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TeglaMeda other = (TeglaMeda) obj;
        if (this.gramaza != other.gramaza) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cenaPoGramu) != Double.doubleToLongBits(other.cenaPoGramu)) {
            return false;
        }
        if (!Objects.equals(this.vrstaTegle, other.vrstaTegle)) {
            return false;
        }
        return Objects.equals(this.vrstaMeda, other.vrstaMeda);
    }

    @Override
    public String toString() {
        return vrstaMeda + " " + gramaza + "g (" + vrstaTegle + ") - " + cena + " din";
    }

    @Override
    public String vratiNazivTabele() {
        return "teglameda";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();

        while (rs.next()) {
            int idTeglaMeda = rs.getInt("teglameda.idTeglaMeda");
            int gramaza = rs.getInt("teglameda.gramaza");
            String vrstaTegle = rs.getString("teglameda.vrstaTegle");
            String vrstaMeda = rs.getString("teglameda.vrstaMeda");
            double cenaPoGramu = rs.getDouble("teglameda.cenaPoGramu");
            double cena = rs.getDouble("teglameda.cena");

            TeglaMeda tm = new TeglaMeda(idTeglaMeda, gramaza, vrstaTegle, vrstaMeda, cena, cenaPoGramu);
            lista.add(tm);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "gramaza,vrstaTegle,vrstaMeda,cenaPoGramu,cena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return gramaza + ", '" + vrstaTegle + "', '" + vrstaMeda + "', " + cenaPoGramu + ", " + cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "teglameda.idTeglaMeda=" + idTeglaMeda;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "gramaza=" + gramaza + ", vrstaTegle='" + vrstaTegle + "', vrstaMeda='" + vrstaMeda
                + "', cenaPoGramu=" + cenaPoGramu + ", cena=" + cena;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
