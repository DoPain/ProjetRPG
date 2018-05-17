/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_game;

/**
 *
 * @author dmorax
 */
public enum Direction {

    NORD(),
    SUD(),
    EST(),
    OUEST();

    public Direction oppose() {
        switch (this) {
            case NORD:
                return SUD;
            case SUD:
                return NORD;
            case EST:
                return OUEST;
            case OUEST:
                return EST;
        }
        return null;
    }

}
