package org.example.ui;

import org.example.services.maps.MapName;
import org.example.services.maps.MapService;
import org.example.ui.maps.main.MainMap;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private static CardLayout cardLayout = new CardLayout();
    private static JPanel mainPanel = new JPanel(cardLayout);

    public MainFrame() throws HeadlessException {
        this.initFrame();
        MapService mapService = new MapService();
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
        setResizable(true);
    }

    public void loadLevels() {
        mainPanel.add(new MainMap(getWidth(), getHeight()), MapName.MAIN_MAP);
    }

    public static void changePanel(String title) {
        cardLayout.show(mainPanel, title);
    }
}
