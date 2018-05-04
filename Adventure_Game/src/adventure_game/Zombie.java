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
    
    /**
     *
     */
    BOSS(100,60),

    /**
     *
     */
    ZOMBIE2(60,30),

    /**
     *
     */
    ZOMBIE1(40,10);
    
    /**
     *
     */
    private int pointsVie;

    /**
     *
     */
    private int dommages;
    
    /**
     *
     * @param pointsVie
     * @param dommages
     * @param vitesseAttaque
     */
    Zombie( int pointsVie, int dommages){
        this.pointsVie = pointsVie;
        this.dommages = dommages;
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
        return new Ennemi(z.name(),z.pointsVie, z.dommages,null);
    }
           
    
}
