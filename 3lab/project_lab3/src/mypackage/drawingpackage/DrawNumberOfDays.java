package mypackage.drawingpackage;

import mypackage.tourpackage.Tour;

import java.awt.*;
import java.util.ArrayList;

public class DrawNumberOfDays extends Draw {
    public DrawNumberOfDays(ArrayList<Tour> list) {
        super(list);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;

        Rectangle rect = null;
        int x = 40;
        int start = 590;

        gr2d.setColor(Color.BLUE);
        for (Tour tour : list) {
            //rect = new Rectangle(x, start - tour.getNumberOfPeople() * 20, 40, tour.getNumberOfPeople() * 20);
            gr2d.fillRect(x, start - tour.getNumberOfDays() * 100, 40, tour.getNumberOfPeople() * 100);
            //gr2d.draw(rect);
            //gr2d.drawString(String.valueOf(tour.getNumberOfPeople()), x + 20, start - tour.getNumberOfPeople() * 20 - 10);
            x += 80;
        }
    }
}
