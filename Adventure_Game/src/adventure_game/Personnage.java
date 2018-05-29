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

    /**
     * Correspond aux points de vie du personnage(ennemi ou personnagePrincipal)
     */
    protected int pointsVie;

    /**
     * Correspond aux dégats à main nue du personnage
     */
    protected int degats;
    
    /**
     *
     */
    protected int armure;

    /**
     * Correspond à la salle courante où se situe le personnage
     */
    protected Salle salle;
    
    protected int courage;

    /**
     * Constructeur de la classe
     * @param pointsVie
     * @param dommagesBase
     * @param armure
     * @param s
     */
    public Personnage(int pointsVie, int dommagesBase,int armure,int courage, Salle s) {
        this.pointsVie = pointsVie;
        this.degats = dommagesBase;
        this.armure = armure;
        this.courage = courage;
        this.salle = s;
    }

    /**
     * Accesseur sur les points de vie du personnage
     * @return
     */
    public int obtenirPointsVie() {
        return this.pointsVie;
    }

    /**
     * Accesseur sur les degats à main nue du personnage
     * @return
     */
    public int obtenirDegats() {
        return this.degats;
    }

    /** 
     * Accesseur sur la salle courante où se situe le personnage
     * @return
     */
    public Salle obtenirSalle() {
        return salle;
    }

    /**
     *
     * @param pointsVie
     */
    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }
    
    /**
     *
     * @param armure
     */
    public void setArmure(int armure){
        this.armure = armure;
    }
    
    /**
     *
     * @return
     */
    public int obtenirArmure() {
        return this.armure;
    }

    public int obtenirCourage() {
        return courage;
    }
    
    

}
