/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Plateau;

import util.Utils.EtatTuile;
import util.Utils.Pion;
import util.Utils.Tresor;

/**
 *
 * @author Aymerick
 */
public class Tuile {
    private final String nomTuile;
    private EtatTuile etat;
    private final Pion spawnPion;
    private final Tresor spawnTresor;
    
    public Tuile(String nomTuile, Pion spawnPion, Tresor spawnTresor) {
        this.nomTuile = nomTuile;
        this.etat = EtatTuile.ASSECHEE;
        this.spawnPion = spawnPion;
        this.spawnTresor = spawnTresor;
    }
    
    // === GETTERS & SETTERS ===================================================

    public String getNomTuile() {
        return nomTuile;
    }
    
    public EtatTuile getEtat() {
        return etat;
    }

    public void setEtat(EtatTuile etat) {
        this.etat = etat;
    }

    public Pion getSpawnPion() {
        return spawnPion;
    }

    public Tresor getSpawnTresor() {
        return spawnTresor;
    }
    
    // =========================================================================
    
    public void inonderTuile() {
        if (etat == EtatTuile.ASSECHEE) {
            this.setEtat(EtatTuile.INONDEE);
            return;
        } else if (etat == EtatTuile.INONDEE) {
            this.setEtat(EtatTuile.COULEE);
        }
    }
}
