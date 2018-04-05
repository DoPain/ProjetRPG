package adventure_game;

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
public class Zone {
    
    private final int nbSalles = 4;
    private static Salle salleCommencement = new Salle(0, null, null,null);
    private static HashMap<Integer, Salle> salles;
    
    public Zone() {        
        salles = new HashMap<>();
        
        salles.put(0, salleCommencement);        
    }
    
    public void AjoutSalle(String id, String descr, String ennemi, String item, String v) {
        Salle s = new Salle(Integer.parseInt(id), descr, Zombie.StringToEnnemi(ennemi), Arme.StringToArme(item));        
        s.AjoutVoisins(Integer.parseInt(v));
        salles.put(Integer.parseInt(id), s);
    }
    
    public static Salle IntToSalle(int s) {
            return salles.get(s);
    }
    
    public static Salle getSalleCommencement() {
        return salleCommencement;
    }
}
