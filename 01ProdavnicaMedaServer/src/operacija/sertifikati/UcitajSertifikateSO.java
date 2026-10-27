/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.sertifikati;

import domen.Sertifikat;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajSertifikateSO extends ApstraktnaGenerickaOperacija {

    private List<Sertifikat> sertifikati;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        sertifikati = broker.getAll(new Sertifikat(), "");
    }

    public List<Sertifikat> getSertifikati() {
        return sertifikati;
    }

}
