package org.example.ui.maps.elements;

import java.awt.*;

public class MapElements {

    private int x_pos;
    private int y_pos;
    private int width;
    private int height;
    private Image elementImage;

    public MapElements(int x_pos, int y_pos, int width, int height, Image elementImage) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.width = width;
        this.height = height;
        this.elementImage = elementImage;
    }

    public void draw(Graphics g) {
        g.drawImage(elementImage, x_pos, y_pos, width, height, null);
    }
}
