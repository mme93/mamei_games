package org.example.ui.backgrounds;

import javax.swing.*;
import java.awt.*;

public class BackGround {

    private Image backgroundImage;
    private int tileSize;
    private ImageIcon icon;
    private int width;
    private int height;


    public BackGround(ImageIcon icon, int tileSize, int width, int height) {
        this.tileSize = tileSize;
        this.icon = icon;
        this.width = width;
        this.height = height;
        loadBackgroundImage();
    }

    private void loadBackgroundImage() {
        backgroundImage = icon.getImage();
    }


    public void drawBackground(Graphics g) {
        int numTilesX = (int) Math.ceil((double) width / tileSize);
        int numTilesY = (int) Math.ceil((double) height / tileSize);
        for (int x = 0; x < numTilesX; x++) {
            for (int y = 0; y < numTilesY; y++) {
                g.drawImage(backgroundImage, x * tileSize, y * tileSize, tileSize, tileSize, null);
            }
        }
    }

    public Image getBackgroundImage() {
        return this.backgroundImage;
    }

}
