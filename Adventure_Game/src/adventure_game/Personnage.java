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
    protected int dommagesBase;
    protected int vitesseAttaque;

    public Personnage(int pointsVie, int dommagesBase, int vitesseAttaque) {
        this.pointsVie = pointsVie;
        this.dommagesBase = dommagesBase;
        this.vitesseAttaque = vitesseAttaque;
    }
    
    
    Personnage John = new PersonnagePrincipal(100,30,5);
    Personnage Zombie1 = new Ennemi(50, 10, 1);
    Personnage Zombie2 = new Ennemi(50, 20, 2);
    Personnage Zombie3 = new Ennemi(50, 30, 3);
    Personnage Zombie4 = new Ennemi(50, 40, 4);
    
    
    
}
