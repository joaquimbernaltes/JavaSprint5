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

import config.Conexio;
import sprint4.provasprint4.auxiliar.FileCsv;
import sprint4.provasprint4.auxiliar.LectorCsv;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import sprint4.provasprint4.classes.*;
import sprint4.provasprint4.forms.alta.JFrameAltaEntitat;
import sprint4.provasprint4.forms.modificar.JFrameModificarEntitats;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * JFrameProjectes
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */


/* Mitjançant aquest Frame durem a terme la gestió i llistat de les entitats*/
public class JFrameEntitats extends javax.swing.JFrame {
    
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
    public static LlistaEntitats consulta2;

    /* Establim els paràmetres del Frame */
    public JFrameEntitats(LlistaEntitats llista_enti, LlistaProjectes llista_proj, LlistaPropostes llista_prop,
                          LlistaPresupostos llista_pres) { //Passar la llista creada al main com a paràmetre al instanciar la classe.
        this.setTitle("Gestió d'Entitats"); //Definir títol de la finestra.
        try {
            ll_enti = llista_enti;
            ll_proj = llista_proj;
            ll_prop = llista_prop;
            ll_pres = llista_pres;

            initComponents();
            setLocationRelativeTo(null);
            grupsTitle.setHorizontalAlignment(JLabel.CENTER); // Fa que el text de grupsTitle estigui centrat al seu contenidor
            //emplenarTaula("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Mètode per a emplenar la taula de entitats */
   /* public void emplenarTaula(String s) {
        Object[] columnNames = {"ID", "Nom", "Ciutat", "Email", "Data Alta", "Data Baixa", "Estat"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        LlistaEntitats consulta = ll_enti.consulta(s);
        consulta2 = consulta;

        for (int i = 0; i < consulta.getComptadorEntitats(); i++) {
            Entitat entitat = consulta.returnList().get(i);

            Object[] rowData = {entitat.getId(), entitat.getNom(), entitat.getCiutat(), entitat.getEmail(), entitat.getDataAlta(), entitat.getDataBaixa(), entitat.getEstat()};
            model.addRow(rowData);
        }
        taulaEntitats.setModel(model);
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
        taulaEntitats = new javax.swing.JTable();
        afegirEntitat = new javax.swing.JButton();
        searchGroups = new javax.swing.JTextField();
        modificarEntitat = new javax.swing.JButton();
        borrarEntitat = new javax.swing.JButton();
        back = new javax.swing.JButton();
        makeCsv = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        grupsTitle.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        grupsTitle.setText("Entitats");
        grupsTitle.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                grupsTitleComponentHidden(evt);
            }
        });

        taulaEntitats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        taulaEntitats.getTableHeader().setReorderingAllowed(false);
        taulaEntitats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaEntitatsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taulaEntitats);

        afegirEntitat.setText("Alta");
        afegirEntitat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                afegirEntitatMouseClicked(evt);
            }
        });
        afegirEntitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afegirEntitatActionPerformed(evt);
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

        modificarEntitat.setText("Modificar");
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

        borrarEntitat.setText("Baixa");
        borrarEntitat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarEntitatMouseClicked(evt);
            }
        });
        borrarEntitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarEntitatActionPerformed(evt);
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

        jButton1.setText("Importar");
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
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(afegirEntitat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grupsTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarEntitat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(borrarEntitat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(makeCsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grupsTitle)
                            .addComponent(jButton1))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(makeCsv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(afegirEntitat)
                    .addComponent(modificarEntitat)
                    .addComponent(borrarEntitat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afegirEntitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afegirEntitatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afegirEntitatActionPerformed

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

    private void afegirEntitatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afegirEntitatMouseClicked
        /* Realitzem la crida del frame per a donar d'alta entitats */
        this.setVisible(false);
        JFrameAltaEntitat fc = new JFrameAltaEntitat(ll_enti, ll_proj, ll_prop,ll_pres);
        fc.setTitle("Afegir Entitat");
        fc.setVisible(true);
        fc.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_afegirEntitatMouseClicked

    private void taulaEntitatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaEntitatsMouseClicked
        /* Cada vegada que fem click a algun element de la taula
        fem que l'atribut selectedItem s'actualitzi per a que sigui l'id de l'element */
        selectedItem = (int) taulaEntitats.getValueAt(taulaEntitats.getSelectedRow(), 0) - 1;
    }//GEN-LAST:event_taulaEntitatsMouseClicked

    private void borrarEntitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarEntitatActionPerformed
    }//GEN-LAST:event_borrarEntitatActionPerformed

    private void borrarEntitatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarEntitatMouseClicked

        if (selectedItem != -1) { // selectedItem s'inicialitza amb -1, si no es -1 entra al if
            if (ll_enti.ll_e.get(selectedItem).getEstat().equals("Activa")) {
                /* Mostrem un missatge de confirmació i fem que conf sigui el que showConfirmDialog retorna */
                int conf = JOptionPane.showConfirmDialog(this, "Esteu segurs de borrar aquesta entitat?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (conf == JOptionPane.YES_OPTION) { // Si hem clickat a Confirmar, entra al if, borra l'element seleccionat, refresca la taula i fica selectedItem a -1 (ningun seleccionat)
                    ll_enti.baixaEntitat(selectedItem);
                    //emplenarTaula("");
                    selectedItem = -1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Aquesta entitat ja està donada de baixa", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } else { // Si no s'ha seleccionat cap element, mostra un missatge d'error
            JOptionPane.showMessageDialog(this, "Per a realitzar aquesta acció heu de seleccionar una entitat de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_borrarEntitatMouseClicked

    private void searchGroupsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGroupsKeyTyped
        //emplenarTaula(searchGroups.getText()); // Cada vegada que s'escriu al input s'actualitza la taula
    }//GEN-LAST:event_searchGroupsKeyTyped

    private void modificarEntitatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarEntitatMouseClicked
        if (selectedItem != -1) {
            int conf2 = JOptionPane.showConfirmDialog(this, "Esteu segurs de modificar les dades d'aquesta entitat?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (conf2 == JOptionPane.YES_OPTION) {
                JFrameModificarEntitats g_a = new JFrameModificarEntitats(ll_enti, ll_proj, ll_prop,ll_pres, selectedItem);
                selectedItem = -1;
                g_a.setVisible(true);
                dispose();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Per a realitzar aquesta acció heu de seleccionar una entitat de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_modificarEntitatMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        //Redireccionem al menu principal
        JFrameMenuPrincipal m = new JFrameMenuPrincipal(ll_enti, ll_proj, ll_prop,ll_pres);
        m.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    }//GEN-LAST:event_backActionPerformed

    private void modificarEntitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEntitatActionPerformed
        if (selectedItem != -1) {//Comprovem que s'hagi seleccionat una matricula
            int confirm2 = JOptionPane.showConfirmDialog(this, "Esteu segurs de modificar aquesta entitat?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm2 == JOptionPane.YES_OPTION) {
                JFrameModificarEntitats modificarWindow = new JFrameModificarEntitats(ll_enti, ll_proj, ll_prop,ll_pres, selectedItem);
                modificarWindow.setVisible(true);       //la fem visible
                this.dispose();//eliminem la finestra actual
                selectedItem = -1;
            }

        } else {
            //Mostrem error si no selecciona res
            JOptionPane.showMessageDialog(this, "Per favor, selecciona una entitat de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_modificarEntitatActionPerformed

    private void makeCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeCsvActionPerformed
        try {
            //Declarem la finestra pare
            JFrameEntitats m = new JFrameEntitats(ll_enti, ll_proj, ll_prop,ll_pres);

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
                    FileCsv.exportarCsvEntitats(consulta2, ruta);
                    //Finalment emplenem la taula amb els valors importats
                    //emplenarTaula("");
                }

            } else if (seleccion == JFileChooser.CANCEL_OPTION) {
                //Mostrem error si no selecciona res
                JOptionPane.showMessageDialog(this, "No has escollit cap ubicació", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(JFrameEntitats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_makeCsvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //Declarem la finestra pare
            JFrameEntitats m = new JFrameEntitats(ll_enti, ll_proj, ll_prop,ll_pres);

            //Cridem a la classe JFileChooser per a poder obrir la finestra d'elecció
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Escolleix el fitxer a importar");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            //Establim i apliquem el filtre establert
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Fitxers CSV", "csv");
            fileChooser.setFileFilter(filter);

            //Guardem la resposta del dialeg en un int.
            int seleccion = fileChooser.showOpenDialog(m);

            //Comprovem que si l'usuari ha escollit un fitxer i ha clicat a acceptar.
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                //Si es compleix la condició agafem la ruta del fitxer i la guardem
                File fichero = fileChooser.getSelectedFile();
                //Posteriorment la ruta que és de tipus File la passem a tipus String
                String ruta = fichero.toString();
                //Cridem al mètode per a importar entitats indicant-li la classe llistaEntitats i la ruta del fitxer a importar
                LectorCsv.importarEntitats(ll_enti, ruta);
                //Finalment emplenem la taula amb els valors importats
                //emplenarTaula("");
            } else if (seleccion == JFileChooser.CANCEL_OPTION) {
                //Mostrem error si no selecciona res
                JOptionPane.showMessageDialog(this, "No has escollit cap fitxer", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(JFrameEntitats.class.getName()).log(Level.SEVERE, null, ex);
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameEntitats.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEntitats.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEntitats.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEntitats.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JFrameEntitats(ll_enti, ll_proj, ll_prop,ll_pres).setVisible(true);
            }
        });
    }
    
     void llistarEmpreses(){
        String sql="select * from empresas";
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]empresa=new Object[7];
            //Iniciem el model
           
            
            //Indiquem els camps i indiquem que s'afegeixi la línia
            while(rs.next()){
                empresa[0]=rs.getInt("id");
                empresa[1]=rs.getString("nom");
                empresa[2]=rs.getString("localitat");
                empresa[3]=rs.getString("direccio");
                empresa[4]=rs.getString("telefon");
                empresa[5]=rs.getString("cif");
                empresa[6]=rs.getString("email");
                model.addRow(empresa);
            }
            //Envia les dades a la taula per mostrar-les
           
        } catch (Exception e) {
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afegirEntitat;
    private javax.swing.JButton back;
    private javax.swing.JButton borrarEntitat;
    private javax.swing.JLabel grupsTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeCsv;
    private javax.swing.JButton modificarEntitat;
    private javax.swing.JTextField searchGroups;
    private javax.swing.JTable taulaEntitats;
    // End of variables declaration//GEN-END:variables

    private void importarfitxers(LlistaEntitats consulta2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
