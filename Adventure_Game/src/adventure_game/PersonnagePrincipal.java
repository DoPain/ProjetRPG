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
public class PersonnagePrincipal extends Personnage implements Description{

    public PersonnagePrincipal(int pointsVies, int dommages, int vitesseAttaque) {
        super(pointsVies, dommages, vitesseAttaque);
    }
       
     @Override
    public String seDecrire(){
    return "";
    }
    
}
