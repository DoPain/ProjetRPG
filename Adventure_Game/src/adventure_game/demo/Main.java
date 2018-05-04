/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_game.demo;

import adventure_game.ControleurJeux;
import adventure_game.Jeux;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dmorax
 */
public class Main extends Application{
    
    /**
     *
     */
    private static final String csvSalle = "texte/salle.csv";

    /**
     *
     */
    private static Jeux j = new Jeux();
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        j.lancer(csvSalle);
        //launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interface.fxml"));
        loader.setController(new ControleurJeux(j));
    
        Scene scene = new Scene(loader.load(), 864, 582);
    
        primaryStage.setTitle("Jeux_Rpg");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
}
