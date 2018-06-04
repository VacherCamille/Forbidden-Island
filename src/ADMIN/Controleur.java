/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import MVC.Message;
import MVC.Observateur;
import Modele.Aventurier;
import Modele.CarteInondation;
import Modele.Cartes.Aventuriers.*;
import Modele.Cartes.Tresor.*;
import Modele.NivEau;
import Modele.Plateau.*;
import Util.Parameters;
import Vues.EcranPrincipal;
import Vues.PlateauJeu;
import java.util.ArrayList;
import java.util.HashMap;
import util.Utils;
import util.Utils.*;

/**
 *
 * @author Aymerick
 */
public class Controleur implements Observateur {
    // Message
        // DEMARRER_PARTIE:
    private int nbJoueurs;
    private String[] listeJoueurs; // permettra de déterminer l'ordre de passage.
    private String difficulte;

    // Vues
    private EcranPrincipal ecranPrincipal;
    private PlateauJeu plateauJeu;
    
    // Modele
    private Grille grille;
    
    private HashMap<Tresor, Boolean> collectionTresor;
    
    private ArrayList<CarteInondation> pileInondation;
    private ArrayList<CarteInondation> defausseInondation;
    private ArrayList<CarteTresor> pileTresor;
    private ArrayList<CarteTresor> defausseTresor;
    private ArrayList<CarteAventurier> pileAventurier;
    
    private HashMap<String, Aventurier> joueurs;
    
    private NivEau niveauDEau;
    
    public Controleur() {
        ecranPrincipal = new EcranPrincipal();
        ecranPrincipal.addObservateur(this);
        ecranPrincipal.afficher();
    }

    @Override
    public void traiterMessage(Message msg) {
        switch (msg.type) {
            case DEMARRER_PARTIE:
                ecranPrincipal.fermer();
                
                nbJoueurs = msg.nbJoueurs;
                listeJoueurs = msg.listeJoueurs;
                difficulte = msg.difficulte;
                
                // Initialisation des Collections...
                collectionTresor = new HashMap<>();
                pileInondation = new ArrayList<>();
                defausseInondation = new ArrayList<>();
                pileTresor = new ArrayList<>();
                defausseTresor = new ArrayList<>();
                pileAventurier = new ArrayList<>();
                joueurs = new HashMap<>();
                
                // === INSTALLATION (cf. règles du jeu) ========================
                
                System.out.println("DEMARRAGE DE L'INITIALISATION PARTIE...");
                
                // 1. Créer l'Île Interdite :
                grille = new Grille();
                
                // 2. Placer les Trésors :
                for (Tresor tresor : Tresor.values()) {
                    collectionTresor.put(tresor, Boolean.FALSE);
                }
                
                // 3. Séparer les cartes :
                    // Pile "Inondation" :
                for (String args : Parameters.tuilesJeu) {
                    String parts[] = args.split(",");
                    String nomCarteI = parts[0];
                    pileInondation.add(new CarteInondation(nomCarteI));
                }
                Utils.melangerInondation(pileInondation);
                    // Pile "Tresor" (cf. Materiel) :
                for (Tresor tresor : Tresor.values()) {
                    for (int i = 0; i < 5; i++) {
                        pileTresor.add(new CarteButin(tresor)); // 5 cartes / trésor
                    }
                }
                for (int i = 0; i < 3; i++) {
                    pileTresor.add(new MonteeEau()); // 3 cartes montée des eaux
                    pileTresor.add(new Helicoptere()); // 3 cartes hélicoptère
                }
                pileTresor.add(new SacSable());
                pileTresor.add(new SacSable()); // 2 cartes sacs de sable
                Utils.melangerTresor(pileTresor);
                    // Pile "Aventurier"
                pileAventurier.add(new Explorateur());
                pileAventurier.add(new Ingenieur());
                pileAventurier.add(new Messager());
                pileAventurier.add(new Navigateur());
                pileAventurier.add(new Pilote());
                pileAventurier.add(new Plongeur());
                Utils.melangerAventuriers(pileAventurier);
                
                // 4. L'Île commence à sombrer :
                for (int i = 0; i < 6; i++) {
                    this.tirerCarteInondation();
                }
                
                // 5. Les aventuriers débarquent :
                    // Création des aventuriers...
                for (int i = 0; i < nbJoueurs; i++) {
                    String nomAventurier = listeJoueurs[i];
                    CarteAventurier role = pileAventurier.get(i);
                    Aventurier nouveauJoueur = new Aventurier(nomAventurier, role);
                    // détermination de la position du futur joueur...
                    Pion pionJoueur = nouveauJoueur.getPion();
                    int[] posJoueur = grille.getXYFromTuile(grille.getTuileFromSpawnPion(pionJoueur));
                    this.addPosition(nouveauJoueur, posJoueur[0], posJoueur[1]);
                    
                    joueurs.put(nomAventurier, nouveauJoueur);
                }
                
                // 6. Distribuer les cartes Trésor :
                for (String nomJoueur : listeJoueurs) {
                    Aventurier joueur = joueurs.get(nomJoueur);
                    while (joueur.getNbCartes() < 2) {
                        this.tirerCarteTresor(joueur);
                    }
                }
                
                // 7. Déterminer le niveau d'eau :
                niveauDEau = new NivEau(difficulte);
                
                System.out.println("INITIALISATION PARTIE TERMINEE !");
                this.verifEtatPartie();
        }
    }
    
    // =========================================================================
    
    private void tirerCarteInondation() {
        CarteInondation carteTiree = pileInondation.remove(0);
        String nomTuile = carteTiree.getNomCarteI();
        grille.getTuileFromName(nomTuile).inonderTuile();
        defausseInondation.add(carteTiree);
    }
    
    private void tirerCarteTresor(Aventurier aventurier) {
        CarteTresor carteTiree = pileTresor.remove(0);
        while (carteTiree.getNomCarteT().equals("Montée des eaux")) {
            pileTresor.add(carteTiree);
            Utils.melangerTresor(pileTresor);
            carteTiree = pileTresor.remove(0);
        }
        aventurier.addCarteTresor(carteTiree);
    }
    
    private void addPosition(Aventurier aventurier, int x, int y) {
        Position position = new Position(grille, aventurier, x, y);
        grille.setPosJoueur(aventurier.getNomAventurier(), position);
        aventurier.setPosition(position);
    }
    
    // =========================================================================

    private void verifEtatPartie() {
        // 1. Créer l'ile interdire :
        plateauJeu = new PlateauJeu(grille, listeJoueurs);
        plateauJeu.afficher();
        
        // 2. Placer les trésors :
        System.out.println("Vérification de la collection de trésors : ");
        for (Tresor tresor : Tresor.values()) {
            System.out.println("\t" + tresor + " : " + collectionTresor.get(tresor));
        }
        System.out.println();
        
        // 3. Séparer les cartes :
        System.out.println("Vérification Pile TRESOR : ");
        for (CarteTresor carte : pileTresor) {
            System.out.println("\t- " + carte.getNomCarteT());
        }
        System.out.println(pileTresor.size() + " cartes.");
        System.out.println();
        System.out.println("Vérification Defausse TRESOR : ");
        for (CarteTresor carte : defausseTresor) {
            System.out.println("\t- " + carte.getNomCarteT());
        }
        System.out.println(defausseTresor.size() + " cartes.");
        System.out.println();
        System.out.println("Vérification Pile INONDATION : ");
        for (CarteInondation carte : pileInondation) {
            System.out.println("\t- " + carte.getNomCarteI());
        }
        System.out.println(pileInondation.size() + " cartes.");
        System.out.println();
        System.out.println("Vérification Defausse INONDATION : ");
        for (CarteInondation carte : defausseInondation) {
            System.out.println("\t- " + carte.getNomCarteI());
        }
        System.out.println(defausseInondation.size() + " cartes.");
        System.out.println();
        System.out.println("Vérification Pile AVENTURIER : ");
        for (CarteAventurier carte : pileAventurier) {
            System.out.print("\t- " + carte.getNomRole() + " - ");
            System.out.println(carte.getPion().toString());
        }
        System.out.println(pileAventurier.size() + " cartes.");
        System.out.println();
        
        // 4. L'ile commence à sombrer :
        System.out.println("Vérification des tuiles inondées :");
        Tuile tuile;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                tuile = grille.getTuile(i, j);
                if (tuile != null && tuile.getEtat() == EtatTuile.INONDEE) {
                    System.out.println("\t" + tuile.getNomTuile() + " - " + tuile.getEtat());
                }
            }
        }
        System.out.println();
        
        // 5. Les aventuriers débarquent :
        System.out.println("Vérification des joueurs :");
        for (String nomJoueur : listeJoueurs) {
            Aventurier aventurier = joueurs.get(nomJoueur);
            System.out.print("\t" + aventurier.getNomAventurier() + " - ");
            System.out.print(aventurier.getRole().getNomRole() + " - ");
            System.out.println(aventurier.getPion().toString());
            System.out.print("\t\tX : " + aventurier.getPosition().getX());
            System.out.println(" / Y : " + aventurier.getPosition().getY());
        }
        System.out.println();
        
        // 6. distribuer les cartes Trésor :
        System.out.println("Vérification des decks des joueurs :");
        for (String nomJoueur : listeJoueurs) {
            Aventurier aventurier = joueurs.get(nomJoueur);
            System.out.println("\t" + aventurier.getNomAventurier() + " :");
            for (CarteTresor carte : aventurier.getDeckTresor()) {
                System.out.println("\t\t- " + carte.getNomCarteT());
            }
        }
        System.out.println();
        
        // 7. Déterminer le niveau d'eau :
        System.out.println("Vérification du niveau d'eau :");
        System.out.println("\tdifficulte : " + difficulte);
        System.out.println("\tIndex : " + niveauDEau.getIndexLevel());
        System.out.println("\tNiveau d'eau : " + niveauDEau.getWaterLevel());
        System.out.println();
    }
    
    
}
