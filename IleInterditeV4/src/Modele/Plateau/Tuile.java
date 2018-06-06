/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.Plateau;

import Util.Utils.EtatTuile;
import Util.Utils.Pion;
import Util.Utils.Tresor;

/**
 *
 * @author dieuaida
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

    public Pion getSpawnPion() {
        return spawnPion;
    }

    public Tresor getSpawnTresor() {
        return spawnTresor;
    }

    public void setEtat(EtatTuile etat) {
        this.etat = etat;
    }
    
    // === UTILITAIRE ==========================================================
    
    public void inonderTuile() {
        if (etat == EtatTuile.ASSECHEE) {
            this.setEtat(EtatTuile.INONDEE);
            return;
        }
        if (etat == EtatTuile.INONDEE) {
            this.setEtat(EtatTuile.COULEE);
            return;
        }
    }
    
    public void assecherTuile() {
        if (etat == EtatTuile.INONDEE) {
            this.setEtat(EtatTuile.ASSECHEE);
        }
    }
}
