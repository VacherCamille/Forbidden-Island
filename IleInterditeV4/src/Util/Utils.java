/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Modele.Aventurier.CarteAventurier;
import Modele.CarteTresor.CarteTresor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import Modele.Divers.CarteInondation;
import Modele.Plateau.Tuile;

/**
 *
 * @author Eric
 */
public class Utils {
    
    // =========================================================================
    
    public static enum EtatTuile {
        ASSECHEE("Asséchée"), 
        INONDEE("Inondée"),
        COULEE("Coulée");

        String libelle ;
        
        EtatTuile(String libelle) {
            this.libelle = libelle ;
        }

        @Override
        public String toString() {
            return this.libelle ;
        }
    }

    // =========================================================================
    
    public static enum Pion {
        ROUGE("Rouge", new Color(255, 0, 0)), // Ingenieur
        VERT("Vert", new Color(0, 195, 0)), // Explorateur
        BLEU("Bleu", new Color(55,194,198)), // Pilote
        ORANGE("Orange", new Color(255, 148, 0)), // Messager
        VIOLET("Violet", new Color(204, 94, 255)), // Plongeur
        JAUNE("Jaune", new Color(255, 255, 0)) ; // Navigateur

        private final String libelle ;
        private final Color couleur ;


        Pion (String libelle, Color couleur) {
            this.libelle = libelle ;
            this.couleur = couleur ;
        }

        @Override
        public String toString() {
            return this.libelle ;
        }

        public Color getCouleur() {
            return this.couleur ;
        }

        public static Pion getFromName(String name) {
            if (ROUGE.name().equals(name)) return ROUGE ;
            if (VERT.name().equals(name)) return VERT ;
            if (BLEU.name().equals(name)) return BLEU ;
            if (ORANGE.name().equals(name)) return ORANGE ;
            if (VIOLET.name().equals(name)) return VIOLET ;
            if (JAUNE.name().equals(name)) return JAUNE ;
            return null ;
        }
    }
    
    // =========================================================================
    
    public static enum Tresor {
        PIERRE("Pierre Sacrée"),
        STATUE("Statue de Zéphyr"),
        CRISTAL("Cristal Ardent"),
        CALICE("Calice de l'Onde");
        
        private final String libelle;
        
        Tresor (String libelle) {
            this.libelle = libelle;
        }
        
        @Override
        public String toString() {
            return this.libelle;
        }
        
        public static Tresor getFromName(String name) {
            if (PIERRE.name().equals(name)) return PIERRE;
            if (STATUE.name().equals(name)) return STATUE;
            if (CRISTAL.name().equals(name)) return CRISTAL;
            if (CALICE.name().equals(name)) return CALICE;
            return null;
        }
    }
    
    // =========================================================================

    public static ArrayList<CarteAventurier> melangerAventuriers(ArrayList<CarteAventurier> arrayList) {
        if (Parameters.ALEAS) {
            Collections.shuffle(arrayList);
        }
        return arrayList ;
    }
    
    public static ArrayList<Tuile> melangerTuiles(ArrayList<Tuile> arrayList) {
        if (Parameters.ALEAS) {
            Collections.shuffle(arrayList);
        }
        return arrayList;
    }
    
    public static ArrayList<CarteInondation> melangerInondation(ArrayList<CarteInondation> arrayList) {
        if (Parameters.ALEAS) {
            Collections.shuffle(arrayList);
        }
        return arrayList;
    }
    
    public static ArrayList<CarteTresor> melangerTresor(ArrayList<CarteTresor> arrayList) {
        if (Parameters.ALEAS) {
            Collections.shuffle(arrayList);
        }
        return arrayList;
    }
    
    /**
     * Permet de poser une question à laquelle l'utilisateur répond par oui ou non
     * @param question texte à afficher
     * @return true si l'utilisateur répond oui, false sinon
     */
    public static Boolean poserQuestion(String question) {
        System.out.println("Divers.poserQuestion(" + question + ")");
        int reponse = JOptionPane.showConfirmDialog (null, question, "", JOptionPane.YES_NO_OPTION) ;
        System.out.println("\tréponse : " + (reponse == JOptionPane.YES_OPTION ? "Oui" : "Non"));
        return reponse == JOptionPane.YES_OPTION;
    }    
    
    /**
     * Permet d'afficher un message d'information avec un bouton OK
     * @param message Message à afficher 
     */
    public static void afficherInformation(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.OK_OPTION);
    }
}
