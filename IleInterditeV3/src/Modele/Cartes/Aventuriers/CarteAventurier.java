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
import util.Utils.Tresor;

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
    
    // === ACTION ==============================================================
    
    public boolean assecher(int x, int y){ // vrai si effectué
      if(getCasesAssech().contains(new Position(x,y))){
         if(getJoueur().getEnvironnement().getTuile(x,y).getEtat() == EtatTuile.INONDEE){
            getJoueur().getEnvironnement().getTuile(x,y).setEtat(EtatTuile.ASSECHEE);
             System.out.println("assechement de la tuile en : " + x + "," + y );
            return true;
         }
      }
      System.out.println("assechement impossible" );
      return false;
    }
    
    
    public ArrayList<Position> getCasesAssech(){ // aficher les tuiles atteignables
         int x = this.getJoueur().getPosition().getX();
         int y = this.getJoueur().getPosition().getY();
         ArrayList<Position> ap = new ArrayList();
         if (getJoueur().getTuile().getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x, y));
         }
         if (getJoueur().getEnvironnement().getTuile(x+1, y).getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x+1, y));
         }
         if (getJoueur().getEnvironnement().getTuile(x-1, y).getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x-1, y));
         }
         if (getJoueur().getEnvironnement().getTuile(x, y+1).getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x, y+1));
         }
         if (getJoueur().getEnvironnement().getTuile(x, y-1).getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x, y-1));
         }
         return ap;
}
    
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
    
    public void seDeplacer(int x, int y) {
        if (joueur != null && joueur.getPointAction() > 0) {
            Position pos = joueur.getPosition();
            if (pos.getX() == x && pos.getY() == y) {
                System.out.println("\033[31m [ DEPLACEMENT INUTILE ! ]");
                return;
            }
            int deplacement = Math.abs(x - pos.getX()) + Math.abs(y - pos.getY());
            if (!joueur.getRole().getNomRole().equals("Explorateur") && deplacement > 1) {
                System.out.println("\033[31m [ ERREUR : DEPLACEMENT > A 1 ! ]");
                return;
            }
            if (joueur.getRole().getNomRole().equals("Explorateur")) {
                int xDep = pos.getX() - x;
                int yDep = pos.getY() - y;
                if (xDep < -1 || xDep > 1 || yDep < -1 || yDep > 1) {
                    System.out.println("\033[31m [ ERREUR (EXPLORATEUR): DEPLACEMENT > A 1 ! ]");
                    return;
                }
            }
            pos.setX(x);
            pos.setY(y);
            System.out.println("\033[32m [ DEPLACEMENT EFFECTUE ! ]");
            joueur.utiliserPA();
        } else {
            System.out.println("\033[31m [ ERREUR  DEPLACEMENT : PAS ASSEZ DE PA ! ]");
        }
    }
    
    public void gagnerTresor(Aventurier a){
        int j=0;
        Tresor c =  a.getPosition().getTuile().getSpawnTresor();
      
        for(int i=0; i<=a.getDeckTresor().size(); i++){
            if( a.getDeckTresor().get(i).getNomCarteT().equals(c.toString())){
                j=j+1;
            }
        
        }
        if( j>=4){
          System.out.println("l'Aventurier " +a +" a gagné le trésor "+ c.toString());
          int i=4;
          int k = 0;
          while(i >0){
            if (a.getDeckTresor().get(k).getNomCarteT().equals(c.toString())){
               a.getDeckTresor().remove(c.toString());               
            }
            k++;
            i--;
          }
         
        }

         
}
    

}
