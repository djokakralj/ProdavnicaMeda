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
public class PrikazSertifikataForma extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrikazSertifikataForma.class.getName());

    public PrikazSertifikataForma() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sertifikati");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonResetuj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSertifikati = new javax.swing.JTable();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonDetalji = new javax.swing.JButton();
        jButtonPromeni = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonObrisi = new javax.swing.JButton();
        jTextFieldNaziv = new javax.swing.JTextField();
        jButtonPretrazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonResetuj.setText("Resetuj");

        jTableSertifikati.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableSertifikati);

        jButtonKreiraj.setText("Kreiraj sertifikat");

        jButtonDetalji.setText("Detalji");

        jButtonPromeni.setText("Promeni sertifikat");

        jLabel1.setText("Naziv:");

        jButtonObrisi.setText("Obrisi");

        jButtonPretrazi.setText("Pretrazi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPretrazi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonResetuj)
                                .addGap(192, 192, 192))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonKreiraj)
                                .addGap(27, 27, 27)
                                .addComponent(jButtonDetalji)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPromeni)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonObrisi)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPretrazi)
                    .addComponent(jButtonResetuj)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonKreiraj)
                    .addComponent(jButtonDetalji)
                    .addComponent(jButtonPromeni)
                    .addComponent(jButtonObrisi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSertifikati;
    private javax.swing.JTextField jTextFieldNaziv;
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

    public JTable getjTableSertifikati() {
        return jTableSertifikati;
    }

    public JTextField getjTextFieldNaziv() {
        return jTextFieldNaziv;
    }

    public void pretraziAddActionListener(ActionListener al) {
        jButtonPretrazi.addActionListener(al);
    }

    public void resetujAddActionListener(ActionListener al) {
        jButtonResetuj.addActionListener(al);
    }

    public void detaljiAddActionListener(ActionListener al) {
        jButtonDetalji.addActionListener(al);
    }

    public void promeniAddActionListener(ActionListener al) {
        jButtonPromeni.addActionListener(al);
    }

    public void kreirajAddActionListener(ActionListener al) {
        jButtonKreiraj.addActionListener(al);
    }

    public void obrisiAddActionListener(ActionListener al) {
        jButtonObrisi.addActionListener(al);
    }

}
