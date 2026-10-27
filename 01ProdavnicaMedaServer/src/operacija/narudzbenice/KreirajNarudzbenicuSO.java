/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.narudzbenice;

import domen.Narudzbenica;
import domen.StavkaNarudzbenice;
import domen.TeglaMeda;
import java.util.Date;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class KreirajNarudzbenicuSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Narudzbenica)) {
            throw new Exception("Sistem ne moze da kreira narudzbenicu");
        }
        Narudzbenica n = (Narudzbenica) param;
        if (n.getProdavac() == null || n.getKupac() == null || n.getDatumIzdavanja() == null
                || n.getDatumIzdavanja().after(new Date())
                || n.getUkupanIznos() <= 0 || n.getStavke() == null || n.getStavke().isEmpty()) {
            throw new Exception("Sistem ne moze da kreira narudzbenicu");
        }
        if (imaDuplihStavki(n.getStavke())) {
            throw new Exception("Sistem ne moze da kreira narudzbenicu");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {

        Narudzbenica n = (Narudzbenica) param;
        int idNarudzbenica = broker.addReturnKey(n);

        List<StavkaNarudzbenice> stavke = n.getStavke();
        int rb = 1;
        for (StavkaNarudzbenice sn : stavke) {
            sn.setIdNarudzbenica(idNarudzbenica);
            sn.setRb(rb++);
            broker.add(sn);
        }
    }

    private boolean imaDuplihStavki(List<StavkaNarudzbenice> stavke) {
        for (int i = 0; i < stavke.size(); i++) {
            TeglaMeda prva = stavke.get(i).getTeglaMeda();
            if (prva == null) {
                continue;
            }
            for (int j = i + 1; j < stavke.size(); j++) {
                TeglaMeda druga = stavke.get(j).getTeglaMeda();
                if (druga != null && prva.getIdTeglaMeda() == druga.getIdTeglaMeda()) {
                    return true;
                }
            }
        }
        return false;
    }

}
