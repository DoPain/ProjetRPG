package adventure_game;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmorax
 */
public class Inventaire {
    
    private HashMap<String,Item> listeItems;
    
    Inventaire(){
        listeItems = new HashMap<>(); 
    }
    
    public void Ajouter(Item i){
        listeItems.put(i.getNom(), i);
        System.out.println("Vous avez ramasser " + i.getNom() + "\n");
    }
    
    public void Supprimer(Item i){
        if (listeItems.size() > 0){
            listeItems.remove(i.getNom());
            System.out.println("Vous avez jeté " + i.getNom() + "\n");
        }else {
            System.out.println("Vous ne pouvez pas jeter du vide" + "\n");
        }
        
    }

    public HashMap<String, Item> getListeItems() {
        return listeItems;
    }
    
    public void displayInventaire(){
        if (listeItems.size() > 0){
            listeItems.forEach((k,v) -> System.out.printf(k + "\n"));
        }else {
            System.out.println("Vous n'avez rien dans votre inventaire" + "\n");
        }
        
        
    }
    
}
