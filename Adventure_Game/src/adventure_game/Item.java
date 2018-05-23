package adventure_game;

/**
 *
 * @author dmorax
 */
public enum Item {

    PISTOLET(null,10,40),
    M4(null,30,50),
    COUTEAU(10,null,20),
    HACHE(15,null,25),
    ARBALETTE(null,6,25),
    POMME(2,null,0);

    
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
    Item(Integer dureeVie, Integer munitions, int degats){
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
        return armeVersObjet(Item.valueOf(s));
    }
    
    

    /**
     * Créer une nouvelle arme(objet)
     * @param a
     * @return
     */
    private static Objet armeVersObjet(Item a){
        return new Objet(0,a.name(), a.dureeVie, a.munitions, a.degats);
    }
    
}
