import builderpackage.TourBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import tourpackage.Tour;

import static org.junit.Assert.*;

public class TestTourBuilder {
    @ParameterizedTest
    @ValueSource(strings = { "Экскурсия в Могилев", "Экскурсия в Брест" })
    public void testSetTitle(String title) {
        TourBuilder tourBuilder = new TourBuilder();
        Assertions.assertNotNull(tourBuilder.setTitle(title));
    }

    @ParameterizedTest
    @ValueSource(ints = { 80, 0 })
    public void testSetPrice(int price) {
        TourBuilder tourBuilder = new TourBuilder();
        Assertions.assertNotNull(tourBuilder.setPrice(price));
    }

    @ParameterizedTest
    @NullSource
    public void testSetDate(String date) {
        TourBuilder tourBuilder = new TourBuilder();
        Assertions.assertNotNull(tourBuilder.setDate(date));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 10, 21 })
    public void testSetNumberOfDays(int numberOfDays) {
        TourBuilder tourBuilder = new TourBuilder();
        Assertions.assertNotNull(tourBuilder.setNumberOfDays(numberOfDays));
    }


    @ParameterizedTest
    @ValueSource(ints = { 0, 2, 20 })
    public void testSetNumberOfPeople(int numberOfPeople) {
        TourBuilder tourBuilder = new TourBuilder();
        Assertions.assertNotNull(tourBuilder.setNumberOfPeople(numberOfPeople));
    }

    @ParameterizedTest
    @CsvSource({
            "Экскурсия в Могилев, 80, 19.11.2023, 3, 11",
            "Экскурсия в Гродно, 65, 20.11.2023, 2, 4"
    })
    public void testGetResult(String title, int price, String date, int numberOfDays, int numberOfPeople) {
        TourBuilder tourBuilder = new TourBuilder();
        tourBuilder.setTitle(title).setPrice(price).setDate(date).setNumberOfDays(numberOfDays).setNumberOfPeople(numberOfPeople);
        Assertions.assertNotNull(tourBuilder.getResult());
    }
}
