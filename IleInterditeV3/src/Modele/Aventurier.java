/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Cartes.Aventuriers.CarteAventurier;
import Modele.Cartes.Tresor.CarteTresor;
import Modele.Plateau.Grille;
import Modele.Plateau.Position;
import Modele.Plateau.Tuile;
import java.util.ArrayList;
import util.Utils.Pion;
import util.Utils.Tresor;

/**
 *
 * @author Aymerick
 */
public class Aventurier {
    private final String nomAventurier;
    private final CarteAventurier role;
    private int pointAction = 3;
    private Position position;
    private ArrayList<CarteTresor> deckTresor;
     private ArrayList<Tresor> Tresors;
    
    public Aventurier(String nomAventurier, CarteAventurier role) {
        this.nomAventurier = nomAventurier;
        this.role = role;
        
        deckTresor = new ArrayList<>();
    }
    
    // === GETTERS & SETTERS ===================================================

    public String getNomAventurier() {
        return nomAventurier;
    }

    public CarteAventurier getRole() {
        return role;
    }
    
    public Position getPosition() {
        return position;
    }

   public Grille getGrille() {
      return getPosition().getGrille();
   }
   
   public Tuile getTuile() {
      return getGrille().getTuile(getPosition().getX(),getPosition().getY());
   }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ArrayList<CarteTresor> getDeckTresor() {
        return deckTresor;
    }

    public int getPointAction() {
        return pointAction;
    }

    public void setPointAction(int pointAction) {
        this.pointAction = pointAction;
    }
    
    // =========================================================================
    
    public Pion getPion() {
        return this.getRole().getPion();
    }
    
    public int getNbCartes() {
        return this.getDeckTresor().size();
    }
    
    public boolean hasFullDeck() {
        return this.getNbCartes() == 5;
    }
    
    public void addCarteTresor(CarteTresor carteTresor) {
        deckTresor.add(carteTresor);
    }
    
    public CarteTresor getCarteTresorFromName(String nomCarteT) {
        for (CarteTresor carte : this.getDeckTresor()) {
            if (carte.getNomCarteT().equals(nomCarteT)) return carte;
        }
        return null;
    }
    
    public void removeCarteTresor(CarteTresor carteTresor) {
        deckTresor.remove(carteTresor);
    }
    
    public void utiliserPA() {
        this.pointAction -= 1;
    }
    
    // === RACCOURCI ACTION ====================================================
    
    public void donnerCarte(Aventurier destinataire, String nomCarte) {
        this.getRole().donnerCarte(destinataire, nomCarte);
    }
    
    public void seDeplacer(int x, int y) {
        this.getRole().seDeplacer(x, y);
    }
}
