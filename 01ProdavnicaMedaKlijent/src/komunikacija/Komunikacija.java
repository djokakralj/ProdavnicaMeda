/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.FizickoLice;
import domen.Kupac;
import domen.Narudzbenica;
import domen.PravnoLice;
import domen.Prodavac;
import domen.Sertifikat;
import domen.TeglaMeda;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Komunikacija {

    private Socket socket;
    private static Komunikacija instance;
    private Posiljalac posiljalac;
    private Primalac primalac;

    private Komunikacija() {
    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void konekcija() {
        try {
            socket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
        } catch (IOException ex) {
            System.getLogger(Komunikacija.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // ******** LOGIN ********
    public Prodavac login(String username, String password) throws Exception {
        Prodavac prodavac = new Prodavac();
        prodavac.setKorisnickoIme(username);
        prodavac.setSifra(password);

        return (Prodavac) posaljiZahtevVratiObjekat(Operacija.LOGIN, prodavac);
    }

    // ******** PRODAVAC ********
    public List<Prodavac> ucitajProdavce() throws Exception {
        return (List<Prodavac>) posaljiZahtevVratiListu(Operacija.UCITAJ_PRODAVCE, null);
    }

    public void kreirajProdavca(Prodavac p) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.KREIRAJ_PRODAVCA, p);
    }

    public void promeniProdavca(Prodavac p) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.PROMENI_PRODAVCA, p);
    }

    public void obrisiProdavca(Prodavac p) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.OBRISI_PRODAVCA, p);
    }

    // ******** KUPAC ********
    public List<Kupac> ucitajKupce() throws Exception {
        return (List<Kupac>) posaljiZahtevVratiListu(Operacija.UCITAJ_KUPCE, null);
    }

    public void kreirajKupca(Kupac k) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.KREIRAJ_KUPCA, k);
    }

    public void promeniKupca(Kupac k) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.PROMENI_KUPCA, k);
    }

    public void obrisiKupca(Kupac k) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.OBRISI_KUPCA, k);
    }

    // ******** FIZICKO LICE ********
    public List<FizickoLice> ucitajFizickaLica() throws Exception {
        return (List<FizickoLice>) posaljiZahtevVratiListu(Operacija.UCITAJ_FIZICKA_LICA, null);
    }

    public void kreirajFizickoLice(FizickoLice fl) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.KREIRAJ_FIZICKO_LICE, fl);
    }

    public void promeniFizickoLice(FizickoLice fl) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.PROMENI_FIZICKO_LICE, fl);
    }

    public void obrisiFizickoLice(FizickoLice fl) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.OBRISI_FIZICKO_LICE, fl);
    }

    // ******** PRAVNO LICE ********
    public List<PravnoLice> ucitajPravnaLica() throws Exception {
        return (List<PravnoLice>) posaljiZahtevVratiListu(Operacija.UCITAJ_PRAVNA_LICA, null);
    }

    public void kreirajPravnoLice(PravnoLice pl) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.KREIRAJ_PRAVNO_LICE, pl);
    }

    public void promeniPravnoLice(PravnoLice pl) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.PROMENI_PRAVNO_LICE, pl);
    }

    public void obrisiPravnoLice(PravnoLice pl) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.OBRISI_PRAVNO_LICE, pl);
    }

    // ******** TEGLA MEDA ********
    public List<TeglaMeda> ucitajTegleMeda() throws Exception {
        return (List<TeglaMeda>) posaljiZahtevVratiListu(Operacija.UCITAJ_TEGLE_MEDA, null);
    }

    public void kreirajTegluMeda(TeglaMeda tm) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.KREIRAJ_TEGLU_MEDA, tm);
    }

    public void promeniTegluMeda(TeglaMeda tm) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.PROMENI_TEGLU_MEDA, tm);
    }

    public void obrisiTegluMeda(TeglaMeda tm) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.OBRISI_TEGLU_MEDA, tm);
    }

    // ******** SERTIFIKAT ********
    public List<Sertifikat> ucitajSertifikate() throws Exception {
        return (List<Sertifikat>) posaljiZahtevVratiListu(Operacija.UCITAJ_SERTIFIKATE, null);
    }

    public void ubaciSertifikat(Sertifikat s) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.UBACI_SERTIFIKAT, s);
    }

    public void promeniSertifikat(Sertifikat s) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.PROMENI_SERTIFIKAT, s);
    }

    public void obrisiSertifikat(Sertifikat s) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.OBRISI_SERTIFIKAT, s);
    }

    // ******** NARUDZBENICA ********
    public List<Narudzbenica> ucitajNarudzbenice() throws Exception {
        return (List<Narudzbenica>) posaljiZahtevVratiListu(Operacija.UCITAJ_NARUDZBENICE, null);
    }

    public void kreirajNarudzbenicu(Narudzbenica n) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.KREIRAJ_NARUDZBENICU, n);
    }

    public void promeniNarudzbenicu(Narudzbenica n) throws Exception {
        posaljiZahtevSaExceptionom(Operacija.PROMENI_NARUDZBENICU, n);
    }

    public List<Narudzbenica> pretraziNarudzbenice(Narudzbenica n) throws Exception {
        return (List<Narudzbenica>) posaljiZahtevVratiListu(Operacija.PRETRAZI_NARUDZBENICE, n);
    }

    private List<?> posaljiZahtevVratiListu(Operacija operacija, Object param) throws Exception {
        Zahtev zahtev = new Zahtev(operacija, param);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() instanceof Exception) {
            throw (Exception) odg.getOdgovor();
        }
        if (odg.getOdgovor() == null) {
            return new ArrayList<>();
        }
        return (List<?>) odg.getOdgovor();
    }

    private Object posaljiZahtevVratiObjekat(Operacija operacija, Object param) throws Exception {
        Zahtev zahtev = new Zahtev(operacija, param);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() instanceof Exception) {
            throw (Exception) odg.getOdgovor();
        }
        return odg.getOdgovor();
    }

    private void posaljiZahtevSaExceptionom(Operacija operacija, Object param) throws Exception {
        Zahtev zahtev = new Zahtev(operacija, param);
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        if (odg.getOdgovor() != null) {
            throw (odg.getOdgovor() instanceof Exception)
                    ? (Exception) odg.getOdgovor()
                    : new Exception((String) odg.getOdgovor());
        }
    }

}
