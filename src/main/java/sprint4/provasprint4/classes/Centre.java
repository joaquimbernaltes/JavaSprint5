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
 * Centre
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe conté els atributs, constructor, setters i getters dels centres*/
public class Centre extends Entitat {
    
    /* Atribut de la classe Centre*/
    private String codiCentre;
    
    /* Constructor amb els atributs de l'herència  i el de la classe*/    
    public Centre(int id, String nom, String ciutat, String email, String codiCentre) {
        super(id, nom, ciutat, email);
        this.codiCentre = codiCentre;
    }

    //Setters
    public void setcodiCentre(String codiCentre) {
        this.codiCentre = codiCentre;
    }

    //Getters
    public String getcodiCentre() {
        return codiCentre;
    }

    //toString
    public String toString() {
        return this.getId()+ " " + this.getNom() + " " + super.getCiutat() + " " + super.getEmail() + " " + codiCentre + " " + this.getDataAlta() + " " + this.getDataBaixa() + " " + this.getEstat();
    }

}
