/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Aventurier;

import Modele.Plateau.Grille;
import Modele.Plateau.Position;
import Modele.Plateau.Tuile;
import Util.Utils.EtatTuile;
import Util.Utils.Pion;
import java.util.ArrayList;

/**
 *
 * @author dieuaida
 */
public class Explorateur extends CarteAventurier {
    
    public Explorateur() {
        super("Explorateur", Pion.VERT);
    }
    
    // === SE DEPLACER =========================================================
    
    @Override
    public void seDeplacer(int ligne, int colonne) {
        if (getJoueur() != null && getJoueur().getPointAction() > 0) {
            Position pos = getJoueur().getPosition();
            
            Tuile tuileDest = pos.getGrille().getTuile(ligne, colonne);
            if (tuileDest == null || tuileDest.getEtat() == EtatTuile.COULEE) {
                System.out.println("\033[31m [ ERREUR DEPLACEMENT : TUILE DESTINATION INEXISTANTE OU COULEE ! ]");
                return;
            }
            
            if (pos.getLigne() == ligne && pos.getColonne() == colonne) {
                System.out.println("\033[31m [ DEPLACEMENT INUTILE ! ]");
                return;
            }
            
            int depL = pos.getLigne() - ligne;
            int depC = pos.getColonne() - colonne;
            if (depL < -1 || depL > 1 || depC < -1 || depC > 1) {
                System.out.println("\033[31m [ ERREUR (EXPLORATEUR): DEPLACEMENT > A 1 ! ]");
                return;
            }
            
            pos.setLigne(ligne);
            pos.setColonne(colonne);
            System.out.println("\033[32m [ DEPLACEMENT EFFECTUE ! ]");
            getJoueur().utiliserPA();
        } else {
            System.out.println("\033[31m [ ERREUR  DEPLACEMENT : PAS ASSEZ DE PA ! ]");
        }
    }
    
    // === ASSECHEMENT =========================================================
    
    @Override
    public ArrayList<Tuile> getInondeesAdjacentes() {
        int posL = getJoueur().getPosition().getLigne();
        int posC = getJoueur().getPosition().getColonne();
        
        ArrayList<Tuile> tuilesInondees = super.getInondeesAdjacentes();
        Grille grille = getJoueur().getGrille();
        
        Tuile tuile = grille.getTuile(posL-1, posC-1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        tuile = grille.getTuile(posL-1, posC+1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        tuile = grille.getTuile(posL+1, posC+1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        tuile = grille.getTuile(posL+1, posC-1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        
        return tuilesInondees;
    }
}
