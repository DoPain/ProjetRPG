package adventure_game;

import java.util.ArrayList;
import java.util.List;

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
    
    List<Item> listItem;
    private static ArrayList<Salle> salles;
    private String description;
    private Ennemi ennemi1;
    
    public Salle(String description, Ennemi ennemi1){
        this.description = description;
        this.ennemi1 = ennemi1;
    }
    
     @Override
    public String seDecrire(){      
    return description;
    }
    
    
    public void description2(){
        System.out.println("Dans cette salle il ya :");
        listItem.forEach(i -> System.out.format("- %s", i.getNom()));
    }
    
    public static void ajoutSalle(String descr, String ennemi ){
        salles.add(new Salle(descr,Zombie.StringToEnnemi(ennemi)));
    }
    
    
}
