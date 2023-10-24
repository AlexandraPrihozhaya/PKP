package mypackage.drawingpackage;

import mypackage.tourpackage.Tour;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Draw extends JFrame {
    ArrayList<Tour> list;

    public Draw(ArrayList<Tour> list) {
        this.list = list;
        setSize(600,600);
        setVisible(true);
    }

    @Override
    public abstract void paint(Graphics g);
}

