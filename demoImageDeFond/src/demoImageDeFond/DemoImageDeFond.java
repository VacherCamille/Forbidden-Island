/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoImageDeFond;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Eric
 * Cette classe contient 3 images superposées : 
 * - une photo de jardin en arrière-plan
 * - une statue en plan intermédiaire
 * - un dragon au premier plan
 */
public class DemoImageDeFond extends JPanel {

    private Image image ;
    private Integer width, height ;
    JLabel titre ;
    JTextField champNom, champPrenom ;

    public DemoImageDeFond(int width, int height) {
        super();
        this.width = width ;
        this.height = height ;
        
        try {
            this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/src/images/ciel.png"));
        } catch (IOException ex) {
            System.err.println("Erreur de lecture de ciel.png");
        }
        
        this.setLayout(new BorderLayout());
        
        titre = new JLabel("Mon IHM", JLabel.CENTER);
        titre.setFont(new Font(titre.getFont().getFamily(), titre.getFont().getStyle(), 24));
        titre.setForeground(Color.ORANGE);
        this.add(titre, BorderLayout.NORTH);

        JPanel panelCentre = new JPanel(new GridLayout(2,2));
        panelCentre.setOpaque(false);
        this.add(panelCentre, BorderLayout.CENTER);

        panelCentre.add(new JLabel("nom : ", JLabel.RIGHT));
        
        champNom = new JTextField();
        panelCentre.add(champNom);

        panelCentre.add(new JLabel("prénom : ", JLabel.RIGHT));
        
        champPrenom = new JTextField();
        panelCentre.add(champPrenom);
        
        JPanel panelBas = new JPanel(new GridLayout());
        panelBas.setOpaque(false);
        this.add(panelBas, BorderLayout.SOUTH);

        panelBas.add(new JLabel(""));
        JButton btnValider = new JButton("Valider");
        panelBas.add(btnValider);
        panelBas.add(new JLabel(""));
        
    }

    @Override
    /**
     * paintComponent permet de gérer l'affichage / la mise à jour des
     * images, à condition que le paintComponent de chaque objet soit appelé
     * avec le même contexte graphique (Graphics)
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, width, height, null, this);
    }
    
    public static void main(String[] args) {
        JFrame window = new JFrame() ;
        window.setSize(450, 300);
        // Centrage de la fenêtre sur l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        window.setLocation(100, dim.height/2-window.getSize().height/2);

        DemoImageDeFond demo = new DemoImageDeFond(450, 300);
        window.add(demo);

        window.setVisible(true);
        demo.repaint();
    }
    
}
