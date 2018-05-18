package adventure_game;

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

    private int id;
    
    /**
     * Correspond à la durée de vie de l'objet. Cette durée de vie est uniquement associé à une 
     * arme blanche (couteau ou hache)
     */
    private Integer dureeVie;

    /**
     * Correspond au munitions de l'objet. Ces munitions sont uniquement associé à une 
     * arme à feu ou à l'arbalette (pistolet ou m4)
     */
    private Integer munitions;

    /**
     * Correspond au nom de l'objet
     */
    private String nom;

    /**
     * Correspond au degats de l'objet
     */
    private int degats;

    /**
     * Constructeur de la classe
     * @param nom
     * @param dureeVie
     * @param munitions
     * @param degats
     */
    public Objet(int id, String nom, Integer dureeVie, Integer munitions, int degats) {
        this.id = id;
        this.nom = nom;
        this.dureeVie = dureeVie;
        this.munitions = munitions;
        this.degats = degats;
    }

    /**
     * Accesseur sur le nom de l'objet
     * @return
     */
    public String obtenirNom() {
        return this.nom;
    }

    /** 
     * Accesseur sur la durée de vie de l'objet
     * @return
     */
    public Integer obtenirDureeVie() {
        return this.dureeVie;
    }

    /**
     * Accesseur sur les munitions de l'objet
     * @return
     */
    public Integer obtenirMunitions() {
        return this.munitions;
    }

    /**
     * Accesseur sur les degats de l'objet
     * @return
     */
    public int obtenirDegats() {
        return this.degats;
    }

    public int obtenirId() {
        return id;
    }

    public void definirId(int id) {
        this.id = id;
    }
    
    

    /**
     * Permet de baisser les munitions d'une arme à feu quand celle-ci sera utilisé
     */
    public void munitionsBaisse() {
            this.munitions--;       
    }

    /**
     * Permet de baisser la durée de vie d'une arme blanche quand celle-ci sera utilisé
     */
    public void duréeVieBaisse() {        
            this.dureeVie--;
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
