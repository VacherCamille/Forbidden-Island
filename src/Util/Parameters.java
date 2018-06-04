/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Eric
 */
public class Parameters {
    
    // ====================================================================================
    // Paramètres NF
    public static final Boolean LOGS = true ; // Afficher des traces par System.out.println()
    public static final Boolean ALEAS = true ; // Attribuer les aventuriers aléatoirement ou non, mélanger les défausses et les pioches
    
    // Configuration des tuiles (utilisée par la Grille pour s'auto-construire...
    // Utilisée également pour les cartes "inondation".
    public static final String[] tuilesJeu = {
        "Le Pont des Abimes,null,null",
        "La Porte de Bronze,ROUGE,null",
        "La Caverne des Ombres,null,CRISTAL",
        "La Porte de Fer,VIOLET,null",
        "La Porte d’Or,JAUNE,null",
        "Les Falaises de l’Oubli,null,null",
        "Le Palais de Corail,null,CALICE",
        "La Porte d’Argent,ORANGE,null",
        "Les Dunes de l’Illusion,null,null",
        "Heliport,BLEU,null",
        "La Porte de Cuivre,VERT,null",
        "Le Jardin des Hurlements,null,STATUE",
        "La Foret Pourpre,null,null",
        "Le Lagon Perdu,null,null",
        "Le Marais Brumeux,null,null",
        "Observatoire,null,null",
        "Le Rocher Fantome,null,null",
        "La Caverne du Brasier,null,CRISTAL",
        "Le Temple du Soleil,null,PIERRE",
        "Le Temple de La Lune,null,PIERRE",
        "Le Palais des Marees,null,CALICE",
        "Le Val du Crepuscule,null,null",
        "La Tour du Guet,null,null",
        "Le Jardin des Murmures,null,STATUE"
    };
}
