package adventure_game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmorax
 */
public class ControleurJeux {
    
    private Jeux jeu;
    
    @FXML
    private TextArea jeux;
    
    @FXML
    private ListView actions;
    
    @FXML
    private ListView inventaire;
    
    @FXML 
    private ListView caracteristiques;
    
    @FXML
    private TextField entrerCommande;
    
    @FXML
    private Label location;

    public ControleurJeux(Jeux jeu) {
        this.jeu = jeu;
    }
    
    public void setLocation(String texte) {
        
    }
    
}
