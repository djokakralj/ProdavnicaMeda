/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.kupci;

import domen.Kupac;
import java.util.Date;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class PromeniKupcaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Kupac)) {
            throw new Exception("Sistem ne moze da zapamti kupca");
        }
        Kupac k = (Kupac) param;
        if (k.getIme() == null || k.getIme().length() < 3
                || k.getPrezime() == null || k.getPrezime().length() < 3
                || k.getDatumRodjenja() == null
                || k.getDatumRodjenja().after(new Date())) {
            throw new Exception("Sistem ne moze da zapamti kupca");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((Kupac) param);
    }

}
