package adventure_game;


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
     * @param armure
     * @param s
     */
    public PersonnagePrincipal(int pointsVies, int dommages, int armure, Salle s) {
        super(pointsVies, dommages, armure, s);
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
            e.pointsVie -= i.obtenirDegats();
            i.munitionsBaisse();
        } else if (i.obtenirDureeVie() != null && i.obtenirMunitions() == null) {
            e.pointsVie -= i.obtenirDegats();
            i.duréeVieBaisse();
        }
    }

    /**
     *
     * @param arme
     * @return
     */
    public String attaquer(String arme) {
        Objet i = inventairePersonnage.obtenirObjet(arme);
        String message = "";

        if (inventairePersonnage.obtenirListeObjets().size() < 0) {
            message += "Inventaire vide\n\n";
        } else if (i == null) {
            message += "L'objet que vous voulez utiliser n'est pas présent dans votre inventaire\n\n";
        } else if (salle.obtenirEnnemi() != null && salle.obtenirEnnemi().obtenirPointsVie() != 0
                && ((i.obtenirDureeVie() != null && i.obtenirDureeVie() > 0) || (i.obtenirMunitions() != null && i.obtenirMunitions() > 0))) {

            message += ("Vous avez décider d'attaqué avec : " + i.obtenirNom() + "\n");
            attaquerAvecArme(i, salle.obtenirEnnemi());

            salle.obtenirEnnemi().ennemiAttaque(this); //Ceci correspond à la riposte de l'ennemi
            message += ("Vous venez de reveiller l'ennemi... celui riposte! \n\n");

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
            }

        } else if ((i.obtenirDureeVie() != null && i.obtenirDureeVie() == 0) || (i.obtenirMunitions() != null && i.obtenirMunitions() == 0)) {
            message += ("L'objet n'est plus utilisable\n\n");
        } else if (salle.obtenirEnnemi() == null) {
            message += "Aucun ennemi n'est présent dans la salle\n\n";
        } else if (salle.obtenirEnnemi().obtenirPointsVie() == 0) {
            i.duréeVieBaisse();
            message += "Vous venez d'attaquer un cadavre et par la même occasion de gaspiller des munitions...\n\n";
        }

        return message;

    }

    /**
     *
     * @param objet
     * @return
     */
    public String utiliser(String objet) {
        String message = "";
        Objet i = inventairePersonnage.obtenirObjet(objet);
        int ptsVie = 5;
        int kevlar = 20;
        int kevlarL = 40;

        if (inventairePersonnage.obtenirListeObjets().size() < 0) {
            message += "Inventaire vide\n\n";
        } else if (i == null) {
            message += "L'objet que vous voulez utiliser n'est pas présent dans votre inventaire\n\n";

        } else if (i.obtenirMunitions() == null && i.obtenirDegats() == 0 && i.obtenirDureeVie() == 2) {
            if (this.pointsVie < 96) {
                this.pointsVie += ptsVie;
                message += ("Vous avez décidé d'utilisé " + i.obtenirNom() + "." + " Vous avez gagné " + ptsVie + " de points de vie. \n\n");
                i.duréeVieBaisse();
            } else if (this.pointsVie > 95 && this.pointsVie < 100) {
                message += ("Vous avez décidé d'utilisé " + i.obtenirNom() + "." + " Vous avez gagné " + (100-this.pointsVie) + " de points de vie. \n\n");
                this.pointsVie = 100;    
            } else {
                message += "Vous ne pouvez plus vous rajouter de vie vous etes au maximu..\n\n";
            }
            if (i.obtenirDureeVie() == 0) {
                this.inventairePersonnage.supprimerObjetInventaire(i);
            }

        } else if (i.obtenirMunitions() == null && i.obtenirDureeVie() == 1 && i.obtenirDegats() == 0) {
            
            if (this.armure < 81) {
                this.armure += kevlar;
                message += ("Vous avez décidé d'utilisé " + i.obtenirNom() + "." + " Vous avez gagné " + kevlar + " d'armure. \n\n");
                i.duréeVieBaisse();
            } else if (this.armure > 80 && this.armure < 100) {
                message += ("Vous avez décidé d'utilisé " + i.obtenirNom() + "." + " Vous avez gagné " + (100-this.armure) + " d'armure. \n\n");
                this.armure = 100;     
            } else {
                message += "Vous ne pouvez plus vous rajouter d'armure vous etes au maximu..\n\n";
            }
            if (i.obtenirDureeVie() == 0) {
                this.inventairePersonnage.supprimerObjetInventaire(i);
            }

        } else if (i.obtenirMunitions() == null && i.obtenirDureeVie() == 1 && i.obtenirDegats() == 1) {
           if (this.armure < 61) {
                this.armure += kevlar;
                message += ("Vous avez décidé d'utilisé " + i.obtenirNom() + "." + " Vous avez gagné " + kevlarL + " d'armure. \n\n");
                i.duréeVieBaisse();
            } else if (this.armure > 60 && this.armure < 100) {
                message += ("Vous avez décidé d'utilisé " + i.obtenirNom() + "." + " Vous avez gagné " + (100-this.armure) + " d'armure. \n\n");
                this.armure = 100;
          } else {
                message += "Vous ne pouvez plus vous rajouter d'armure vous etes au maximu..\n\n";
            }

            if (i.obtenirDureeVie() == 0) {
                this.inventairePersonnage.supprimerObjetInventaire(i);
            }

        } else if (!(i.obtenirMunitions() == null && i.obtenirDegats() == 0)) {
            message += ("Vous ne possédez pas cet objet veuillez vérifier votre inventaire ou cet objet ne peut pas s'utiliser de cette manière \n\n");
        } else if ((!(i.obtenirMunitions() == null && i.obtenirDegats() == 0 && i.obtenirDureeVie() == 2))
                || (!(i.obtenirMunitions() == null && i.obtenirDureeVie() == 1 && i.obtenirDegats() == 0))
                || (!(i.obtenirMunitions() == null && i.obtenirDureeVie() == 1 && i.obtenirDegats() == 1))) {
            message += "Vous ne pouvez pas utiliser cet objet de cette manière\n\n";
        }
        return message;
    }

    /**
     *
     * @param objet
     * @return
     */
    public String lire(String objet) {
        Objet i = inventairePersonnage.obtenirObjet(objet);
        String message = "";
        if (inventairePersonnage.obtenirListeObjets().size() < 0) {
            message += "Inventaire vide\n\n";
        } else if (i == null) {
            message += "L'objet que vous voulez utiliser n'est pas présent dans votre inventaire\n\n";
        } else if (i.obtenirMunitions() == null && i.obtenirDegats() == 0 && i.obtenirDureeVie() == 666) {
            message += Jeux.LireFichier("texte/livre.txt");
            this.inventairePersonnage.supprimerObjetInventaire(i);
            this.obtenirSalle().supprimerItemSalle();
        } else if (!(i.obtenirMunitions() == null && i.obtenirDegats() == 0 && i.obtenirDureeVie() == 100)) {
            message += "Voyons, vous ne pouvez lire que des livres...\n\n";
        }

        return message;
    }

    /**
     *
     * @param ennemi
     * @return
     */
    public String parler(String ennemi) {
        Ennemi e = Zombie.chaineVersEnnemi(ennemi);
        String message = "";

        if (salle.contientEnnemi() == false) {
            message += "Vous ne pouvez pas parler dans le vide... du moins cela ne servirai à rien..";
        } else if (e.pointsVie == 0) {
            message += "C'est pas sur qu'il vous réponde....";
        } else if (e.obtenirDegats() < 9) {
            message += Jeux.LireFichier("texte/dialogue.txt");
        } else {
            message += "Il est surement dangereux de vouloir parler avec ce personnage...\n\n";
        }

        return message;
    }

    /**
     * Permet au personnage de se déplacer dans différentes salles voisines à sa
     * salle actuelle
     *
     * @param i
     * @return
     */
    public String seDeplacer(int i) {
        String message = "";
        boolean estVoisin = false;
        for (Salle s : this.salle.obtenirVoisins().values()) {
            if (s.obtenirId() == i) {
                estVoisin = true;
            }
        }

        if (estVoisin) {
            message += ("Vous vous dirigez vers la salle n°" + Zone.entierVersSalle(i).obtenirId() + "\n");
            this.salle = Zone.entierVersSalle(i);
        } else {
            message += ("La salle que vous demandez n'est pas voisine avec la salle dans laquelle vous vous situez\n"
                    + "Veuillez entrer une salle voisine valide \n \n");
        }
        return message;
    }

    /**
     * Permet au personnage de ramasser un objet présent dans la salle où il se
     * situe
     *
     * @param i
     * @return
     */
    public String ramasser(Objet i) {
        System.out.println(this.obtenirSalle().obtenirItem());
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
     *
     * @return
     */
    public String afficherInventaire() {
        String message = "";
        message += ("Dans votre inventaire se trouve : \n");
        message += inventairePersonnage.afficher();

        return message;
    }

    /**
     *
     * @return
     */
    public Inventaire obtenirInventaire() {
        return this.inventairePersonnage;
    }

}
