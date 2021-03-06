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

import javax.swing.UIManager;
import sprint4.provasprint4.classes.*;
import sprint4.provasprint4.forms.*;
import sprint4.provasprint4.forms.select.*;
import javax.swing.JOptionPane;

/**
 * JFrameAltaProposta
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Mitjançant aquest Frame durem a terme l'alta de propostes*/
public class JFrameAltaProposta extends javax.swing.JFrame {

    /* Atributs de classe */
    public static LlistaEntitats ll_enti;
    public static LlistaProjectes ll_proj;
    public static LlistaPropostes ll_prop;
    public static LlistaPresupostos ll_pres;
    public static int selectedItemProposta = -1;
    public static int selectedItemEntitat = -1;
    public static String nom_proposta;
    public static String descripcio_proposta;
    public String en;
    public String i;
    public int opcio = 0;
    public String data_alta;

    /* Establim els paràmetres del Frame */
    public JFrameAltaProposta(LlistaEntitats ll_enti, LlistaProjectes ll_proj, LlistaPropostes ll_prop, LlistaPresupostos ll_pres,  int selectedItemProposta) {
        try {
           //
            JFrameAltaProposta.selectedItemProposta = selectedItemProposta;
            JFrameAltaProposta.ll_enti = ll_enti;
            JFrameAltaProposta.ll_proj = ll_proj;
            JFrameAltaProposta.ll_prop = ll_prop;
            JFrameAltaProposta.ll_pres = ll_pres;

            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public JFrameAltaProposta(LlistaEntitats ll_enti, LlistaProjectes ll_proj, LlistaPropostes ll_prop, LlistaPresupostos ll_pres) {
        try {
            JFrameAltaProposta.ll_enti = ll_enti;
            JFrameAltaProposta.ll_proj = ll_proj;
            JFrameAltaProposta.ll_prop = ll_prop;
            JFrameAltaProposta.ll_pres = ll_pres;

            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public JFrameAltaProposta(LlistaEntitats ll_enti, LlistaPropostes ll_prop, LlistaProjectes ll_proj,
                              LlistaPresupostos ll_pres, int selectedItemEntitat, String nom_proposta,
                              String descripcio_proposta, String data_alta) /*throws Exception*/{
        try {
            JFrameAltaProposta.selectedItemEntitat = selectedItemEntitat;
            JFrameAltaProposta.ll_enti = ll_enti;
            JFrameAltaProposta.ll_proj = ll_proj;
            JFrameAltaProposta.ll_prop = ll_prop;
            JFrameAltaProposta.ll_pres = ll_pres;
            JFrameAltaProposta.nom_proposta = nom_proposta;
            JFrameAltaProposta.descripcio_proposta = descripcio_proposta;
            this.data_alta = data_alta;
            initComponents();
            field_descripcio.setText(descripcio_proposta);
            field_nom.setText(nom_proposta);

            //Aixo peta per que IDE no deixa modificar una funció protegida, pero es para evitar errors d'execució, errors personalitzats 
            //if(nom_proposta.length() <4){
            //    throw new Exception("El nom té que ser més llarg que 4 lletres");
            //};
            
            if (selectedItemEntitat != -1) {
                //Agafar el valor de l'entitat d'una taula
                Entitat e = ll_enti.returnList().get(selectedItemEntitat);
                field_entitat.setText(e.getNom());
                en = e.getNom();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTextPane jTextPane1 = new javax.swing.JTextPane();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        field_nom = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        field_descripcio = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JButton enrere = new javax.swing.JButton();
        javax.swing.JButton jButton2 = new javax.swing.JButton();
        // Variables declaration - do not modify                     
        javax.swing.JButton boto_alta = new javax.swing.JButton();
        field_entitat = new javax.swing.JLabel();

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom");

        field_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nomActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripció");

        field_descripcio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_descripcioActionPerformed(evt);
            }
        });

        jLabel3.setText("Entitat");

        enrere.setText("Cancel·lar");
        enrere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrereMouseClicked(evt);
            }
        });
        enrere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrereActionPerformed(evt);
            }
        });

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        boto_alta.setText("Acceptar");
        boto_alta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boto_altaMouseClicked(evt);
            }
        });
        boto_alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boto_altaActionPerformed(evt);
            }
        });

        field_entitat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        field_entitat.setText("Selecciona una entitat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_nom)
                            .addComponent(field_descripcio)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field_entitat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(35, 35, 35)))
                        .addGap(2, 2, 2)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(enrere, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(boto_alta)))
                        .addGap(0, 120, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(field_descripcio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton2)
                    .addComponent(field_entitat))
                .addGap(18, 18, 18)
                .addComponent(boto_alta)
                .addGap(12, 12, 12)
                .addComponent(enrere)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void field_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nomActionPerformed

    private void field_descripcioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_descripcioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_descripcioActionPerformed

    private void altaGrupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_altaGrupMouseClicked

    }//GEN-LAST:event_altaGrupMouseClicked

    private void enrereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrereMouseClicked
        JFramePropostes pp = new JFramePropostes(ll_enti, ll_proj, ll_prop,ll_pres);
        pp.setVisible(true);
        dispose();
    }//GEN-LAST:event_enrereMouseClicked

    private void altaGrupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaGrupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_altaGrupActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Tornem a la finestra principal
        JFrameEntitatSeleccionar ju = new JFrameEntitatSeleccionar(ll_enti, ll_proj, ll_prop, ll_pres, field_nom.getText(), field_descripcio.getText(), opcio, data_alta);
        ju.setVisible(true);       //la fem visible
        dispose(); //eliminem la finestra actual
    }//GEN-LAST:event_jButton2ActionPerformed

    private void enrereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enrereActionPerformed

    private void boto_altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boto_altaActionPerformed

    }//GEN-LAST:event_boto_altaActionPerformed

    private void boto_altaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boto_altaMouseClicked
        // TODO add your handling code here:
        if (field_nom.getText().equals("") || field_descripcio.getText().equals("") || selectedItemEntitat == -1) {
            //Mostrem error si no selecciona res
            JOptionPane.showMessageDialog(this, "Per favor, introdueix les dades", "Error", JOptionPane.WARNING_MESSAGE);
        } else {

            Entitat e = ll_enti.buscarPerNom(field_entitat.getText(), selectedItemEntitat);
            ll_prop.inserirProposta(field_nom.getText(), field_descripcio.getText(), e);
            enrereMouseClicked(evt);
        }


    }//GEN-LAST:event_boto_altaMouseClicked

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
            java.util.logging.Logger.getLogger(JFrameAltaProposta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAltaProposta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAltaProposta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAltaProposta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAltaProposta(ll_enti, ll_proj, ll_prop, ll_pres,selectedItemProposta).setVisible(true);
            }
        });
    }

    private javax.swing.JTextField field_descripcio;
    private javax.swing.JLabel field_entitat;
    private javax.swing.JTextField field_nom;
    // End of variables declaration                   
}
