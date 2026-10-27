/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.prodavci;

import domen.Prodavac;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class KreirajProdavcaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Prodavac)) {
            throw new Exception("Sistem ne moze da kreira prodavca");
        }
        Prodavac p = (Prodavac) param;
        if (p.getIme() == null || p.getIme().length() < 3
                || p.getPrezime() == null || p.getPrezime().length() < 3) {
            throw new Exception("Sistem ne moze da kreira prodavca");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Prodavac) param);
    }

}
