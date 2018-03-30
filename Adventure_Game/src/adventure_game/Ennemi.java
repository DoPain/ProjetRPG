package adventure_game;


import adventure_game.Personnage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmorax
 */
public class Ennemi extends Personnage implements Description {

    public Ennemi(int pointsVie, int dommages, int vitesseAttaque) {
        super(pointsVie,dommages,vitesseAttaque);
    }
    
    
    
     @Override
    public String seDecrire(){
    return "";
    }
    
}
