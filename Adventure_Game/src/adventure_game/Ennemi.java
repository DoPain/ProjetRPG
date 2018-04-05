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



    private String nom;
    
    public Ennemi(String nom, int pointsVie, int dommages, int vitesseAttaque, Salle s) {
        super(pointsVie,dommages,vitesseAttaque, s);
        this.nom = nom;
        
    }
    
    public String getNom() {
        return nom;
    }    
    
}
