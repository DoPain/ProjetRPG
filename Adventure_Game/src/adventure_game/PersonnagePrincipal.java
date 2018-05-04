package adventure_game;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmorax
 */
public class PersonnagePrincipal extends Personnage {

    /**
     * Correspond à l'inventaire du personnage
     */
    private Inventaire inventairePersonnage;

    /**
     * Constructeur de la classe
     * @param pointsVies
     * @param dommages
     * @param vitesseAttaque
     * @param s
     */
    public PersonnagePrincipal(int pointsVies, int dommages, Salle s) {
        super(pointsVies, dommages, s);
        inventairePersonnage = new Inventaire();
    }

    /**
     * Permet avec une arme d'attaquer un ennemi
     * @param i
     * @param e
     */
    public void attaquerAvecArme(Objet i, Ennemi e) {    
        if (i.obtenirMunitions() != null && i.obtenirDureeVie() == null) {
            i.munitionsBaisse(i);
            e.pointsVie -= i.obtenirDegats();
        } else if (i.obtenirDureeVie() != null && i.obtenirMunitions() == null) {
            e.pointsVie -= i.obtenirDegats();
            i.duréeVieBaisse(i);
        }
    }

    /**
     *
     */
    public void attaquer() {           
        afficherInventaire();
        Objet i = new Objet("poings", null, null, this.dommages); 
        Scanner sc = new Scanner(System.in);
        System.out.println("Points de vie de l'ennemi avant l'attaque " + salle.obtenirEnnemi().pointsVie + "\n");
        System.out.println("Vos points de vies avant l'attaque " + this.pointsVie + "\n");     
            if (inventairePersonnage.obtenirListeObjets().size() > 0 && salle.obtenirEnnemi() != null) {
                System.out.println("Quel item choisissez-vous pour attaquer? ");
                String arme = sc.next().toUpperCase();
                switch (arme) {
                    case "COUTEAU":
                        i = Arme.chaineVersArme(arme);
                        break;
                    case "M4":
                        i = Arme.chaineVersArme(arme);
                        break;
                    case "PISTOLET":
                        i = Arme.chaineVersArme(arme);
                        break;
                    case "HACHE":
                        i = Arme.chaineVersArme(arme);
                        break;
                    case "ARBALETTE":
                        i = Arme.chaineVersArme(arme);
                        break;
                    default:
                        break;
                }        
        System.out.println("Vous avez décider d'attaqué avec : " + i.obtenirNom() + "\n");
        attaquerAvecArme(i, salle.obtenirEnnemi());
        if (i.obtenirDureeVie() != null && i.obtenirMunitions() == null){
            i.duréeVieBaisse(i);
        }else if (i.obtenirMunitions() != null && i.obtenirDureeVie() == null){
            i.munitionsBaisse(i);
        }
        } else if (salle.obtenirEnnemi() == null) {
            System.out.println("Vous ne pouvez pas vous attaquer vous même voyons. Essayez de trouver un ennemi d'abord.");
        }
        if (salle.obtenirEnnemi().pointsVie > 0) {
            System.out.println("Points de vie de l'ennemi après l'attaque " + salle.obtenirEnnemi().pointsVie + "\n");
        } else {
            this.obtenirSalle().supprimerEnnemiSalle();
            System.out.println("Votre ennemi est mort " + "\n");
        }
        if (this.pointsVie > 0) {
            System.out.println("Points de vie du personnage après l'attaque " + this.pointsVie + "\n");
        } else {
            System.out.println("Vous etes morts" + "\n" 
                    + "Vous avez donc perdu, veuillez relancer le jeux");
            System.exit(0);
        }

    }

    /**
     * Permet au personnage de se déplacer dans différentes salles voisines à sa salle actuelle
     * @param i
     */
    public void seDeplacer(int i) {
        System.out.println("Vous vous dirigez vers la salle n°" + Zone.entierVersSalle(i).obtenirId() + "\n");
        this.salle = Zone.entierVersSalle(i);
    }

    /**
     * Permet au personnage de ramasser un objet présent dans la salle où il se situe
     * @param i
     */
    public void ramasser(Objet i) {
        if (this.obtenirSalle().contientItem() && this.obtenirSalle().obtenirItem().equals(i)){                
                inventairePersonnage.ajouter(i);
                salle.supprimerItemSalle();
        }else {
            System.out.println("L'item demandé n'est pas présent dans la salle");
        }
    
    }

    /**
     * permet au personnage de jeter dans la salle un objet de son inventaire
     * @param i
     */
    public void jeter(Objet i) {
        inventairePersonnage.supprimerObjetInventaire(i);
        salle.ajouterItemSalle(i);
    }

    /**
     * permet d'afficher le contenu de l'inventaire du personnage
     */
    public void afficherInventaire() {
        System.out.println("Dans votre inventaire se trouve : ");
        inventairePersonnage.afficher();
    }

}
