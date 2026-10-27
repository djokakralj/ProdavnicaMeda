/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.sertifikati;

import domen.Sertifikat;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UbaciSertifikatSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Sertifikat)) {
            throw new Exception("Sistem ne moze da zapamti Sertifikat");
        }
        Sertifikat s = (Sertifikat) param;
        if (s.getNaziv() == null || s.getNaziv().isEmpty()) {
            throw new Exception("Sistem ne moze da zapamti Sertifikat");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Sertifikat) param);
    }

}
