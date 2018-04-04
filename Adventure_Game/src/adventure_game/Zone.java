package adventure_game;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmorax
 */
public class Zone {
    
    private final int nbSalles = 4;
    private int niveauZone;
    private static ArrayList<Salle> salles;
    
     public static void AjoutSalle(String descr, String ennemi, String item ){
        salles.add(new Salle(descr,Zombie.StringToEnnemi(ennemi), Arme.StringToArme(item)));
    }
}
