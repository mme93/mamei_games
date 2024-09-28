package org.example.ui.menu;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public Menu() {
        setLayout(new BorderLayout());
        JButton startButton = new JButton("Spiel starten");
        JButton optionsButton = new JButton("Optionen");
        JButton exitButton = new JButton("Beenden");

        // Hier kannst du ActionListener für die Buttons hinzufügen
        startButton.addActionListener(e -> System.out.println("Spiel wird gestartet..."));
        optionsButton.addActionListener(e -> System.out.println("Optionen werden geöffnet..."));
        exitButton.addActionListener(e -> System.exit(0));

        // Füge die Buttons zu einem Panel hinzu
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(exitButton);
        setBackground(Color.red);
        add(buttonPanel, BorderLayout.CENTER);
    }

}
