/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Modele.Plateau.Tuile;
import Util.Utils.EtatTuile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Aymerick
 */
class TuileGraphique extends JPanel {
    private final Tuile tuile;
    
    private JLabel labelNom;
    
    private static final Color COULEUR_ASSECHEE = new Color(108, 181, 217);
    private static final Color COULEUR_INONDEE = new Color(10, 147, 216);
    private static final Color COULEUR_COULEE = new Color(3, 53, 79);
    
    public TuileGraphique(Tuile tuile) {
        this.tuile = tuile;
        this.config();
    }
    
    private void config() {
        if (tuile != null) {
            labelNom = new JLabel(tuile.getNomTuile());
            this.add(labelNom);
            
            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {}

                @Override
                public void mousePressed(MouseEvent me) {}

                @Override
                public void mouseReleased(MouseEvent me) {}

                @Override
                public void mouseEntered(MouseEvent me) {
                    setBorder(new LineBorder(Color.WHITE, 3, false));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    setBorder(new EmptyBorder(3, 3, 3, 3));
                }
            });
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        int largeur = this.getWidth();
        int hauteur = this.getHeight();
        
        if (tuile != null) {
            if (tuile.getEtat() == EtatTuile.ASSECHEE) g.setColor(COULEUR_ASSECHEE);
            if (tuile.getEtat() == EtatTuile.INONDEE) g.setColor(COULEUR_INONDEE);
            if (tuile.getEtat() == EtatTuile.COULEE) g.setColor(COULEUR_COULEE);
            g.fillRect(0, 0, largeur, hauteur);
            
            if (tuile.getSpawnPion() != null) {
                g.setColor(tuile.getSpawnPion().getCouleur());
                g.fillOval(5, 25, (int) (largeur * 0.15), (int) (hauteur * 0.15));
                g.setColor(Color.BLACK);
                g.drawOval(5, 25, (int) (largeur * 0.15), (int) (hauteur * 0.15));
            }
            
            if (tuile.getSpawnTresor() != null) {
                Image img = null;
                switch (tuile.getSpawnTresor()) {
                    case CALICE:
                        img = getToolkit().getImage("ressources/tresor/calice.png");
                        break;
                    case CRISTAL:
                        img = getToolkit().getImage("ressources/tresor/cristal.png");
                        break;
                    case PIERRE:
                        img = getToolkit().getImage("ressources/tresor/pierre.png");
                        break;
                    case STATUE:
                        img = getToolkit().getImage("ressources/tresor/statue.png");
                        break;
                }
                g.drawImage(img, 5, 50, (int) (largeur * 0.3), (int) (hauteur * 0.3), this);
            }
        } else {
            g.setColor(COULEUR_COULEE);
            g.fillRect(0, 0, largeur, hauteur);
            Image img = getToolkit().getImage("ressources/tuile/coulee.png");
            g.drawImage(img, 0, 0, largeur, hauteur, this);
        }
        
        
    }
}
