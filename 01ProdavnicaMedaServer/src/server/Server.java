/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import niti.ObradaKlijentskihZahteva;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Server extends Thread {

    boolean kraj = false;
    ServerSocket serverSoket;
    List<ObradaKlijentskihZahteva> klijenti;

    public Server() {
        klijenti = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            int port = 9000;
            try {
                port = Integer.parseInt(konfiguracija.Konfiguracija.getInstance().getProperty("PORT"));
            } catch (NumberFormatException ex) {
                System.out.println("PORT nije podesen u konfiguraciji, koristi se 9000");
            }
            serverSoket = new ServerSocket(port);

            while (!kraj) {
                System.out.println("Cekanje Klijenta...");
                Socket s = serverSoket.accept();
                System.out.println("Klijent povezan!");

                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                klijenti.add(okz);
                okz.start();

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void zaustaviServer() {
        kraj = true;
        try {
            for (ObradaKlijentskihZahteva okz : klijenti) {
                okz.prekini();
            }
            serverSoket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
