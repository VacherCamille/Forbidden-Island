/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import MVC.Observe;
import Modele.Plateau.Grille;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Aymerick
 */
public class PlateauJeu extends Observe {
    
    // Variables paramètres
    private String[] listeJoueurs;
    private Grille grille;
    
    // Variable JFrame
    private JFrame window;
    private JPanelPerso main;
    
    private javax.swing.JButton buttonDC1;
    private javax.swing.JButton buttonDC2;
    private javax.swing.JButton buttonDC3;
    private javax.swing.JButton buttonDC4;
    private javax.swing.JButton buttonDC5;
    private javax.swing.JButton defausseInondation;
    private javax.swing.JButton defausseTresor;
    private javax.swing.JLabel labelJ1;
    private javax.swing.JLabel labelJ2;
    private javax.swing.JLabel labelJ3;
    private javax.swing.JLabel labelJ4;
    private javax.swing.JPanel panelDJ1;
    private javax.swing.JPanel panelDJ2;
    private javax.swing.JPanel panelDJ3;
    private javax.swing.JPanel panelDJ4;
    private javax.swing.JPanel panelGrille;
    private javax.swing.JPanel panelInondation;
    private javax.swing.JPanel panelJ1;
    private javax.swing.JPanel panelJ2;
    private javax.swing.JPanel panelJ3;
    private javax.swing.JPanel panelJ4;
    private javax.swing.JPanel panelJC;
    private javax.swing.JPanel panelNivEau;
    private javax.swing.JPanel panelRoleJ1;
    private javax.swing.JPanel panelRoleJ2;
    private javax.swing.JPanel panelRoleJ3;
    private javax.swing.JPanel panelRoleJ4;
    private javax.swing.JPanel panelTresor;
    private javax.swing.JButton pileInondation;
    private javax.swing.JButton pileTresor;
    
    // Variables JWindow
    
    
    // Constructeur
    public PlateauJeu(Grille grille, String[] listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
        this.grille = grille;
        
        this.window = new JFrame("Île Interdite - Plateau de Jeu");
        window.setLayout(new BorderLayout());
        this.main = new JPanelPerso();
        window.add(main, BorderLayout.CENTER);
        this.initWindow();
        this.initPlayers();
        
        this.initGrille();
    }
    
    // =========================================================================
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initWindow() {

        panelGrille = new javax.swing.JPanel();
        panelJ1 = new javax.swing.JPanel();
        labelJ1 = new javax.swing.JLabel();
        panelRoleJ1 = new javax.swing.JPanel();
        panelDJ1 = new javax.swing.JPanel();
        panelJ2 = new javax.swing.JPanel();
        labelJ2 = new javax.swing.JLabel();
        panelRoleJ2 = new javax.swing.JPanel();
        panelDJ2 = new javax.swing.JPanel();
        panelTresor = new javax.swing.JPanel();
        defausseTresor = new javax.swing.JButton();
        pileTresor = new javax.swing.JButton();
        panelInondation = new javax.swing.JPanel();
        pileInondation = new javax.swing.JButton();
        defausseInondation = new javax.swing.JButton();
        panelJ3 = new javax.swing.JPanel();
        labelJ3 = new javax.swing.JLabel();
        panelRoleJ3 = new javax.swing.JPanel();
        panelDJ3 = new javax.swing.JPanel();
        panelJ4 = new javax.swing.JPanel();
        labelJ4 = new javax.swing.JLabel();
        panelRoleJ4 = new javax.swing.JPanel();
        panelDJ4 = new javax.swing.JPanel();
        panelJC = new javax.swing.JPanel();
        panelNivEau = new javax.swing.JPanel();
        buttonDC1 = new javax.swing.JButton();
        buttonDC2 = new javax.swing.JButton();
        buttonDC3 = new javax.swing.JButton();
        buttonDC4 = new javax.swing.JButton();
        buttonDC5 = new javax.swing.JButton();

        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(new java.awt.Dimension(1080, 720));
        window.setLocationRelativeTo(null);

        panelGrille.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelGrille.setPreferredSize(new java.awt.Dimension(600, 540));
        panelGrille.setLayout(new java.awt.GridLayout(6, 6, 2, 2));

        panelJ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelJ1.setPreferredSize(new java.awt.Dimension(220, 240));

        labelJ1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        labelJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ1.setText(" - ");

        panelRoleJ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelRoleJ1Layout = new javax.swing.GroupLayout(panelRoleJ1);
        panelRoleJ1.setLayout(panelRoleJ1Layout);
        panelRoleJ1Layout.setHorizontalGroup(
            panelRoleJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRoleJ1Layout.setVerticalGroup(
            panelRoleJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelDJ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelDJ1.setLayout(new java.awt.GridLayout(2, 3));

        javax.swing.GroupLayout panelJ1Layout = new javax.swing.GroupLayout(panelJ1);
        panelJ1.setLayout(panelJ1Layout);
        panelJ1Layout.setHorizontalGroup(
            panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelJ1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addGroup(panelJ1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoleJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelJ1Layout.setVerticalGroup(
            panelJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJ1Layout.createSequentialGroup()
                .addComponent(labelJ1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRoleJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDJ1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelJ2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelJ2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        labelJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ2.setText(" - ");

        panelRoleJ2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelRoleJ2Layout = new javax.swing.GroupLayout(panelRoleJ2);
        panelRoleJ2.setLayout(panelRoleJ2Layout);
        panelRoleJ2Layout.setHorizontalGroup(
            panelRoleJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRoleJ2Layout.setVerticalGroup(
            panelRoleJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelDJ2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelDJ2.setPreferredSize(new java.awt.Dimension(20, 102));
        panelDJ2.setLayout(new java.awt.GridLayout(2, 3));

        javax.swing.GroupLayout panelJ2Layout = new javax.swing.GroupLayout(panelJ2);
        panelJ2.setLayout(panelJ2Layout);
        panelJ2Layout.setHorizontalGroup(
            panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelJ2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addGroup(panelJ2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoleJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelJ2Layout.setVerticalGroup(
            panelJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJ2Layout.createSequentialGroup()
                .addComponent(labelJ2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRoleJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTresor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelTresor.setPreferredSize(new java.awt.Dimension(220, 120));

        javax.swing.GroupLayout panelTresorLayout = new javax.swing.GroupLayout(panelTresor);
        panelTresor.setLayout(panelTresorLayout);
        panelTresorLayout.setHorizontalGroup(
            panelTresorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTresorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(defausseTresor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pileTresor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTresorLayout.setVerticalGroup(
            panelTresorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTresorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTresorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pileTresor, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(defausseTresor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelInondation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelInondation.setPreferredSize(new java.awt.Dimension(220, 120));

        javax.swing.GroupLayout panelInondationLayout = new javax.swing.GroupLayout(panelInondation);
        panelInondation.setLayout(panelInondationLayout);
        panelInondationLayout.setHorizontalGroup(
            panelInondationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInondationLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(defausseInondation, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pileInondation, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInondationLayout.setVerticalGroup(
            panelInondationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInondationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInondationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pileInondation, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(defausseInondation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelJ3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelJ3.setPreferredSize(new java.awt.Dimension(220, 240));

        labelJ3.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        labelJ3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ3.setText(" - ");

        panelRoleJ3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelRoleJ3Layout = new javax.swing.GroupLayout(panelRoleJ3);
        panelRoleJ3.setLayout(panelRoleJ3Layout);
        panelRoleJ3Layout.setHorizontalGroup(
            panelRoleJ3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRoleJ3Layout.setVerticalGroup(
            panelRoleJ3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelDJ3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelDJ3.setPreferredSize(new java.awt.Dimension(20, 102));
        panelDJ3.setLayout(new java.awt.GridLayout(2, 3));

        javax.swing.GroupLayout panelJ3Layout = new javax.swing.GroupLayout(panelJ3);
        panelJ3.setLayout(panelJ3Layout);
        panelJ3Layout.setHorizontalGroup(
            panelJ3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelJ3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addGroup(panelJ3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJ3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoleJ3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDJ3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelJ3Layout.setVerticalGroup(
            panelJ3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJ3Layout.createSequentialGroup()
                .addComponent(labelJ3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRoleJ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDJ3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelJ4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelJ4.setPreferredSize(new java.awt.Dimension(220, 240));

        labelJ4.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        labelJ4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ4.setText(" - ");

        panelRoleJ4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelRoleJ4Layout = new javax.swing.GroupLayout(panelRoleJ4);
        panelRoleJ4.setLayout(panelRoleJ4Layout);
        panelRoleJ4Layout.setHorizontalGroup(
            panelRoleJ4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRoleJ4Layout.setVerticalGroup(
            panelRoleJ4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        panelDJ4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelDJ4.setPreferredSize(new java.awt.Dimension(20, 98));
        panelDJ4.setLayout(new java.awt.GridLayout(2, 3));

        javax.swing.GroupLayout panelJ4Layout = new javax.swing.GroupLayout(panelJ4);
        panelJ4.setLayout(panelJ4Layout);
        panelJ4Layout.setHorizontalGroup(
            panelJ4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelJ4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addGroup(panelJ4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJ4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoleJ4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDJ4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelJ4Layout.setVerticalGroup(
            panelJ4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJ4Layout.createSequentialGroup()
                .addComponent(labelJ4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRoleJ4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDJ4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelJC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelJC.setPreferredSize(new java.awt.Dimension(1060, 147));
        panelJC.setOpaque(false);

        panelNivEau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelNivEauLayout = new javax.swing.GroupLayout(panelNivEau);
        panelNivEau.setLayout(panelNivEauLayout);
        panelNivEauLayout.setHorizontalGroup(
            panelNivEauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        panelNivEauLayout.setVerticalGroup(
            panelNivEauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelJCLayout = new javax.swing.GroupLayout(panelJC);
        panelJC.setLayout(panelJCLayout);
        panelJCLayout.setHorizontalGroup(
            panelJCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJCLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(buttonDC1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDC2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDC3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDC4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDC5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelNivEau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(459, 459, 459))
        );
        panelJCLayout.setVerticalGroup(
            panelJCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNivEau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonDC5, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(buttonDC4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDC3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(main);
        main.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelJC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelTresor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelJ3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelInondation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelJ4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelInondation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTresor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelJC, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        window.pack();
    }// </editor-fold>
    
    private void initGrille() {
        for (int i = 0; i < 6; i++) { // lignes
            for (int j = 0; j < 6; j++) { // colonnes
                TuileGraphique tuile = new TuileGraphique(grille.getTuile(i, j));
                panelGrille.add(tuile);
            }
        }
    }
    
    private void initPlayers() {
        if (listeJoueurs.length >= 2) {
            this.labelJ1.setText(listeJoueurs[0]);
            this.labelJ2.setText(listeJoueurs[1]);
        }
        if (listeJoueurs.length >= 3) this.labelJ3.setText(listeJoueurs[2]);
        if (listeJoueurs.length == 4) this.labelJ4.setText(listeJoueurs[3]);
    }
    
    public void afficher() {
        window.setVisible(true);
    }
    
    public void fermer() {
        window.setVisible(false);
    }
    public void update(){
       window.setVisible(false);
       window.setVisible(true);
    }
}
