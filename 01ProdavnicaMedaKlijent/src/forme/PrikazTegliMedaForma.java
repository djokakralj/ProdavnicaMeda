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
public class PrikazTegliMedaForma extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrikazTegliMedaForma.class.getName());

    public PrikazTegliMedaForma() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tegle meda");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldVrstaMeda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldVrstaTegle = new javax.swing.JTextField();
        jButtonPretrazi = new javax.swing.JButton();
        jButtonResetuj = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTegle = new javax.swing.JTable();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonDetalji = new javax.swing.JButton();
        jButtonPromeni = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Vrsta meda:");

        jLabel2.setText("Vrsta tegle:");

        jButtonPretrazi.setText("Pretrazi");

        jButtonResetuj.setText("Resetuj");

        jTableTegle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableTegle);

        jButtonKreiraj.setText("Kreiraj teglu meda");

        jButtonDetalji.setText("Detalji");

        jButtonPromeni.setText("Promeni teglu meda");

        jButtonObrisi.setText("Obrisi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldVrstaMeda, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldVrstaTegle, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButtonPretrazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonResetuj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButtonKreiraj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDetalji)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPromeni)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonObrisi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldVrstaMeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldVrstaTegle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPretrazi)
                        .addComponent(jButtonResetuj))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonKreiraj)
                    .addComponent(jButtonDetalji)
                    .addComponent(jButtonPromeni)
                    .addComponent(jButtonObrisi))
                .addContainerGap(48, Short.MAX_VALUE))
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
    private javax.swing.JTable jTableTegle;
    private javax.swing.JTextField jTextFieldVrstaMeda;
    private javax.swing.JTextField jTextFieldVrstaTegle;
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

    public JTextField getjTextFieldVrstaMeda() {
        return jTextFieldVrstaMeda;
    }

    public JTextField getjTextFieldVrstaTegle() {
        return jTextFieldVrstaTegle;
    }

    public JTable getjTableTegle() {
        return jTableTegle;
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
