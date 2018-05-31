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
    
    /**
     *
     */
    private HashMap<String,Objet> listeObjets;
    
    /**
     *
     */
    public Inventaire(){
        listeObjets = new HashMap<>(); 
    }
    
    /**
     * Permet d'ajouter un objet dans l'inventaire du joueur
     * @param i
     * @return 
     */
    public String ajouter(Objet i){
        listeObjets.put(i.obtenirNom(), i);
        return ("Vous avez ramassé " + i.obtenirNom() + "\n \n");
    }
    
    /**
     * Permet de supprimer un objet de l'inventaire du personnage
     * @param i
     * @return 
     */
    public String supprimerObjetInventaire(Objet i){
        if (listeObjets.size() > 0){
            listeObjets.remove(i.obtenirNom());
            return ("Vous avez jeté " + i.obtenirNom() + "\n");
        }else {
            return ("Vous ne pouvez pas jeter du vide" + "\n");
        }
        
    }

    /**
     * Accesseur sur la liste d'objet
     * @return
     */
    public HashMap<String, Objet> obtenirListeObjets() {
        return listeObjets;
    }
    
    /**
     * Permet d'afficher l'inventaire actuel du personnage
     * @return 
     */
    public String afficher(){
        final StringBuilder message = new StringBuilder();
        if (listeObjets.size() > 0){
            listeObjets.forEach((k,v) -> {
                if (v.obtenirDureeVie() != null && v.obtenirMunitions() == null){
                    message.append(String.format(k + " il lui reste " + v.obtenirDureeVie() + " de durée de vie." + "\n"));
                }else  if (v.obtenirMunitions() != null && v.obtenirDureeVie() == null){
                    message.append(String.format(k + " il lui reste " + v.obtenirMunitions() + " de munitions." + "\n"));
                }
            });
        }else {
            message.append("Vous n'avez rien dans votre inventaire" + "\n");
        }
        
        return message.toString();
    }
    
    /**
     *
     * @param s
     * @return
     */
    public Objet obtenirObjet(String s){
        return listeObjets.get(s);
    }
    
}
