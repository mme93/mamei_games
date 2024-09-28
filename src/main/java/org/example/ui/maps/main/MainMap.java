package org.example.ui.maps.main;

import org.example.ui.backgrounds.dust.Dust;
import org.example.ui.elements.imageIcons.ElementsImageIcons;
import org.example.ui.elements.mushrooms.Mushrooms;
import org.example.ui.maps.BasicMap;

public class MainMap extends BasicMap {

    public MainMap(String backgroundTitle) {
        super(backgroundTitle, new Dust());
        addElements(new Mushrooms(100, 150, ElementsImageIcons.mushroomIcon.getImage()));
        addElements(new Mushrooms(200, 150, ElementsImageIcons.mushroomIcon.getImage()));
    }
}
