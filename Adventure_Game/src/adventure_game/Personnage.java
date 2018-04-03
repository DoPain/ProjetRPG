package adventure_game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmorax
 */
public abstract class Personnage {
    
    protected int pointsVie;
    protected int dommages;
    protected int vitesseAttaque;

    public Personnage(int pointsVie, int dommagesBase, int vitesseAttaque) {
        this.pointsVie = pointsVie;
        this.dommages = dommagesBase;
        this.vitesseAttaque = vitesseAttaque;
    }
    
    
    public int getPointsVie(){
        return this.pointsVie;
    }
    
    public int getDommages(){
        return this.dommages;
    }
    
    public int getVitesseAttaque(){
        return this.vitesseAttaque;
    }
    
}
