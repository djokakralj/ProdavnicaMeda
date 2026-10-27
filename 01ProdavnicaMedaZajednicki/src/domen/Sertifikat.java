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
public class Sertifikat implements ApstraktniDomenskiObjekat {

    private int idSertifikat;
    private String naziv;

    public Sertifikat() {
    }

    public Sertifikat(int idSertifikat, String naziv) {
        this.idSertifikat = idSertifikat;
        this.naziv = naziv;
    }

    public int getIdSertifikat() {
        return idSertifikat;
    }

    public void setIdSertifikat(int idSertifikat) {
        this.idSertifikat = idSertifikat;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Sertifikat other = (Sertifikat) obj;
        return this.idSertifikat == other.idSertifikat;
    }

    @Override
    public String vratiNazivTabele() {
        return "sertifikat";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int idSertifikat = rs.getInt("sertifikat.idSertifikat");
            String naziv = rs.getString("sertifikat.naziv");

            Sertifikat s = new Sertifikat(idSertifikat, naziv);
            lista.add(s);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "sertifikat.idSertifikat=" + idSertifikat;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "'";
    }

}
