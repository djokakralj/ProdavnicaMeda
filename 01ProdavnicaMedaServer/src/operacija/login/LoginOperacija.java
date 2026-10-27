/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.login;

import domen.Prodavac;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {

    Prodavac prodavac;

    public Prodavac getProdavac() {
        return prodavac;
    }

    @Override
    protected void preduslovi(Object param) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Prodavac trazeni = (Prodavac) param;
        prodavac = (Prodavac) broker.login(trazeni);
    }

}
