package iteratorpackage;

import tourpackage.Tour;

import java.util.ArrayList;

public class TourIterator<T> implements Iterator {
    private int pos;
    ArrayList <T> tourArray;

    public TourIterator(ArrayList<T> tourArray) {
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
