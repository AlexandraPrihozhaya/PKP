import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.xml.sax.SAXException;
import parsingpackage.DOMParser;
import strategypackage.SortByNumberOfDays;
import tourpackage.Tour;

import javax.xml.parsers.ParserConfigurationException;

import java.util.ArrayList;

import static mainpackage.JspServlet.toursCatalog;
import static org.junit.Assert.*;

public class TestSortByNumberOfDays {
    @DisplayName("test SortByNumberOfDays.sort method")
    @RepeatedTest(value = 3, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
    public void testSort() {
        ArrayList<Tour> list = new ArrayList<>();
        list.add(new Tour("Экскурсия в Могилев", 80, "19.11.2023", 3,11));
        list.add(new Tour("Экскурсия в Гродно", 55, "18.11.2023", 2,8));
        list.add(new Tour("Экскурсия в Брест", 96, "17.11.2023", 4,13));
        SortByNumberOfDays sortObject = new SortByNumberOfDays();
        sortObject.sort(list);
        Assertions.assertEquals(list.get(0).getNumberOfDays(), 2);
    }
}
