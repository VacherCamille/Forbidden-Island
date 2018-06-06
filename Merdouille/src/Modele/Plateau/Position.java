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
    private int ligne;
    private int colonne;
    private final Grille grille;
    private final Aventurier aventurier;
    
    public Position(Grille grille, Aventurier aventurier, int colonne, int ligne) {
        this.grille = grille;
        this.aventurier = aventurier;
        this.colonne = colonne;
        this.ligne = ligne;
    }
    
    // === GETTERS & SETTERS ===================================================

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public Grille getGrille() {
        return grille;
    }

    public Aventurier getAventurier() {
        return aventurier;
    }
    
    // =========================================================================
    
    public Tuile getTuile() {
        return grille.getTuile(ligne, colonne);
    }
}
