/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Korisnik
 */
public class PrikazFizickihLicaForma extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrikazFizickihLicaForma.class.getName());

    public PrikazFizickihLicaForma() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fizicka lica");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPromeni = new javax.swing.JButton();
        jTextFieldKupac = new javax.swing.JTextField();
        jButtonObrisi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldJmbg = new javax.swing.JTextField();
        jButtonPretrazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFizickaLica = new javax.swing.JTable();
        jButtonResetuj = new javax.swing.JButton();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonDetalji = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonPromeni.setText("Promeni kupca");

        jButtonObrisi.setText("Obrisi");

        jLabel2.setText("JMBG:");

        jButtonPretrazi.setText("Pretrazi");

        jTableFizickaLica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableFizickaLica);

        jButtonResetuj.setText("Resetuj");

        jButtonKreiraj.setText("Kreiraj kupca");

        jButtonDetalji.setText("Detalji");

        jLabel1.setText("Kupac(Ime i prezime):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldJmbg, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jButtonPretrazi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonResetuj))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButtonKreiraj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDetalji)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPromeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonObrisi)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldJmbg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPretrazi)
                    .addComponent(jButtonResetuj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonKreiraj)
                    .addComponent(jButtonDetalji)
                    .addComponent(jButtonPromeni)
                    .addComponent(jButtonObrisi))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetalji;
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonPretrazi;
    private javax.swing.JButton jButtonPromeni;
    private javax.swing.JButton jButtonResetuj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFizickaLica;
    private javax.swing.JTextField jTextFieldJmbg;
    private javax.swing.JTextField jTextFieldKupac;
    // End of variables declaration//GEN-END:variables

    public JButton getjButtonDetalji() {
        return jButtonDetalji;
    }

    public JButton getjButtonKreiraj() {
        return jButtonKreiraj;
    }

    public JButton getjButtonObrisi() {
        return jButtonObrisi;
    }

    public JButton getjButtonPretrazi() {
        return jButtonPretrazi;
    }

    public JButton getjButtonPromeni() {
        return jButtonPromeni;
    }

    public JButton getjButtonResetuj() {
        return jButtonResetuj;
    }

    public JTable getjTableFizickaLica() {
        return jTableFizickaLica;
    }

    public JTextField getjTextFieldJmbg() {
        return jTextFieldJmbg;
    }

    public JTextField getjTextFieldKupac() {
        return jTextFieldKupac;
    }

    public void dodajAddActionListener(ActionListener al) {
        jButtonKreiraj.addActionListener(al);
    }

    public void detaljiAddActionListener(ActionListener al) {
        jButtonDetalji.addActionListener(al);
    }

    public void promeniAddActionListener(ActionListener al) {
        jButtonPromeni.addActionListener(al);
    }

    public void obrisiAddActionListener(ActionListener al) {
        jButtonObrisi.addActionListener(al);
    }

    public void pretraziAddActionListener(ActionListener al) {
        jButtonPretrazi.addActionListener(al);
    }

    public void resetujAddActionListener(ActionListener al){
        jButtonResetuj.addActionListener(al);
    }

}
