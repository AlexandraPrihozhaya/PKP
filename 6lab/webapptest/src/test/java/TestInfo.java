import infopackage.Info;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import strategypackage.SortByNumberOfDays;
import tourpackage.Tour;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestInfo {
    private static final ArrayList<Tour> list = new ArrayList<>();

    @BeforeClass
    public static void setup(){
        list.add(new Tour("Экскурсия в Могилев", 80, "19.11.2023", 3,11));
        list.add(new Tour("Экскурсия в Гродно", 55, "18.11.2023", 2,8));
        list.add(new Tour("Экскурсия в Брест", 96, "17.11.2023", 4,13));
    }

    @Test
    public void testFindAverageNumberOfDays() {
        assertEquals(Info.findAverageNumberOfDays(list), 3);
    }

    @Test
    public void testFindAverageNumberOfPeople() {
        assertEquals(Info.findAverageNumberOfPeople(list), 10);
    }

    @Test
    public void testFindAveragePrice() {
        assertEquals(Info.findAveragePrice(list), 77);
    }

    @Test
    public void testFindMaxNumberOfDays() {
        assertEquals(Info.findMaxNumberOfDays(list), 4);
    }

    @Test
    public void testFindMaxNumberOfPeople() {
        assertEquals(Info.findMaxNumberOfPeople(list), 13);
    }

    @Test
    public void testFindMaxPrice() {
        assertEquals(Info.findMaxPrice(list), 96);
    }

    @Test
    public void testFindMinNumberOfDays() {
        assertEquals(Info.findMinNumberOfDays(list), 2);
    }

    @Test
    public void testFindMinNumberOfPeople() {
        assertEquals(Info.findMinNumberOfPeople(list), 8);
    }

    @Test
    public void testFindMinPrice() {
        assertEquals(Info.findMinPrice(list), 55);
    }
}
