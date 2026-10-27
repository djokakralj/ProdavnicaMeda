/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.narudzbenice;

import domen.Narudzbenica;
import domen.StavkaNarudzbenice;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class PretraziNarudzbeniceSO extends ApstraktnaGenerickaOperacija {

    private List<Narudzbenica> narudzbenice;

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Narudzbenica)) {
            throw new Exception("Sistem ne moze da nadje narudzbenice po zadatim kriterijumima");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String joinUslov = " JOIN prodavac p ON p.idProdavac=narudzbenica.idProdavac"
                + " JOIN kupac k ON k.idKupac=narudzbenica.idKupac";

        List<String> uslovi = new ArrayList<>();
        Narudzbenica n = (Narudzbenica) param;

        if (n.getIdNarudzbenica() != 0) {
            uslovi.add("narudzbenica.idNarudzbenica=" + n.getIdNarudzbenica());
        }
        if (n.getUkupanIznos() != 0) {
            uslovi.add("narudzbenica.ukupanIznos <= " + n.getUkupanIznos());
        }
        if (n.getDatumIzdavanja() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            uslovi.add("narudzbenica.datumIzdavanja='" + sdf.format(n.getDatumIzdavanja()) + "'");
        }
        if (n.getProdavac() != null) {
            uslovi.add("p.idProdavac=" + n.getProdavac().getIdProdavac());
        }
        if (n.getKupac() != null) {
            uslovi.add("k.idKupac=" + n.getKupac().getIdKupac());
        }

        if (kljuc != null && !kljuc.isEmpty()) {
            uslovi.add("narudzbenica.idNarudzbenica IN (SELECT sn.idNarudzbenica FROM stavkanarudzbenice sn WHERE sn.idTeglaMeda=" + kljuc + ")");
        }

        String whereUslov = "";
        if (!uslovi.isEmpty()) {
            whereUslov = " WHERE " + String.join(" AND ", uslovi);
        }

        String finalniUslov = joinUslov + whereUslov;
        System.out.println(finalniUslov);

        narudzbenice = broker.getAll(new Narudzbenica(), finalniUslov);

        for (Narudzbenica nar : narudzbenice) {
            String uslovStavke = " JOIN teglameda t ON t.idTeglaMeda=stavkanarudzbenice.idTeglaMeda"
                    + " WHERE stavkanarudzbenice.idNarudzbenica=" + nar.getIdNarudzbenica();
            List<StavkaNarudzbenice> stavke = broker.getAll(new StavkaNarudzbenice(), uslovStavke);
            nar.setStavke(stavke);
        }
    }

    public List<Narudzbenica> getNarudzbenice() {
        return narudzbenice;
    }

}
