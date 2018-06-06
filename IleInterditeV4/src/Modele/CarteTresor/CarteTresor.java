/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.CarteTresor;

/**
 *
 * @author dieuaida
 */
public abstract class CarteTresor {
    private final String nomCarteT;
    
    public CarteTresor(String nomCarteT) {
        this.nomCarteT = nomCarteT;
    }
    
    // === GETTERS & SETTERS ===================================================

    public String getNomCarteT() {
        return nomCarteT;
    }
}
