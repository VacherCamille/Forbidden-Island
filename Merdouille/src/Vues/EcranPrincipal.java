/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import MVC.Message;
import MVC.Observe;
import MVC.TypesMessages;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Aymerick
 */
public class EcranPrincipal extends Observe {
    
    // Variables Message Controleur
    private int nbJoueurs;
    private String[] listeJoueurs;
    private String difficulte;
    
    // Variables JFrame
    private JFrame window;
    
    private javax.swing.JComboBox<String> comboBoxDifficulty;
    private javax.swing.JComboBox<String> comboBoxNbJ;
    private javax.swing.JButton demarrer;
    private javax.swing.JLabel labelDifficulty;
    private javax.swing.JLabel labelNbJ;
    private javax.swing.JLabel labelTitre;
    private javax.swing.JButton quitter;
    
    // Variables JDialog associé
    private JDialog dialog;
    
    private javax.swing.JButton buttonGO;
    private javax.swing.JLabel labelDialog;
    private javax.swing.JLabel labelJ1;
    private javax.swing.JLabel labelJ2;
    private javax.swing.JLabel labelJ3;
    private javax.swing.JLabel labelJ4;
    private javax.swing.JTextField textFieldJ1;
    private javax.swing.JTextField textFieldJ2;
    private javax.swing.JTextField textFieldJ3;
    private javax.swing.JTextField textFieldJ4;
    
    // Constructeur
    public EcranPrincipal() {
        this.window = new JFrame("Jeu - Île Interdite");
        this.initWindow();
    }
    
    // ====== JFrame ===========================================================
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initWindow() {

        labelTitre = new javax.swing.JLabel();
        labelNbJ = new javax.swing.JLabel();
        comboBoxNbJ = new javax.swing.JComboBox<>();
        labelDifficulty = new javax.swing.JLabel();
        comboBoxDifficulty = new javax.swing.JComboBox<>();
        demarrer = new javax.swing.JButton();
        quitter = new javax.swing.JButton();

        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(new java.awt.Dimension(720, 480));
        window.setLocationRelativeTo(null);

        labelTitre.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        labelTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitre.setText("L'Île Interdite");
        labelTitre.setToolTipText("");

        labelNbJ.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        labelNbJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNbJ.setText("Nombre de Joueurs :");

        comboBoxNbJ.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        comboBoxNbJ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Joueurs", "3 Joueurs", "4 Joueurs" }));

        labelDifficulty.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        labelDifficulty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDifficulty.setText("Niveau de Difficulté :");

        comboBoxDifficulty.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        comboBoxDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novice", "Normal", "Elite", "Légendaire" }));

        demarrer.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        demarrer.setText("Démarrer le Jeu");
        demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demarrerActionPerformed(evt);
            }
        });

        quitter.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        quitter.setText("Quitter le Jeu");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(window.getContentPane());
        window.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNbJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitre, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                            .addComponent(comboBoxNbJ, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDifficulty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxDifficulty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(demarrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quitter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelNbJ, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(comboBoxNbJ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(demarrer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        window.pack();
    }// </editor-fold>                        

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }                                       

    private void demarrerActionPerformed(java.awt.event.ActionEvent evt) {
        this.difficulte = (String) this.comboBoxDifficulty.getSelectedItem();
        
        dialog = new JDialog(window, "Île Interdite - Nom des Personnages", true);
        this.initDialog();
        
        if (comboBoxNbJ.getSelectedItem().equals("2 Joueurs")) {
            textFieldJ3.setEditable(false);
            textFieldJ4.setEditable(false);
            nbJoueurs = 2;
        } else if (comboBoxNbJ.getSelectedItem().equals("3 Joueurs")) {
            textFieldJ4.setEditable(false);
            nbJoueurs = 3;
        } else {
            nbJoueurs = 4;
        }
        
        dialog.setVisible(true);
    }
    
    // ====== JDialog ==========================================================
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initDialog() {

        labelDialog = new javax.swing.JLabel();
        buttonGO = new javax.swing.JButton();
        labelJ1 = new javax.swing.JLabel();
        labelJ2 = new javax.swing.JLabel();
        labelJ3 = new javax.swing.JLabel();
        labelJ4 = new javax.swing.JLabel();
        textFieldJ1 = new javax.swing.JTextField();
        textFieldJ2 = new javax.swing.JTextField();
        textFieldJ3 = new javax.swing.JTextField();
        textFieldJ4 = new javax.swing.JTextField();

        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setSize(new java.awt.Dimension(350, 500));
        dialog.setLocationRelativeTo(null);

        labelDialog.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        labelDialog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDialog.setText("Nom des Personnages");

        buttonGO.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        buttonGO.setText("C'est parti !");
        buttonGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGOActionPerformed(evt);
            }
        });

        labelJ1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        labelJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ1.setText("Joueur 1 :");

        labelJ2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        labelJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ2.setText("Joueur 2 :");

        labelJ3.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        labelJ3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ3.setText("Joueur 3 :");

        labelJ4.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        labelJ4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJ4.setText("Joueur 4 :");

        textFieldJ1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        textFieldJ1.setForeground(new java.awt.Color(102, 102, 102));

        textFieldJ2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        textFieldJ2.setForeground(new java.awt.Color(102, 102, 102));

        textFieldJ3.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        textFieldJ3.setForeground(new java.awt.Color(102, 102, 102));

        textFieldJ4.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        textFieldJ4.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(dialog.getContentPane());
        dialog.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonGO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDialog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldJ4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldJ1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldJ2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldJ3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldJ1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(labelJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldJ2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldJ3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldJ4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttonGO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        dialog.pack();
    }// </editor-fold>                        

    private void buttonGOActionPerformed(java.awt.event.ActionEvent evt) {                                         
        listeJoueurs = new String[nbJoueurs];
        if (nbJoueurs >= 2) {
            listeJoueurs[0] = textFieldJ1.getText();
            listeJoueurs[1] = textFieldJ2.getText();
        }
        if (nbJoueurs >= 3) listeJoueurs[2] = textFieldJ3.getText();
        if (nbJoueurs == 4) listeJoueurs[3] = textFieldJ4.getText();
        
        Message m = new Message();
        m.type = TypesMessages.DEMARRER_PARTIE;
        m.nbJoueurs = this.nbJoueurs;
        m.listeJoueurs = this.listeJoueurs;
        m.difficulte = this.difficulte;
        notifierObservateur(m);
        
        dialog.setVisible(false);
    }
    
    // =========================================================================
    
    public void afficher() {
        window.setVisible(true);
    }
    
    public void fermer() {
        window.setVisible(false);
    }
}
