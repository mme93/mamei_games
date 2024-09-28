package org.example.ui.maps;

import javax.swing.*;
import java.awt.*;

public class WelcomeMap extends JPanel {
    private Image backgroundImage;
    private Image mushroomImage;
    private Image knightImage;

    public WelcomeMap(String title) {
        setBackground(Color.CYAN);
        loadImages();
        setPreferredSize(new Dimension(800, 800));
    }

    private void loadImages() {
        backgroundImage = new ImageIcon(getClass().getResource("/maps/background/gras_32.png")).getImage();
        mushroomImage = new ImageIcon(getClass().getResource("/maps/objects/mushroom.png")).getImage();
        knightImage = new ImageIcon(getClass().getResource("/figures/knigh.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dynamische Kachelgröße basierend auf Fenstergröße berechnen
        int tileWidth = backgroundImage.getWidth(this);
        int tileHeight = backgroundImage.getHeight(this);

        // Anzahl der Kacheln basierend auf der Fenstergröße berechnen
        int numTilesX = (int) Math.ceil((double) getWidth() / tileWidth);
        int numTilesY = (int) Math.ceil((double) getHeight() / tileHeight);

        // Hintergrund zeichnen (kein Rand bleibt)
        for (int x = 0; x < numTilesX; x++) {
            for (int y = 0; y < numTilesY; y++) {
                g.drawImage(backgroundImage, x * tileWidth, y * tileHeight, tileWidth, tileHeight, this);
            }
        }

        // Pilze an relativen Positionen zeichnen
        drawMushrooms(g);

        // Ritter in der Mitte der Karte zeichnen
        drawKnight(g);
    }

    private void drawMushrooms(Graphics g) {
        // Beispiel für relative Positionen (immer basierend auf der Fenstergröße)
        int[][] mushroomPositions = {
                { (int) (getWidth() * 0.2), (int) (getHeight() * 0.3) },
                { (int) (getWidth() * 0.5), (int) (getHeight() * 0.6) },
                { (int) (getWidth() * 0.8), (int) (getHeight() * 0.2) }
        };

        for (int[] pos : mushroomPositions) {
            g.drawImage(mushroomImage, pos[0], pos[1], 50, 50, this);  // Größe der Pilze anpassen
        }
    }

    private void drawKnight(Graphics g) {
        // Ritter immer relativ in der Mitte der Karte
        int knightX = getWidth() / 2 - knightImage.getWidth(this) / 2;
        int knightY = getHeight() / 2 - knightImage.getHeight(this) / 2;
        g.drawImage(knightImage, knightX, knightY, 100, 100, this);  // Größe des Ritters anpassen
    }
}
