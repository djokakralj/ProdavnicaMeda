/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.pravnalica;

import domen.PravnoLice;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class PromeniPravnoLiceSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof PravnoLice)) {
            throw new Exception("Sistem ne moze da zapamti pravno lice");
        }
        PravnoLice pl = (PravnoLice) param;
        if (pl.getPib() == null || pl.getPib().length() != 9 || !pl.getPib().matches("[0-9]+")) {
            throw new Exception("Sistem ne moze da zapamti pravno lice");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((PravnoLice) param);
    }

}
