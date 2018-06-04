/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Cartes.Aventuriers;

import util.Utils.Pion;

/**
 *
 * @author Aymerick
 */
public abstract class CarteAventurier {
    private final String nomRole;
    private final Pion pion;
    
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
    
    // =========================================================================
    
    
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
