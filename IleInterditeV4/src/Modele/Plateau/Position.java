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
public class Position implements Comparable<Position> {

    private int ligne;
    private int colonne;
    private Grille grille;
    private Aventurier aventurier;

    public Position(Grille grille, Aventurier aventurier, int ligne, int colonne) {
        this.grille = grille;
        this.aventurier = aventurier;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public Position(int ligne, int colonne) {
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

    @Override
    public int compareTo(Position pos) {
        if (this.getLigne() == pos.getLigne() && this.getColonne() == pos.getColonne()) {
            return 0;
        } else if (this.getLigne() > pos.getLigne()) {
            return 1;
        } else {
            return -1;
        }
    }

    // === UTILITAIRE ==========================================================
    public Tuile getTuile() {
        return grille.getTuile(ligne, colonne);
    }

}
