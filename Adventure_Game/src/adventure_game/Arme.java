/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_game;

/**
 *
 * @author dmorax
 */
public enum Arme {
    
    PISTOLET(null,10,40),
    M4(null,30,50),
    COUTEAU(10,null,20),
    HACHE(15,null,25),
    ARBALETTE(null,6,25);
    

    private Integer dureeVie;
    private Integer munitions;
    private int degats;
    
    Arme(Integer dureeVie, Integer munitions, int degats){
        this.dureeVie = dureeVie;
        this.munitions = munitions;
        this.degats = degats;
    }
    
    //recupere la case du csv correspondante et creer l'item correspondant
    public static Objet chaineVersArme(String s){
        return armeVersItem(Arme.valueOf(s));
    }
    
    //Créer une nouvelle arme(item)
    private static Objet armeVersItem(Arme a){
        return new Objet(a.name(), a.dureeVie, a.munitions, a.degats);
    }
    
}
