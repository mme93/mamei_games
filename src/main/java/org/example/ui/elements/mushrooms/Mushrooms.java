package org.example.ui.elements.mushrooms;

import org.example.ui.elements.Elements;

import java.awt.*;

public class Mushrooms extends Elements {

    private Image mushroomImage;
    private int x, y;

    public Mushrooms(int x, int y, Image mushroomImage) {
        this.x = x;
        this.y = y;
        this.mushroomImage = mushroomImage;
    }

    public void draw(Graphics g) {
        if (mushroomImage != null) {
            g.drawImage(mushroomImage, getX(), getY(), null);
        } else {
            System.out.println("Mushroom image is null");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
