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
public enum Zombie {
    
    BOSS(100,60,6),
    ZOMBIE2(60,30,4),
    ZOMBIE1(40,10,2);
    
    private int pointsVie;
    private int dommages;
    private int vitesseAttaque;
    
    Zombie( int pointsVie, int dommages, int vitesseAttaque){
        this.pointsVie = pointsVie;
        this.dommages = dommages;
        this.vitesseAttaque = vitesseAttaque;
    }
    
    public static Ennemi chaineVersEnnemi(String s){
        return zombieVersEnnemi(Zombie.valueOf(s));
    }
    
    private static Ennemi zombieVersEnnemi(Zombie z){
        return new Ennemi(z.name(),z.pointsVie, z.dommages, z.vitesseAttaque,null);
    }
           
    
}
