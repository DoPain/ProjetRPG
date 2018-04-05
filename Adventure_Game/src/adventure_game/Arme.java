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
    
    PISTOLET(null,10,20),
    M4(null,30,25),
    COUTEAU(10,null,40),
    HACHE(15,null,17),
    ARBALETTE(null,6,20);
    

    private Integer dureeVie;
    private Integer munitions;
    private int degats;
    
    Arme(Integer dureeVie, Integer munitions, int degats){
        this.dureeVie = dureeVie;
        this.munitions = munitions;
        this.degats = degats;
    }
    
    //recupere la case du csv correspondante et creer l'item correspondant
    public static Item StringToArme(String s){
        return ArmeToItem(Arme.valueOf(s));
    }
    
    //Créer une nouvelle arme(item)
    private static Item ArmeToItem(Arme a){
        return new Item(a.name(), a.dureeVie, a.munitions, a.degats);
    }
    
}
