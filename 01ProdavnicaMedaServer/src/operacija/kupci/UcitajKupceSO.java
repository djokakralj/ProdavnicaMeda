/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.kupci;

import domen.Kupac;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajKupceSO extends ApstraktnaGenerickaOperacija {

    private List<Kupac> kupci;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        kupci = broker.getAll(new Kupac(), "");
    }

    public List<Kupac> getKupci() {
        return kupci;
    }

}
