/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.pravnalica;

import domen.PravnoLice;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajPravnaLicaSO extends ApstraktnaGenerickaOperacija {

    private List<PravnoLice> pravnaLica;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN kupac k ON k.idKupac=pravnolice.idKupac";
        pravnaLica = broker.getAll(new PravnoLice(), uslov);
    }

    public List<PravnoLice> getPravnaLica() {
        return pravnaLica;
    }

}
