package org.example.ui.maps;

import org.example.ui.figures.imageIcons.FigureImageIcons;
import org.example.ui.figures.main.MainFigure;
import org.example.ui.maps.backgrounds.BackGround;
import org.example.ui.maps.elements.MapElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        initKeyListener();
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

    private void initKeyListener() {
        setFocusable(true);
        requestFocusInWindow();
        bindKeyToAction(KeyEvent.VK_W, "moveUp", e -> moveFigure("up"));
        bindKeyToAction(KeyEvent.VK_A, "moveLeft", e -> moveFigure("left"));
        bindKeyToAction(KeyEvent.VK_S, "moveDown", e -> moveFigure("down"));
        bindKeyToAction(KeyEvent.VK_D, "moveRight", e -> moveFigure("right"));
    }

    private void bindKeyToAction(int keyCode, String actionName, ActionListener action) {
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0), actionName);
        getActionMap().put(actionName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(e);
            }
        });
    }

    private void moveFigure(String direction) {
        switch (direction) {
            case "up":
                figure.move(0, -5);
                break;
            case "down":
                figure.move(0, 5);
                break;
            case "left":
                figure.move(-5, 0);
                break;
            case "right":
                figure.move(5, 0);
                break;
        }
        this.repaint();
    }

}
