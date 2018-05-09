/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dmorax
 */
public class Jeux {

    private ControleurJeux controle;

    private PersonnagePrincipal p ;
    
    public Jeux (){
    }
    /**
     *
     * @param csvSalle
     */
    public String traiterCommande(String s) {       
        String message = "";

        String start = s.toLowerCase();
        String[] arguments = start.split(" ");

        switch (arguments[0]) {
            case "bouger":
                if (arguments.length >= 2) {
                    message += p.seDeplacer(Integer.parseInt(arguments[1]));
                    message += ("Vous vous situez dans la salle n° : " + p.obtenirSalle().obtenirId() + "\n \n");
                } else {
                    message += ("Vous devez préciser un nom de salle \n");               
                }
                break;
            case "ramasser":
                if (arguments.length >= 2) {
                    message += p.ramasser(Arme.chaineVersArme(arguments[1].toUpperCase()));
                    
                } else {
                    message += ("Vous devez préciser un objet présent dans la salle \n");
                }
                break;
            case "jeter":
                if (arguments.length >= 2) {
                    p.jeter(Arme.chaineVersArme(arguments[1].toUpperCase()));
                } else {
                    message += ("Vous devez préciser un objet présent dans votre inventaire \n");
                }
                break;
            case "attaquer":
                message += p.attaquer(arguments[1].toUpperCase());
                break;
            case "quitter":
                Quitter();
                break;
            case "items":
                message += p.obtenirSalle().afficherItem();
                break;
            case "voisins":
                message += p.obtenirSalle().afficherVoisins();
                message += ("Vous vous situez dans la salle n° : " + p.obtenirSalle().obtenirId() + "\n \n");
                break;
            case "inventaire":
                message += p.afficherInventaire();
                break;
            case "examiner":
                message += p.obtenirSalle().examiner();
                break;
            case "ennemi":
                message += p.obtenirSalle().afficherEnnemi();
                break;
            case "aide":
               message += LireFichier("texte/aide.txt");
                break;
            default:
                message += ("Veuillez entrer une commande valide" + "\n");
                break;
        }

        return message;
    }

    /**
     * Initialise le jeux en lisant le fichier csv
     *
     * @param csvSalle
     * @param z
     */
    public static void InitJeux(String csvSalle, Zone z) {
        FormatCsv salleCSV = new FormatCsv(csvSalle, ';');
        salleCSV.lire();
        salleCSV.donnees.forEach(s -> z.ajoutSalle(s.get(0), s.get(1), s.get(2), s.get(3), s.get(4), s.get(5), s.get(6)));
    }

    /**
     * Permet de quitter le jeux
     */
    public static void Quitter() {
        System.exit(0);
    }

    /**
     * Permet de lire un fichier texte
     *
     * @param s
     */
    public static String LireFichier(String s) {
        StringBuilder message = new StringBuilder();
        try {
            File f = new File(s);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            try {
                String line = br.readLine();

                while (line != null) {
                    message.append(line).append("\n");
                    line = br.readLine();
                }

                br.close();
                fr.close();
            } catch (IOException exception) {
                message.append("Erreur lors de la lecture : " + exception.getMessage());
            }
        } catch (FileNotFoundException exception) {
            message.append("Le fichier n'a pas été trouvé");
        }
        
        return message.toString();
    }

    public void setControlleur(ControleurJeux c) {
        this.controle = c;
    }

    public void setP(PersonnagePrincipal p) {
        this.p = p;
    }
    
    

}
