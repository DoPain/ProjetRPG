/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_game;

import java.util.Arrays;

/**
 *
 * @author dmorax
 */
public enum Zombie {
    
    BOSS(100,60,6),
    ZOMBIE2(60,30,4),
    ZOMBIE1(40,10,2);
    
    private int PointsVie;
    private int dommages;
    private int vitesseAttaque;
    
    Zombie( int PointsVie, int dommages, int vitesseAttaque){
        this.PointsVie = PointsVie;
        this.dommages = dommages;
        this.vitesseAttaque = vitesseAttaque;
    }
    
    public static Ennemi StringToEnnemi(String s){
        return ZombieToEnnemi(Zombie.valueOf(s));
    }
    
    private static Ennemi ZombieToEnnemi(Zombie z){
        return new Ennemi(z.PointsVie, z.dommages, z.vitesseAttaque);
    }
           
    
}
