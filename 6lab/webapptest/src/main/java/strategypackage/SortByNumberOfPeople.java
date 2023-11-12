package strategypackage;

import tourpackage.Tour;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByNumberOfPeople implements SortStrategy {
    @Override
    public void sort(ArrayList<Tour> tours) {
        tours.sort(Comparator.comparing(Tour::getNumberOfPeople));
    }
}
