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
public class PravnoLice implements ApstraktniDomenskiObjekat {

    private Kupac kupac;
    private String pib;

    public PravnoLice() {
    }

    public PravnoLice(Kupac kupac, String pib) {
        this.kupac = kupac;
        this.pib = pib;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    @Override
    public String toString() {
        return kupac + " (" + pib + ")";
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
        final PravnoLice other = (PravnoLice) obj;
        return this.kupac != null && other.kupac != null
                && this.kupac.getIdKupac() == other.kupac.getIdKupac();
    }

    @Override
    public String vratiNazivTabele() {
        return "pravnolice";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            String pib = rs.getString("pravnolice.PIB");

            int idKupac = rs.getInt("k.idKupac");
            String ime = rs.getString("k.ime");
            String prezime = rs.getString("k.prezime");
            Date datumRodjenja = rs.getDate("k.datumRodjenja");
            int starost = rs.getInt("k.starost");
            Kupac k = new Kupac(idKupac, ime, prezime, datumRodjenja, starost);

            PravnoLice pl = new PravnoLice(k, pib);
            lista.add(pl);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idKupac,PIB";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return kupac.getIdKupac() + ", '" + pib + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "pravnolice.idKupac=" + kupac.getIdKupac();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "PIB='" + pib + "'";
    }

}
