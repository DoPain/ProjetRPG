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
     * @param armure
     * @param s
     */
    public Ennemi(String nom, int pointsVie, int dommages,int armure, Salle s) {
        super(pointsVie,dommages,armure, s);
        this.nom = nom;
        
    }
    
    /**
     * Accesseur sur le nom de l'ennemi
     * @return
     */
    public String obtenirNom() {
        return nom;
    }    
    
    /**
     *
     * @param p
     */
    public void ennemiAttaque(PersonnagePrincipal p){
          if(p.obtenirArmure() > 0){
              p.setArmure(p.obtenirArmure()-this.degats);
              if(p.obtenirArmure() < 0){
                p.setPointsVie(p.obtenirPointsVie()+p.obtenirArmure());
                p.setArmure(0);
              }
         }else{
             p.setPointsVie(p.obtenirPointsVie()-this.degats);
         }      
    }
    
}
