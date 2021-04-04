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
package Sprint4.provasprint4.forms.modificar;

import javax.swing.UIManager;

import Sprint4.provasprint4.classes.*;
import Sprint4.provasprint4.forms.JFrameProjectes;
import Sprint4.provasprint4.forms.select.JFramePropostaSeleccionar;
import javax.swing.JOptionPane;

/**
 * JFrameProjectes
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Mitjançant aquest Frame durem a terme la modificació de projectes*/
public class JFrameModificarProjectes extends javax.swing.JFrame {

    /* Atributs de classe */
    static int selectedItem = -1;
  public static LlistaEntitats ll_enti;
    public static LlistaProjectes ll_proj;
    public static LlistaPropostes ll_prop;
    public static LlistaPresupostos ll_pres;
    public static int selectedItemProposta = -1;
    public static String nom;
    public static String descripcio;
    public static String data_alta;
    public static int opcio = 1;
    public static String propo;
    private Projecte proj;

    /* Establim els paràmetres del Frame */
    public JFrameModificarProjectes(LlistaEntitats llista_enti, LlistaProjectes llista_proj,
                                    LlistaPropostes llista_prop, LlistaPresupostos llista_pres, int selectedItem) {
        try {
           //
            ll_enti = llista_enti;
            ll_proj = llista_proj;
            ll_prop = llista_prop;
            ll_pres  = llista_pres;
            JFrameModificarProjectes.selectedItem = selectedItem;
            initComponents();

            proj = ll_proj.returnList().get(selectedItem);
            field_nom.setText(proj.getNom());
            field_descripcio.setText(proj.getDescripcio());
            field_dataAlta.setText(proj.getDataAlta());
            camp_proposta.setText(proj.getProposta().getNom());
            if ("Actiu".equals(proj.getEstat())) {
                botoAlta.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Establim els paràmetres del Frame */
    public JFrameModificarProjectes(LlistaEntitats llista_enti, LlistaProjectes llista_proj, LlistaPropostes llista_prop,
                                    LlistaPresupostos llista_pres,
                                    int selectedItemProposta, String nom, String descripcio, String data_alta) {
        try {
           //
            ll_enti = llista_enti;
            ll_proj = llista_proj;
            ll_prop = llista_prop;
            ll_pres  = llista_pres;
            JFrameModificarProjectes.selectedItemProposta = selectedItemProposta;
            JFrameModificarProjectes.nom = nom;
            JFrameModificarProjectes.descripcio = descripcio;
            JFrameModificarProjectes.data_alta = data_alta;
            initComponents();
            System.out.println(nom);

            proj = ll_proj.returnList().get(selectedItem);

            if (selectedItemProposta != -1) {
                //Agafar el valor de l'entitat d'una taula
                Proposta p = ll_prop.returnList().get(selectedItemProposta);
                camp_proposta.setText(p.getNom());
                propo = p.getNom();
            }
            field_nom.setText(proj.getNom());
            field_descripcio.setText(proj.getDescripcio());
            field_dataAlta.setText(proj.getDataAlta());
            camp_proposta.setText(propo);
            if ("Actiu".equals(proj.getEstat())) {
                botoAlta.setVisible(false);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JButton modificarProjectes = new javax.swing.JButton();
        field_nom = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        field_descripcio = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JButton enrere = new javax.swing.JButton();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        field_dataAlta = new javax.swing.JTextField();
        botoAlta = new javax.swing.JButton();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        camp_proposta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom");

        modificarProjectes.setText("Aceptar");
        modificarProjectes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarProjectesMouseClicked(evt);
            }
        });
        modificarProjectes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProjectesActionPerformed(evt);
            }
        });

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

        jLabel3.setText("Proposta");

        enrere.setText("Cancelar");
        enrere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrereMouseClicked(evt);
            }
        });

        jLabel4.setText("Data d'alta");

        field_dataAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_dataAltaActionPerformed(evt);
            }
        });

        botoAlta.setText("Alta");
        botoAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoAltaActionPerformed(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        camp_proposta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        camp_proposta.setText("Selecciona una proposta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(field_nom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_descripcio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_dataAlta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(camp_proposta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botoAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modificarProjectes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(enrere, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGap(6, 6, 6)))
                .addGap(24, 24, 24))
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
                    .addComponent(jButton1)
                    .addComponent(camp_proposta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(field_dataAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botoAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarProjectes)
                    .addComponent(enrere))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void field_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nomActionPerformed

    private void field_descripcioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_descripcioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_descripcioActionPerformed

    private void modificarProjectesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarProjectesMouseClicked
        //Mostrem missatge de confirmació
        int confirm = JOptionPane.showConfirmDialog(this, "Esteu segurs de modificar aquesta matricula?");
        if (confirm == JOptionPane.YES_OPTION) {
            if (proj.getEstat().equals("Actiu")) {
                //Cridem al metode per a modificar les dades
                Proposta prop = ll_prop.buscarPerNom(camp_proposta.getText(), selectedItemProposta);
                ll_proj.modificarProjecte(selectedItem, field_nom.getText(), field_descripcio.getText(), prop, field_dataAlta.getText(), "", "Actiu");
            } else {
                //Cridem al metode per a modificar les dades
                Proposta prop = ll_prop.buscarPerNom(camp_proposta.getText(), selectedItemProposta);
                ll_proj.modificarProjecte(selectedItem, field_nom.getText(), field_descripcio.getText(), prop, field_dataAlta.getText(), proj.getDataBaixa(), "Inactiu");
            }
            enrereMouseClicked(evt);
        }
    }//GEN-LAST:event_modificarProjectesMouseClicked

    private void enrereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrereMouseClicked
        JFrameProjectes pp = new JFrameProjectes(ll_enti, ll_proj, ll_prop,ll_pres);
        pp.setVisible(true);
        dispose();
    }//GEN-LAST:event_enrereMouseClicked

    private void modificarProjectesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProjectesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarProjectesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Tornem a la finestra principal
        JFramePropostaSeleccionar ju = new JFramePropostaSeleccionar(ll_enti, ll_proj, ll_prop, ll_pres, field_nom.getText(), field_descripcio.getText(), field_dataAlta.getText(), opcio);
        ju.setVisible(true);       //la fem visible
        dispose(); //eliminem la finestra actual    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botoAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoAltaActionPerformed
        //Mostrem missatge de confirmació
        int confirm = JOptionPane.showConfirmDialog(this, "Esteu segurs de modificar aquest projecte?");
        if (confirm == JOptionPane.YES_OPTION) {
            //Realitzem la cerca de la proposta mitjançant la selecció d'aquesta
            Proposta prop = ll_prop.buscarPerNom(camp_proposta.getText(), selectedItemProposta);

            //Cridem al metode per a modificar les dades
            ll_proj.modificarProjecte(selectedItem, field_nom.getText(), field_descripcio.getText(), prop, field_dataAlta.getText(), "", "Actiu");

            // Tornem a la finestra principal
            JFrameProjectes principalWindow = new JFrameProjectes(ll_enti, ll_proj, ll_prop,ll_pres);
            principalWindow.setVisible(true);       //la fem visible
            dispose();                             //eliminem la finestra actual
        }    }//GEN-LAST:event_botoAltaActionPerformed

    private void field_dataAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_dataAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_dataAltaActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameModificarProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameModificarProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameModificarProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameModificarProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JFrameModificarProjectes(ll_enti, ll_proj, ll_prop, ll_pres,selectedItem).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoAlta;
    private javax.swing.JLabel camp_proposta;
    private javax.swing.JTextField field_dataAlta;
    private javax.swing.JTextField field_descripcio;
    private javax.swing.JTextField field_nom;
    // End of variables declaration//GEN-END:variables
}
