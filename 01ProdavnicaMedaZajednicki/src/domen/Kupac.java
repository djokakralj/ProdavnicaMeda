/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Kupac implements ApstraktniDomenskiObjekat {

    private int idKupac;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private int starost;

    public Kupac() {
    }

    public Kupac(int idKupac, String ime, String prezime, Date datumRodjenja, int starost) {
        this.idKupac = idKupac;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.starost = starost;
    }

    public int getIdKupac() {
        return idKupac;
    }

    public void setIdKupac(int idKupac) {
        this.idKupac = idKupac;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Kupac other = (Kupac) obj;
        return this.idKupac == other.idKupac;
    }

    @Override
    public String vratiNazivTabele() {
        return "kupac";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int idKupac = rs.getInt("kupac.idKupac");
            String ime = rs.getString("kupac.ime");
            String prezime = rs.getString("kupac.prezime");
            Date datumRodjenja = rs.getDate("kupac.datumRodjenja");
            int starost = rs.getInt("kupac.starost");

            Kupac k = new Kupac(idKupac, ime, prezime, datumRodjenja, starost);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,datumRodjenja,starost";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date sqlDatum = new java.sql.Date(datumRodjenja.getTime());
        return "'" + ime + "', '" + prezime + "', '" + sqlDatum + "', " + starost;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kupac.idKupac=" + idKupac;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        java.sql.Date sqlDatum = new java.sql.Date(datumRodjenja.getTime());
        return "ime='" + ime + "', prezime='" + prezime + "', datumRodjenja='" + sqlDatum + "', starost=" + starost;
    }

}
