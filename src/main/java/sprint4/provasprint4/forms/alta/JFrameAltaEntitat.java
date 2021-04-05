/**
 *                               Copyrigth 2020
 *
 *       Licensed under the Apache License, Version 2.0 (the "License");
 *       you may not use this file except in compliance with the License.
 *       You may obtain a copy of the License at
 *
 *                   http://www.apache.org/licenses/LICENSE-2.0
 *
 *       Unless required by applicable law or agreed to in writing, software
 *       distributed under the License is distributed on an "AS IS" BASIS,
 *       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *       See the License for the specific language governing permissions and
 *       limitations under the License.
 */
package sprint4.provasprint4.forms.alta;

import sprint4.provasprint4.classes.Entitat;

import javax.swing.*;

import sprint4.provasprint4.classes.LlistaEntitats;
import sprint4.provasprint4.classes.LlistaProjectes;
import sprint4.provasprint4.classes.LlistaPropostes;
import sprint4.provasprint4.classes.LlistaPresupostos;
import sprint4.provasprint4.forms.JFrameEntitats;
import java.util.Iterator;

/**
 * JFrameAltaEntitat
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 13.0
 */

/* Mitjançant aquest Frame durem a terme l'alta d'entitats*/
public class JFrameAltaEntitat extends javax.swing.JFrame {

    /* Atributs de classe */
    public static LlistaEntitats ll_enti;
    public static LlistaProjectes ll_proj;
    public static LlistaPropostes ll_prop;
    public static LlistaPresupostos ll_pres;

    /* Establim els paràmetres del Frame */
    public JFrameAltaEntitat(LlistaEntitats ll_enti, LlistaProjectes ll_proj, LlistaPropostes ll_prop,
                             LlistaPresupostos ll_pres) {
        try {

            this.ll_enti = ll_enti;
            this.ll_proj = ll_proj;
            this.ll_prop = ll_prop;
            this.ll_pres = ll_pres;
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        altaEntitat = new javax.swing.JButton();
        field_nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        field_ciutat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        field_email = new javax.swing.JTextField();
        enrere = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom");

        altaEntitat.setText("Acceptar");
        altaEntitat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                altaEntitatMouseClicked(evt);
            }
        });
        altaEntitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaEntitatActionPerformed(evt);
            }
        });

        field_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nomActionPerformed(evt);
            }
        });

        jLabel2.setText("Ciutat");

        field_ciutat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_ciutatActionPerformed(evt);
            }
        });

        jLabel3.setText("Email");

        enrere.setText("Cancel·lar");
        enrere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrereMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(field_nom)
                                        .addComponent(field_ciutat)
                                        .addComponent(field_email))
                                .addGap(30, 30, 30))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(enrere, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(altaEntitat, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(field_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(field_ciutat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(field_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(altaEntitat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enrere)
                                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void field_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nomActionPerformed

    private void field_ciutatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ciutatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ciutatActionPerformed

    private void altaEntitatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_altaEntitatMouseClicked
        if (field_nom.getText().equals("") || field_ciutat.getText().equals("") || field_email.getText().equals("")) {
            /* Mostrem error si no selecciona res */
            JOptionPane.showMessageDialog(this, "Per favor, introdueix les dades", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try{
            Iterator it = ll_enti.ll_e.iterator();
            Boolean nom_repetit = false;
            while (it.hasNext()) {
                Entitat enti = (Entitat) it.next();
                if (enti.getNom().equals(field_nom.getText())) {
                    nom_repetit = true;
                    break;
                }
            }
            if (nom_repetit) {
                JOptionPane.showMessageDialog(this, "Ja hi ha una entitat amb el nom: " + field_nom.getText(), "Error", JOptionPane.WARNING_MESSAGE);

            } else {
                ll_enti.afegirEntitat(field_nom.getText(), field_ciutat.getText(), field_email.getText());
                enrereMouseClicked(evt);
            }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(this, "Sembla que no hi han elements a mostrar ", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_altaEntitatMouseClicked

    private void enrereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrereMouseClicked
        JFrameEntitats pp = new JFrameEntitats(ll_enti, ll_proj, ll_prop,ll_pres);
        pp.setVisible(true);
        dispose();
    }//GEN-LAST:event_enrereMouseClicked

    private void altaEntitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaEntitatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_altaEntitatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAltaEntitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAltaEntitat(ll_enti, ll_proj, ll_prop,ll_pres).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altaEntitat;
    private javax.swing.JButton enrere;
    private javax.swing.JTextField field_ciutat;
    private javax.swing.JTextField field_email;
    private javax.swing.JTextField field_nom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
