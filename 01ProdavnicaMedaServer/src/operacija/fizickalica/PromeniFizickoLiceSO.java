/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.fizickalica;

import domen.FizickoLice;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class PromeniFizickoLiceSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof FizickoLice)) {
            throw new Exception("Sistem ne moze da zapamti fizicko lice");
        }
        FizickoLice fl = (FizickoLice) param;
        if (fl.getJmbg() == null || fl.getJmbg().length() != 13 || !fl.getJmbg().matches("[0-9]+")) {
            throw new Exception("Sistem ne moze da zapamti fizicko lice");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.edit((FizickoLice) param);
    }

}
