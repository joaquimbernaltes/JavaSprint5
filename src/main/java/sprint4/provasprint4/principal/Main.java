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
package sprint4.provasprint4.principal;

import sprint4.provasprint4.classes.*;
import sprint4.provasprint4.forms.JFrameMenuPrincipal;

/**
 * Main
 *
 * @author grup3 Ximo Bernaltes, Joel Ferragut, Marc España, Joel Pascual
 * @version 14.0
 */

/* Mitjançant aquest Frame seleccionem una proposta del llistat*/
public class Main {
//Constructor, li passem per paramentre 34 objectes de classe per a llistar cada una de les entitats
    public static void main(String[] args) throws Exception{
        LlistaEntitats ll_enti = new LlistaEntitats();
        LlistaProjectes ll_proj = new LlistaProjectes();
        LlistaPropostes ll_prop = new LlistaPropostes();
        LlistaPresupostos ll_pres = new LlistaPresupostos();
        //ll_enti.entitatsInicials();
        JFrameMenuPrincipal m = new JFrameMenuPrincipal(ll_enti, ll_proj, ll_prop, ll_pres);
        m.setVisible(true);//Mostrem la pantalla principal
        
    }
}
