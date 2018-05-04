/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_game.demo;

import adventure_game.Jeux;

/**
 *
 * @author dmorax
 */
public class Main {
    
    /**
     *
     */
    private static final String csvSalle = "texte/salle.csv";

    /**
     *
     */
    private static Jeux j = new Jeux();
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        j.lancer(csvSalle);
    }
    
}
