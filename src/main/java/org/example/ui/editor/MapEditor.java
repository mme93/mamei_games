package org.example.ui.editor;

import org.example.ui.maps.elements.imageIcons.ElementsImageIcons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MapEditor extends JPanel {
    private List<Mushroom> mushrooms = new ArrayList<>();
    private BackGround background;

    public MapEditor() {
        setLayout(new BorderLayout());

        // Beispielhintergrund setzen
        background = new BackGround(new ImageIcon("path_to_your_background_image.png"));

        // Mausklick-Listener hinzufügen
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addMushroom(e.getX(), e.getY());
                repaint(); // Neuzeichnen des Panels
            }
        });

        add(background, BorderLayout.CENTER);
    }

    private void addMushroom(int x, int y) {
        mushrooms.add(new Mushroom(x, y, ElementsImageIcons.mushroomIcon.getImage()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.drawBackground(g); // Hintergrund zeichnen
        for (Mushroom mushroom : mushrooms) {
            mushroom.draw(g); // Mushrooms zeichnen
        }
    }

    // Einstiegspunkt
    public static void main(String[] args) {
        JFrame frame = new JFrame("Map Editor");
        MapEditor editor = new MapEditor();
        frame.add(editor);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Mushroom {
    private int x, y;
    private Image image;

    public Mushroom(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, 32, 32, null); // Feste Breite und Höhe für die Pilze
    }
}

class BackGround extends JPanel {
    private Image backgroundImage;

    public BackGround(ImageIcon icon) {
        backgroundImage = icon.getImage();
    }

    public void drawBackground(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }
}
