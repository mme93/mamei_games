package org.example.ui.maps;

import org.example.ui.backgrounds.BackGround;
import org.example.ui.elements.mushrooms.Mushrooms;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicMap extends JPanel {
    private List<Mushrooms>elementsList= new ArrayList<>();
    String backgroundTitle;

    public BasicMap(String backgroundTitle, BackGround background) {
        this.backgroundTitle = backgroundTitle;
        setLayout(new BorderLayout());
        add(background, BorderLayout.CENTER);
    }

    public void addElements(Mushrooms mushrooms){
        this.elementsList.add(mushrooms);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Mushrooms mushrooms : elementsList) {
            mushrooms.draw(g);
        }
    }

}
