package iteratorpackage;

import tourpackage.Tour;

import java.util.ArrayList;

public class TourIterator implements Iterator {
    private int pos;
    ArrayList <Tour> tourArray;

    public TourIterator(ArrayList<Tour> tourArray) {
        this.tourArray = tourArray;
    }

    @Override
    public boolean hasNext() {
        return pos < tourArray.size();
    }

    @Override
    public Object next() {
        if(this.hasNext())
            return tourArray.get(pos++);
        return null;
    }
}
