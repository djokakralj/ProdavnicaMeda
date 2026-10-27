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
public class PromeniNarudzbenicuSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Narudzbenica)) {
            throw new Exception("Sistem ne moze da zapamti narudzbenicu");
        }
        Narudzbenica n = (Narudzbenica) param;
        if (n.getProdavac() == null || n.getKupac() == null || n.getDatumIzdavanja() == null
                || n.getDatumIzdavanja().after(new Date())
                || n.getStavke() == null || n.getStavke().isEmpty()) {
            throw new Exception("Sistem ne moze da zapamti narudzbenicu");
        }
        if (imaDuplihStavki(n.getStavke())) {
            throw new Exception("Sistem ne moze da zapamti narudzbenicu");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Narudzbenica n = (Narudzbenica) param;
        broker.edit(n);

        String uslov = " JOIN teglameda t ON t.idTeglaMeda=stavkanarudzbenice.idTeglaMeda"
                + " WHERE stavkanarudzbenice.idNarudzbenica=" + n.getIdNarudzbenica();
        List<StavkaNarudzbenice> stareStavke = broker.getAll(new StavkaNarudzbenice(), uslov);
        List<StavkaNarudzbenice> noveStavke = n.getStavke();

        for (StavkaNarudzbenice stara : stareStavke) {
            if (nadjiStavku(noveStavke, stara) == null) {
                broker.delete(stara);
            }
        }

        int sledeciRb = sledeciSlobodanRb(stareStavke);
        for (StavkaNarudzbenice nova : noveStavke) {
            StavkaNarudzbenice stara = nadjiStavku(stareStavke, nova);
            if (stara == null) {
                nova.setIdNarudzbenica(n.getIdNarudzbenica());
                nova.setRb(sledeciRb++);
                broker.add(nova);
            } else if (nova.getKolicina() != stara.getKolicina()
                    || Double.compare(nova.getCenaStavke(), stara.getCenaStavke()) != 0) {
                nova.setIdNarudzbenica(n.getIdNarudzbenica());
                nova.setRb(stara.getRb());
                broker.edit(nova);
            }
        }
    }

    private StavkaNarudzbenice nadjiStavku(List<StavkaNarudzbenice> lista, StavkaNarudzbenice trazena) {
        if (trazena.getTeglaMeda() == null) {
            return null;
        }
        for (StavkaNarudzbenice sn : lista) {
            if (sn.getTeglaMeda() != null
                    && sn.getTeglaMeda().getIdTeglaMeda() == trazena.getTeglaMeda().getIdTeglaMeda()) {
                return sn;
            }
        }
        return null;
    }

    private int sledeciSlobodanRb(List<StavkaNarudzbenice> stareStavke) {
        int maxRb = 0;
        for (StavkaNarudzbenice sn : stareStavke) {
            if (sn.getRb() > maxRb) {
                maxRb = sn.getRb();
            }
        }
        return maxRb + 1;
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
