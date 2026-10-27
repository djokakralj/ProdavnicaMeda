/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import coordinator.Coordinator;
import domen.Prodavac;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Korisnik
 */
public class LoginController {

    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {

        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                try {
                    String username = lf.getjTextFieldUsername().getText().trim();
                    String password = String.valueOf(lf.getjPasswordFieldPassword().getPassword()).trim();

                    Komunikacija.getInstance().konekcija();
                    Prodavac ulogovani = Komunikacija.getInstance().login(username, password);
                    if (ulogovani == null) {
                        JOptionPane.showMessageDialog(lf, "Korisnicko ime i sifra nisu ispravni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Coordinator.getInstance().setUlogovaniProdavac(ulogovani);
                        JOptionPane.showMessageDialog(lf, "Korisnicko ime i sifra su ispravni", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            Coordinator.getInstance().otvoriGlavnuFormu();
                            lf.dispose();
                        } catch (Exception exGlavnaForma) {
                            JOptionPane.showMessageDialog(lf, "Ne moze da se otvori glavna forma i meni", "GRESKA", JOptionPane.ERROR_MESSAGE);
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, exGlavnaForma);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(lf, ex.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }

}
