/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Cartes.Aventuriers;

import Modele.Aventurier;
import Modele.Cartes.Tresor.CarteTresor;
import util.Utils.Pion;

/**
 *
 * @author Aymerick
 */
public class Messager extends CarteAventurier {
    
    public Messager() {
        super("Messager", Pion.ORANGE);
    }
    
    @Override
    public void donnerCarteT(Aventurier J2,CarteTresor C){
            if (getAventurier().getPointAction()<1){ 
                if (J2.hasFullDeck()==false){
                 J2.addCarteTresor(C);
                 getAventurier().removeCarteTresor(C);
                 getAventurier().setPointAction(getAventurier().getPointAction()-1);
                }
             }
    }
}
