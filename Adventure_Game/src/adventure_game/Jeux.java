/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_game;

import java.util.ArrayList;

/**
 *
 * @author dmorax
 */
public class Jeux {
    
    public static void run(String csvSalle){
        initJeux(csvSalle);
    }
    
    public static void initJeux(String csvSalle){
        FormatCsv salleCSV = new FormatCsv(csvSalle,';');
        salleCSV.lire();
        
        salleCSV.donnees.forEach(s -> Salle.ajoutSalle(s.get(1),s.get(0)));
    }
    
}
