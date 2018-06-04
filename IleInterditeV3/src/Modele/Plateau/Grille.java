/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Plateau;

import Util.Parameters;
import java.util.ArrayList;
import java.util.HashMap;
import util.Utils;
import util.Utils.Pion;
import util.Utils.Tresor;

/**
 *
 * @author Aymerick
 */
public class Grille {
    private final Tuile tuiles[][] = new Tuile[6][6];
    private HashMap<String, Position> posJoueurs;
    
    public Grille() {
        posJoueurs = new HashMap<>();
        // Initialisation et mélange des tuiles du jeu...
        ArrayList<Tuile> listeTuiles = new ArrayList<>();
        this.initTuiles(listeTuiles);
        
        // Disposition des tuiles sur le plateau...
        this.initGrille(listeTuiles);
    }
    
    // === GETTERS & SETTERS ===================================================

    public Tuile[][] getTuiles() {
        return tuiles;
    }

    public void setPosJoueur(String nomAventurier, Position position) {
        this.posJoueurs.put(nomAventurier, position);
    }
    
    // === METHODES D'INITIALISATION DE LA GRILLE ==============================
    
    private void initTuiles(ArrayList<Tuile> arrayList) {
        for (String args : Parameters.tuilesJeu) { // on va chercher la liste dans Parameters...
            String parts[] = args.split(","); // les caractéristiques sont séparés par des virgules...
            String nomTuile = parts[0];
            Pion spawnPion = Pion.getFromName(parts[1]);
            Tresor spawnTresor = Tresor.getFromName(parts[2]);
            arrayList.add(new Tuile(nomTuile, spawnPion, spawnTresor));
        }
        Utils.melangerTuiles(arrayList);
    }
    
    private void initGrille(ArrayList<Tuile> arrayList) {
        int k = 0;
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0: case 5:
                    tuiles[i][0] = null;    tuiles[i][1] = null;
                    tuiles[i][4] = null;    tuiles[i][5] = null;
                    tuiles[i][2] = arrayList.get(k); k += 1;
                    tuiles[i][3] = arrayList.get(k); k += 1;
                    break;
                case 1: case 4:
                    tuiles[i][0] = null;    tuiles[i][5] = null;
                    for (int j = 1; j < 5; j++) {
                        tuiles[i][j] = arrayList.get(k); k += 1;
                    }
                    break;
                case 2: case 3:
                    for (int j = 0; j <= 5; j++) {
                        tuiles[i][j] = arrayList.get(k); k += 1;
                    }
                    break;
            }
        }
    }
    
    // =========================================================================
    
    public Tuile getTuile(int x, int y) {
        return tuiles[x][y];
    }
    
    public Tuile getTuileFromName(String nomTuile) {
        Tuile tuile = null;
        boolean trouve = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                tuile = this.getTuile(i, j);
                if (tuile != null && tuile.getNomTuile().equals(nomTuile)) {
                    trouve = true;
                    break;
                }
            }
            if (trouve) break;
        }
        return tuile;
    }
    
    public Tuile getTuileFromSpawnPion(Pion pion) {
        Tuile tuile = null;
        boolean trouve = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                tuile = this.getTuile(i, j);
                if (tuile != null && tuile.getSpawnPion() == pion) {
                    trouve = true;
                    break;
                }
            }
            if (trouve) break;
        }
        return tuile;
    }
    
    public int[] getXYFromTuile(Tuile tuile) {
        int coordonnees[] = new int[2];
        boolean trouve = false;
        for (int i = 0; i < 6; i++) { // Y
            for (int j = 0; j < 6; j++) { // X
                if (tuiles[i][j] != null && tuiles[i][j].equals(tuile)) {
                    trouve = true;
                    coordonnees[0] = j;
                    break;
                }
            }
            if (trouve) {
                coordonnees[1] = i;
                break;
            }
        }
        return coordonnees;
    }
}
