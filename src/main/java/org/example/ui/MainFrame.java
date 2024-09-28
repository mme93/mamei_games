package org.example.ui;

import org.example.services.maps.MapService;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private CardLayout cardLayout = new CardLayout();

    public MainFrame() throws HeadlessException {
        this.initFrame();
        MapService mapService = new MapService();
        JPanel mainPanel = new JPanel(cardLayout);
        mainPanel.add(mapService.loadMenu(), "Menu");
        add(mainPanel);
        this.cardLayout.show(mainPanel, "Menu");
    }

    private void initFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Eras of Empire");
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void changePanel(JPanel panel, String title) {
        cardLayout.show(panel, title);
    }
}
