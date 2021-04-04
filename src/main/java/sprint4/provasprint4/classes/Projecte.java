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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Projecte
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe conté els atributs, constructor, setters i getters dels projectes*/
public class Projecte {

    private int id;
    private String nom;
    private String descripcio;
    private String data_alta;
    private String data_baixa;
    private String estat;
    private Proposta proposta;
    private int contador;

    /* Constructor */
    public Projecte(int id, String nom, String descripcio, Proposta proposta) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.data_alta = setDataAlta();
        this.data_baixa = " ";
        this.estat = "Actiu";
        this.proposta = proposta;

    }
    public int getComptadorProjectes() {
        return contador;
    }
    /* Getters */
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getDataAlta() {
        return data_alta;

    }

    public String getDataBaixa() {
        return data_baixa;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public String getEstat() {
        return estat;
    }

    /* Setters */
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public static String setDataAlta() {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date actual = new Date(System.currentTimeMillis());
        return formatador.format(actual);
    }

    public void setDataBaixa(String data_baixa) {
        this.data_baixa = data_baixa;
    }

    public void setData(String data_alta) {
        this.data_alta = data_alta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    /* toString */
    public String toString() {
        return id + " " + nom + " " + descripcio + " " + data_alta + " " + data_baixa + " " + proposta;
    }
}
