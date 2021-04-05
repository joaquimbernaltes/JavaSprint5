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

import config.Conexio;
import config.ConexionSql;
import sprint4.provasprint4.auxiliar.Log;
import sprint4.provasprint4.classes.Pressupost;
import sprint4.provasprint4.classes.Projecte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Llistapresupostos
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe conté la llista on guardarem les presupostos creades i els mètodes per a gestionar aquestes*/
public class LlistaPresupostos {

    ConexionSql cc=new ConexionSql();
    Connection con =cc.conexion();

    /* Atributs de la classe */
    private final static int maxim = 10;
    //Creació arraylist de tipo pressupost en lo nom ll_pres i en capacitat maxima de 10
    public final ArrayList<Pressupost> ll_pres = new ArrayList<>(maxim);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Log log = new Log();

    /* Getter per a agafar el número de presupostos que hi ha actualment */


    /* Mètode per a inserir presupostos */
    public void inserirPressupost(String nom_cost, Double preu_cost, int quantitat_cost,String estat_proposta,String estat) {
        try {

            //Pressupost m = new Pressupost(contador + 1, titol, descripcio, projecte);
            //Agafa ll_pres i afegeix el num de contador (com a id) i m es el objecte de pressupost

            String SQL ="insert into linia_pressupost(id, id_pressupost,nom_cost,preu_cost,quantitat_cost,estat_proposta,estat) values (?,?,?,?,?,?,?)";
            PreparedStatement pst =con.prepareStatement(SQL); //19:08
            pst.setString(1, nom_cost);
            pst.setDouble(2, preu_cost);
            pst.setInt(3, quantitat_cost);
            pst.setString(4,estat_proposta);
            pst.setString(5,estat);

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Mètode per a donar de baixa presupostos */
    public void baixaPressupost(int item) {

        try {
            //No elimina, el posa inactiu, utilitzar remove(indexarray) para eliminar
            ll_pres.get(item).setEstat("Inactiva");
            log.generarInfoLog("info.log", "S'ha anul·lat el pressupost '" + ll_pres.get(item).toString() + "'.\n");
        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }

    }

    /* Metode per a consultar presupostos */
    public LlistaPresupostos consulta(String s) {

        LlistaPresupostos temp_consulta = new LlistaPresupostos();

        try {

            Iterator it = ll_pres.iterator();
            while (it.hasNext()) {
                Pressupost presupostos = (Pressupost) it.next();
                //Canvia a minuscules i comprova en diferents formes
                if (presupostos.toString().toLowerCase().contains(s.toLowerCase())) {
                    temp_consulta.ll_pres.add(presupostos);

                }
            }

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }

        return temp_consulta;
    }

    /* Mètode per a cercar presupostos pel nom */
    public Pressupost buscarPerNomProjecte(String nom, int id) {

        Pressupost Pressupost = null;

        try {

            Iterator it = ll_pres.iterator();

            while (it.hasNext()) {
                Pressupost = (Pressupost) it.next();
                if (nom.equals(Pressupost.getProjecte().getNom())) {
                    Pressupost = ll_pres.get(id);
                    System.out.println(Pressupost.toString());
                    break;
                }
            }

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }

        return Pressupost;
    }

    /* Mètode per a modificar presupostos */
    public void modificarPressupost(int item, String nom, String descripcio, Projecte projecte, String data_alta,
                                    String data_baixa, String estat) {

        try {
            this.ll_pres.get(item).setNom(nom);
            this.ll_pres.get(item).setDescripcio(descripcio);
            this.ll_pres.get(item).setData(data_alta);
            this.ll_pres.get(item).setProjecte(projecte);
            this.ll_pres.get(item).setDataBaixa(data_baixa);
            this.ll_pres.get(item).setEstat(estat);

            log.generarInfoLog("info.log", "S'ha modificat " + this.ll_pres.toString() + ".\n");
        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Mètode per a retornar el llistat de presupostos */
    public ArrayList<Pressupost> returnList() {
        return ll_pres;
    }

}
