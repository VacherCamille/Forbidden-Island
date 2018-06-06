/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Cartes.Aventuriers;

import Modele.Plateau.Grille;
import Modele.Plateau.Position;
import Modele.Plateau.Tuile;
import java.util.ArrayList;
import util.Utils.EtatTuile;
import util.Utils.Pion;

/**
 *
 * @author Aymerick
 */
public class Explorateur extends CarteAventurier {
    
    public Explorateur() {
        super("Explorateur", Pion.VERT);
    }
    
    // === SE DEPLACER =========================================================
    
    @Override
    public void seDeplacer(int colonne, int ligne) {
        if (getJoueur() != null && getJoueur().getPointAction() > 0) {
            Position pos = getJoueur().getPosition();
            
            Tuile tuileDest = pos.getGrille().getTuile(ligne, colonne);
            if (tuileDest == null || tuileDest.getEtat() == EtatTuile.COULEE) {
                System.out.println("\033[31m [ ERREUR DEPLACEMENT : TUILE DESTINATION INEXISTANTE OU COULEE ! ]");
                return;
            }
            
            if (pos.getColonne() == colonne && pos.getLigne() == ligne) {
                System.out.println("\033[31m [ DEPLACEMENT INUTILE ! ]");
                return;
            }
            int xDep = pos.getColonne() - colonne;
            int yDep = pos.getLigne() - ligne;
            if (xDep < -1 || xDep > 1 || yDep < -1 || yDep > 1) {
                System.out.println("\033[31m [ ERREUR (EXPLORATEUR): DEPLACEMENT > A 1 ! ]");
                return;
            }
            pos.setLigne(ligne);
            pos.setLigne(colonne);
            System.out.println("\033[32m [ DEPLACEMENT EFFECTUE ! ]");
            getJoueur().utiliserPA();
        } else {
            System.out.println("\033[31m [ ERREUR  DEPLACEMENT : PAS ASSEZ DE PA ! ]");
        }
    }
    
    // === ASSECHER ============================================================
    
    @Override
    public ArrayList<Tuile> getAdjacentesInondees() {
        int xPos = getJoueur().getPosition().getColonne();
        int yPos = getJoueur().getPosition().getLigne();
        
        ArrayList<Tuile> tuilesInondees = super.getAdjacentesInondees();
        Grille grille = getJoueur().getGrille();
        
        Tuile tuile = grille.getTuile(xPos-1, yPos+1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
            System.out.println(tuile.getNomTuile());
        }
        tuile = grille.getTuile(xPos+1, yPos+1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
            System.out.println(tuile.getNomTuile());
        }
        tuile = grille.getTuile(xPos-1, yPos-1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            System.out.println(tuile.getNomTuile());
        }
        tuile = grille.getTuile(xPos+1, yPos-1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        
        return tuilesInondees;
    }
}
