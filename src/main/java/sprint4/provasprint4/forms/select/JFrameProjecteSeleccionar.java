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
package Sprint4.provasprint4.forms.select;

import Sprint4.provasprint4.classes.*;
import Sprint4.provasprint4.forms.JFramePropostes;
import Sprint4.provasprint4.forms.alta.JFrameAltaPressupost;
import Sprint4.provasprint4.forms.alta.JFrameAltaProposta;
import Sprint4.provasprint4.forms.modificar.JFrameModificarPressuposts;
import Sprint4.provasprint4.forms.modificar.JFrameModificarPropostes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * JFrameEntitatSeleccionar
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Mitjançant aquest Frame seleccionem una entitat del llistat*/
public class JFrameProjecteSeleccionar extends javax.swing.JFrame {

    /* Atributs de classe */
    public static LlistaEntitats ll_enti;
    public static LlistaProjectes ll_proj;
    public static LlistaPropostes ll_prop;
    public static LlistaPresupostos ll_pres;
    private int selectedItem = -1;
    public static String nom_proj;
    public static String descripcio_proj;
    public static int opcio;
    public static String data_alta;
    public static LlistaProjectes consulta2;

    /* Establim els paràmetres del Frame */
    public JFrameProjecteSeleccionar(LlistaEntitats ll_enti, LlistaProjectes ll_proj, LlistaPropostes ll_prop,
                                     LlistaPresupostos ll_pres, String nom_proj, String descripcio_proj, int opcio, String data_alta) {
        //Passar la llista creada al main com a paràmetre al instanciar la classe.
        this.setTitle("Gestió d'Entitats"); //Definir títol de la finestra.
        try {
            JFrameProjecteSeleccionar.ll_enti = ll_enti;
            JFrameProjecteSeleccionar.ll_proj = ll_proj;
            JFrameProjecteSeleccionar.ll_prop = ll_prop;
            JFrameProjecteSeleccionar.ll_pres = ll_pres;
            JFrameProjecteSeleccionar.nom_proj = nom_proj;
            JFrameProjecteSeleccionar.descripcio_proj = descripcio_proj;
            JFrameProjecteSeleccionar.opcio = opcio;
            JFrameProjecteSeleccionar.data_alta = data_alta;
            initComponents();
            grupsTitle.setHorizontalAlignment(JLabel.CENTER); // Fa que el text de grupsTitle estigui centrat al seu contenidor
            emplenarTaula("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /* Mètode per a emplenar la taula de entitats */
    public void emplenarTaula(String s) {
        Object[] columnNames = {"ID", "Nom", "Descripcio", "Proposta", "Data Alta", "Data Baixa", "Estat"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        LlistaProjectes consulta = ll_proj.consulta(s);
        consulta2 = consulta;

        for (int i = 0; i < consulta.getNumProjectesActuals(); i++) {
            Projecte projecte = consulta.returnList().get(i);

            Object[] rowData = {projecte.getId(), projecte.getNom(), projecte.getDescripcio(), 
                    projecte.getProposta().getNom(), projecte.getDataAlta(), projecte.getDataBaixa(), 
                    projecte.getEstat()};
            model.addRow(rowData);
        }
        taula_projectes.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupsTitle = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        taula_projectes = new javax.swing.JTable();
        searchGroups = new javax.swing.JTextField();
        JButton jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        grupsTitle.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        grupsTitle.setText("Projectes");
        grupsTitle.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                grupsTitleComponentHidden(evt);
            }
        });

        taula_projectes.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        taula_projectes.getTableHeader().setReorderingAllowed(false);
        taula_projectes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taula_projectesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taula_projectes);

        searchGroups.setText("Search...");
        searchGroups.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchGroupsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchGroupsFocusLost(evt);
            }
        });
        searchGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGroupsActionPerformed(evt);
            }
        });
        searchGroups.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchGroupsKeyTyped(evt);
            }
        });

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(grupsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(searchGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchGroups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(grupsTitle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGroupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchGroupsActionPerformed

    private void grupsTitleComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_grupsTitleComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_grupsTitleComponentHidden

    private void searchGroupsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGroupsFocusGained
        // TODO add your handling code here:
        if (searchGroups.getText().equals("Search...")) {
            searchGroups.setText("");
        }
    }//GEN-LAST:event_searchGroupsFocusGained

    private void searchGroupsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGroupsFocusLost
        // TODO add your handling code here:
        if (searchGroups.getText().length() == 0) {
            //searchGroups.setText("Search...");
        }
    }//GEN-LAST:event_searchGroupsFocusLost

    private void taula_projectesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taula_projectesMouseClicked
        selectedItem = (int) taula_projectes.getValueAt(taula_projectes.getSelectedRow(), 0) - 1; // Cada vegada que fem click a algun element de la taula
//fem que l'atribut selectedItem s'actualitzi per a que sigui l'id de l'element
    }//GEN-LAST:event_taula_projectesMouseClicked

    private void searchGroupsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGroupsKeyTyped
        emplenarTaula(searchGroups.getText()); // Cada vegada que s'escriu al input s'actualitza la taula
    }//GEN-LAST:event_searchGroupsKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(selectedItem);
        if (opcio == 0) {
            JFrameAltaPressupost g_a = new JFrameAltaPressupost(ll_enti, ll_prop, ll_proj, ll_pres,
                    selectedItem, nom_proj, descripcio_proj, data_alta);
            // Al fer click a afegirGrup, instanciem el jframe JFrameAltaProposta
            g_a.setVisible(true); // el fem visible
            dispose(); // i tanquem la finestra que estavem
        } else {

            JFrameModificarPressuposts g_b = new JFrameModificarPressuposts(ll_enti, ll_prop, ll_proj, ll_pres,
                    selectedItem, nom_proj, descripcio_proj, data_alta); // Al fer click a afegirGrup, instanciem el jframe JFrameAltaProposta
            g_b.setVisible(true); // el fem visible
            dispose(); // i tanquem la finestra que estavem
        }


    }//GEN-LAST:event_jButton1ActionPerformed

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePropostes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JFramePropostes(ll_enti, ll_proj, ll_prop,ll_pres).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel grupsTitle;
    private javax.swing.JTextField searchGroups;
    private javax.swing.JTable taula_projectes;
    // End of variables declaration//GEN-END:variables
}