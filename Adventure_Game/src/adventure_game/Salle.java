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


    private HashMap<Direction, Salle> sallesVoisines;
    private int id;
    //private String description;
    private Ennemi ennemi;
    private Objet item;
    //private HashMap<String,Objets> ItemsSalle;

    public Salle(int id, Ennemi ennemi, Objet item) {
        this.id = id;
        //this.description = description;
        this.ennemi = ennemi;
        this.item = item;
        sallesVoisines = new HashMap<>();
    }

    public boolean mortPersonnage(PersonnagePrincipal p) {
        int pointsVie = p.obtenirPointsVie();
        if (pointsVie == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean mortEnnemi(Ennemi z) {
        int pointsVie = z.obtenirPointsVie();
        if (pointsVie == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void ajoutVoisins(int i, Direction d) {
        Salle voisine = Zone.entierVersSalle(i);
        if(voisine != null) {
            sallesVoisines.put(d, voisine);
            voisine.sallesVoisines.put(d, this);
        }
    }

    public void afficherVoisins() {
        sallesVoisines.forEach((k, v) -> System.out.format("La salle %d se situe direction:  %s\n", v.id, k.name()));
    }

    public void afficherItem() {
        if (item != null){
            if (item.obtenirDureeVie() != null && item.obtenirMunitions() == null){
                System.out.println("Dans cette salle il y a : " + item.obtenirNom() + ". " + "Cette arme possède " + item.obtenirDegats() + " de dégats d'attaque et lui reste " 
                        + item.obtenirDureeVie() + " de durée de vie" + "\n");
            }else if (item.obtenirMunitions() != null && item.obtenirDureeVie() == null){
                System.out.println("Dans cette salle il y a : " + item.obtenirNom() + ". " + "Cette arme possède " + item.obtenirDegats() + " de dégats d'attaque et lui reste " 
                        + item.obtenirMunitions() + " de munitions" + "\n");
            }         
        }else {
            System.out.println("Il n'y a pas d'objet dans cette salle");
        }
        
        
    }
    
    public void afficherEnnemi(){
        if (this.ennemi != null){
            System.out.println("Dans cette salle il y a : " + this.ennemi.obtenirNom() + " il possède " + this.ennemi.pointsVie + " de points de vies");
        }else {
            System.out.println("Il n'y a pas d'ennemis dans cette salle");
        }
        
    }
    
    public void examiner(){
        afficherEnnemi();
        afficherItem();
    }
    
    public void supprimerItemSalle(){
        item = null; 
    }
    
    public void ajouterItemSalle(){
        
    }
    
    public void supprimerEnnemiSalle(){
        this.ennemi = null;
    }

    public int obtenirId() {
        return id;
    }
    
    
    public Ennemi obtenirEnnemi() {
        return ennemi;
    }
    
    public Objet obtenirItem(){
        return item;
    }
    
    public boolean contientItem(){
        return item != null;
    }
    
    

}
