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
    private Objet objet;
    
    /**
     * Constructeur de la classe
     * @param id
     * @param ennemi
     * @param objet
     */
    public Salle(int id, Ennemi ennemi, Objet objet) {
        this.id = id;
     
        this.ennemi = ennemi;
        this.objet = objet;
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
            voisine.sallesVoisines.put(d.oppose(), this);
        }
    }

    /**
     * Permet d'afficher les voisins de la salle courante
     * @return 
     */
    public String afficherVoisins() {
        final StringBuilder message = new StringBuilder();
        sallesVoisines.forEach((k, v) -> message.append(String.format("La salle %d se situe direction:  %s\n", v.id, k.name())));
        
        return message.toString();
    }

    /**
     * Permet d'afficher les objets présent dans la salle courante
     * @return 
     */
    public String afficherItem() {
        if (objet != null){
            if (objet.obtenirDureeVie() != null && objet.obtenirMunitions() == null){
                return ("Dans cette salle il y a : " + objet.obtenirNom() + ". " + "Cet objet possède " + objet.obtenirDegats() + " de dégats d'attaque et lui reste " 
                        + objet.obtenirDureeVie() + " de durée de vie" + "\n\n");
            }else if (objet.obtenirMunitions() != null && objet.obtenirDureeVie() == null){
                return ("Dans cette salle il y a : " + objet.obtenirNom() + ". " + "Cet objet possède " + objet.obtenirDegats() + " de dégats d'attaque et lui reste " 
                        + objet.obtenirMunitions() + " de munitions" + "\n\n");
            }else if (objet.obtenirDureeVie() == null && objet.obtenirMunitions() == null){
                return ("Dans cette salle il y a : " + objet.obtenirNom() + ". \n\n");
            }         
        }else {
            return ("Il n'y a pas d'objet dans cette salle \n\n");
        }
        
        return "";
    }
    
    /**
     * Permet d'afficher les ennemis présents dans la salle courante
     * @return 
     */
    public String afficherEnnemi(){
        String message = "";
        if (this.ennemi != null){
            message+=("Dans cette salle il y a : " + this.ennemi.obtenirNom() + " il possède " + this.ennemi.pointsVie + " de points de vies \n");
        }else {
            message+=("Il n'y a pas d'ennemis dans cette salle \n");
        }
        return message;
    }
    
    /**
     * Permet au personnage d'examiner la salle pour savoir ce qu'il s'y trouve (objets/ennemis)
     * @return 
     */
    public String examiner(){
        return afficherEnnemi() + afficherItem();
    }
    
    /**
     *
     */
    public void supprimerItemSalle(){
        objet = null; 
    }
    
    /**
     *
     * @param o
     * @return  
     */
    public String ajouterItemSalle(Objet o){
        if(this.objet == null){
            this.objet = o;
            return "";
        }else {
            return ("Vous ne pouvez pas rajouter d'item à la salle.");
        }
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
        return objet;
    }
    
    /**
     *
     * @return
     */
    public HashMap<Direction, Salle> obtenirVoisins(){
        return sallesVoisines;
    }
    
    /**
     *
     * @return
     */
    public boolean contientItem(){
        return objet != null;
    }
    
    /**
     *
     * @return
     */
    public boolean contientEnnemi(){
        return this.ennemi !=null;
    }
    
    /**
     *
     * @return
     */
    public String decrire(){
        return ("Vous vous situez dans la salle n°" + obtenirId() + " \n" + "Voici les salles voisines à la votre : " + afficherVoisins());
    }
    
}
