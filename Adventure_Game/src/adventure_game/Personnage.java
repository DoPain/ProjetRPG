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
     * Correspond aux points de vie du personnage
     */
    protected int pointsVie;

    /**
     * Correspond aux dégats à main nue du personnage
     */
    protected int dommages;

    /**
     * Correspond à la salle courante où se situe le personnage
     */
    protected Salle salle;

    /**
     * Constructeur de la classe
     * @param pointsVie
     * @param dommagesBase
     * @param vitesseAttaque
     * @param s
     */
    public Personnage(int pointsVie, int dommagesBase, Salle s) {
        this.pointsVie = pointsVie;
        this.dommages = dommagesBase;
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
    public int obtenirDommages() {
        return this.dommages;
    }

    /** 
     * Accesseur sur la salle courante où se situe le personnage
     * @return
     */
    public Salle obtenirSalle() {
        return salle;
    }

}
