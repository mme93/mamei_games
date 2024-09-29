package org.example.ui.maps;

import org.example.ui.figures.imageIcons.FigureImageIcons;
import org.example.ui.figures.main.MainFigure;
import org.example.ui.maps.backgrounds.BackGround;
import org.example.ui.maps.elements.MapElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class BasicMap extends JPanel {

    private List<MapElements> elements = new ArrayList<>();
    private BackGround background;
    private MainFigure figure;

    public BasicMap(BackGround background) {
        this.background = background;
        figure = generateMainFigure();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moveFigure(e);
            }
        });
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
        figure.drawFigure(g);
    }

    public MainFigure generateMainFigure() {
        return new MainFigure(50, 50, getWidth(), getHeight(), FigureImageIcons.mushroomIcon.getImage());
    }


    private void moveFigure(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // Move Up
                figure.move(0, -5);
                break;
            case KeyEvent.VK_A: // Move Left
                figure.move(-5, 0);
                break;
            case KeyEvent.VK_S: // Move Down
                figure.move(0, 5);
                break;
            case KeyEvent.VK_D: // Move Right
                figure.move(5, 0);
                break;
        }
        this.repaint();
    }
}
