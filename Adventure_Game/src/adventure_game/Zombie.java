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
public enum Zombie  {

    ZEYROK(80,60,0,30),
    LOUZI(100,65,0,50),
    ZOMBIE2(60,20,0,15),
    ZOMBIE1(40,4,0,10),
    DOVAKIN(500,100,0,100),
    CADAVRE(0,0,0,0),
    JAMES(5,2,0,0);
    
    /**
     *
     */
    private final int pointsVie;

    /**
     *
     */
    private final int degats;
    
    private final int armure;
    
    private final int couragePerdu;
    
    /**
     *
     * @param pointsVie
     * @param dommages
     * @param vitesseAttaque
     */
    Zombie( int pointsVie, int degats,int armure, int courage){
        this.pointsVie = pointsVie;
        this.degats = degats;
        this.armure = armure;
        this.couragePerdu = courage;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static Ennemi chaineVersEnnemi(String s){
        return zombieVersEnnemi(Zombie.valueOf(s));
    }
    
    /**
     *
     * @param z
     * @return
     */
    private static Ennemi zombieVersEnnemi(Zombie z){
        return new Ennemi(z.name(),z.pointsVie, z.degats,z.armure,z.couragePerdu, null);
    }
       
           
    
}
