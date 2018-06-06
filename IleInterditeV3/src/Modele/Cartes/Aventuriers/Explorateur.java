/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Cartes.Aventuriers;

import Modele.Plateau.Position;
import java.util.ArrayList;
import util.Utils.Pion;

/**
 *
 * @author Aymerick
 */
public class Explorateur extends CarteAventurier {
    
    public Explorateur() {
        super("Explorateur", Pion.VERT);
    }
    
       @Override
     public ArrayList<Position> getCasesAssech() {
      ArrayList ap = super.getCasesAssech(); 
      ap.add(new Position(this.getJoueur().getPosition().getX()+1, this.getJoueur().getPosition().getY()+1));
      ap.add(new Position(this.getJoueur().getPosition().getX()-1, this.getJoueur().getPosition().getY()+1));
      ap.add(new Position(this.getJoueur().getPosition().getX()+1, this.getJoueur().getPosition().getY()-1));
      ap.add(new Position(this.getJoueur().getPosition().getX()-1, this.getJoueur().getPosition().getY()-1));
      return ap;
   }

}
