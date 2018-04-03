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
    
    private static PersonnagePrincipal p = new PersonnagePrincipal(100, 30, 5);
    private static Ennemi e = new Ennemi(60, 10, 3);
    private static Item i = new Item(null,30,15);
    
    public static void run(String csvSalle){               
        initJeux(csvSalle);  
        Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                Scanner s = new Scanner(in.nextLine());
                while (s.hasNext()) {
                    String start = s.next();
                    switch (start) {
                        case "attaquer":
                            PersonnagePrincipal.AttaquerMainNue(p, e);
                            break;
                        case "attaquer avec arme":
                            PersonnagePrincipal.AttaquerAvecArme(i, e);
                            break;
                        case "haut":
                            
                            break;
                        case "bas":
                            
                            break;
                        case "quitter":
                            quitter();
                            break;
                        case "aide":
                            aide();
                            break;
                    }
                }
            }
    }

      
    public static void initJeux(String csvSalle){
        FormatCsv salleCSV = new FormatCsv(csvSalle,';');
        salleCSV.lire();   
        salleCSV.donnees.forEach(s -> Salle.ajoutSalle(s.get(0),s.get(1),s.get(2)));
        
        
    }
    
    public static void quitter(){
        System.exit(0);
    }
    
    public static void aide(){
        try {
            File f = new File("texte/aide.txt");
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


    

