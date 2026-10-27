/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.narudzbenice;

import domen.Narudzbenica;
import domen.StavkaNarudzbenice;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajNarudzbeniceSO extends ApstraktnaGenerickaOperacija {

    private List<Narudzbenica> narudzbenice;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN prodavac p ON p.idProdavac=narudzbenica.idProdavac"
                + " JOIN kupac k ON k.idKupac=narudzbenica.idKupac";
        narudzbenice = broker.getAll(new Narudzbenica(), uslov);

        for (Narudzbenica n : narudzbenice) {
            String uslovStavke = " JOIN teglameda t ON t.idTeglaMeda=stavkanarudzbenice.idTeglaMeda"
                    + " WHERE stavkanarudzbenice.idNarudzbenica=" + n.getIdNarudzbenica();
            List<StavkaNarudzbenice> stavke = broker.getAll(new StavkaNarudzbenice(), uslovStavke);
            n.setStavke(stavke);
        }
    }

    public List<Narudzbenica> getNarudzbenice() {
        return narudzbenice;
    }

}
