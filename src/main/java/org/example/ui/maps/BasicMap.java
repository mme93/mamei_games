package org.example.ui.maps;

import org.example.ui.backgrounds.BackGround;
import org.example.ui.maps.elements.MapElements;
import org.example.ui.maps.elements.mushrooms.Mushrooms;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicMap extends JPanel {
    private List<MapElements> elements = new ArrayList<>();
    private String backgroundTitle;
    private BackGround background;

    public BasicMap(String backgroundTitle, BackGround background) {
        this.backgroundTitle = backgroundTitle;
        this.background = background;
    }

    public void addElement(MapElements element) {
        elements.add(element);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null && background.getBackgroundImage() != null) {


            g.drawImage(background.getBackgroundImage(), 0, 0, getWidth(), getHeight(), null);

            int numTilesX = (int) Math.ceil((double) getWidth() / 32);
            int numTilesY = (int) Math.ceil((double) getHeight() / 32);

            for (int x = 0; x < numTilesX; x++) {
                for (int y = 0; y < numTilesY; y++) {
                    g.drawImage(background.getBackgroundImage(), x * 32, y * 32, 32, 32, this);
                }
            }

        }

        for (MapElements elements : elements) {
            elements.draw(g);
        }
    }

}
