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
     *
     * @param pointsVies
     * @param dommages
     * @param s
     */
    public PersonnagePrincipal(int pointsVies, int dommages, Salle s) {
        super(pointsVies, dommages, s);
        inventairePersonnage = new Inventaire();
    }

    /**
     * Permet avec une arme d'attaquer un ennemi
     *
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
    public String attaquer(String arme) {
        String message = "";
        afficherInventaire();
        Objet i = Arme.chaineVersArme(arme);

        if (inventairePersonnage.obtenirListeObjets().size() > 0 && salle.obtenirEnnemi() != null && inventairePersonnage.obtenirListeObjets().values().contains(i)) {
            message += ("Points de vie de l'ennemi avant l'attaque " + salle.obtenirEnnemi().pointsVie + "\n");
            message += ("Vos points de vies avant l'attaque " + this.pointsVie + "\n \n");
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
                case "POINGS":
                    break;
            }
            message += ("Vous avez décider d'attaqué avec : " + i.obtenirNom() + "\n");
            attaquerAvecArme(i, salle.obtenirEnnemi());
            if (i.obtenirMunitions() == null) {
                i.duréeVieBaisse(i);
            } else if (i.obtenirDureeVie() == null) {
                i.munitionsBaisse(i);
            }
            if (salle.obtenirEnnemi().pointsVie > 0) {
            message += ("Points de vie de l'ennemi après l'attaque " + salle.obtenirEnnemi().pointsVie + "\n");
        } else {
            this.obtenirSalle().supprimerEnnemiSalle();
            message += ("Votre ennemi est mort " + "\n");
        }
        if (this.pointsVie > 0) {
            message += ("Points de vie du personnage après l'attaque " + this.pointsVie + "\n \n");
        } else {
            message += ("Vous etes morts" + "\n"
                    + "Vous avez donc perdu, veuillez relancer le jeux \n");
            System.exit(0);
        }
        } else {
            message += ("L'arme précisé n'est pas présente dans votre inventaire et/ou il n'y a pas d'ennemi dans cette salle \n \n");
        }
     
        return message;

    }

    /**
     * Permet au personnage de se déplacer dans différentes salles voisines à sa
     * salle actuelle
     *
     * @param i
     */
    public String seDeplacer(int i) {
        String message = "";
        boolean estVoisin = false;
        for (Salle s : this.salle.obtenirVoisins().values()) {
            if (s.obtenirId() == i) {
                estVoisin = true;
            }
        }
                
        if (estVoisin){
            message += ("Vous vous dirigez vers la salle n°" + Zone.entierVersSalle(i).obtenirId() + "\n");
            this.salle = Zone.entierVersSalle(i);      
        }else {
            message+= ("La salle que vous demandez n'est pas voisine avec la salle dans laquelle vous vous situez\n"
                    + "Veuillez entrer une salle voisine valide \n \n");
        }
        return message;
    }

    /**
     * Permet au personnage de ramasser un objet présent dans la salle où il se
     * situe
     *
     * @param i
     */
    public String ramasser(Objet i) {
        String message = "";
        if (this.obtenirSalle().contientItem() && this.obtenirSalle().obtenirItem().equals(i)) {
            message += inventairePersonnage.ajouter(i);
            salle.supprimerItemSalle();
        } else {
            message += ("L'item demandé n'est pas présent dans la salle \n");
        }
        return message;
    }

    /**
     * permet au personnage de jeter dans la salle un objet de son inventaire
     *
     * @param i
     */
    public void jeter(Objet i) {
        inventairePersonnage.supprimerObjetInventaire(i);
        salle.ajouterItemSalle(i);
    }

    /**
     * permet d'afficher le contenu de l'inventaire du personnage
     */
    public String afficherInventaire() {
        String message = "";
        message += ("Dans votre inventaire se trouve : \n");
        message += inventairePersonnage.afficher();

        return message;
    }
    
    public Inventaire obtenirInventaire(){
        return this.inventairePersonnage;
    }

}
