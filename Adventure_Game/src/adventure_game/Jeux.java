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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dmorax
 */
public class Jeux {

    private PersonnagePrincipal p;
    
    private static String csvSalle;
    /**
     * Constructeur par defaut 
     */
    public Jeux() {
    }

    /**
     *
     * @param s
     * @return
     */
    public String traiterCommande(String s) throws IOException {
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
                    message += p.ramasser(Item.chaineVersArme(arguments[1].toUpperCase()));

                } else {
                    message += ("Vous devez préciser un objet présent dans la salle \n");
                }
                break;
            case "jeter":
                if (arguments.length >= 2) {
                    p.jeter(p.obtenirInventaire().obtenirObjet(arguments[1].toUpperCase()));
                } else {
                    message += ("Vous devez préciser un objet présent dans votre inventaire \n");
                }
                break;
            case "utiliser":
                message += p.utiliser(arguments[1].toUpperCase());
                break;
            case "lire":
                message += p.lire(arguments[1].toUpperCase());
                break;
            case "attaquer":
                message += p.attaquer(arguments[1].toUpperCase());     
                break;
            case "parler":
                message += p.parler(arguments[1].toUpperCase());
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
     * Initialise le jeux en lisant le fichier csv et en ajoutant à la salle
     * courante les éléments présent dans le fichier
     *
     * @param csvSalle
     * @param csvItem
     * @param z
     */
    public static void initJeux(String csvSalle, String csvItem, Zone z) {
        Jeux.csvSalle = csvSalle;
        FormatCsv salleCSV = new FormatCsv(csvSalle, ';');
        salleCSV.lire();
        Map<Integer, Objet> objet = creerObjet(csvItem);
        for (ArrayList<String> s : salleCSV.donnees) {
            String id = s.get(0);
            String ennemi = "";
            if (!s.get(1).equalsIgnoreCase("null")) {
                ennemi = s.get(1);
            }
            Objet idItem = objet.get(Integer.valueOf(s.get(2)));
            String sud = s.get(3);
            String est = s.get(4);
            String nord = s.get(5);
            String ouest = s.get(6);
            z.ajoutSalle(id, ennemi, idItem, sud, est, nord, ouest);
        }

    }
    
   /**
     *
     * @param csvItem
     * @return
     */
    public static Map<Integer, Objet> creerObjet(String csvItem) {
        FormatCsv itemCSV = new FormatCsv(csvItem, ';');
        String nul = "-1";
        Map objet = new HashMap<>();
        itemCSV.lire();
        for (ArrayList<String> o : itemCSV.donnees) {
            int id = Integer.valueOf(o.get(0));
            String nom = o.get(1);
            Integer dureeVie = null;
            if (!o.get(2).equalsIgnoreCase("null")) {
                dureeVie = Integer.valueOf(o.get(2));
            }
            Integer munitions = null;
            if (!o.get(3).equalsIgnoreCase("null")) {
                munitions = Integer.valueOf(o.get(3));
            }
            int degats = Integer.valueOf(o.get(4));
            Objet ob = new Objet(id, nom, dureeVie, munitions, degats);
            objet.put(id, ob);
        }
        return objet;
    }

    /**
     *
     * @return
     */
    private static List<Zombie> listeZombie() {
        FormatCsv itemCSV = new FormatCsv(csvSalle, ';');
        List<Zombie> zombie = new ArrayList<>();
        itemCSV.lire();
        for (ArrayList<String> o : itemCSV.donnees) {
            Zombie z = Zombie.valueOf(o.get(1));
            zombie.add(z);
        }
        return zombie;
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
     * @return 
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
    
    public static int pointsPourGagner(){
        int cpt = 0;
       for(Zombie z : listeZombie()){
           cpt+= z.obtenirCouragePerdu();
       }
       return cpt;
    }

    /**
     *
     * @param p
     */
    public void setP(PersonnagePrincipal p) {
        this.p = p;
    }

}
