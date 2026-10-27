/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import server.Server;

/**
 *
 * @author Korisnik
 */
public class ServerskaForma extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ServerskaForma.class.getName());
    private Server server;

    public ServerskaForma() {
        initComponents();
        setTitle("Server");
        jLabelStatus.setText("Server nije pokrenut");
        jButtonZaustavi.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPokreni = new javax.swing.JButton();
        jButtonZaustavi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonPokreni.setText("Pokreni");
        jButtonPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPokreniActionPerformed(evt);
            }
        });

        jButtonZaustavi.setText("Zaustavi");
        jButtonZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZaustaviActionPerformed(evt);
            }
        });

        jLabel1.setText("Status:");

        jMenu1.setText("Konf");

        jMenuItem1.setText("Port");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Baza");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPokreni)
                        .addGap(74, 74, 74)
                        .addComponent(jButtonZaustavi)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelStatus))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPokreni)
                    .addComponent(jButtonZaustavi))
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPokreniActionPerformed
        server = new Server();
        server.start();
        jLabelStatus.setText("Server je pokrenut");
        jButtonZaustavi.setEnabled(true);
        jButtonPokreni.setEnabled(false);
    }//GEN-LAST:event_jButtonPokreniActionPerformed

    private void jButtonZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZaustaviActionPerformed
        server.zaustaviServer();
        jLabelStatus.setText("Server je zaustavljen!");
        jButtonPokreni.setEnabled(true);
        jButtonZaustavi.setEnabled(false);
    }//GEN-LAST:event_jButtonZaustaviActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FormaKonfPort port = new FormaKonfPort();
        port.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        FormaKonfBaza baza = new FormaKonfBaza();
        baza.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPokreni;
    private javax.swing.JButton jButtonZaustavi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
