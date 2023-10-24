package mypackage.strategypackage;

import mypackage.tourpackage.Tour;

import java.util.ArrayList;

public class Context {
    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void executeSortStrategy(ArrayList<Tour> tours) {
        sortStrategy.sort(tours);
    }
}
