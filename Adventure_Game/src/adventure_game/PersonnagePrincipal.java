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

    private Inventaire inventairePersonnage;

    public PersonnagePrincipal(int pointsVies, int dommages, int vitesseAttaque, Salle s) {
        super(pointsVies, dommages, vitesseAttaque, s);
        inventairePersonnage = new Inventaire();
    }

    public void AttaquerAvecArme(Item i, Ennemi e) {
        e.pointsVie -= i.getDegats();
        if (i.getMunitions() != null && i.getDureeVie() == null) {
            i.MunitionsBaisse(i);
        } else if (i.getDureeVie() != null && i.getMunitions() == null) {
            i.DuréeVieBaisse(i);
        }
    }

    public void Attaquer() {
        DisplayInventaire();
        Scanner sc = new Scanner(System.in);
        System.out.println("Points de vie de l'ennemi avant l'attaque " + salle.getEnnemi().pointsVie + "\n");
        System.out.println("Points de vie du personnage avant l'attaque " + this.pointsVie + "\n");
        Item i = new Item("poings", null, null, this.dommages);
        if (inventairePersonnage.getListeItems().size() > 0) {
            System.out.println("Quel item choisissez-vous pour attaquer? ");
            String arme = sc.next();
            switch (arme) {
                case "COUTEAU":
                    i = Arme.StringToArme(arme);
                    break;
                case "M4":
                    i = Arme.StringToArme(arme);
                    break;
                case "PISTOLET":
                    i = Arme.StringToArme(arme);
                    break;
                case "HACHE":
                    i = Arme.StringToArme(arme);
                    break;
                case "ARBALETTE":
                    i = Arme.StringToArme(arme);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Vous avez décider d'attaqué avec : " + i.getNom() + "\n");
        AttaquerAvecArme(i, salle.getEnnemi());

        if (salle.getEnnemi().pointsVie > 0) {
            System.out.println("Points de vie de l'ennemi après l'attaque " + salle.getEnnemi().pointsVie + "\n");
        } else {
            this.getSalle().SupprimerEnnemiSalle();
            System.out.println("Votre ennemi est mort " + "\n");
        }
        if (this.pointsVie > 0) {
            System.out.println("Points de vie du personnage après l'attaque " + this.pointsVie + "\n");
        } else {
            System.out.println("Vous etes morts" + "\n");
        }

    }

    public void SeDeplacer(int i) {
        System.out.println("Vous vous dirigez vers la salle n°" + Zone.IntToSalle(i).getId() + "\n");
        this.salle = Zone.IntToSalle(i);
    }

    public void Ramasser(Item i) {
        inventairePersonnage.Ajouter(i);
        salle.SupprimerItemSalle();
    }

    public void Jeter(Item i) {
        inventairePersonnage.Supprimer(i);
        salle.AjouterItemSalle();
    }

    public void DisplayInventaire() {
        System.out.println("Dans votre inventaire se trouve : ");
        inventairePersonnage.displayInventaire();
    }

}
