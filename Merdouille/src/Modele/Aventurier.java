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

/**
 *
 * @author Aymerick
 */
public class Aventurier {
    private final String nomAventurier;
    private final CarteAventurier role;
    private Position position;
    private ArrayList<CarteTresor> deckTresor;
    private int pointAction;
    
    public Aventurier(String nomAventurier, CarteAventurier role) {
        this.nomAventurier = nomAventurier;
        this.role = role;
        this.pointAction = 3;
        
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public ArrayList<CarteTresor> getDeckTresor() {
        return deckTresor;
    }

    public int getPointAction() {
        return pointAction;
    }
    
    // =========================================================================
    
    public Grille getGrille() {
        return this.getPosition().getGrille();
    }
    
    public Tuile getTuile() {
        int x = this.getPosition().getColonne();
        int y = this.getPosition().getLigne();
        return this.getGrille().getTuile(x, y);
    }
    
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
        if (deckTresor.contains(carteTresor)) deckTresor.remove(carteTresor);
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
    
    public void assecherTuile(int x, int y) {
        this.getRole().assecherTuile(x, y);
        System.out.println("Aventurier (à assécher) : " + this.getGrille().getTuile(x, y).getNomTuile());
    }
}
