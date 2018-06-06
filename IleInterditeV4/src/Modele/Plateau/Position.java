/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Plateau;

import Modele.Aventurier.Aventurier;

/**
 *
 * @author dieuaida
 */
public class Position {
    private int ligne;
    private int colonne;
    private final Grille grille;
    private final Aventurier aventurier;
    
    public Position(Grille grille, Aventurier aventurier, int ligne, int colonne) {
        this.grille = grille;
        this.aventurier = aventurier;
        this.ligne = ligne;
        this.colonne = colonne;
    }
    
    // === GETTERS & SETTERS ===================================================

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public Grille getGrille() {
        return grille;
    }

    public Aventurier getAventurier() {
        return aventurier;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
    
    // === UTILITAIRE ==========================================================
    
    public Tuile getTuile() {
        return grille.getTuile(ligne, colonne);
    }
}
