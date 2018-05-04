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
    protected Salle salle;

    public Personnage(int pointsVie, int dommagesBase, int vitesseAttaque, Salle s) {
        this.pointsVie = pointsVie;
        this.dommages = dommagesBase;
        this.vitesseAttaque = vitesseAttaque;
        this.salle = s;
    }

    public int obtenirPointsVie() {
        return this.pointsVie;
    }

    public int obtenirDommages() {
        return this.dommages;
    }

    public int obtenirVitesseAttaque() {
        return this.vitesseAttaque;
    }

    public Salle obtenirSalle() {
        return salle;
    }

}
