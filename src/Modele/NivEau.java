/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Aymerick
 */
public class NivEau {
    private final int waterLevels[] = { 2, 2, 3, 3, 3, 4, 4, 5, 5, 0 };
    private int indexLevel;

    public NivEau(String difficulte) {
        this.setCurrentLevel(difficulte);
    }

    // === GETTERS & SETTERS ===================================================
    
    public int getIndexLevel() {
        return indexLevel;
    }

    public void setCurrentLevel(String difficulte) {
        if (difficulte.equals("Novice")) this.indexLevel = 0;
        if (difficulte.equals("Normal")) this.indexLevel = 1;
        if (difficulte.equals("Elite")) this.indexLevel = 2;
        if (difficulte.equals("Légendaire")) this.indexLevel = 3;
    }
    
    // =========================================================================
    
    public int getWaterLevel() {
        return waterLevels[indexLevel];
    }
    
    public boolean isGameOver() {
        return indexLevel == 9;
    }
}
