package adventure_game;


import java.util.ArrayList;
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
public class Item implements Description {
    
    private Integer dureeVie;
    private Integer munitions;
    private String nom;
    private int degats;
    
    public Item(Integer dureeVie, Integer munitions, int degats){
        this.dureeVie = dureeVie;
        this.munitions = munitions;
        this.degats = degats;
    }
    
    private ArrayList<Item> items;
    
    public String getNom(){
        return this.nom;
    }
    public int getDureeVie(){
        return this.dureeVie;
    }
    
    public int getMunitions(){
        return this.munitions;
    }
    
    public int getDegats(){
        return this.degats;
    }

    @Override
    public String seDecrire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
