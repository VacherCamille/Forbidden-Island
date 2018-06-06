/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Aymerick
 */
public class JPanelPerso extends JPanel {
    
    @Override
    public void paintComponent(Graphics g) {
        Image img = Toolkit.getDefaultToolkit().getImage("ressources/IHMtest.png");
        Dimension dimension = this.getSize();
        g.drawImage(img, 0, 0, dimension.width, dimension.height, this);
    }
}
