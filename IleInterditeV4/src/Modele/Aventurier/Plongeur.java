/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Aventurier;

import Modele.Plateau.Position;
import Modele.Plateau.Tuile;
import Util.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author dieuaida
 */
public class Plongeur extends CarteAventurier {

    public Plongeur() {
        super("Plongeur", Utils.Pion.VIOLET);
    }

    @Override
    public void seDeplacer(int x, int y) {
        if (getCaseAtteignable().contains(getJoueur().getEnvironnement().getTuile(x, y))) {
            getJoueur().getPosition().setColonne(x);
            getJoueur().getPosition().setLigne(y);
            getJoueur().utiliserPA();
        }
    }

    public ArrayList<Tuile> getCaseAtteignable() {
        int x = this.getJoueur().getPosition().getColonne();
        int y = this.getJoueur().getPosition().getLigne();
        int l1;
        int l2;
        int i = 0;
        TreeSet<Position> aa = new TreeSet<>();
        TreeSet<Position> ab = new TreeSet<>();
        ArrayList<Tuile> at = new ArrayList<>();
        //toutes les cases coulées atteignables
        aa = getCaseAdjacenteInCl(x, y);

        ab.addAll(aa);
        do {
            l1 = aa.size();
            for (Position pos : aa) {
                ab.addAll(getCaseAdjacenteInCl(pos.getLigne(), pos.getColonne()));
            }
            i++;
            aa.addAll(ab);
            l2 = aa.size();
        } while (l1 != l2);
        //toutes les cases asséchée et inondée atteignables
        ab.clear();
        for (Position pos : aa) {
            ab.addAll(getCaseAdjacenteAsIn(pos.getLigne(), pos.getColonne()));
        }
        //transformation en tuile
        for (Position pos : ab) {
            at.add(getJoueur().getEnvironnement().getTuile(pos.getLigne(), pos.getColonne()));
        }
        for (Tuile t : at) {
            System.out.println(t.getNomTuile());
        }
        return at;

    }

    public TreeSet<Position> getCaseAdjacenteInCl(int x, int y) {
        TreeSet<Position> ap = new TreeSet<>();
        if (getJoueur().getEnvironnement().getTuile(x + 1, y) != null) {
            if (getJoueur().getEnvironnement().getTuile(x + 1, y).getEtat() == Utils.EtatTuile.INONDEE || getJoueur().getEnvironnement().getTuile(x + 1, y).getEtat() == Utils.EtatTuile.COULEE) {
                Position a = new Position(x + 1, y);
                ap.add(a);
            }
        }
        if (getJoueur().getEnvironnement().getTuile(x - 1, y) != null) {
            if (getJoueur().getEnvironnement().getTuile(x - 1, y).getEtat() == Utils.EtatTuile.INONDEE || getJoueur().getEnvironnement().getTuile(x - 1, y).getEtat() == Utils.EtatTuile.COULEE) {
                Position a = new Position(x - 1, y);
                ap.add(a);

            }
        }
        if (getJoueur().getEnvironnement().getTuile(x, y + 1) != null) {
            if (getJoueur().getEnvironnement().getTuile(x, y + 1).getEtat() == Utils.EtatTuile.INONDEE || getJoueur().getEnvironnement().getTuile(x, y + 1).getEtat() == Utils.EtatTuile.COULEE) {
                Position a = new Position(x, y + 1);
                ap.add(a);

            }
        }
        if (getJoueur().getEnvironnement().getTuile(x, y - 1) != null) {
            if (getJoueur().getEnvironnement().getTuile(x, y - 1).getEtat() == Utils.EtatTuile.INONDEE || getJoueur().getEnvironnement().getTuile(x, y - 1).getEtat() == Utils.EtatTuile.COULEE) {
                Position a = new Position(x, y - 1);
                ap.add(a);

            }
        }
        return ap;
    }

    public TreeSet<Position> getCaseAdjacenteAsIn(int x, int y) {
        TreeSet<Position> ap = new TreeSet<>();
        if (getJoueur().getEnvironnement().getTuile(x + 1, y) != null) {
            if (getJoueur().getEnvironnement().getTuile(x + 1, y).getEtat() == Utils.EtatTuile.ASSECHEE || getJoueur().getEnvironnement().getTuile(x + 1, y).getEtat() == Utils.EtatTuile.INONDEE) {
                Position a = new Position(x + 1, y);
                ap.add(a);
            }
        }
        if (getJoueur().getEnvironnement().getTuile(x - 1, y) != null) {
            if (getJoueur().getEnvironnement().getTuile(x - 1, y).getEtat() == Utils.EtatTuile.ASSECHEE || getJoueur().getEnvironnement().getTuile(x - 1, y).getEtat() == Utils.EtatTuile.INONDEE) {
                Position a = new Position(x - 1, y);
                ap.add(a);
            }
        }
        if (getJoueur().getEnvironnement().getTuile(x, y + 1) != null) {
            if (getJoueur().getEnvironnement().getTuile(x, y + 1).getEtat() == Utils.EtatTuile.ASSECHEE || getJoueur().getEnvironnement().getTuile(x, y+1).getEtat() == Utils.EtatTuile.INONDEE) {
                Position a = new Position(x, y + 1);
                ap.add(a);
            }
        }
        if (getJoueur().getEnvironnement().getTuile(x, y - 1) != null) {
            if (getJoueur().getEnvironnement().getTuile(x, y - 1).getEtat() == Utils.EtatTuile.ASSECHEE || getJoueur().getEnvironnement().getTuile(x , y-1).getEtat() == Utils.EtatTuile.INONDEE) {
                Position a = new Position(x, y - 1);
                ap.add(a);
            }
        }
        return ap;
    }
}
