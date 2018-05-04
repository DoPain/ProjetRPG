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

    /**
     *
     */
    private HashMap<Direction, Salle> sallesVoisines;

    /**
     *
     */
    private int id;
    //private String description;

    /**
     *
     */
    private Ennemi ennemi;

    /**
     *
     */
    private Objet item;
    //private HashMap<String,Objets> ItemsSalle;

    /**
     * Constructeur de la classe
     * @param id
     * @param ennemi
     * @param item
     */
    public Salle(int id, Ennemi ennemi, Objet item) {
        this.id = id;
        //this.description = description;
        this.ennemi = ennemi;
        this.item = item;
        sallesVoisines = new HashMap<>();
    }

    /**
     * Indique si le personnage est mort ou non
     * @param p
     * @return
     */
    public boolean mortPersonnage(PersonnagePrincipal p) {

        if (p.obtenirPointsVie() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Indique si le zombie courant est mort ou non
     * @param z
     * @return
     */
    public boolean mortEnnemi(Ennemi z) {

        if (z.obtenirPointsVie() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Permet d'ajouter un voisin à la liste de voisin
     * @param i
     * @param d
     */
    public void ajoutVoisins(int i, Direction d) {
        Salle voisine = Zone.entierVersSalle(i);
        if(voisine != null) {
            sallesVoisines.put(d, voisine);
            voisine.sallesVoisines.put(d, this);
        }
    }

    /**
     * Permet d'afficher les voisins de la salle courante
     */
    public void afficherVoisins() {
        sallesVoisines.forEach((k, v) -> System.out.format("La salle %d se situe direction:  %s\n", v.id, k.name()));
    }

    /**
     * Permet d'afficher les objets présent dans la salle courante
     */
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
    
    /**
     * Permet d'afficher les ennemis présents dans la salle courante
     */
    public void afficherEnnemi(){
        if (this.ennemi != null){
            System.out.println("Dans cette salle il y a : " + this.ennemi.obtenirNom() + " il possède " + this.ennemi.pointsVie + " de points de vies");
        }else {
            System.out.println("Il n'y a pas d'ennemis dans cette salle");
        }
        
    }
    
    /**
     * Permet au personnage d'examiner la salle pour savoir ce qu'il s'y trouve (objets/ennemis)
     */
    public void examiner(){
        afficherEnnemi();
        afficherItem();
    }
    
    /**
     *
     */
    public void supprimerItemSalle(){
        item = null; 
    }
    
    /**
     *
     */
    public void ajouterItemSalle(){
        
    }
    
    /**
     *
     */
    public void supprimerEnnemiSalle(){
        this.ennemi = null;
    }

    /**
     *
     * @return
     */
    public int obtenirId() {
        return id;
    }
    
    /**
     *
     * @return
     */
    public Ennemi obtenirEnnemi() {
        return ennemi;
    }
    
    /**
     *
     * @return
     */
    public Objet obtenirItem(){
        return item;
    }
    
    /**
     *
     * @return
     */
    public boolean contientItem(){
        return item != null;
    }
    
    

}
