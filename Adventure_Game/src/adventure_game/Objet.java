package adventure_game;

import java.util.ArrayList;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmorax
 */
public class Objet {

    private Integer dureeVie;
    private Integer munitions;
    private String nom;
    private int degats;

    public Objet(String nom, Integer dureeVie, Integer munitions, int degats) {
        this.nom = nom;
        this.dureeVie = dureeVie;
        this.munitions = munitions;
        this.degats = degats;
    }

    public String obtenirNom() {
        return this.nom;
    }

    public Integer obtenirDureeVie() {
        return this.dureeVie;
    }

    public Integer obtenirMunitions() {
        return this.munitions;
    }

    public int obtenirDegats() {
        return this.degats;
    }

    public void munitionsBaisse(Objet e) {
        if (e.munitions != null && e.dureeVie == null) {
            e.munitions--;
        }
        if (e.munitions == 0) {
            System.out.println("Munitions épuisées");
        }
    }

    public void duréeVieBaisse(Objet e) {
        if (e.dureeVie != null && e.munitions == null) {
            e.dureeVie--;
            if (e.dureeVie == 0) {
                System.out.println("Votre arme n'est plus utilisable" + "\n");
            }
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Objet other = (Objet) obj;
        if (this.degats != other.degats) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.dureeVie, other.dureeVie)) {
            return false;
        }
        if (!Objects.equals(this.munitions, other.munitions)) {
            return false;
        }
        return true;
    }

}
