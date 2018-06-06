/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Cartes.Aventuriers;

import Modele.Aventurier;
import Modele.Cartes.Tresor.CarteTresor;
import Modele.Plateau.Position;
import Modele.Plateau.Tuile;
import java.util.ArrayList;
import util.Utils.EtatTuile;
import util.Utils.Pion;

/**
 *
 * @author Aymerick
 */
public abstract class CarteAventurier {
    private final String nomRole;
    private final Pion pion;
    private Aventurier joueur;
    
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
    
    public Aventurier getJoueur() {
        return joueur;
    }

    public void setJoueur(Aventurier joueur) {
        this.joueur = joueur;
    }
    
    // === DONNER CARTE ==============================================================
    
    public void donnerCarte(Aventurier destinataire, String nomCarte) {
        if (destinataire.hasFullDeck()) {
            System.out.println("\033[31m [ ERREUR : DECK DESTINATAIRE PLEIN");
            return;
        }
        if (joueur != null && joueur.getPointAction() > 0) {
            Tuile tuileDestinateur = joueur.getPosition().getTuile();
            Tuile tuileDestinataire = destinataire.getPosition().getTuile();
            if (tuileDestinateur.equals(tuileDestinataire)) {
                CarteTresor carteDonnee = joueur.getCarteTresorFromName(nomCarte);
                joueur.removeCarteTresor(carteDonnee);
                destinataire.addCarteTresor(carteDonnee);
                System.out.println("\033[32m [ CARTE TRANSFEREE ! ]");
                joueur.utiliserPA();
            } else {
                System.out.println("\033[31m [ ERREUR DON DE CARTE : PAS MÊME TUILE ]");
            }
        } else {
            System.out.println("\033[31m [ ERREUR DON DE CARTE : PAS ASSEZ DE PA ! ]");
        }
    }
    
    // === DEPLACEMENT =========================================================
    
    public void seDeplacer(int colonne, int ligne) {
        if (joueur != null && joueur.getPointAction() > 0) {
            Position pos = joueur.getPosition();
            
            Tuile tuileDest = pos.getGrille().getTuile(colonne, ligne);
            if (tuileDest == null || tuileDest.getEtat() == EtatTuile.COULEE) {
                System.out.println("\033[31m [ ERREUR DEPLACEMENT : TUILE DESTINATION INEXISTANTE OU COULEE ! ]");
                return;
            }
            
            if (pos.getColonne() == colonne && pos.getLigne() == ligne) {
                System.out.println("\033[31m [ DEPLACEMENT INUTILE ! ]");
                return;
            }
            int deplacement = Math.abs(colonne - pos.getColonne()) + Math.abs(ligne - pos.getLigne());
            if (deplacement > 1) {
                System.out.println("\033[31m [ ERREUR : DEPLACEMENT > A 1 ! ]");
                return;
            }
            pos.setLigne(ligne);
            pos.setColonne(colonne);
            System.out.println("\033[32m [ DEPLACEMENT EFFECTUE ! ]");
            joueur.utiliserPA();
        } else {
            System.out.println("\033[31m [ ERREUR  DEPLACEMENT : PAS ASSEZ DE PA ! ]");
        }
    }
    
    // === ASSECHEMENT =========================================================
    
    public void assecherTuile(int ligne, int colonne) {
        if (joueur != null && joueur.getPointAction() > 0) {
            ArrayList<Tuile> tuilesInondees = this.getAdjacentesInondees();
            
            if (tuilesInondees.contains(joueur.getGrille().getTuile(ligne, colonne))) {
                Tuile tuile = joueur.getGrille().getTuile(ligne, colonne);
                
                System.out.println("CarteAventurier (à assécher) : " + tuile.getNomTuile());
                
                tuile.setEtat(EtatTuile.ASSECHEE);
                System.out.println("\033[32m [ ASSECHEMENT EFFECTUE ! ]");
                joueur.utiliserPA();
            } else {
                System.out.println("\033[31m [ ERREUR  ASSECHEMENT : TUILE DEJA ASSECHEE OU HORS DE PORTEE ! ]");
            }
        } else {
            System.out.println("\033[31m [ ERREUR  ASSECHEMENT : PAS ASSEZ DE PA ! ]");
        }
    }
    
    public ArrayList<Tuile> getAdjacentesInondees() {
        int xPos = joueur.getPosition().getColonne();
        int yPos = joueur.getPosition().getLigne();
        
        ArrayList<Tuile> tuilesInondees = new ArrayList<>();
        if (joueur.getTuile().getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(joueur.getTuile());
        }
        
        Tuile tuile = joueur.getGrille().getTuile(xPos+1, yPos);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        tuile = joueur.getGrille().getTuile(xPos-1, yPos);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        tuile = joueur.getGrille().getTuile(xPos, yPos+1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        tuile = joueur.getGrille().getTuile(xPos, yPos-1);
        if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
            tuilesInondees.add(tuile);
        }
        return tuilesInondees;
    }
    
    // === GAGNER TRESOR =======================================================
    
    
}
