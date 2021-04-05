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
package sprint4.provasprint4.auxiliar;

import sprint4.provasprint4.classes.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * FileCsv
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe l'utilitzem per afegir les dades a importar, dintre del fitxer csv*/
public class FileCsv {

    /* Mitjançant aquest metode durem a terme l'exportació d'entitats en format CSV */
    public static void exportarCsvEntitats(LlistaEntitats ll_enti, String ruta) throws Exception {

        /*Establim l'ubicació i el nom del fitxer CSV, ruta se selecciona al programa*/
        String csvFile = ruta + "/exportEntitats.csv";

        /*Passem les dades establertes anteriorment a l'objecte de la classe FileWriter, 
        el qual ens permetra dur a terme l'inserció de les dades en el fitxer. (Filewriter genera/escriu fitxers)*/
        FileWriter writer = new FileWriter(csvFile);

        /*Realitzem la creació de l'iterador, el qual assignem a l'arraylist i que juntament
        amb el while i una funció d'aquest, recorrerem les dades i accedirem a aquestes,
        finalment les afegirem dintre de l'array entitat la qual conté totes les dades 
        d'una entitat. Ja que hi ha un bucle, per cada volta, s'escriura una linia.*/
        Iterator it = ll_enti.ll_e.iterator();
        while (it.hasNext()) {
            Entitat e = (Entitat) it.next();
            String nom = e.getNom();
            String ciutat = e.getCiutat();
            String email = e.getEmail();
            String data_alta = e.getDataAlta();
            String data_baixa = e.getDataBaixa();
            String estat = e.getEstat();

            ArrayList<String> entitat = new ArrayList<>(7);
            entitat.add(nom);
            entitat.add(ciutat);
            entitat.add(email);
            entitat.add(data_alta);
            entitat.add(data_baixa);
            entitat.add(estat);

            /*Escriu les linies*/
            GenerarCsv.writeLine(writer, entitat);
        }

        /*Llimpia l'escritor (FileWriter), para evitar l'execució anterior i actual en quan a text*/
        writer.flush();
        writer.close();

    }

    /* Mitjançant aquest metode durem a terme l'exportació de propostes en format CSV */
    public static void exportarCsvPropostes(LlistaPropostes ll_pro, String ruta) throws Exception {

        /*Establim l'ubicació i el nom del fitxer CSV*/
        String csvFile = ruta + "/exportPropostes.csv";

        /*Passem les dades establertes anteriorment a l'objecte de la classe FileWriter, 
        el qual ens permetra dur a terme l'inserció de les dades en el fitxer.*/
        FileWriter writer = new FileWriter(csvFile);

        /*Realitzem la creació de l'iterador, el qual assignem a l'arraylist i que juntament
        amb el while i una funció d'aquest, recorrerem les dades i accedirem a aquestes,
        finalment les afegirem dintre de l'array entitat la qual conté totes les dades 
        d'una entitat. Ja que hi ha un bucle, per cada volta, s'escriura una linia.*/
        for (Proposta p : ll_pro.ll_prop) {
            String nom = p.getNom();
            String descripcio = p.getDescripcio();
            String data_alta = p.getDataAlta();
            String data_baixa = p.getDataBaixa();
            String autor = p.getAutor().getNom();
            String estat = p.getEstat();

            ArrayList<String> proposta = new ArrayList<>(7);
            proposta.add(nom);
            proposta.add(descripcio);
            proposta.add(autor);
            proposta.add(data_alta);
            proposta.add(data_baixa);
            proposta.add(estat);

            GenerarCsv.writeLine(writer, proposta);
        }

        writer.flush();
        writer.close();

    }
    public static void exportarCsvPressupostos(LlistaPresupostos ll_pre, String ruta) throws Exception {

        /*Establim l'ubicació i el nom del fitxer CSV*/
        String csvFile = ruta + "/exportPressupostos.csv";

        /*Passem les dades establertes anteriorment a l'objecte de la classe FileWriter,
        el qual ens permetra dur a terme l'inserció de les dades en el fitxer.*/
        FileWriter writer = new FileWriter(csvFile);

        /*Realitzem la creació de l'iterador, el qual assignem a l'arraylist i que juntament
        amb el while i una funció d'aquest, recorrerem les dades i accedirem a aquestes,
        finalment les afegirem dintre de l'array entitat la qual conté totes les dades
        d'una entitat. Ja que hi ha un bucle, per cada volta, s'escriura una linia.*/
        for (Pressupost pressupost : ll_pre.ll_pres) {
            Pressupost p = pressupost;
            String nom = p.getNom();
            String projecte = p.getProjecte().getNom();
            String descripcio = p.getDescripcio();
            String data_alta = p.getDataAlta();
            String data_baixa = p.getDataBaixa();
            String estat = p.getEstat();

            ArrayList<String> proposta = new ArrayList<>(7);
            proposta.add(nom);
            proposta.add(projecte);
            proposta.add(descripcio);
            proposta.add(data_alta);
            proposta.add(data_baixa);
            proposta.add(estat);

            GenerarCsv.writeLine(writer, proposta);
        }

        writer.flush();
        writer.close();

    }
    /* Mitjançant aquest metode durem a terme l'exportació de projectes en format CSV */
    public static void exportarCsvProjectes(LlistaProjectes ll_proj, String ruta) throws Exception {

        /*Establim l'ubicació i el nom del fitxer CSV*/
        String csvFile = ruta + "/exportProjectes.csv";

        /*Passem les dades establertes anteriorment a l'objecte de la classe FileWriter, 
        el qual ens permetra dur a terme l'inserció de les dades en el fitxer.*/
        FileWriter writer = new FileWriter(csvFile);

        /*Realitzem la creació de l'iterador, el qual assignem a l'arraylist i que juntament
        amb el while i una funció d'aquest, recorrerem les dades i accedirem a aquestes,
        finalment les afegirem dintre de l'array entitat la qual conté totes les dades 
        d'una entitat. Ja que hi ha un bucle, per cada volta, s'escriura una linia.*/
        Iterator it = ll_proj.ll_proj.iterator();
        while (it.hasNext()) {
            Projecte p = (Projecte) it.next();
            String nom = p.getNom();
            String descripcio = p.getDescripcio();
            String proposta = p.getProposta().getNom();
            String data_alta = p.getDataAlta();
            String data_baixa = p.getDataBaixa();
            String estat = p.getEstat();

            ArrayList<String> projecte = new ArrayList<>(7);
            projecte.add(nom);
            projecte.add(descripcio);
            projecte.add(proposta);
            projecte.add(data_alta);
            projecte.add(data_baixa);
            projecte.add(estat);

            GenerarCsv.writeLine(writer, projecte);
        }

        writer.flush();
        writer.close();

    }
}
