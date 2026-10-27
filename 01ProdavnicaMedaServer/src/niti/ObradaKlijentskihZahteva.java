/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.FizickoLice;
import domen.Kupac;
import domen.Narudzbenica;
import domen.PravnoLice;
import domen.Prodavac;
import domen.Sertifikat;
import domen.TeglaMeda;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.*;

/**
 *
 * @author Korisnik
 */
public class ObradaKlijentskihZahteva extends Thread {

    boolean kraj = false;
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskihZahteva() {
    }

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }

    @Override
    public void run() {

        while (!kraj) {
            Zahtev zahtev = (Zahtev) primalac.primi();
            if (zahtev == null) {
                break;
            }
            Odgovor odgovor = new Odgovor();

            try {
                switch (zahtev.getOperacija()) {
                    case LOGIN:
                        Prodavac p = (Prodavac) zahtev.getParametar();
                        p = Controller.getInstance().login(p);
                        odgovor.setOdgovor(p);
                        break;

                    // ******** PRODAVAC ********
                    case UCITAJ_PRODAVCE:
                        List<Prodavac> prodavci = Controller.getInstance().ucitajProdavce();
                        odgovor.setOdgovor(prodavci);
                        break;
                    case KREIRAJ_PRODAVCA:
                        Controller.getInstance().kreirajProdavca((Prodavac) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case PROMENI_PRODAVCA:
                        Controller.getInstance().promeniProdavca((Prodavac) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case OBRISI_PRODAVCA:
                        try {
                        Controller.getInstance().obrisiProdavca((Prodavac) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                    } catch (Exception e) {
                        odgovor.setOdgovor(new Exception("Sistem ne moze da obrise prodavca"));
                    }
                    break;

                    // ******** KUPAC ********
                    case UCITAJ_KUPCE:
                        List<Kupac> kupci = Controller.getInstance().ucitajKupce();
                        odgovor.setOdgovor(kupci);
                        break;
                    case KREIRAJ_KUPCA:
                        Controller.getInstance().kreirajKupca((Kupac) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case PROMENI_KUPCA:
                        Controller.getInstance().promeniKupca((Kupac) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case OBRISI_KUPCA:
                        try {
                        Controller.getInstance().obrisiKupca((Kupac) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                    } catch (Exception e) {
                        odgovor.setOdgovor(new Exception("Sistem ne moze da obrise kupca"));
                    }
                    break;

                    // ******** FIZICKO LICE ********
                    case UCITAJ_FIZICKA_LICA:
                        List<FizickoLice> fizickaLica = Controller.getInstance().ucitajFizickaLica();
                        odgovor.setOdgovor(fizickaLica);
                        break;
                    case KREIRAJ_FIZICKO_LICE:
                        Controller.getInstance().kreirajFizickoLice((FizickoLice) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case PROMENI_FIZICKO_LICE:
                        Controller.getInstance().promeniFizickoLice((FizickoLice) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case OBRISI_FIZICKO_LICE:
                        try {
                        Controller.getInstance().obrisiFizickoLice((FizickoLice) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                    } catch (Exception e) {
                        odgovor.setOdgovor(new Exception("Sistem ne moze da obrise fizicko lice"));
                    }
                    break;

                    // ******** PRAVNO LICE ********
                    case UCITAJ_PRAVNA_LICA:
                        List<PravnoLice> pravnaLica = Controller.getInstance().ucitajPravnaLica();
                        odgovor.setOdgovor(pravnaLica);
                        break;
                    case KREIRAJ_PRAVNO_LICE:
                        Controller.getInstance().kreirajPravnoLice((PravnoLice) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case PROMENI_PRAVNO_LICE:
                        Controller.getInstance().promeniPravnoLice((PravnoLice) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case OBRISI_PRAVNO_LICE:
                        try {
                        Controller.getInstance().obrisiPravnoLice((PravnoLice) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                    } catch (Exception e) {
                        odgovor.setOdgovor(new Exception("Sistem ne moze da obrise pravno lice"));
                    }
                    break;

                    // ******** TEGLA MEDA ********
                    case UCITAJ_TEGLE_MEDA:
                        List<TeglaMeda> tegle = Controller.getInstance().ucitajTegleMeda();
                        odgovor.setOdgovor(tegle);
                        break;
                    case KREIRAJ_TEGLU_MEDA:
                        Controller.getInstance().kreirajTegluMeda((TeglaMeda) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case PROMENI_TEGLU_MEDA:
                        Controller.getInstance().promeniTegluMeda((TeglaMeda) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case OBRISI_TEGLU_MEDA:
                        try {
                        Controller.getInstance().obrisiTegluMeda((TeglaMeda) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                    } catch (Exception e) {
                        odgovor.setOdgovor(new Exception("Sistem ne moze da obrise teglu meda"));
                    }
                    break;

                    // ******** SERTIFIKAT ********
                    case UCITAJ_SERTIFIKATE:
                        List<Sertifikat> sertifikati = Controller.getInstance().ucitajSertifikate();
                        odgovor.setOdgovor(sertifikati);
                        break;
                    case UBACI_SERTIFIKAT:
                        Controller.getInstance().ubaciSertifikat((Sertifikat) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case PROMENI_SERTIFIKAT:
                        Controller.getInstance().promeniSertifikat((Sertifikat) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case OBRISI_SERTIFIKAT:
                        try {
                        Controller.getInstance().obrisiSertifikat((Sertifikat) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                    } catch (Exception e) {
                        odgovor.setOdgovor(new Exception("Sistem ne moze da obrise Sertifikat"));
                    }
                    break;

                    // ******** NARUDZBENICA ********
                    case UCITAJ_NARUDZBENICE:
                        List<Narudzbenica> narudzbenice = Controller.getInstance().ucitajNarudzbenice();
                        odgovor.setOdgovor(narudzbenice);
                        break;
                    case KREIRAJ_NARUDZBENICU:
                        Controller.getInstance().kreirajNarudzbenicu((Narudzbenica) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case PROMENI_NARUDZBENICU:
                        Controller.getInstance().promeniNarudzbenicu((Narudzbenica) zahtev.getParametar());
                        odgovor.setOdgovor(null);
                        break;
                    case PRETRAZI_NARUDZBENICE:
                        List<Narudzbenica> pronadjene = Controller.getInstance().pretraziNarudzbenice((Narudzbenica) zahtev.getParametar());
                        odgovor.setOdgovor(pronadjene);
                        break;

                    default:
                        System.out.println("Greska! Ta operacija ne postoji");
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                odgovor.setOdgovor(ex.getMessage());
                posiljalac.posalji(odgovor);
            }
        }
    }

    public void prekini() {
        kraj = true;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        interrupt();
    }
}
