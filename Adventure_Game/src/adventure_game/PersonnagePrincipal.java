package adventure_game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmorax
 */
public class PersonnagePrincipal extends Personnage implements Description {

    public PersonnagePrincipal(int pointsVies, int dommages, int vitesseAttaque) {
        super(pointsVies, dommages, vitesseAttaque);
    }

    public static void AttaquerMainNue(PersonnagePrincipal p, Ennemi e) {
        e.pointsVie -= p.dommages;
    }

    public static void AttaquerAvecArme(Item i, Ennemi e) {
        while (i.getMunitions() > 0 || i.getDureeVie() > 0) {
            e.pointsVie -= i.getDegats();
            if (i.getMunitions() != null && i.getDureeVie() == null) {
                i.MunitionsBaisse(i);
            } else if (i.getDureeVie() != null && i.getMunitions() == null) {
                i.DuréeVieBaisse(i);
            }
        }
    }

    @Override
    public String seDecrire() {
        return "";
    }

}
