/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_game;

/**
 *
 * @author dmorax
 */
public class Main {
    
    private static final String csvSalle = "texte/salle.csv";
    private static Jeux j = new Jeux();
    
    
    public static void main(String[] args) {
        j.run(csvSalle);
    }
    
}
