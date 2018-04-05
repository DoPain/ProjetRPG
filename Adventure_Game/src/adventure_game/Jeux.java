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

    private Item i = new Item("Dorian", null, 30, 15);

    public void run(String csvSalle) {
        lireFichier("texte/debut.txt");
        Zone z = new Zone();
        initJeux(csvSalle, z);
        Zone.getSalleCommencement().AjoutVoisins(1);
        PersonnagePrincipal p = new PersonnagePrincipal(100, 30, 5, Zone.getSalleCommencement());
        Ennemi e = new Ennemi("Maxime", 60, 10, 3, Zone.IntToSalle(1));
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Scanner s = new Scanner(in.nextLine());

            while (s.hasNext()) {
                String param = " ";
                String start = s.nextLine();
                try {
                    param = start.substring(start.indexOf(" ") + 1);
                } catch (NullPointerException ee) {
                } catch (StringIndexOutOfBoundsException ee) {
                }
                if (start.startsWith("bouger")) {
                    p.SeDeplacer(Integer.parseInt(param));
                } else if (start.startsWith("ramasser")) {
                    p.Ramasser(Arme.StringToArme(param));
                } else if (start.startsWith("jeter")) {
                    p.Jeter(Arme.StringToArme(param));
                }
                switch (start) {
                    case "attaquer":
                        p.Attaquer();
                        break;
                    case "quitter":
                        quitter();
                        break;
                    case "items":
                        p.getSalle().displayItem();
                        break;
                    case "voisins":
                        p.getSalle().displayVoisins();
                        break;
                    case "inventaire":
                        p.DisplayInventaire();
                        break;
                    case "examiner":
                        p.getSalle().Examiner();
                        break;
                    case "ennemi":
                        p.getSalle().DisplayEnnemi();
                        break;
                    case "aide":
                        lireFichier("texte/aide.txt");
                        break;
                }
                System.out.println("Vous vous situez dans la salle n° : " + p.getSalle().getId() + "\n");
            }
        }
    }

    public void initJeux(String csvSalle, Zone z) {
        FormatCsv salleCSV = new FormatCsv(csvSalle, ';');
        salleCSV.lire();
        salleCSV.donnees.forEach(s -> z.AjoutSalle(s.get(0), s.get(1), s.get(2), s.get(3), s.get(4)));

    }

    public static void quitter() {
        System.exit(0);
    }

    public static void lireFichier(String s) {
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
