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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static sprint4.provasprint4.classes.LlistaProjectes.actualData;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import sprint4.provasprint4.auxiliar.Log;

/**
 * LlistaEntitats
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe conté la llista on guardarem les entitats creades i els mètodes per a gestionar aquestes*/
public class LlistaEntitats {
    
    /* Connexió BD */
    Conexio con= new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;

    /* Atributs de classe */
    public int contador = 0;
    private final static int MAXIM = 10;
    public final ArrayList<Entitat> ll_e = new ArrayList<>(MAXIM);
    static LocalDate date = LocalDate.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static String actualData = date.format(formatter);
    Log log = new Log();


    /* Setters / Getters */
    public int getComptadorEntitats() {
        return contador;
    }

    /* Metode per a consultar entitats */
    public LlistaEntitats consulta(String s) {

        LlistaEntitats temp_consulta = new LlistaEntitats();

        try {

            Iterator it = ll_e.iterator();
            while (it.hasNext()) {
                Entitat enti = (Entitat) it.next();
                if (enti.toString().toLowerCase().contains(s.toLowerCase())) {
                    temp_consulta.ll_e.add(enti);
                    temp_consulta.contador++;
                }
            }
        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }

        return temp_consulta;
    }

    /* Mètode per afegir una entitat a la llista */
    public void afegirEntitat(String nom, String ciutat, String email) {

        try {
            Entitat e = new Entitat(contador + 1, nom, ciutat, email);
            ll_e.add(contador, e);
            contador++;
            log.generarInfoLog("info.log", "S'ha afegit la entitat " + e.getNom() + ", de la localitat de " + e.getCiutat() + " amb email " + e.getEmail() + ".\n");
        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Mètode per a modificar els atributs d'una entitat */
    public void modificarEntitat(int id, String nom, String ciutat, String email, String data_alta, String data_baixa, String estat) {
        try {

            this.ll_e.get(id).setNom(nom);
            this.ll_e.get(id).setCiutat(ciutat);
            this.ll_e.get(id).setEmail(email);
            this.ll_e.get(id).setData(data_alta);
            this.ll_e.get(id).setDataBaixa(data_baixa);
            this.ll_e.get(id).setEstat(estat);
            log.generarInfoLog("info.log", "S'ha modificat l'entitat " + this.ll_e.get(id).getNom() + ", amb les següent dades: " + "\n" + " -Ciutat: " + this.ll_e.get(id).getCiutat() + "\n" + "-Correu: " + this.ll_e.get(id).getEmail() + "\n" + "-Data Alta: " + this.ll_e.get(id).getDataAlta() + "\n" + "-Data Baixa: " + this.ll_e.get(id).getDataBaixa() + "\n" + "-Estat: " + this.ll_e.get(id).getEstat() + "\n");

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Mètode per a donar de baixa una entitat */
    public void baixaEntitat(int item) {
        try {

            ll_e.get(item).setDataBaixa(actualData);
            ll_e.get(item).setEstat("Innactiu");
            log.generarInfoLog("info.log", "S'ha donat de baixa l'entitat " + this.ll_e.get(item).getNom() + ", de la localitat de " + this.ll_e.get(item).getCiutat() + " amb email " + this.ll_e.get(item).getEmail() + ".\n");

        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }

    /* Mètode per a la creacio d'exemples */
   /* public void entitatsInicials() {
        try {
            afegirEntitat("Pymeralia", "La Rapita", "pymer@gmail.com");
            afegirEntitat("Pymeralia", "La Rapita", "pymer@gmail.com");
            afegirEntitat("Pymeralia", "La Rapita", "pymer@gmail.com");
            afegirEntitat("Pymeralia", "La Rapita", "pymer@gmail.com");
            afegirEntitat("Pymeralia", "La Rapita", "pymer@gmail.com");
        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
    }*/

    /* Metode per a cercar entitats pel nom */
    public Entitat buscarPerNom(String nom, int id) {

        Entitat entitat = null;

        try {
            Iterator it = ll_e.iterator();
            while (it.hasNext()) {
                entitat = (Entitat) it.next();
                if (nom.equals(entitat.getNom())) {
                    entitat = ll_e.get(id);
                    break;
                }
            }
        } catch (Exception e) {
            log.generarErrorLog("error.log", e.toString());
        }
        System.out.println(entitat);
        return entitat;
    }

    /* Metoder per a retornar el llistat d'entitats */
    public ArrayList<Entitat> returnList() {

        return ll_e;
    }


}
