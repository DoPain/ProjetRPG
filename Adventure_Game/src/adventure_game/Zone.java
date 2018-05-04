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
    private static Salle salleCommencement = new Salle(0, null,null);
    private static HashMap<Integer, Salle> salles;
    
    public Zone() {        
        salles = new HashMap<>();
        
        salles.put(0, salleCommencement);        
    }
    
    public void ajoutSalle(String id, String ennemi, String item, String nord, String ouest, String sud, String est) {
        Salle s = new Salle(Integer.parseInt(id), Zombie.chaineVersEnnemi(ennemi), Arme.chaineVersArme(item));        
        s.ajoutVoisins(Integer.parseInt(nord), Direction.NORD);
        s.ajoutVoisins(Integer.parseInt(ouest),Direction.OUEST);
        s.ajoutVoisins(Integer.parseInt(sud),Direction.SUD);
        s.ajoutVoisins(Integer.parseInt(est),Direction.EST);
        salles.put(Integer.parseInt(id), s);
    }
    
    public static Salle entierVersSalle(int s) {
            return salles.get(s);
    }
    
    public static Salle obtenirSalleCommencement() {
        return salleCommencement;
    }
}
