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

    /**
     *
     */
    private final int nbSalles = 4;

    /**
     *
     */
    private static Salle salleCommencement = new Salle(0, null, null);

    /**
     *
     */
    private static HashMap<Integer, Salle> salles;

    /**
     *
     */
    public Zone() {        
        salles = new HashMap<>();
        
        salles.put(0, salleCommencement);        
    }

    /**
     *
     * @param id
     * @param ennemi
     * @param item
     * @param nord
     * @param ouest
     * @param sud
     * @param est
     */
    public void ajoutSalle(String id, String ennemi, String item, String sud, String est, String nord, String ouest) {
        Salle s = new Salle(Integer.parseInt(id), Zombie.chaineVersEnnemi(ennemi), Arme.chaineVersArme(item));
        
        if (!nord.equals("-1")) {
            s.ajoutVoisins(Integer.parseInt(nord), Direction.NORD);
        }
        if (!ouest.equals("-1")) {
            s.ajoutVoisins(Integer.parseInt(ouest), Direction.OUEST);
        }
        if (!sud.equals("-1")) {
            s.ajoutVoisins(Integer.parseInt(sud), Direction.SUD);
        } 
        if (!est.equals("-1")) {
            s.ajoutVoisins(Integer.parseInt(est), Direction.EST);
        } 
 
        salles.put(Integer.parseInt(id), s);
    }

    /**
     *
     * @param s
     * @return
     */
    public static Salle entierVersSalle(int s) {
        return salles.get(s);
    }

    /**
     *
     * @return
     */
    public static Salle obtenirSalleCommencement() {
        return salleCommencement;
    }
}
