/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.teglemeda;

import domen.TeglaMeda;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajTegleMedaSO extends ApstraktnaGenerickaOperacija {

    private List<TeglaMeda> tegleMeda;

    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        tegleMeda = broker.getAll(new TeglaMeda(), "");
    }

    public List<TeglaMeda> getTegleMeda() {
        return tegleMeda;
    }

}
