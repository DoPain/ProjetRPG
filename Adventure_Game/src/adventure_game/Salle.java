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
public class Salle{


    private HashMap<Integer, Salle> sallesVoisines;
    private int id;
    private String description;
    private Ennemi ennemi;
    private Item item;
    private HashMap<String,Item> ItemsSalle;

    public Salle(int id, String description, Ennemi ennemi, Item item) {
        this.id = id;
        this.description = description;
        this.ennemi = ennemi;
        this.item = item;
        sallesVoisines = new HashMap<>();
    }

    public boolean MortPersonnage(PersonnagePrincipal p) {
        int pointsVie = p.getPointsVie();
        if (pointsVie == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean MortEnnemi(Ennemi z) {
        int pointsVie = z.getPointsVie();
        if (pointsVie == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void AjoutVoisins(int i) {
        sallesVoisines.put(i, Zone.IntToSalle(i));
    }

    public void displayVoisins() {
        sallesVoisines.forEach((k, v) -> System.out.format("Salle voisine = %d\n", k));
    }

    public void displayItem() {
        if (item != null){
            System.out.println("Dans cette salle il y a : " + item.getNom());
        }else {
            System.out.println("Il n'y a rien dans la salle");
        }
        
        
    }
    
    public void DisplayEnnemi(){
        if (this.ennemi != null){
            System.out.println("Dans cette salle il y a : " + this.ennemi.getNom());
        }else {
            System.out.println("Il n'y a pas d'ennemis dans cette salle");
        }
        
    }
    
    public void Examiner(){
        DisplayEnnemi();
        displayItem();
    }
    
    public void SupprimerItemSalle(){
        item = null; 
    }
    
    public void AjouterItemSalle(){
 
    }
    
    public void SupprimerEnnemiSalle(){
        this.ennemi = null;
    }

    public int getId() {
        return id;
    }
    
    
    public Ennemi getEnnemi() {
        return ennemi;
    }
    
    

}
