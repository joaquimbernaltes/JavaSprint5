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
package sprint4.provasprint4.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import sprint4.provasprint4.auxiliar.Log;
import config.Conexio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 * LlistaProjectes
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe conté la llista on guardarem els projectes creats i els mètodes per a gestionar aquests*/
public class LlistaProjectes {
    
    /* Connexió BD */
    Conexio con= new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;

    /* Atributs de classe */
    public int contador = 0;
    private final static int MAXIM = 10;
    public final ArrayList<Projecte> ll_proj = new ArrayList<>(MAXIM);
    static LocalDate date = LocalDate.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static String actualData = date.format(formatter);
    Log log = new Log();

    /* Getter per a agafar el número de professors que hi ha actualment al llistat de Projectes */
    public int getNumProjectesActuals() {
        return contador;
    }

    /* Mètode per a inserir projectes */
    public void inserirProjecte(String nom, String descripcio, Proposta proposta) {
        try {

            Projecte m = new Projecte(contador + 1, nom, descripcio, proposta);
            ll_proj.add(contador, m);
            contador++;
            log.generarInfoLog("info.log", "S'ha creat el projecte " + "'" + m.getNom() + "'.\n");
        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }

    }

    /* Mètode per a consultar projectes */
    public LlistaProjectes consulta(String s) {

        LlistaProjectes temp_consulta = new LlistaProjectes(); //Definim un segon llistat

        try {

            Iterator it = ll_proj.iterator(); //Definim el iterador per a recorrer l'array
            while (it.hasNext()) { //Establim el while per anar recorrent l'array mentres hi haguin valors
                Projecte projecte = (Projecte) it.next(); //Afegim l'objecte que estem iterant a una variable
                if (projecte.toString().toLowerCase().contains(s.toLowerCase())) {
                    temp_consulta.ll_proj.add(projecte); // Afegim el projecte al llistat clonat
                    temp_consulta.contador++;
                }
            }
            if (temp_consulta.getNumProjectesActuals() == 0) {
                System.out.println("No s'han trobat resultats");
            }

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }

        return temp_consulta;
    }

    /* Mètode per a donar de baixa projectes */
    public void baixaProjecte(int item) {
        try {

            this.ll_proj.get(item).setDataBaixa(actualData);
            this.ll_proj.get(item).setEstat("Inactiva");
            log.generarInfoLog("info.log", "S'ha donat de baixa el projecte " + "'" + ll_proj.get(item).getNom() + "'.\n");

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Metode per a modificar projectes */
    public void modificarProjecte(int item, String nom, String descripcio, Proposta proposta, String data_alta, String data_baixa, String estat) {
        try {

            this.ll_proj.get(item).setNom(nom);
            this.ll_proj.get(item).setDescripcio(descripcio);
            this.ll_proj.get(item).setProposta(proposta);
            this.ll_proj.get(item).setData(data_alta);
            this.ll_proj.get(item).setDataBaixa(data_baixa);
            this.ll_proj.get(item).setEstat(estat);

            log.generarInfoLog("info.log", "S'ha modificat el projecte " + this.ll_proj.get(item).getNom() + ", amb les següent dades: " + "\n" + "-Descripció: " + this.ll_proj.get(item).getDescripcio() + "\n" + "-Proposta: " + this.ll_proj.get(item).getProposta().getNom() + "\n" + "-Data Alta: " + this.ll_proj.get(item).getDataAlta() + "\n" + "-Data Baixa: " + this.ll_proj.get(item).getDataBaixa() + "\n" + "-Estat: " + this.ll_proj.get(item).getEstat() + "\n");

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Mètode per a cercar projectes pel nom */
    public Projecte buscarPerNom(String nom, int id) {

        Projecte projecte = null;

        try {

            Iterator it = ll_proj.iterator();
            while (it.hasNext()) {
                projecte = (Projecte) it.next();
                if (nom.equals(ll_proj.get(id).getNom())) {
                    projecte = ll_proj.get(id);
                    break;
                }
            }

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
        return projecte;
    }
    
/*    void llistar(){
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
            log.generarErrorLog("error.log", e.toString());
        }
    }
*/
    /* Mètode per a retornar el llistat de projectes */
    public ArrayList<Projecte> returnList() {
        return ll_proj;
    }


}
