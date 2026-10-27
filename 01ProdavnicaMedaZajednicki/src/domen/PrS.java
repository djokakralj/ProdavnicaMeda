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
public class PrS implements ApstraktniDomenskiObjekat {

    private Prodavac prodavac;
    private Sertifikat sertifikat;
    private Date datumIzdavanja;
    private Date datumIsteka;

    public PrS() {
    }

    public PrS(Prodavac prodavac, Sertifikat sertifikat, Date datumIzdavanja, Date datumIsteka) {
        this.prodavac = prodavac;
        this.sertifikat = sertifikat;
        this.datumIzdavanja = datumIzdavanja;
        this.datumIsteka = datumIsteka;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public Sertifikat getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(Sertifikat sertifikat) {
        this.sertifikat = sertifikat;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Date getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(Date datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    @Override
    public String toString() {
        return "PrS{" + "prodavac=" + prodavac + ", sertifikat=" + sertifikat
                + ", datumIzdavanja=" + datumIzdavanja + ", datumIsteka=" + datumIsteka + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "prs";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Date datumIzdavanja = rs.getDate("prs.datumIzdavanja");
            Date datumIsteka = rs.getDate("prs.datumIsteka");

            int idProdavac = rs.getInt("p.idProdavac");
            String ime = rs.getString("p.ime");
            String prezime = rs.getString("p.prezime");
            Prodavac p = new Prodavac(idProdavac, ime, prezime, null, null);

            int idSertifikat = rs.getInt("s.idSertifikat");
            String naziv = rs.getString("s.naziv");
            Sertifikat s = new Sertifikat(idSertifikat, naziv);

            PrS prs = new PrS(p, s, datumIzdavanja, datumIsteka);
            lista.add(prs);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idProdavac,idSertifikat,datumIzdavanja,datumIsteka";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date sqlIzdavanje = new java.sql.Date(datumIzdavanja.getTime());
        java.sql.Date sqlIstek = new java.sql.Date(datumIsteka.getTime());
        return prodavac.getIdProdavac() + ", " + sertifikat.getIdSertifikat() + ", '" + sqlIzdavanje + "', '" + sqlIstek + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "prs.idProdavac=" + prodavac.getIdProdavac() + " AND prs.idSertifikat=" + sertifikat.getIdSertifikat();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        java.sql.Date sqlIzdavanje = new java.sql.Date(datumIzdavanja.getTime());
        java.sql.Date sqlIstek = new java.sql.Date(datumIsteka.getTime());
        return "datumIzdavanja='" + sqlIzdavanje + "', datumIsteka='" + sqlIstek + "'";
    }

}
