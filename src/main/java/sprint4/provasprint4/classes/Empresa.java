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


/**
 * Empresa
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe conté els atributs, constructor, setters i getters de les empreses*/
public class Empresa {

    private int id;
    private String nom;
    private String localitat;
    private String direccio;
    private String telefon;
    private String cif;
    private String email;
    private String estat;
    private int contador;

    /* Constructor */
    public Empresa(int id, String nom, String localitat, String direccio, String telefon, String cif, String email) {
        this.id = id;
        this.nom = nom;
        this.localitat = localitat;
        this.direccio =  direccio;
        this.telefon = telefon;
        this.cif = cif;
        this.cif = email;
        this.estat = "Actiu";
        

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

    public String getLocalitat() {
        return localitat;
    }

    public String getDireccio() {
        return direccio;

    }

    public String getTelefon() {
        return telefon;
    }

    public String getCif() {
        return cif;
    }
    public String getEmail() {
        return email;
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

    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }
    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }
    

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public void setEstat(String estat) {
        this.estat = estat;
    }

    /* toString */
    public String toString() {
        return id + " " + nom + " " + localitat + " " + direccio + " " + telefon + " " + cif + " " + email;
    }
}
