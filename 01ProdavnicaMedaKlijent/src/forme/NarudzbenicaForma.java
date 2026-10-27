/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import domen.Kupac;
import domen.Prodavac;
import domen.TeglaMeda;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Korisnik
 */
public class NarudzbenicaForma extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NarudzbenicaForma.class.getName());

    public NarudzbenicaForma() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jTextFieldId.setEditable(false);
        setTitle("Narudzbenica");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDatum = new javax.swing.JTextField();
        jComboBoxKupac = new javax.swing.JComboBox<>();
        jComboBoxProdavac = new javax.swing.JComboBox<>();
        jComboBoxTeglaMeda = new javax.swing.JComboBox<>();
        jTextFieldKolicina = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStavke = new javax.swing.JTable();
        jButtonDodajStavku = new javax.swing.JButton();
        jButtonObrisiStavku = new javax.swing.JButton();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonZapamti = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldUkupnoStavki = new javax.swing.JTextField();
        jTextFieldUkupanIznos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID narudzbenice:");

        jLabel2.setText("Datum izdavanja(dd.MM.yyyy):");

        jLabel3.setText("Prodavac:");

        jLabel4.setText("Tegla meda:");

        jLabel5.setText("Kupac:");

        jLabel6.setText("Kolicina:");

        jTableStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableStavke);

        jButtonDodajStavku.setText("Dodaj Stavku");

        jButtonObrisiStavku.setText("Obrisi Stavku");

        jButtonKreiraj.setText("Kreiraj Narudzbenicu");

        jButtonZapamti.setText("Zapamti");

        jLabel7.setText("Ukupno stavki:");

        jLabel8.setText("Ukupan iznos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDodajStavku)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonObrisiStavku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonZapamti))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxTeglaMeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxProdavac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDatum)
                            .addComponent(jTextFieldKolicina)
                            .addComponent(jComboBoxKupac, 0, 100, Short.MAX_VALUE))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUkupanIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUkupnoStavki, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButtonKreiraj)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxKupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProdavac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxTeglaMeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDodajStavku)
                    .addComponent(jButtonObrisiStavku)
                    .addComponent(jButtonZapamti))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonKreiraj)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldUkupnoStavki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUkupanIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodajStavku;
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonObrisiStavku;
    private javax.swing.JButton jButtonZapamti;
    private javax.swing.JComboBox<Kupac> jComboBoxKupac;
    private javax.swing.JComboBox<Prodavac> jComboBoxProdavac;
    private javax.swing.JComboBox<TeglaMeda> jComboBoxTeglaMeda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStavke;
    private javax.swing.JTextField jTextFieldDatum;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldKolicina;
    private javax.swing.JTextField jTextFieldUkupanIznos;
    private javax.swing.JTextField jTextFieldUkupnoStavki;
    // End of variables declaration//GEN-END:variables

    public JComboBox<Kupac> getjComboBoxKupac() {
        return jComboBoxKupac;
    }

    public void setjComboBoxKupac(JComboBox<Kupac> jComboBoxKupac) {
        this.jComboBoxKupac = jComboBoxKupac;
    }

    public JComboBox<Prodavac> getjComboBoxProdavac() {
        return jComboBoxProdavac;
    }

    public void setjComboBoxProdavac(JComboBox<Prodavac> jComboBoxProdavac) {
        this.jComboBoxProdavac = jComboBoxProdavac;
    }

    public JComboBox<TeglaMeda> getjComboBoxTeglaMeda() {
        return jComboBoxTeglaMeda;
    }

    public void setjComboBoxTeglaMeda(JComboBox<TeglaMeda> jComboBoxTeglaMeda) {
        this.jComboBoxTeglaMeda = jComboBoxTeglaMeda;
    }

    public JTextField getjTextFieldDatum() {
        return jTextFieldDatum;
    }

    public void setjTextFieldDatum(JTextField jTextFieldDatum) {
        this.jTextFieldDatum = jTextFieldDatum;
    }

    public JTextField getjTextFieldId() {
        return jTextFieldId;
    }

    public void setjTextFieldId(JTextField jTextFieldIdNarudzbenica) {
        this.jTextFieldId = jTextFieldIdNarudzbenica;
    }

    public JTextField getjTextFieldKolicina() {
        return jTextFieldKolicina;
    }

    public void setjTextFieldKolicina(JTextField jTextFieldKolicina) {
        this.jTextFieldKolicina = jTextFieldKolicina;
    }

    public void kreirajAddActionListener(java.awt.event.ActionListener al) {
        jButtonKreiraj.addActionListener(al);
    }

    public void zapamtiAddActionListener(java.awt.event.ActionListener al) {
        jButtonZapamti.addActionListener(al);
    }

    public void dodajStavkuAddActionListener(java.awt.event.ActionListener al) {
        jButtonDodajStavku.addActionListener(al);
    }

    public void obrisiStavkuAddActionListener(java.awt.event.ActionListener al) {
        jButtonObrisiStavku.addActionListener(al);
    }

    public javax.swing.JTable getjTableStavke() {
        return jTableStavke;
    }

    public javax.swing.JTextField getjTextFieldUkupanIznos() {
        return jTextFieldUkupanIznos;
    }

    public javax.swing.JTextField getjTextFieldUkupnoStavki() {
        return jTextFieldUkupnoStavki;
    }

    public javax.swing.JButton getjButtonKreiraj() {
        return jButtonKreiraj;
    }

    public javax.swing.JButton getjButtonZapamti() {
        return jButtonZapamti;
    }

    public javax.swing.JButton getjButtonDodajStavku() {
        return jButtonDodajStavku;
    }

    public javax.swing.JButton getjButtonObrisiStavku() {
        return jButtonObrisiStavku;
    }

}
