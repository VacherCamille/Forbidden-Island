/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Cartes.Aventuriers;

import Modele.Plateau.Position;
import Modele.Plateau.Tuile;
import java.util.ArrayList;
import java.util.HashSet;
import util.Utils;
import util.Utils.Pion;

/**
 *
 * @author Aymerick
 */
public class Plongeur extends CarteAventurier {
    
    public Plongeur() {
        super("Plongeur", Pion.VIOLET);
    }
    
    public ArrayList<Tuile> getCaseAtteignable() {
         int x = this.getJoueur().getPosition().getX();
         int y = this.getJoueur().getPosition().getY();
         int l1;
         int l2;
         int i = 0;
         HashSet<int[]> ap = new HashSet<>();
         HashSet<int[]> aa = new HashSet<>();
         ArrayList<Tuile> at = new ArrayList<>();
         //toutes les cases coulées attegnables
         ap = getCaseAdjacenteInCl(x, y, ap);
         do{
             l1 = ap.size();
             for(int[] pos : ap){
                 ap = getCaseAdjacenteInCl(pos[0], pos[1], ap);
             }
             i++;
             l2 = ap.size();
         }while(l1 != l2);
         //toutes les cases asséchée et inondée attegnables
         for(int[] pos : ap){
             aa = getCaseAdjacenteAsIn(pos[0],pos[1],aa);
         }
         //transformation en tuile
         for(int[] pos : aa){
             at.add(getJoueur().getEnvironnement().getTuile(pos[0], pos[1]));
         }
         return at;
    }
    
    public HashSet<int[]> getCaseAdjacenteInCl(int x, int y, HashSet<int[]> ap) {
         if (getJoueur().getEnvironnement().getTuile(x+1, y).getEtat() == Utils.EtatTuile.INONDEE || getJoueur().getTuile().getEtat() == Utils.EtatTuile.COULEE){
             int[] a = {x+1, y};
             ap.add(a);
         }
         if (getJoueur().getEnvironnement().getTuile(x-1, y).getEtat() == Utils.EtatTuile.INONDEE || getJoueur().getTuile().getEtat() == Utils.EtatTuile.COULEE){
             int[] a = {x-1, y};
             ap.add(a);
         }
         if (getJoueur().getEnvironnement().getTuile(x, y+1).getEtat() == Utils.EtatTuile.INONDEE || getJoueur().getTuile().getEtat() == Utils.EtatTuile.COULEE){
             int[] a = {x, y+1};
             ap.add(a);
         }
         if (getJoueur().getEnvironnement().getTuile(x, y-1).getEtat() == Utils.EtatTuile.INONDEE || getJoueur().getTuile().getEtat() == Utils.EtatTuile.COULEE){
             int[] a = {x, y-1};
             ap.add(a);
         }
         return ap;
    }
    
    public HashSet<int[]> getCaseAdjacenteAsIn(int x, int y, HashSet<int[]> ap) {
         if (getJoueur().getEnvironnement().getTuile(x+1, y).getEtat() == Utils.EtatTuile.ASSECHEE || getJoueur().getEnvironnement().getTuile(x+1, y).getEtat() == Utils.EtatTuile.INONDEE ){
             int[] a = {x+1, y};
             ap.add(a);
         }
         if (getJoueur().getEnvironnement().getTuile(x-1, y).getEtat() == Utils.EtatTuile.ASSECHEE || getJoueur().getEnvironnement().getTuile(x+1, y).getEtat() == Utils.EtatTuile.INONDEE ){
             int[] a = {x-1, y};
             ap.add(a);
         }
         if (getJoueur().getEnvironnement().getTuile(x, y+1).getEtat() == Utils.EtatTuile.ASSECHEE || getJoueur().getEnvironnement().getTuile(x+1, y).getEtat() == Utils.EtatTuile.INONDEE ){
             int[] a = {x, y+1};
             ap.add(a);
         }
         if (getJoueur().getEnvironnement().getTuile(x, y-1).getEtat() == Utils.EtatTuile.ASSECHEE || getJoueur().getEnvironnement().getTuile(x+1, y).getEtat() == Utils.EtatTuile.INONDEE ){
             int[] a = {x, y-1};
             ap.add(a);
         }
         return ap;
    }

}
