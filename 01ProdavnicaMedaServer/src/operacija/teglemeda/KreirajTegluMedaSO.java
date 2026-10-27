/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.teglemeda;

import domen.TeglaMeda;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class KreirajTegluMedaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof TeglaMeda)) {
            throw new Exception("Sistem ne moze da kreira teglu meda");
        }
        TeglaMeda tm = (TeglaMeda) param;
        if (tm.getGramaza() <= 0 || tm.getCenaPoGramu() <= 0 || tm.getCena() <= 0
                || tm.getVrstaTegle() == null || tm.getVrstaMeda() == null) {
            throw new Exception("Sistem ne moze da kreira teglu meda");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((TeglaMeda) param);
    }

}
