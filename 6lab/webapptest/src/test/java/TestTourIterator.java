import builderpackage.TourBuilder;
import iteratorpackage.Iterator;
import iteratorpackage.TourIterator;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mainpackage.JspServlet.toursCatalog;
import static org.junit.Assert.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class TestTourIterator {

    @Test
    public void testNext() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Iterator iterator = new TourIterator<>(arrayList);
        iterator.next();
        assertEquals(arrayList.get(1), iterator.next());
    }

    @Test
    public void testHasNext() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Iterator iterator = new TourIterator<>(arrayList);
        assertTrue(iterator.hasNext());
    }
}
