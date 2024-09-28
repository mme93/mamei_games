package org.example.ui.figures.main;

import java.awt.*;

public class MainFigure {

    private int x_pos;
    private int y_pos;
    private int width;
    private int height;
    private Image figureImage;

    public MainFigure(int x_pos, int y_pos, int width, int height, Image figureImage) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.width = width;
        this.height = height;
        this.figureImage = figureImage;
    }

    public void drawFigure(Graphics g) {
        g.drawImage(figureImage, x_pos, y_pos,35,60,null);
    }

    public void move(int dx, int dy) {
        this.x_pos += dx;
        this.y_pos += dy;
    }

}
