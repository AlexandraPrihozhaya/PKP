import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import strategypackage.SortByNumberOfDays;
import tourpackage.Tour;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestSortByNumberOfPeople {
    @Test
    @DisplayName("test SortByNumberOfPeople.sort method, should be equal")
    public void testSort() {
        ArrayList<Tour> list = new ArrayList<>();
        list.add(new Tour("Экскурсия в Могилев", 80, "19.11.2023", 3,11));
        list.add(new Tour("Экскурсия в Гродно", 55, "18.11.2023", 2,8));
        list.add(new Tour("Экскурсия в Брест", 96, "17.11.2023", 4,13));
        SortByNumberOfDays sortObject = new SortByNumberOfDays();
        sortObject.sort(list);
        assertEquals(list.get(0).getNumberOfPeople(), 8);
    }
}
