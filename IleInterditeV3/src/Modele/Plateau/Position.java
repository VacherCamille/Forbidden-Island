/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Plateau;

import Modele.Aventurier;

/**
 *
 * @author Aymerick
 */
public class Position {
    private int x;
    private int y;
    private Grille grille;
    private Aventurier aventurier;
    
    public Position(Grille grille, Aventurier aventurier, int x, int y) {
        this.grille = grille;
        this.aventurier = aventurier;
        this.x = x;
        this.y = y;
    }
    
    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
    
    // === GETTERS & SETTERS ===================================================

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Grille getGrille() {
        return grille;
    }

    public Aventurier getAventurier() {
        return aventurier;
    }
    
    // =========================================================================
    
    public Tuile getTuile() {
        return grille.getTuile(x, y);
    }
}
