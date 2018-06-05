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
        if (a.getPosition().getTuile().equals(J2.getPosition().getTuile())){
             J2.addCarteTresor(C);
             a.removeCarteTresor(C);
        }
    }
    public boolean getDeplacementPossible(Aventurier J,int x, int y){
        int nbcasedep = 0;
        int xdep = 0;
        int ydep = 0;
        int xdepPosit = 0;
        int ydepPosit = 0;
        
        xdep = this.getAventurier().getPosition().getX()-x;
        ydep = this.getAventurier().getPosition().getY()-y;
        
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
                if((xdep == -1 && ydep == 0) || (xdep == 1 && ydep == 0) || (xdep == 0 && ydep == -1) || (xdep == 0 && ydep == 1)){
                    if(getAventurier().getGrille().getTuile(xdep,ydep).getEtat() == EtatTuile.INONDEE || getAventurier().getGrille().getTuile(xdep,ydep)==null){
                        return false;
                    } 
                    else{
                        return false;
                    }
                }
                
                    
                }
            }
        }
    
    
    public void seDeplacer(Aventurier J, int x, int y){
        if(getDeplacementPossible(J, x, y) == true){
            J.getPosition().setX(x);
            J.getPosition().setY(y);
            System.out.println("DEPLACEMENT EFFECTUE"); 
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
      if( j==4){
          System.out.println("l'Aventurier " +a +" a gagné le trésor "+ c.toString());
          Tresors.remove(c.toString());
          
      }

    

         }
}


