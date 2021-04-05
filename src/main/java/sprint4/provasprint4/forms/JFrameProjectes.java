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
package sprint4.provasprint4.forms;

import sprint4.provasprint4.forms.alta.JFrameAltaProjecte;
import sprint4.provasprint4.auxiliar.FileCsv;

import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import sprint4.provasprint4.classes.*;
import sprint4.provasprint4.forms.modificar.JFrameModificarProjectes;
import config.Conexio;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 * JFrameProjectes
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Mitjançant aquest Frame durem a terme la gestió i llistat dels projectes*/
public class JFrameProjectes extends javax.swing.JFrame {

    /* Connexió BD */
    Conexio con= new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;
    
    /* Atributs de classe */
    public static LlistaEntitats ll_enti;
    public static LlistaProjectes ll_proj;
    public static LlistaPropostes ll_prop;
    public static LlistaPresupostos ll_pres;
    private int selectedItem = -1;
    LlistaProjectes consulta2;

    /* Establim els paràmetres del Frame */
    public JFrameProjectes(LlistaEntitats llista_enti, LlistaProjectes llista_proj, LlistaPropostes llista_prop,
                           LlistaPresupostos llista_pres) { //Passar la llista creada al main com a paràmetre al instanciar la classe.
        this.setTitle("Gestió de Projectes"); //Definir títol de la finestra.
        try {
            ll_enti = llista_enti;
            ll_proj = llista_proj;
            ll_prop = llista_prop;
            ll_pres = llista_pres;
            initComponents();
            setLocationRelativeTo(null);
            grupsTitle.setHorizontalAlignment(JLabel.CENTER); // Fa que el text de grupsTitle estigui centrat al seu contenidor
            llistarProjectes();
            //emplenarTaula("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Mètode per a emplenar la taula de projectes */
    /*public void emplenarTaula(String s) {
        Object columnNames[] = {"ID", "Nom", "Proposta", "Descripcio", "Data Alta", "Data Baixa", "Estat"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        LlistaProjectes consulta = ll_proj.consulta(s);
        consulta2 = consulta;
        for (int i = 0; i < consulta.getNumProjectesActuals(); i++) {
            Projecte p = consulta.returnList().get(i);
            Object rowData[] = {p.getId(), p.getNom(), p.getProposta().getNom(), p.getDescripcio(), p.getDataAlta(), p.getDataBaixa(), p.getEstat()};
            model.addRow(rowData);

        }
        taulaPropostes.setModel(model);

    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupsTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taulaPropostes = new javax.swing.JTable();
        afegirProjecte = new javax.swing.JButton();
        searchGroups = new javax.swing.JTextField();
        modificarProjecte = new javax.swing.JButton();
        borrarProjecte = new javax.swing.JButton();
        back = new javax.swing.JButton();
        makeCsv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        grupsTitle.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        grupsTitle.setText("Projectes");
        grupsTitle.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                grupsTitleComponentHidden(evt);
            }
        });

        taulaPropostes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "id_proposta", "data_inici", "data_final", "nom_projecte", "estat"
            }
        ));
        taulaPropostes.getTableHeader().setReorderingAllowed(false);
        taulaPropostes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaPropostesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taulaPropostes);
        if (taulaPropostes.getColumnModel().getColumnCount() > 0) {
            taulaPropostes.getColumnModel().getColumn(5).setResizable(false);
        }

        afegirProjecte.setText("Alta");
        afegirProjecte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                afegirProjecteMouseClicked(evt);
            }
        });
        afegirProjecte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afegirProjecteActionPerformed(evt);
            }
        });

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

        modificarProjecte.setText("Modificar");
        modificarProjecte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarProjecteMouseClicked(evt);
            }
        });
        modificarProjecte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProjecteActionPerformed(evt);
            }
        });

        borrarProjecte.setText("Baixa");
        borrarProjecte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarProjecteMouseClicked(evt);
            }
        });
        borrarProjecte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarProjecteActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        back.setText("Menu Principal");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        makeCsv.setText("Exportar");
        makeCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeCsvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(afegirProjecte, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarProjecte, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grupsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(borrarProjecte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(makeCsv, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(searchGroups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(grupsTitle)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(makeCsv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(afegirProjecte)
                    .addComponent(modificarProjecte)
                    .addComponent(borrarProjecte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afegirProjecteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afegirProjecteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afegirProjecteActionPerformed

    private void searchGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGroupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchGroupsActionPerformed

    private void grupsTitleComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_grupsTitleComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_grupsTitleComponentHidden

    private void searchGroupsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGroupsFocusGained
        /* Mitjançant aquest textfield duem a terme la cerca */
        if (searchGroups.getText().equals("Search...")) {
            searchGroups.setText("");
        }
    }//GEN-LAST:event_searchGroupsFocusGained

    private void searchGroupsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGroupsFocusLost
        /* Mitjançant aquest textfield duem a terme la cerca */
        if (searchGroups.getText().length() == 0) {
        }
    }//GEN-LAST:event_searchGroupsFocusLost

    private void afegirProjecteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afegirProjecteMouseClicked
        if (ll_prop.ll_prop.isEmpty()) {
            /*Mostrem error si no selecciona res*/
            JOptionPane.showMessageDialog(this, "No hi ha cap proposta donada d'alta", "Error", JOptionPane.WARNING_MESSAGE);

        } else {
            Iterator it = ll_prop.ll_prop.iterator(); //Definim el iterador per a recorrer l'array
            boolean totes_inactives = false;
            while (it.hasNext()) {
                Proposta prop = (Proposta) it.next(); //Afegim l'objecte que estem iterant a una variable
                if (prop.getEstat().equals("Activa")) {
                    totes_inactives = true;
                    break;
                }
            }
            if (totes_inactives) {
                this.setVisible(false);
                JFrameAltaProjecte fc = new JFrameAltaProjecte(ll_enti, ll_proj, ll_prop,ll_pres);
                fc.setTitle("Afegir projecte");
                fc.setVisible(true);
                fc.setLocationRelativeTo(null);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No hi ha cap proposta donada d'alta", "Error", JOptionPane.WARNING_MESSAGE);

            }

        }


    }//GEN-LAST:event_afegirProjecteMouseClicked

    private void taulaPropostesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaPropostesMouseClicked
        /* Cada vegada que fem click a algun element de la taula
        fem que l'atribut selectedItem s'actualitzi per a que sigui l'id de l'element */
        selectedItem = (int) taulaPropostes.getValueAt(taulaPropostes.getSelectedRow(), 0) - 1;
    }//GEN-LAST:event_taulaPropostesMouseClicked

    private void borrarProjecteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarProjecteActionPerformed
    }//GEN-LAST:event_borrarProjecteActionPerformed

    private void borrarProjecteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarProjecteMouseClicked
        if (selectedItem != -1) { // selectedItem s'inicialitza amb -1, si no es -1 entra al if
            if (ll_proj.ll_proj.get(selectedItem).getEstat().equals("Actiu")) {
                /* Mostrem un missatge de confirmació i fem que conf sigui el que showConfirmDialog retorna */
                int conf = JOptionPane.showConfirmDialog(this, "Esteu segurs de borrar aquest projecte?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (conf == JOptionPane.YES_OPTION) { // Si hem clickat a Confirmar, entra al if, borra l'element seleccionat, refresca la taula i fica selectedItem a -1 (ningun seleccionat)
                    ll_proj.baixaProjecte(selectedItem);
                    //emplenarTaula("");
                    selectedItem = -1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Aquest projecte ja està donat de baixa", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else { // Si no s'ha seleccionat cap element, mostra un missatge d'error
            JOptionPane.showMessageDialog(this, "Per a realitzar aquesta acció heu de seleccionar un projecte de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_borrarProjecteMouseClicked

    private void searchGroupsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGroupsKeyTyped
        //emplenarTaula(searchGroups.getText()); // Cada vegada que s'escriu al input s'actualitza la taula
    }//GEN-LAST:event_searchGroupsKeyTyped

    private void modificarProjecteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarProjecteMouseClicked
        if (selectedItem != -1) {
            int conf2 = JOptionPane.showConfirmDialog(this, "Esteu segurs de modificar les dades d'aquest projecte?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (conf2 == JOptionPane.YES_OPTION) {
                JFrameModificarProjectes g_a = new JFrameModificarProjectes(ll_enti, ll_proj, ll_prop, ll_pres, selectedItem);
                selectedItem = -1;
                g_a.setVisible(true);
                dispose();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Per a realitzar aquesta acció heu de seleccionar un projecte de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_modificarProjecteMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        /* Redireccionem al menu principal */
        JFrameMenuPrincipal m = new JFrameMenuPrincipal(ll_enti, ll_proj, ll_prop,ll_pres);
        m.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    }//GEN-LAST:event_backActionPerformed

    private void modificarProjecteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProjecteActionPerformed
        if (selectedItem != -1) {//Comprovem que s'hagi seleccionat una matricula
            int confirm2 = JOptionPane.showConfirmDialog(this, "Esteu segurs de modificar aquest projecte?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm2 == JOptionPane.YES_OPTION) {
                JFrameModificarProjectes modificarWindow = new JFrameModificarProjectes(ll_enti, ll_proj, ll_prop, ll_pres,
                        selectedItem);
                modificarWindow.setVisible(true);       //la fem visible
                this.dispose();//eliminem la finestra actual
                selectedItem = -1;
            }

        } else {
            /* Mostrem error si no selecciona res */
            JOptionPane.showMessageDialog(this, "Per favor, selecciona un projecte de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_modificarProjecteActionPerformed

    private void makeCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeCsvActionPerformed

        try {
            //Declarem la finestra pare 
            JFrameProjectes m = new JFrameProjectes(ll_enti, ll_proj, ll_prop,ll_pres);

            //Cridem a la classe JFileChooser per a poder obrir la finestra d'elecció
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Escolleix l'ubicació de l'exportació");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            //Guardem la resposta del dialeg en un int.
            int seleccion = fileChooser.showSaveDialog(m);

            //Comprovem que si l'usuari ha escollit un fitxer i ha clicat a acceptar.
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                //Comprovem que realment és un fitxer
                if (fileChooser.getSelectedFile().isDirectory()) {
                    //Si es compleix la condició agafem la ruta del fitxer i la guardem
                    File fichero = fileChooser.getSelectedFile();
                    //Posteriorment la ruta que és de tipus File la passem a tipus String
                    String ruta = fichero.toString();
                    //Cridem al mètode per a importar entitats indicant-li la classe llistaEntitats i la ruta del fitxer a importar
                    FileCsv.exportarCsvProjectes(consulta2, ruta);
                    //Finalment emplenem la taula amb els valors importats
                    //emplenarTaula("");
                }

            } else if (seleccion == JFileChooser.CANCEL_OPTION) {
                //Mostrem error si no selecciona res
                JOptionPane.showMessageDialog(this, "No has escollit cap ubicació", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(JFramePropostes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_makeCsvActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JFrameProjectes(ll_enti, ll_proj, ll_prop,ll_pres).setVisible(true);
            }
        });
    }
        void llistarProjectes(){
        String sql="select * from proyectos";
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]projecte=new Object[6];
            //Iniciem el model
            model=(DefaultTableModel)taulaPropostes.getModel();
            
            //Indiquem els camps i indiquem que s'afegeixi la línia
            while(rs.next()){
                projecte[0]=rs.getInt("id");
                projecte[1]=rs.getInt("id_proposta");
                projecte[2]=rs.getString("data_inici");
                projecte[3]=rs.getString("data_final");
                projecte[4]=rs.getString("nom_projecte");
                projecte[5]=rs.getString("estat");
                model.addRow(projecte);
            }
            //Envia les dades a la taula per mostrar-les
            taulaPropostes.setModel(model);
        } catch (Exception e) {
            
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afegirProjecte;
    private javax.swing.JButton back;
    private javax.swing.JButton borrarProjecte;
    private javax.swing.JLabel grupsTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeCsv;
    private javax.swing.JButton modificarProjecte;
    private javax.swing.JTextField searchGroups;
    private javax.swing.JTable taulaPropostes;
    // End of variables declaration//GEN-END:variables
}
