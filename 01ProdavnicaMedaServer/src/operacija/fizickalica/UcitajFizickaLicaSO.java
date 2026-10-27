/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.fizickalica;

import domen.FizickoLice;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajFizickaLicaSO extends ApstraktnaGenerickaOperacija {

    private List<FizickoLice> fizickaLica;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN kupac k ON k.idKupac=fizickolice.idKupac";
        fizickaLica = broker.getAll(new FizickoLice(), uslov);
    }

    public List<FizickoLice> getFizickaLica() {
        return fizickaLica;
    }

}
