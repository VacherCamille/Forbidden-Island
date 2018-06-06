/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import MVC.Message;
import MVC.Observe;
import MVC.TypesMessages;
import Modele.Aventurier.Aventurier;
import Modele.CarteTresor.CarteTresor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;

/**
 *
 * @author dieuaida
 */
public class VueAventurier extends Observe {
    // Variables annexes
    private final Aventurier joueur;
    private final String[] listeJoueurs;
    
    public static HashMap<String, VueAventurier> vuesAventuriers = new HashMap<>();
    
    private final String nomJoueur;
    private final String nomAventurier;
    private final Color couleur;
    
    // Composants VueAventurier
    private final JPanel panelBoutons;
    private final JPanel panelCentre;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnBouger;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private final JTextField position;
    
    private JDialog fenetreAutreBouton;
    private JButton btnGagnerTresor, btnActionSpeciale;
    
    private JDialog fenetreDonCarte;
    private JButton btnDonnerCarteOk, btnDonnerCarte;
    private JComboBox cbCarte, cbListeJoueurs;
    
    private JDialog fenetreBouger;
    private JButton btnBougerOk;
    private JComboBox depColonne, depLigne;
    
    private JDialog fenetreAssecher;
    private JButton btnAssecherOk;
    private JComboBox assechColonne, assechLigne;
    
    public VueAventurier(Aventurier joueur, String[] listeJoueurs) {
        this.joueur = joueur;
        this.listeJoueurs = listeJoueurs;
        
        nomJoueur = joueur.getNomAventurier();
        nomAventurier = joueur.getRole().getNomRole();
        couleur = joueur.getPion().getCouleur();
        
        this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;

        // =====================================================================
        // NORD : le titre = nom de l'aventurier sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(nomAventurier,SwingConstants.CENTER ));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =====================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JTextField(30); 
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);
        
        this.setPosition("[ LIGNE : " + joueur.getPosition().getLigne() + "; COLONNE : " + joueur.getPosition().getColonne() + "]");

        // =====================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnBouger = new JButton("Bouger") ;
        this.btnAssecher = new JButton( "Assecher");
        this.btnAutreAction = new JButton("AutreAction") ;
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        
        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);
        
        btnTerminerTour.setEnabled(false);
        
        VueAventurier.vuesAventuriers.put(nomJoueur, this);
        
        this.initJDialogAutreAction();
        this.initBtnAutreAction();
        
        this.initJDialogBouger();
        this.initBtnBouger();
        
        this.initJDialogAssecher();
        this.initBtnAssecher();
    }
        
    // === GETTERS & SETTERS ===================================================
    
    public void setPosition(String pos) {
        this.position.setText(pos);
    }
    
     public JButton getBtnAutreAction() {
        return btnAutreAction;
    }
    
    public String getPosition() {
        return position.getText();
    }

    public JButton getBtnBouger() {
        return btnBouger;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }
    
    // UTILITAIRE JDIALOG ======================================================
    
    private void initJDialogAutreAction() {
        // JDialog associé à "AUTRE ACTION"
        fenetreAutreBouton = new JDialog(window, "Autre Action", true);
        fenetreAutreBouton.setSize(200, 150);
        fenetreAutreBouton.setLocationRelativeTo(null);
        fenetreAutreBouton.setLayout(new GridLayout(3, 1, 5, 5));
        
        btnDonnerCarte = new JButton("Donner Carte");
        btnGagnerTresor = new JButton("Gagner Tresor");
        btnActionSpeciale = new JButton("Utiliser Action Spéciale");
        
        fenetreAutreBouton.add(btnDonnerCarte);
        fenetreAutreBouton.add(btnGagnerTresor);
        fenetreAutreBouton.add(btnActionSpeciale);
        
        btnGagnerTresor.setEnabled(false);
        btnActionSpeciale.setEnabled(false);
        
        this.initJDialogDonnerCarte();
        this.initBtnDonnerCarte();
    }
    
    private void initJDialogDonnerCarte() {
        // JDialog associé à "AUTRE ACTION > DONNER CARTE"
        fenetreDonCarte = new JDialog(fenetreAutreBouton, "Autre Action > Donner Carte", true);
        fenetreDonCarte.setSize(300, 200);
        fenetreDonCarte.setLocationRelativeTo(null);
        fenetreDonCarte.setLayout(new GridLayout(3, 2, 5, 5));
        
        JLabel labelCarte = new JLabel("Choisir la carte à donner :");
        cbCarte = new JComboBox();
        for (CarteTresor carte : joueur.getDeckTresor()) {
            cbCarte.addItem(carte.getNomCarteT());
        }
        JLabel labelDestinataire = new JLabel("Choisir le destinataire :");
        cbListeJoueurs = new JComboBox();
        for (String destinataire : listeJoueurs) {
            if (!destinataire.equals(nomJoueur)) cbListeJoueurs.addItem(destinataire);
        }
        btnDonnerCarteOk = new JButton("Confirmer");
        
        fenetreDonCarte.add(labelCarte);
        fenetreDonCarte.add(cbCarte);
        fenetreDonCarte.add(labelDestinataire);
        fenetreDonCarte.add(cbListeJoueurs);
        fenetreDonCarte.add(btnDonnerCarteOk);
        
        this.initBtnDonnerCarteOk();
        
        if (joueur.getDeckTresor().isEmpty()) btnDonnerCarteOk.setEnabled(false);
    }
    
    private void initJDialogBouger() {
        // JDialog associé à "BOUGER"
        fenetreBouger = new JDialog(window, "Bouger", true);
        fenetreBouger.setSize(250, 250);
        fenetreBouger.setLocationRelativeTo(null);
        fenetreBouger.setLayout(new GridLayout(6, 1, 5, 5));
        
        JLabel labelDep = new JLabel("Coordonnées Destination :");
        
        JLabel labelDepLigne = new JLabel("LIGNE : "); labelDepLigne.setHorizontalAlignment(CENTER);
        depLigne = new JComboBox();
        
        int posJLigne = joueur.getPosition().getLigne();
        if (posJLigne != 0) depLigne.addItem(posJLigne - 1);
        depLigne.addItem(posJLigne);
        if (posJLigne != 5) depLigne.addItem(posJLigne + 1);
        
        JLabel labelDepColonne = new JLabel("COLONNE : "); labelDepColonne.setHorizontalAlignment(CENTER);
        depColonne = new JComboBox();
        
        int posJColonne = joueur.getPosition().getColonne();
        if (posJColonne != 0) depColonne.addItem(posJColonne - 1);
        depColonne.addItem(posJColonne);
        if (posJColonne != 5) depColonne.addItem(posJColonne + 1);
        
        btnBougerOk = new JButton("Confirmer");
        
        fenetreBouger.add(labelDep);
        fenetreBouger.add(labelDepLigne);
        fenetreBouger.add(depLigne);
        fenetreBouger.add(labelDepColonne);
        fenetreBouger.add(depColonne);
        fenetreBouger.add(btnBougerOk);
        
        this.initBtnBougerOk();
    }
    
    private void initJDialogAssecher() {
        // JDialog associé à "ASSECHER"
        fenetreAssecher = new JDialog(window, "Assécher", true);
        fenetreAssecher.setSize(250, 250);
        fenetreAssecher.setLocationRelativeTo(null);
        fenetreAssecher.setLayout(new GridLayout(6, 1, 5, 5));
        
        JLabel labelAssech = new JLabel("Coord. Case à assécher :");
        
        JLabel labelAssLigne = new JLabel("LIGNE : "); labelAssLigne.setHorizontalAlignment(CENTER);
        assechLigne = new JComboBox();
        
        int posJLigne = joueur.getPosition().getLigne();
        if (posJLigne != 0) assechLigne.addItem(posJLigne - 1);
        assechLigne.addItem(posJLigne);
        if (posJLigne != 5) assechLigne.addItem(posJLigne + 1);
        
        JLabel labelAssColonne = new JLabel("COLONNE : "); labelAssColonne.setHorizontalAlignment(CENTER);
        assechColonne = new JComboBox();
        
        int posJColonne = joueur.getPosition().getColonne();
        if (posJColonne != 0) assechColonne.addItem(posJColonne - 1);
        assechColonne.addItem(posJColonne);
        if (posJColonne != 5) assechColonne.addItem(posJColonne + 1);
        
        btnAssecherOk = new JButton("Confirmer");
        
        fenetreAssecher.add(labelAssech);
        fenetreAssecher.add(labelAssLigne);
        fenetreAssecher.add(assechLigne);
        fenetreAssecher.add(labelAssColonne);
        fenetreAssecher.add(assechColonne);
        fenetreAssecher.add(btnAssecherOk);
        
        this.initBtnAssecherOk();
    }
    
    // === ACTION LISTENER =====================================================
    
    private void initBtnAutreAction() {
        // Action pour btnAutreAction :
        btnAutreAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetreAutreBouton.setVisible(true);
            }
        });
    }
    
    private void initBtnDonnerCarte() {
        // Action pour btnDonnerCarte :
        btnDonnerCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fenetreDonCarte.setVisible(true);
            }
        });
    }
    
    private void initBtnDonnerCarteOk() {
        // Action pour btnDonnerCarteOk :
        btnDonnerCarteOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetreDonCarte.setVisible(false);
                fenetreAutreBouton.setVisible(false);
                
                Message m = new Message();
                m.type = TypesMessages.DONNER_CARTE;
                m.nomCarteT = (String) cbCarte.getSelectedItem();
                m.destinateur = nomJoueur;
                m.destinataire = (String) cbListeJoueurs.getSelectedItem();
                notifierObservateur(m);
                
                initJDialogDonnerCarte();
                VueAventurier.vuesAventuriers.get(m.destinataire).initJDialogDonnerCarte();
            }
        });
    }
    
    private void initBtnBouger() {
        // Action pour btnBouger :
        btnBouger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetreBouger.setVisible(true);
            }
        });
    }
    
    private void initBtnBougerOk() {
        // Action pour btnBougerOk :
        btnBougerOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetreBouger.setVisible(false);
                
                Message m = new Message();
                m.type = TypesMessages.SE_DEPLACER;
                m.destinateur = nomJoueur;
                m.posL = (int) depLigne.getSelectedItem();
                m.posC = (int) depColonne.getSelectedItem();
                notifierObservateur(m);
                
                initJDialogBouger();
                initJDialogAssecher();
                setPosition("[ LIGNE : " + joueur.getPosition().getLigne() + "; COLONNE : " + joueur.getPosition().getColonne() + "]");
            }
        });
    }
    
    private void initBtnAssecher() {
        // Action pour btnAssecher :
        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetreAssecher.setVisible(true);
            }
        });
    }
    
    private void initBtnAssecherOk() {
        // Action pour btnAssecherOk :
        btnAssecherOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetreAssecher.setVisible(false);
                
                Message m = new Message();
                m.type = TypesMessages.ASSECHER;
                m.destinateur = nomJoueur;
                m.posL = (int) assechLigne.getSelectedItem();
                m.posC = (int) assechColonne.getSelectedItem();
                notifierObservateur(m);
            }
        });
    }
    
    // === UTILITAIRE ==========================================================
    
    public void afficher() {
        this.window.setVisible(true);
    }
    
    public void fermer() {
        this.window.setVisible(false);
    }
    
    public void activer() {
        btnBouger.setEnabled(true);
        btnAssecher.setEnabled(true);
        btnAutreAction.setEnabled(true);
        btnTerminerTour.setEnabled(true);
    }
    
    public void desactiver() {
        btnBouger.setEnabled(false);
        btnAssecher.setEnabled(false);
        btnAutreAction.setEnabled(false);
        btnTerminerTour.setEnabled(false);
    }
}
