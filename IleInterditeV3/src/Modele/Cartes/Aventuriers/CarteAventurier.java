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

    public Aventurier getAventurier() {
        return joueur;
    }

   public String getNomRole() {
      return nomRole;
   }

    public Pion getPion() {
        return pion;
    }
    
    // =========================================================================
    
    public boolean assecher(int x, int y){ // vrai si effectué
      if(getCasesAssech().contains(new Position(x,y))){
         if(getAventurier().getGrille().getTuile(x,y).getEtat() == EtatTuile.INONDEE){
            getAventurier().getGrille().getTuile(x,y).setEtat(EtatTuile.ASSECHEE);
             System.out.println("assechement de la tuile en : " + x + "," + y );
            return true;
         }
      }
      System.out.println("assechement impossible" );
      return false;
    }
    
    
    public ArrayList<Position> getCasesAssech(){ // aficher les tuiles atteignables
         int x = this.getAventurier().getPosition().getX();
         int y = this.getAventurier().getPosition().getY();
         ArrayList<Position> ap = new ArrayList();
         if (getAventurier().getTuile().getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x, y));
         }
         if (getAventurier().getGrille().getTuile(x+1, y).getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x+1, y));
         }
         if (getAventurier().getGrille().getTuile(x-1, y).getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x-1, y));
         }
         if (getAventurier().getGrille().getTuile(x, y+1).getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x, y+1));
         }
         if (getAventurier().getGrille().getTuile(x, y-1).getEtat() == EtatTuile.INONDEE){
             ap.add(new Position(x, y-1));
         }
         return ap;
      }
    
    
        
    
    public void donnerCarteT(Aventurier J2,CarteTresor C){
        if (joueur.getPosition().getTuile().equals(J2.getPosition().getTuile())){
             J2.addCarteTresor(C);
             joueur.removeCarteTresor(C);
        }
    }
        
    public void donnerCarte(Aventurier destinataire, String nomCarte) {
        if (joueur != null && joueur.getPointAction() > 0) {
            Tuile tuileDestinateur = joueur.getPosition().getTuile();
            Tuile tuileDestinataire = destinataire.getPosition().getTuile();
            if (tuileDestinateur.equals(tuileDestinataire)) {
                CarteTresor carteDonnee = joueur.getCarteTresorFromName(nomCarte);
                joueur.removeCarteTresor(carteDonnee);
                destinataire.addCarteTresor(carteDonnee);
                System.out.println("=== CARTE TRANSFEREE ! =====================");
                joueur.utiliserPA();
            } else {
                System.out.println("=== ERREUR DON DE CARTE : PAS MÊME TUILE ===");
            }
        } else {
            System.out.println("=== ERREUR DON DE CARTE : PAS ASSEZ DE PA ! =================");
        }
    }
    
    public void seDeplacer(int x, int y) {
        if (joueur != null && joueur.getPointAction() > 0) {
            Position pos = joueur.getPosition();
            pos.setX(x);
            pos.setY(y);
            Position posJGrille = pos.getGrille().getPosJoueurs().get(joueur.getNomAventurier());
            posJGrille.setX(x);
            posJGrille.setY(y);
            System.out.println("=== DEPLACEMENT EFFECTUE ! =====================");
            joueur.utiliserPA();
        } else {
            System.out.println("=== ERREUR  DEPLACEMENT : PAS ASSEZ DE PA ! =================");
        }
    }
    
    public void gagnerTresor(Aventurier a){
        int j=0;
        Tresor c=  a.getPosition().getTuile().getSpawnTresor();
      
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


