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

/**
 * Empresa
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Aquesta classe conté els atributs, constructor, setters i getters de les empreses*/
public class Empresa extends Entitat {
    
    /* Atribut de la classe Empresa */
    private String NIF;
    
    /* Constructor amb els atributs de l'herència i el de la classe*/
    public Empresa(int ID, String nom, String ciutat, String email, String nif) {
        super(ID, nom, ciutat, email);
        this.NIF = nif;
    }

    //Setters
    public void setNIF(String nif) {
        NIF = nif;
    }

    //Getters
    public String getNIF() {
        return NIF;
    }

    //toString
    public String toString() {
        return this.getId() + "" + this.getNom() + "" + this.getCiutat() + "" + this.getEmail() + "" + NIF + "" + this.getDataAlta() + "" + this.getDataBaixa() + "" + this.getEstat();
    }

}
