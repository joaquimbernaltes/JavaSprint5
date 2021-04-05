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
package sprint4.provasprint4.forms.modificar;

import sprint4.provasprint4.classes.*;

import javax.swing.UIManager;

import sprint4.provasprint4.forms.JFrameEntitats;

/**
 * JFrameProjectes
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Mitjançant aquest Frame durem a terme la modificació d'entitats*/
public class JFrameModificarEntitats extends javax.swing.JFrame {

    /* Atributs de classe */
    static int selectedItem = -1;
    public static LlistaEntitats ll_enti;
    public static LlistaProjectes ll_proj;
    public static LlistaPropostes ll_prop;
    public static LlistaPresupostos ll_pres;
    private Entitat enti;

    /* Establim els paràmetres del Frame */
    public JFrameModificarEntitats(LlistaEntitats llista_enti, LlistaProjectes llista_proj, LlistaPropostes llista_prop,
                                   LlistaPresupostos llista_pres, int selectedItem) {
        try {
           //
        } catch (Exception e) {
            e.printStackTrace();
        }
        ll_enti = llista_enti;
        ll_proj = llista_proj;
        ll_prop = llista_prop;
        ll_pres = llista_pres;
        JFrameModificarEntitats.selectedItem = selectedItem;

        initComponents();

        enti = ll_enti.returnList().get(selectedItem);
        field_nom.setText(enti.getNom());
        field_ciutat.setText(enti.getCiutat());
        field_email.setText(enti.getEmail());
        field_dataAlta.setText(enti.getDataAlta());
        if (enti.getEstat().equals("Activa")) {
            boto_alta.setVisible(false);
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
        modificarEntitat = new javax.swing.JButton();
        field_nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        field_ciutat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        field_email = new javax.swing.JTextField();
        enrere = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        field_dataAlta = new javax.swing.JTextField();
        boto_alta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom");

        modificarEntitat.setText("Aceptar");
        modificarEntitat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarEntitatMouseClicked(evt);
            }
        });
        modificarEntitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEntitatActionPerformed(evt);
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

        enrere.setText("Cancelar");
        enrere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrereMouseClicked(evt);
            }
        });

        jLabel4.setText("Data d'alta");

        boto_alta.setText("Alta");
        boto_alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boto_altaActionPerformed(evt);
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boto_alta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enrere, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(modificarEntitat, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(field_nom)
                    .addComponent(field_ciutat)
                    .addComponent(field_dataAlta)
                    .addComponent(field_email))
                .addGap(30, 30, 30))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(field_dataAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(boto_alta)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificarEntitat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enrere, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void field_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nomActionPerformed

    private void field_ciutatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_ciutatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_ciutatActionPerformed

    private void modificarEntitatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarEntitatMouseClicked
        if (enti.getEstat().equals("Actiu")) {
            ll_enti.modificarEntitat(selectedItem, field_nom.getText(), field_ciutat.getText(), field_email.getText(), field_dataAlta.getText(), "", "Actiu");
        } else {
            ll_enti.modificarEntitat(selectedItem, field_nom.getText(), field_ciutat.getText(), field_email.getText(), field_dataAlta.getText(), enti.getDataBaixa(), "Inactiu");
        }

        enrereMouseClicked(evt);
    }//GEN-LAST:event_modificarEntitatMouseClicked

    private void enrereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrereMouseClicked
        JFrameEntitats pp = new JFrameEntitats(ll_enti, ll_proj, ll_prop,ll_pres);
        pp.setVisible(true);
        dispose();
    }//GEN-LAST:event_enrereMouseClicked

    private void modificarEntitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEntitatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarEntitatActionPerformed

    private void boto_altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boto_altaActionPerformed
        // TODO add your handling code here:
        //Donar d'alta una matricula que esta de baixa
        ll_enti.modificarEntitat(selectedItem, field_nom.getText(), field_ciutat.getText(), field_email.getText(), field_dataAlta.getText(), "", "Actiu ");

        // Tornem a la finestra principal
        JFrameEntitats principalWindow = new JFrameEntitats(ll_enti, ll_proj, ll_prop,ll_pres);
        principalWindow.setVisible(true);       //la fem visible
        dispose();                             //eliminem la finestra actual      
    }//GEN-LAST:event_boto_altaActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameModificarEntitats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameModificarEntitats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameModificarEntitats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameModificarEntitats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new JFrameModificarEntitats(ll_enti, ll_proj, ll_prop,ll_pres, selectedItem).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boto_alta;
    private javax.swing.JButton enrere;
    private javax.swing.JTextField field_ciutat;
    private javax.swing.JTextField field_dataAlta;
    private javax.swing.JTextField field_email;
    private javax.swing.JTextField field_nom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton modificarEntitat;
    // End of variables declaration//GEN-END:variables
}
