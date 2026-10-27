/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public enum Operacija implements Serializable {
    LOGIN,

    UCITAJ_PRODAVCE,
    KREIRAJ_PRODAVCA,
    PROMENI_PRODAVCA,
    OBRISI_PRODAVCA,

    UCITAJ_KUPCE,
    KREIRAJ_KUPCA,
    PROMENI_KUPCA,
    OBRISI_KUPCA,

    UCITAJ_FIZICKA_LICA,
    KREIRAJ_FIZICKO_LICE,
    PROMENI_FIZICKO_LICE,
    OBRISI_FIZICKO_LICE,

    UCITAJ_PRAVNA_LICA,
    KREIRAJ_PRAVNO_LICE,
    PROMENI_PRAVNO_LICE,
    OBRISI_PRAVNO_LICE,

    UCITAJ_TEGLE_MEDA,
    KREIRAJ_TEGLU_MEDA,
    PROMENI_TEGLU_MEDA,
    OBRISI_TEGLU_MEDA,

    UCITAJ_SERTIFIKATE,
    UBACI_SERTIFIKAT,
    PROMENI_SERTIFIKAT,
    OBRISI_SERTIFIKAT,

    UCITAJ_NARUDZBENICE,
    KREIRAJ_NARUDZBENICU,
    PROMENI_NARUDZBENICU,
    PRETRAZI_NARUDZBENICE
}
