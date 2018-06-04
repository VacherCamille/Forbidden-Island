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
        public void assecher(int x, int y){
      ArrayList<Position> ap = new ArrayList();
      ap.add(new Position(this.getAventurier().getPosition().getX(), this.getAventurier().getPosition().getY()));
      ap.add(new Position(this.getAventurier().getPosition().getX()+ 1 , this.getAventurier().getPosition().getY()+1));
      ap.add(new Position(this.getAventurier().getPosition().getX()+ 1 , this.getAventurier().getPosition().getY()-1));
      ap.add(new Position(this.getAventurier().getPosition().getX()- 1 , this.getAventurier().getPosition().getY()+1));
      ap.add(new Position(this.getAventurier().getPosition().getX()- 1 , this.getAventurier().getPosition().getY()-1));

      if(ap.contains(new Position(x,y))){
         if(getAventurier().getGrille().getTuile(x,y).getEtat() == EtatTuile.INONDEE){
            getAventurier().getGrille().getTuile(x,y).setEtat(EtatTuile.ASSECHEE);
         }
               
      }
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
    
    public void seDeplacer(int x, int y){
        Position posjoueur = new Position(this.getAventurier().getPosition().getX(), this.getAventurier().getPosition().getY());
        int nbcasedep = 0;
        int xdep = 0;
        int ydep = 0;
        int xdepPosit = 0;
        int ydepPosit = 0;
        boolean chemin1 = true;
        
        xdep = posjoueur.getX()-x;
        ydep = posjoueur.getY()-y;
        
        if(xdep < 0){
            xdepPosit = xdep*(-1);
        }
        else{
            xdepPosit = xdep;
        }
        
        if(ydep < 0){
            ydepPosit = ydep*(-1);
        }
        else{
            ydepPosit = ydep;
        }
        
        nbcasedep = xdepPosit + ydepPosit;
        if(nbcasedep > this.getAventurier().getPointAction()){
            System.out.println("DEPLACEMENT TROP GRAND");
        }
        else if(nbcasedep == 0){
            System.out.println("DEPLACEMENT SUR SOIS MEME IMPOSSIBLE");
        }
        else{
            if(nbcasedep == 1){
                if(xdep == -1 && ydep == 0){
                    if(getAventurier().getGrille().getTuile(xdep,ydep).getEtat() == EtatTuile.INONDEE || getAventurier().getGrille().getTuile(xdep,ydep)==null){
                        chemin1 = false;
                    } 
                }
                if(xdep == 1 && ydep == 0){
                    if(getAventurier().getGrille().getTuile(xdep,ydep).getEtat() == EtatTuile.INONDEE || getAventurier().getGrille().getTuile(xdep,ydep)==null){
                        chemin1 = false;
                    }   
                }
                if(xdep == 0 && ydep == -1){
                    if(getAventurier().getGrille().getTuile(xdep,ydep).getEtat() == EtatTuile.INONDEE || getAventurier().getGrille().getTuile(xdep,ydep)==null){
                        chemin1 = false;
                    } 
                }
                if(xdep == 0 && ydep == 1){
                    if(getAventurier().getGrille().getTuile(xdep,ydep).getEtat() == EtatTuile.INONDEE || getAventurier().getGrille().getTuile(xdep,ydep)==null){
                        chemin1 = false;
                    } 
                }
            }
        }
        if(chemin1 == false){
            System.out.println("DEPLACEMENT IMPOSSIBLE");
        }
        else if(chemin1 == true){
            System.out.println("DEPLACEMENT POSSIBLE");
        }
    }
}
