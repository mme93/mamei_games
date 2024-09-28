package org.example.ui.backgrounds;

import javax.swing.*;
import java.awt.*;

public class BackGround extends JPanel {

    private Image backgroundImage;
    private final int tileSize = 32;
    private ImageIcon icon;


    public BackGround(ImageIcon icon) {
        this.icon = icon;
        loadBackgroundImage();
    }

    private void loadBackgroundImage() {
        backgroundImage = icon.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.err.println("Paint");
        int numTilesX = (int) Math.ceil((double) getWidth() / tileSize);
        int numTilesY = (int) Math.ceil((double) getHeight() / tileSize);

        for (int x = 0; x < numTilesX; x++) {
            for (int y = 0; y < numTilesY; y++) {
                g.drawImage(backgroundImage, x * tileSize, y * tileSize, tileSize, tileSize, this);
            }
        }
    }

    public Image getBackgroundImage() {
        return this.backgroundImage;
    }

}
