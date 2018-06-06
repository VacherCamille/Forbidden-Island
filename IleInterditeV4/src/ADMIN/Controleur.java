/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import MVC.Message;
import MVC.Observateur;
import Modele.Aventurier.Aventurier;
import Modele.Aventurier.CarteAventurier;
import Modele.Aventurier.Explorateur;
import Modele.Aventurier.Ingenieur;
import Modele.Aventurier.Messager;
import Modele.Aventurier.Navigateur;
import Modele.Aventurier.Pilote;
import Modele.Aventurier.Plongeur;
import Modele.CarteTresor.CarteButin;
import Modele.CarteTresor.CarteTresor;
import Modele.CarteTresor.Helicoptere;
import Modele.CarteTresor.MonteeEau;
import Modele.CarteTresor.SacSable;
import Modele.Divers.CarteInondation;
import Modele.Divers.NivEau;
import Modele.Plateau.Grille;
import Modele.Plateau.Position;
import Modele.Plateau.Tuile;
import Util.Parameters;
import Util.Utils;
import Util.Utils.EtatTuile;
import Util.Utils.Pion;
import Util.Utils.Tresor;
import Vues.EcranPrincipal;
import Vues.PlateauJeu;
import Vues.VueAventurier;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dieuaida
 */
public class Controleur implements Observateur {
    // Message
        // DEMARRER_PARTIE:
    private int nbJoueurs;
    private String[] listeJoueurs; // déterminera l'ordre de jeu.
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
        Aventurier destinateur = null;
        int posL, posC;
        
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
                    role.setJoueur(nouveauJoueur);
                    // Détermination de la position du futur joueur...
                    Pion pionJoueur = nouveauJoueur.getPion();
                    int[] posJoueur = grille.getPosFromTuile(grille.getTuileFromSpawnPion(pionJoueur));
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
                
                // 7. Déterminer du niveau d'eau :
                niveauDEau = new NivEau(difficulte);
                
                // + Finalisation + //
                plateauJeu = new PlateauJeu(grille, listeJoueurs);
                plateauJeu.addObservateur(this);
                plateauJeu.afficher();
                
                for (String nomJoueur : listeJoueurs) {
                    VueAventurier vueAventurier = new VueAventurier(joueurs.get(nomJoueur), listeJoueurs);
                    vueAventurier.addObservateur(this);
                    vueAventurier.afficher();
                }
                
                System.out.println("INITIALISATION PARTIE TERMINEE !");
                this.verifEtatPartie();
                break;
                
            // === ACTIONS ==================
            case DONNER_CARTE:
                destinateur = joueurs.get(msg.destinateur);
                Aventurier destinataire = joueurs.get(msg.destinataire);
                destinateur.donnerCarte(destinataire, msg.nomCarteT);
                this.verifDeckTresorJoueurs();
                break;
                
            case SE_DEPLACER:
                destinateur = joueurs.get(msg.destinateur);
                posL = msg.posL;
                posC = msg.posC;
                
                destinateur.seDeplacer(posL, posC);
                
                this.verifEtatJoueurs();
                break;
                
            case ASSECHER:
                destinateur = joueurs.get(msg.destinateur);
                posL = msg.posL;
                posC = msg.posC;
                
                destinateur.assecherTuile(posL, posC);
                
                this.verifTuilesInondees();
                break;
        }
    }
    
    // === UTILITAIRE ==========================================================
    
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
    
    private void addPosition(Aventurier aventurier, int ligne, int colonne) {
        Position position = new Position(grille, aventurier, ligne, colonne);
        grille.setPosJoueur(aventurier.getNomAventurier(), position);
        aventurier.setPosition(position);
    }
    
    // === PHASE TEST ==========================================================
    
    private void verifEtatPartie() {
        // 1. Créer l'île interdite :
        // ...

        // 2. Placer les trésors :
        this.verifTresors();
        
        // 3. Séparer les cartes :
        this.verifPilesCarte();
        
        // 4. L'ile commence à sombrer :
        this.verifTuilesInondees();
        
        // 5. Les aventuriers débarquent :
        this.verifEtatJoueurs();
        
        // 6. distribuer les cartes Trésor :
        this.verifDeckTresorJoueurs();
        
        // 7. Déterminer le niveau d'eau :
        this.verifNiveauEau();
    }
    
    private void verifTresors() {
        System.out.println("Vérification de la collection de trésors : ");
        System.out.println("\tfalse : pas obtenu // true : obtenu");
        for (Tresor tresor : Tresor.values()) {
            System.out.println("\t" + tresor + " : " + collectionTresor.get(tresor));
        }
        System.out.println();
    }
    
    private void verifPilesCarte() {
        // Pile / Défausse Tresor :
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
        
        // Pile / Défausse Inondation :
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
        
        // Pile Aventurier :
        System.out.println("Vérification Pile AVENTURIER : ");
        for (CarteAventurier carte : pileAventurier) {
            System.out.print("\t- " + carte.getNomRole() + " - ");
            System.out.println(carte.getPion().toString());
        }
        System.out.println(pileAventurier.size() + " cartes.");
        System.out.println();
    }
    
    private void verifTuilesInondees() {
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
    }
    
    private void verifTuilesCoulees() {
        System.out.println("Vérification des tuiles coulées :");
        Tuile tuile;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                tuile = grille.getTuile(i, j);
                if (tuile != null && tuile.getEtat() == EtatTuile.COULEE) {
                    System.out.println("\t" + tuile.getNomTuile() + " - " + tuile.getEtat());
                }
            }
        }
        System.out.println();
    }
    
    private void verifEtatJoueurs() {
        System.out.println("Vérification des joueurs :");
        for (String nomJoueur : listeJoueurs) {
            Aventurier aventurier = joueurs.get(nomJoueur);
            System.out.print("\t" + aventurier.getNomAventurier() + " - ");
            System.out.print(aventurier.getRole().getNomRole() + " - ");
            System.out.println(aventurier.getPion().toString());
            System.out.print("\t\tLigne : " + aventurier.getPosition().getLigne());
            System.out.println(" / Colonne : " + aventurier.getPosition().getColonne());
            System.out.println("\t\tPA : " + aventurier.getPointAction());
        }
        System.out.println();
    }
    
    private void verifDeckTresorJoueurs() {
        System.out.println("Vérification des decks des joueurs :");
        for (String nomJoueur : listeJoueurs) {
            Aventurier aventurier = joueurs.get(nomJoueur);
            System.out.println("\t" + aventurier.getNomAventurier() + " :");
            for (CarteTresor carte : aventurier.getDeckTresor()) {
                System.out.println("\t\t- " + carte.getNomCarteT());
            }
        }
        System.out.println();
    }
    
    private void verifNiveauEau() {
        System.out.println("Vérification du niveau d'eau :");
        System.out.println("\tdifficulte : " + difficulte);
        System.out.println("\tIndex : " + niveauDEau.getIndexLevel());
        System.out.println("\tNiveau d'eau : " + niveauDEau.getWaterLevel());
        System.out.println();
    }
}
