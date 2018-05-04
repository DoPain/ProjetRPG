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
public class Ennemi extends Personnage {

    /**
     * Correspond au nom de l'ennemi
     */
    private String nom;
    
    /**
     * Constructeur de la classe
     * @param nom
     * @param pointsVie
     * @param dommages
     * @param vitesseAttaque
     * @param s
     */
    public Ennemi(String nom, int pointsVie, int dommages, int vitesseAttaque, Salle s) {
        super(pointsVie,dommages,vitesseAttaque, s);
        this.nom = nom;
        
    }
    
    /**
     * Accesseur sur le nom de l'ennemi
     * @return
     */
    public String obtenirNom() {
        return nom;
    }    
    
}
