/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author Aymerick
 */
public class Message {
    public TypesMessages type;
    public String destinateur;
    
    // DEMARRER_PARTIE
    public int nbJoueurs;
    public String[] listeJoueurs;
    public String difficulte;
    
    // DONNER_CARTE
    public String nomCarteT;
    public String destinataire;
    
    // SE_DEPLACER ET ASSECHER
    public int posX;
    public int posY;
}
