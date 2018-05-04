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

    /**
     *
     * @param csvSalle
     */
    public void lancer(String csvSalle) {
        LireFichier("texte/debut.txt");
        Zone z = new Zone();
        InitJeux(csvSalle, z);
        Zone.obtenirSalleCommencement().ajoutVoisins(1, Direction.EST);
        PersonnagePrincipal p = new PersonnagePrincipal(100, 10, 5, Zone.obtenirSalleCommencement());
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Scanner s = new Scanner(in.nextLine());

            while (s.hasNext()) {
               
                String start = s.nextLine().toLowerCase();
                String[] arguments = start.split(" ");            
        
                switch (arguments[0]) {
                    case "bouger" :
                        if (arguments.length >= 2){
                        p.seDeplacer(Integer.parseInt(arguments[1]));
                        }else {
                            System.out.println("Vous devez préciser un nom de salle");
                        }
                        break;
                    case "ramasser" :
                        if (arguments.length >= 2){
                        p.ramasser(Arme.chaineVersArme(arguments[1].toUpperCase()));
                        }else{
                            System.out.println("Vous devez préciser un objet présent dans la salle");
                        }
                        break;
                    case "jeter" : 
                    if (arguments.length >= 2){
                        p.jeter(Arme.chaineVersArme(arguments[1]));
                        }else{
                            System.out.println("Vous devez préciser un objet présent dans votre inventaire");
                        }
                        break;
                    case "attaquer":
                        p.attaquer();
                        break;
                    case "quitter":
                        Quitter();
                        break;
                    case "items":
                        p.obtenirSalle().afficherItem();
                        break;
                    case "voisins":
                        p.obtenirSalle().afficherVoisins();
                        break;
                    case "inventaire":
                        p.afficherInventaire();
                        break;
                    case "examiner":
                        p.obtenirSalle().examiner();
                        break;
                    case "ennemi":
                        p.obtenirSalle().afficherEnnemi();
                        break;
                    case "aide":
                        LireFichier("texte/aide.txt");
                        break;
                    default:
                        System.out.println("Veuillez entrer une commande valide" + "\n");
                        break;
                }
                System.out.println("Vous vous situez dans la salle n° : " + p.obtenirSalle().obtenirId() + "\n");
            }
        }
    }

    /**
     * Initialise le jeux en lisant le fichier csv
     * @param csvSalle
     * @param z
     */
    public void InitJeux(String csvSalle, Zone z) {
        FormatCsv salleCSV = new FormatCsv(csvSalle, ';');
        salleCSV.lire();
        salleCSV.donnees.forEach(s -> z.ajoutSalle(s.get(0), s.get(1), s.get(2), s.get(3), s.get(4),s.get(5), s.get(6)));

    }

    /**
     * Permet de quitter le jeux
     */
    public static void Quitter() {
        System.exit(0);
    }

    /**
     * Permet de lire un fichier texte
     * @param s
     */
    public static void LireFichier(String s) {
        try {
            File f = new File(s);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            try {
                String line = br.readLine();

                while (line != null) {
                    System.out.println(line);
                    line = br.readLine();
                }

                br.close();
                fr.close();
            } catch (IOException exception) {
                System.out.println("Erreur lors de la lecture : " + exception.getMessage());
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Le fichier n'a pas été trouvé");
        }
    }

}
