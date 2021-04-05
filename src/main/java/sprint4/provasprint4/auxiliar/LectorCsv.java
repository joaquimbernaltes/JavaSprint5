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

import sprint4.provasprint4.classes.Entitat;
import sprint4.provasprint4.classes.LlistaEntitats;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LectorCsv
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe l'utilitzem per a dur a terme la lectura del fitxer csv a importar */
public class LectorCsv {

    /* Mitjançant aquest mètode duem a terme l'importació massiva d'entitats */
    public static void importarEntitats(LlistaEntitats ll_enti, String ruta) {

        /* Establim els parametres de configuració del fitxer */
        String csvFile = ruta;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Log log = new Log();

        try {
            /* Instanciem el lector dintre d'un try/catch per a fer front a possibles errors */
            br = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /*Recorrem les dades del fitxer*/
            while ((line = br.readLine()) != null) {
                /*Separem en comes les dades importades i cridem al metode per afegir-les */
                String[] entitat = line.split(cvsSplitBy);
                /* Establim el iterador per a recorrer el llistat d'entitats */
                Iterator it = ll_enti.ll_e.iterator();
                /* Declarem una bandera, la qual si es compleix que el nom esta repetit aquest no serà inserit*/
                boolean repetit = false;
                /* Establim el bucle per a recorrer el llistat d'entitats i comprovar-ne l'existència */
                while (it.hasNext()) {
                    Entitat enti = (Entitat) it.next();
                    if (enti.getNom().equals(entitat[0])) {
                        log.generarInfoLog("info.log", "IMPORTACIÓ: S'ha descartat l'entitat " + entitat[0]);
                        repetit = true;
                    }
                }
                if (!repetit) {
                    ll_enti.afegirEntitat(entitat[0], entitat[1], entitat[2]);
                }

            }
        } catch (IOException ex) {

            Logger.getLogger(LectorCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
