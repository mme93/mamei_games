package org.example.ui.menu;

import org.example.services.maps.MapName;
import org.example.ui.MainFrame;
import org.example.ui.editor.MapEditor;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public Menu() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel welcomeLabel = new JLabel("Willkommen zu Eras of Empire!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.DARK_GRAY);
        add(welcomeLabel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Vertikales Layout mit gleichmäßigen Abständen

        JButton startButton = new JButton("Spiel starten");
        JButton optionsButton = new JButton("Optionen");
        JButton editorButton = new JButton("Editor");
        JButton exitButton = new JButton("Beenden");

        startButton.setPreferredSize(new Dimension(200, 50));
        optionsButton.setPreferredSize(new Dimension(200, 50));
        editorButton.setPreferredSize(new Dimension(200, 50));
        exitButton.setPreferredSize(new Dimension(200, 50));

        startButton.addActionListener(e -> {
            MainFrame.changePanel(MapName.MAIN_MAP);
        });
        optionsButton.addActionListener(e -> System.out.println("Optionen werden geöffnet..."));
        editorButton.addActionListener(e -> {
            MainFrame.changePanel(MapEditor.MAP_EDITOR);
        });
        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(startButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(editorButton);
        buttonPanel.add(exitButton);
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        JPanel centerPanel = new JPanel();
        centerPanel.add(buttonPanel);
        centerPanel.setBackground(Color.LIGHT_GRAY);

        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(Color.LIGHT_GRAY);
        outerPanel.add(centerPanel);

        add(outerPanel, BorderLayout.CENTER);
    }
}
