package org.example.ui.maps.elements.mushrooms;

import org.example.ui.maps.elements.MapElements;
import org.example.ui.maps.elements.imageIcons.ElementsImageIcons;

import java.awt.*;

public class Mushrooms extends MapElements {

    public Mushrooms(int x_pos, int y_pos, int width, int height) {
        super(x_pos, y_pos, width, height,  ElementsImageIcons.mushroomIcon.getImage());
    }

    public void draw(Graphics g){
       super.draw(g);
    }

}
