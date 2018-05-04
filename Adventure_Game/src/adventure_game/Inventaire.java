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
     */
    public void ajouter(Objet i){
        listeObjets.put(i.obtenirNom(), i);
        System.out.println("Vous avez ramasser " + i.obtenirNom() + "\n");
    }
    
    /**
     * Permet de supprimer un objet de l'inventaire du personnage
     * @param i
     */
    public void supprimerObjetInventaire(Objet i){
        if (listeObjets.size() > 0){
            listeObjets.remove(i.obtenirNom());
            System.out.println("Vous avez jeté " + i.obtenirNom() + "\n");
        }else {
            System.out.println("Vous ne pouvez pas jeter du vide" + "\n");
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
     */
    public void afficher(){
        if (listeObjets.size() > 0){
            listeObjets.forEach((k,v) -> {
                if (v.obtenirDureeVie() != null && v.obtenirMunitions() == null){
                    System.out.printf(k + " il lui reste " + v.obtenirDureeVie() + " de durée de vie." + "\n");
                }else  if (v.obtenirMunitions() != null && v.obtenirDureeVie() == null){
                    System.out.printf(k + " il lui reste " + v.obtenirMunitions() + " de munitions." + "\n");
                }
            });
        }else {
            System.out.println("Vous n'avez rien dans votre inventaire" + "\n");
        }           
    }
    
}
