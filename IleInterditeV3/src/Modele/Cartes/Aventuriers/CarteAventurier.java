/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Cartes.Aventuriers;

import Modele.Aventurier;
import Modele.Cartes.Tresor.CarteTresor;
import Modele.Plateau.Position;
import java.util.ArrayList;
import util.Utils;
import util.Utils.EtatTuile;
import util.Utils.Pion;

/**
 *
 * @author Aymerick
 */
public abstract class CarteAventurier {
    private final String nomRole;
    private final Pion pion;
    private Aventurier a;
    
    public CarteAventurier(String nomRole, Pion pion) {
        this.nomRole = nomRole;
        this.pion = pion;
    }
    
    // === GETTERS & SETTERS ===================================================

    public Aventurier getAventurier() {
        return a;
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
            return true;
         }
      }
      return false;
    }
        public ArrayList<Position> getCasesAssech(){
            ArrayList<Position> ap = new ArrayList();
            ap.add(new Position(this.getAventurier().getPosition().getX(), this.getAventurier().getPosition().getY()));
            ap.add(new Position(this.getAventurier().getPosition().getX()+ 1 , this.getAventurier().getPosition().getY()));
            ap.add(new Position(this.getAventurier().getPosition().getX(), this.getAventurier().getPosition().getY()+1));
            ap.add(new Position(this.getAventurier().getPosition().getX()- 1 , this.getAventurier().getPosition().getY()));
            ap.add(new Position(this.getAventurier().getPosition().getX(), this.getAventurier().getPosition().getY()-1));
            return ap;
        }
        
    public void donnerCarteT(Aventurier J2,CarteTresor C){
        if (a.getPosition() == J2.getPosition()){
            if (a.getPointAction()<1){ 
                if (J2.hasFullDeck()==false){
                 J2.addCarteTresor(C);
                 a.removeCarteTresor(C);
                 a.setPointAction(a.getPointAction()-1);
                }
            } 
        }
    }
}
