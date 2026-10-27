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
public class FizickoLice implements ApstraktniDomenskiObjekat {

    private Kupac kupac;
    private String jmbg;

    public FizickoLice() {
    }

    public FizickoLice(Kupac kupac, String jmbg) {
        this.kupac = kupac;
        this.jmbg = jmbg;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return kupac + " (" + jmbg + ")";
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
        final FizickoLice other = (FizickoLice) obj;
        return this.kupac != null && other.kupac != null
                && this.kupac.getIdKupac() == other.kupac.getIdKupac();
    }

    @Override
    public String vratiNazivTabele() {
        return "fizickolice";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            String jmbg = rs.getString("fizickolice.JMBG");

            int idKupac = rs.getInt("k.idKupac");
            String ime = rs.getString("k.ime");
            String prezime = rs.getString("k.prezime");
            Date datumRodjenja = rs.getDate("k.datumRodjenja");
            int starost = rs.getInt("k.starost");
            Kupac k = new Kupac(idKupac, ime, prezime, datumRodjenja, starost);

            FizickoLice fl = new FizickoLice(k, jmbg);
            lista.add(fl);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idKupac,JMBG";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return kupac.getIdKupac() + ", '" + jmbg + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "fizickolice.idKupac=" + kupac.getIdKupac();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "JMBG='" + jmbg + "'";
    }

}
