package org.example.ui.maps.main;

import org.example.ui.backgrounds.dust.Dust;
import org.example.ui.maps.elements.mushrooms.Mushrooms;
import org.example.ui.maps.BasicMap;

public class MainMap extends BasicMap {

    public MainMap(int width, int height) {
        super(new Dust(32, width, height));
        addElement(new Mushrooms(100, 150, 32, 32));
        addElement(new Mushrooms(200, 250, 32, 32));
    }
}
