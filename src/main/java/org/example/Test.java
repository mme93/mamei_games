package org.example;

import javax.swing.*;
import java.awt.*;

import static javax.swing.text.StyleConstants.setBackground;

public class Test extends JPanel {

    private Image backgroundImage;
    private Image mushroomImage;
    private Image knightImage;
    private final int tilesX = 32; // Anzahl der Kacheln in der Breite
    private final int tilesY = 32; // Anzahl der Kacheln in der Höhe

    public Test(String title) {
        setBackground(Color.CYAN); // Cyan-Hintergrund
        loadImages();
        setPreferredSize(new Dimension(800, 800)); // Beispielgröße für das Panel
    }

    private void loadImages() {
        // Hintergrundbild
        backgroundImage = new ImageIcon(getClass().getResource("/maps/background/gras_32.png")).getImage();
        // Pilzbild
        mushroomImage = new ImageIcon(getClass().getResource("/maps/objects/mushroom.png")).getImage();
        // Ritterbild
        knightImage = new ImageIcon(getClass().getResource("/figures/knigh.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hintergrundkacheln zeichnen
        int tileWidth = getWidth() / tilesX;
        int tileHeight = getHeight() / tilesY;

        for (int x = 0; x < tilesX; x++) {
            for (int y = 0; y < tilesY; y++) {
                g.drawImage(backgroundImage, x * tileWidth, y * tileHeight, tileWidth, tileHeight, this);
            }
        }

        // Pilze an relativen Positionen zeichnen
        drawMushrooms(g, tileWidth, tileHeight);

        // Ritter in der Mitte der Karte zeichnen
        int knightX = getWidth() / 2 - knightImage.getWidth(this) / 2;
        int knightY = getHeight() / 2 - knightImage.getHeight(this) / 2;
        g.drawImage(knightImage, knightX, knightY, this);
    }

    private void drawMushrooms(Graphics g, int tileWidth, int tileHeight) {
        // Beispiel für relative Positionen (immer basierend auf der Fenstergröße)
        int[][] mushroomPositions = {
                { (int) (getWidth() * 0.2), (int) (getHeight() * 0.3) },
                { (int) (getWidth() * 0.5), (int) (getHeight() * 0.6) },
                { (int) (getWidth() * 0.8), (int) (getHeight() * 0.2) }
        };

        for (int[] pos : mushroomPositions) {
            g.drawImage(mushroomImage, pos[0], pos[1], tileWidth, tileHeight, this);
        }
    }
}
