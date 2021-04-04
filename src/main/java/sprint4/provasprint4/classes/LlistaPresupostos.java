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
package Sprint4.provasprint4.classes;

import Sprint4.provasprint4.auxiliar.Log;

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

    /* Atributs de la classe */
    private int contador = 0;
    private final static int maxim = 10;
    //Creació arraylist de tipo pressupost en lo nom ll_pres i en capacitat maxima de 10
    public final ArrayList<Pressupost> ll_pres = new ArrayList<>(maxim);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Log log = new Log();

    /* Getter per a agafar el número de presupostos que hi ha actualment */
    public int getNumpresupostosActuals() {
        return contador;
    }

    /* Mètode per a inserir presupostos */
    public void inserirPressupost(  String titol, String descripcio,Projecte projecte) {
        try {

            if (contador == maxim) {
                System.out.println("Ja no hi caben més presupostos!");
                return;
            }
            Pressupost m = new Pressupost(contador + 1, titol, descripcio, projecte);
            //Agafa ll_pres i afegeix el num de contador (com a id) i m es el objecte de pressupost
            this.ll_pres.add(contador, m);
            contador++;
            log.generarInfoLog("info.log", "S'ha creat el " + m.toString() + "'.\n");
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
                    temp_consulta.contador++;
                }
            }
            if (temp_consulta.getNumpresupostosActuals() == 0) {
                System.out.println("No s'han trobat resultats");
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
