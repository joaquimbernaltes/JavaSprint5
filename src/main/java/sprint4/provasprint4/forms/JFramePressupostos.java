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
import sprint4.provasprint4.classes.*;
import sprint4.provasprint4.forms.alta.JFrameAltaPressupost;
import sprint4.provasprint4.forms.modificar.JFrameModificarPressuposts;
import sprint4.provasprint4.forms.modificar.JFrameModificarPropostes;

import sprint4.provasprint4.auxiliar.FileCsv;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Iterator;
import javax.swing.filechooser.FileSystemView;

/**
 * JFramePropostes
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 13.0
 */

/* Mitjançant aquest Frame durem a terme la gestió i llistat de les propostes*/
public class JFramePressupostos extends javax.swing.JFrame {

    /* Atributs de classe */
  public static LlistaEntitats ll_enti;
    public static LlistaProjectes ll_proj;
    public static LlistaPropostes ll_prop;
    public static LlistaPresupostos ll_pres;
    private int selectedItem = -1;
    LlistaPresupostos consulta2;

    /* Establim els paràmetres del Frame */
    public JFramePressupostos(LlistaEntitats llista_enti, LlistaProjectes llista_proj, LlistaPropostes llista_prop,
                              LlistaPresupostos llista_pres) { //Passar la llista creada al main com a paràmetre al instanciar la classe.
        this.setTitle("Gestió de Pressupostos"); //Definir títol de la finestra.
        try {

            ll_enti = llista_enti;
            ll_proj = llista_proj;
            ll_prop = llista_prop;
            ll_pres = llista_pres;
            initComponents();
            grupsTitle.setHorizontalAlignment(JLabel.CENTER); // Fa que el text de grupsTitle estigui centrat al seu contenidor
            emplenarTaula("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Mètode per a emplenar la taula de Pressupostos */
    public void emplenarTaula(String s) {
        Object[] columnNames = {"ID", "Nom", "Projecte", "Descripció", "Data Alta", "Data Baixa", "Estat"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        LlistaPresupostos consulta = ll_pres.consulta(s);
        consulta2 = consulta;
        for (int i = 0; i < consulta.getNumpresupostosActuals(); i++) {
            Pressupost p = consulta.returnList().get(i);
            Object[] rowData = {p.getId(), p.getNom(), p.getProjecte().getNom(), p.getDescripcio(),
                    p.getDataAlta(), p.getDataBaixa(), p.getEstat()};
            model.addRow(rowData);

        }
        taulaPressupostos.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        grupsTitle = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        taulaPressupostos = new javax.swing.JTable();
        // Variables declaration - do not modify                     
        JButton afegirPressupost = new JButton();
        searchGroups = new javax.swing.JTextField();
        JButton modificarPressupost = new JButton();
        JButton borrarPressupost = new JButton();
        JButton back = new JButton();
        JButton makeCsv = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        grupsTitle.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        grupsTitle.setText("Pressupostos");
        grupsTitle.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                grupsTitleComponentHidden(evt);
            }
        });

        taulaPressupostos.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        taulaPressupostos.getTableHeader().setReorderingAllowed(false);
        taulaPressupostos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaPressupostosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taulaPressupostos);

        afegirPressupost.setText("Alta");
        afegirPressupost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    afegirPressupostMouseClicked(evt);
                }
                catch (Exception e){

                }
            }
        });
        afegirPressupost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afegirPressupostActionPerformed(evt);
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

        modificarPressupost.setText("Modificar");
        modificarPressupost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarPressupostMouseClicked(evt);
            }
        });
        modificarPressupost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPressupostActionPerformed(evt);
            }
        });

        borrarPressupost.setText("Baixa");
        borrarPressupost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarPressupostMouseClicked(evt);
            }
        });
        borrarPressupost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarPressupostActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(grupsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(afegirPressupost, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(201, 201, 201)
                                .addComponent(modificarPressupost, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrarPressupost, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(makeCsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(afegirPressupost)
                    .addComponent(modificarPressupost)
                    .addComponent(borrarPressupost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void afegirPressupostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afegirPressupostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afegirPressupostActionPerformed

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
        searchGroups.getText();
    }//GEN-LAST:event_searchGroupsFocusLost

    private void afegirPressupostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_afegirPressupostMouseClicked
        /* Realitzem la crida del frame per a donar d'alta Pressupostos */
        if (ll_proj.ll_proj.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hi ha cap projecte donat d'alta.\nCrea un " +
                    "projecte per a associarlo a un pressupost", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Iterator it = ll_proj.ll_proj.iterator(); //Definim el iterador per a recorrer l'array
            boolean totes_inactives = false;
            while (it.hasNext()) {
                Projecte projecte = (Projecte) it.next(); //Afegim l'objecte que estem iterant a una variable
                if (projecte.getEstat().equals("Actiu")) {
                    totes_inactives = true;
                    break;
                }
            }
            if (totes_inactives) {
                this.setVisible(false);
                JFrameAltaPressupost fc = new JFrameAltaPressupost(ll_enti, ll_proj, ll_prop,ll_pres);
                fc.setTitle("Afegir");
                fc.setVisible(true);
                fc.setLocationRelativeTo(null);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No hi ha cap projecte associat", "Error", JOptionPane.WARNING_MESSAGE);

            }

        }
    }//GEN-LAST:event_afegirPressupostMouseClicked

    private void taulaPressupostosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaPressupostosMouseClicked
        /* Cada vegada que fem click a algun element de la taula
        fem que l'atribut selectedItem s'actualitzi per a que sigui l'id de l'element */
        selectedItem = (int) taulaPressupostos.getValueAt(taulaPressupostos.getSelectedRow(), 0) - 1;
    }//GEN-LAST:event_taulaPressupostosMouseClicked

    private void borrarPressupostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarPressupostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_borrarPressupostActionPerformed

    private void borrarPressupostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarPressupostMouseClicked
        if (selectedItem != -1) { // selectedItem s'inicialitza amb -1, si no es -1 entra al if
            if (ll_pres.ll_pres.get(selectedItem).getEstat().equals("Activa")) {
                /* Mostrem un missatge de confirmació i fem que conf sigui el que showConfirmDialog retorna */
                int conf = JOptionPane.showConfirmDialog(this, "Esteu segurs de donar de baixa aquest Pressupost?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (conf == JOptionPane.YES_OPTION) { // Si hem clickat a Confirmar, entra al if, borra l'element seleccionat, refresca la taula i fica selectedItem a -1 (ningun seleccionat)
                    ll_pres.baixaPressupost(selectedItem);
                    emplenarTaula("");
                    selectedItem = -1;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Aquest Pressupost ja està donada de baixa", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } else { // Si no s'ha seleccionat cap element, mostra un missatge d'error
            JOptionPane.showMessageDialog(this, "Per a realitzar aquesta acció heu de seleccionar una propsta de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_borrarPressupostMouseClicked

    private void searchGroupsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGroupsKeyTyped
        emplenarTaula(searchGroups.getText()); // Cada vegada que s'escriu al input s'actualitza la taula
    }//GEN-LAST:event_searchGroupsKeyTyped

    private void modificarPressupostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarPressupostMouseClicked
        if (selectedItem != -1) {
            int conf2 = JOptionPane.showConfirmDialog(this, "Esteu segurs de modificar les dades d'aquest Pressupost?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (conf2 == JOptionPane.YES_OPTION) {
                JFrameModificarPressuposts g_a = new JFrameModificarPressuposts(ll_enti, ll_prop, ll_proj, ll_pres,selectedItem);
                selectedItem = -1;
                g_a.setVisible(true);
                dispose();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Per a realitzar aquesta acció heu de seleccionar un Pressupost de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_modificarPressupostMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        /* Redireccionem al menu principal */
        JFrameMenuPrincipal m = new JFrameMenuPrincipal(ll_enti, ll_proj, ll_prop, ll_pres);
        m.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    }//GEN-LAST:event_backActionPerformed

    private void modificarPressupostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPressupostActionPerformed
        if (selectedItem != -1) {//Comprovem que s'hagi seleccionat una matricula
            int confirm2 = JOptionPane.showConfirmDialog(this, "Esteu segurs de modificar aquest Pressupost?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm2 == JOptionPane.YES_OPTION) {
                JFrameModificarPressuposts modificarWindow = new JFrameModificarPressuposts(ll_enti, ll_prop, ll_proj, ll_pres, selectedItem);
                modificarWindow.setVisible(true);       //la fem visible
                this.dispose();//eliminem la finestra actual
                selectedItem = -1;
            }

        } else {
            /*Mostrem error si no selecciona res*/
            JOptionPane.showMessageDialog(this, "Per favor, selecciona un Pressupost de la taula", "Error", JOptionPane.WARNING_MESSAGE);
        }    }//GEN-LAST:event_modificarPressupostActionPerformed

    private void makeCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeCsvActionPerformed
        try {
            //Declarem la finestra pare
            JFramePressupostos m = new JFramePressupostos(ll_enti, ll_proj, ll_prop,ll_pres);

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
                    FileCsv.exportarCsvPressupostos(consulta2, ruta);
                    //Finalment emplenem la taula amb els valors importats
                    emplenarTaula("");
                }

            } else if (seleccion == JFileChooser.CANCEL_OPTION) {
                //Mostrem error si no selecciona res
                JOptionPane.showMessageDialog(this, "No has escollit cap ubicació", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(JFramePressupostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_makeCsvActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePressupostos.class
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
                new JFramePressupostos(ll_enti, ll_proj, ll_prop,ll_pres).setVisible(true);
            }
        });
    }

    private JLabel grupsTitle;
    private javax.swing.JTextField searchGroups;
    private javax.swing.JTable taulaPressupostos;
    // End of variables declaration                   
}
