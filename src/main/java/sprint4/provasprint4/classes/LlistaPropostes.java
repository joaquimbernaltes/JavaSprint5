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
import sprint4.provasprint4.*;
import sprint4.provasprint4.classes.*;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import config.ConexionSql;
import sprint4.provasprint4.auxiliar.Log;

/**
 * LlistaPropostes
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe conté la llista on guardarem les propostes creades i els mètodes per a gestionar aquestes*/
public class LlistaPropostes {
	
	ConexionSql cc = new ConexionSql();
    Connection con = cc.conexion();
    
    /* Atributs de la classe */
    //private int contador = 0;
    private final static int maxim = 10;
    public final ArrayList<Proposta> ll_prop = new ArrayList<>(maxim);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Log log = new Log();

    /* Getter per a agafar el número de propostes que hi ha actualment */
    

    /* Mètode per a inserir propostes */
    public void inserirPropostes(String nom, String descripcio, String requeriments, Double estimacio_economica, String estat) {
        try {

            //Pressupost m = new Pressupost(contador + 1, titol, descripcio, projecte);
            //Agafa ll_pres i afegeix el num de contador (com a id) i m es el objecte de pressupost

            String SQL ="insert into propuestas(id, id_empresa, id_grup, id_categoria, nom, descripcio, requeriments, ruta_image, estimacio_economica, estat_proposta, data_publica, data_acceptacio, estat) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, nom);
            pst.setString(2, descripcio);
            pst.setString(3, requeriments);
            pst.setDouble(4,estimacio_economica);
            pst.setString(5,estat);
            
            

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Mètode per a donar de baixa propostes */
    public void baixaProposta(int item) {

        try {

			//ll_prop.get(item).setDataBaixa(dataActual);
			ll_prop.get(item).setEstat("Inactiva");
			log.generarInfoLog("info.log", "S'ha donat de baixa la proposta '" + ll_prop.get(item).getNom() + "'.\n");
		} catch (Exception e) {
			log.generarErrorLog("error.log", e.toString());
		}

    }

    /* Metode per a consultar propostes */
    public LlistaPropostes consulta(String s) {

        LlistaPropostes temp_consulta = new LlistaPropostes();

        try {

            Iterator it = ll_prop.iterator();
            while (it.hasNext()) {
                Proposta proposta = (Proposta) it.next();
                if (proposta.toString().toLowerCase().contains(s.toLowerCase())) {
                    temp_consulta.ll_prop.add(proposta);
                    //temp_consulta.contador++;
                }
            }
           /* if (temp_consulta.getNumPropostesActuals() == 0) {
                System.out.println("No s'han trobat resultats");
            }*/

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }

        return temp_consulta;
    }

    /* Mètode per a cercar propostes pel nom */
    public Proposta buscarPerNom(String nom, int id) {

        Proposta  proposta = null;

        try {

            Iterator it = ll_prop.iterator();

            while (it.hasNext()) {
                proposta = (Proposta) it.next();
                if (nom.equals(proposta.getNom())) {
                    proposta = ll_prop.get(id);
                    System.out.println(proposta.getNom());
                    break;
                }
            }

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }

        return proposta;
    }

    /* Mètode per a modificar propostes */
    public void modificarProposta(int item, String nom, String descripcio, Entitat entitat, String data_alta, String data_baixa, String estat) {

        try {

            this.ll_prop.get(item).setNom(nom);
            this.ll_prop.get(item).setDescripcio(descripcio);
            this.ll_prop.get(item).setData(data_alta);
            this.ll_prop.get(item).setEntitat(entitat);
            this.ll_prop.get(item).setDataBaixa(data_baixa);
            this.ll_prop.get(item).setEstat(estat);

            log.generarInfoLog("info.log", "S'ha modificat la propostas " + this.ll_prop.get(item).getNom() + ", amb les següent dades: " + "\n" + "-Descripció: " + this.ll_prop.get(item).getDescripcio() + "\n" + "-Proposta: " + this.ll_prop.get(item).getAutor().getNom() + "\n" + "-Data Alta: " + this.ll_prop.get(item).getDataAlta() + "\n" + "-Data Baixa: " + this.ll_prop.get(item).getDataBaixa() + "\n" + "-Estat: " + this.ll_prop.get(item).getEstat() + "\n");
        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Mètode per a retornar el llistat de propostes */
    public ArrayList<Proposta> returnList() {
        return ll_prop;
    }

}
