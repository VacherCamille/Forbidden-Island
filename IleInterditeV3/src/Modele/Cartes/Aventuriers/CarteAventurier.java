/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Cartes.Aventuriers;

import Modele.Aventurier;
import Modele.Cartes.Tresor.CarteTresor;
import util.Utils.Pion;

/**
 *
 * @author Aymerick
 */
public abstract class CarteAventurier {
    private final String nomRole;
    private final Pion pion;
    private Aventurier J1;
    
    public CarteAventurier(String nomRole, Pion pion) {
        this.nomRole = nomRole;
        this.pion = pion;
    }
    
    // === GETTERS & SETTERS ===================================================

    public String getNomRole() {
        return nomRole;
    }

    public Pion getPion() {
        return pion;
    }
    
    // =========================================================================
    
    public void donnerCarteT(Aventurier J2,CarteTresor C){
        if (J1.getPosition() == J2.getPosition()){
            if (J1.getPointAction()<1){ 
                if (J2.hasFullDeck()==false){
                 J2.addCarteTresor(C);
                 J1.removeCarteTresor(C);
                }
            } 
        }
    }
}
