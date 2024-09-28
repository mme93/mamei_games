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
        background.drawBackground(g);
        for (MapElements elements : elements) {
            elements.draw(g);
        }
    }

}
