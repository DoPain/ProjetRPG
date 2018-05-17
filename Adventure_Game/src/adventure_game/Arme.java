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
    
    /**
     * Correspond à la durée de vie de l'objet. Cette durée de vie est uniquement associé à une 
     * arme blanche (couteau ou hache)
     */
    private Integer dureeVie;

    /**
     * Correspond au munitions de l'objet. Ces munitions sont uniquement associé à une 
     * arme à feu ou à l'arbalette (pistolet ou m4)
     */
    private Integer munitions;

    /**
     * Correspons aux dégats de l'arme
     */
    private int degats;
    
    /**
     * Constructeur de la classe
     * @param dureeVie
     * @param munitions
     * @param degats
     */
    Arme(Integer dureeVie, Integer munitions, int degats){
        this.dureeVie = dureeVie;
        this.munitions = munitions;
        this.degats = degats;
    }
    
    //recupere la case du csv correspondante et creer l'item correspondant

    /**
     * recupere la valeur de la colone du csv correspondant à l'objet et creer cet objet
     * @param s
     * @return
     */
    public static Objet chaineVersArme(String s){
        return armeVersItem(Arme.valueOf(s));
    }
    
    

    /**
     * Créer une nouvelle arme(objet)
     * @param a
     * @return
     */
    private static Objet armeVersItem(Arme a){
        return new Objet(a.name(), a.dureeVie, a.munitions, a.degats);
    }
    
}
