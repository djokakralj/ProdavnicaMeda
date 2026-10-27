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
public class Narudzbenica implements ApstraktniDomenskiObjekat {

    private int idNarudzbenica;
    private Date datumIzdavanja;
    private double ukupanIznos;
    private int ukupnoStavki;
    private Prodavac prodavac;
    private Kupac kupac;

    private List<StavkaNarudzbenice> stavke = new ArrayList<>();

    public Narudzbenica() {
    }

    public Narudzbenica(int idNarudzbenica, Date datumIzdavanja, double ukupanIznos,
            int ukupnoStavki, Prodavac prodavac, Kupac kupac) {
        this.idNarudzbenica = idNarudzbenica;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznos = ukupanIznos;
        this.ukupnoStavki = ukupnoStavki;
        this.prodavac = prodavac;
        this.kupac = kupac;
    }

    public int getIdNarudzbenica() {
        return idNarudzbenica;
    }

    public void setIdNarudzbenica(int idNarudzbenica) {
        this.idNarudzbenica = idNarudzbenica;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public int getUkupnoStavki() {
        return ukupnoStavki;
    }

    public void setUkupnoStavki(int ukupnoStavki) {
        this.ukupnoStavki = ukupnoStavki;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public List<StavkaNarudzbenice> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaNarudzbenice> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Narudzbenica " + idNarudzbenica + " (" + datumIzdavanja + ", " + prodavac + ", " + kupac + ")";
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
        final Narudzbenica other = (Narudzbenica) obj;
        return this.idNarudzbenica == other.idNarudzbenica;
    }

    @Override
    public String vratiNazivTabele() {
        return "narudzbenica";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            // ** NARUDZBENICA **
            int idNarudzbenica = rs.getInt("narudzbenica.idNarudzbenica");
            Date datumIzdavanja = rs.getDate("narudzbenica.datumIzdavanja");
            double ukupanIznos = rs.getDouble("narudzbenica.ukupanIznos");
            int ukupnoStavki = rs.getInt("narudzbenica.ukupnoStavki");

            // ** PRODAVAC **
            int idProdavac = rs.getInt("p.idProdavac");
            String imeP = rs.getString("p.ime");
            String prezimeP = rs.getString("p.prezime");
            Prodavac p = new Prodavac(idProdavac, imeP, prezimeP, null, null);

            // ** KUPAC **
            int idKupac = rs.getInt("k.idKupac");
            String imeK = rs.getString("k.ime");
            String prezimeK = rs.getString("k.prezime");
            Date datumRodjenja = rs.getDate("k.datumRodjenja");
            int starost = rs.getInt("k.starost");
            Kupac k = new Kupac(idKupac, imeK, prezimeK, datumRodjenja, starost);

            Narudzbenica n = new Narudzbenica(idNarudzbenica, datumIzdavanja, ukupanIznos, ukupnoStavki, p, k);
            n.setStavke(new ArrayList<>());
            lista.add(n);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumIzdavanja,ukupanIznos,ukupnoStavki,idProdavac,idKupac";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date sqlDatum = new java.sql.Date(datumIzdavanja.getTime());
        return "'" + sqlDatum + "', " + ukupanIznos + ", " + ukupnoStavki + ", "
                + prodavac.getIdProdavac() + ", " + kupac.getIdKupac();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "narudzbenica.idNarudzbenica=" + idNarudzbenica;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        java.sql.Date sqlDatum = new java.sql.Date(datumIzdavanja.getTime());
        return "datumIzdavanja='" + sqlDatum + "', ukupanIznos=" + ukupanIznos + ", ukupnoStavki=" + ukupnoStavki
                + ", idProdavac=" + prodavac.getIdProdavac() + ", idKupac=" + kupac.getIdKupac();
    }

}
