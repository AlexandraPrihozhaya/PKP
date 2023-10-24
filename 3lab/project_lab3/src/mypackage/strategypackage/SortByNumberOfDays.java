package mypackage.strategypackage;

import mypackage.tourpackage.Tour;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByNumberOfDays implements SortStrategy {
    @Override
    public void sort(ArrayList<Tour> tours) {
        tours.sort(Comparator.comparing(Tour::getNumberOfDays));
    }
}
