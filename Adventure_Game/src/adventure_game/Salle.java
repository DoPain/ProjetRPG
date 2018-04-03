package adventure_game;

import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmorax
 */
public class Salle implements Description{
    
    //ArrayList<Item> listItem;
    private static ArrayList<Salle> salles;
    private String description;
    private Ennemi ennemi;
    private Item item;
    
    public Salle(String description, Ennemi ennemi, Item item){
        this.description = description;
        this.ennemi = ennemi;
        this.item = item;
    }
    
     @Override
    public String seDecrire(){      
    return description;
    }
    
    public int MortPersonnage(PersonnagePrincipal p){
        return p.pointsVie = 0;
    }
    
    //public void description2(){
    //    System.out.println("Dans cette salle il ya :");
    //    listItem.forEach(i -> System.out.format("- %s", i.getNom()));
    //}
    
    public static void ajoutSalle(String descr, String ennemi, String item ){
        salles.add(new Salle(descr,Zombie.StringToEnnemi(ennemi), Arme.StringToArme(item)));
    }
    
    
}
