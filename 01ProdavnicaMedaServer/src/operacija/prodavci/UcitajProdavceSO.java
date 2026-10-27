/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.prodavci;

import domen.Prodavac;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajProdavceSO extends ApstraktnaGenerickaOperacija {

    private List<Prodavac> prodavci;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        prodavci = broker.getAll(new Prodavac(), "");
    }

    public List<Prodavac> getProdavci() {
        return prodavci;
    }

}
