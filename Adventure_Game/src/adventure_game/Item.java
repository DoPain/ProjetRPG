package adventure_game;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmorax
 */
public class Item implements Description {

    private Integer dureeVie;
    private Integer munitions;
    private String nom;
    private int degats;

    public Item(Integer dureeVie, Integer munitions, int degats) {
        this.dureeVie = dureeVie;
        this.munitions = munitions;
        this.degats = degats;
    }

    private ArrayList<Item> items;

    public String getNom() {
        return this.nom;
    }

    public Integer getDureeVie() {
        return this.dureeVie;
    }

    public Integer getMunitions() {
        return this.munitions;
    }

    public int getDegats() {
        return this.degats;
    }

    public void MunitionsBaisse(Item e) {
        if (e.munitions != null && e.dureeVie == null) {
            while (e.munitions > 0) {
                e.munitions--;
            }
            if (e.munitions == 0) {
                System.out.println("Munitions épuisées");
            }
        }
    }
   
  
    public void DuréeVieBaisse(Item e) {       
        if (e.dureeVie != null && e.munitions == null) {
            while (e.dureeVie > 0) {
                e.dureeVie--;
            }
            if (e.dureeVie == 0) {
                System.out.println("Votre arme n'est plus utilisable");
            }
        }

    }


    @Override
    public String seDecrire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
