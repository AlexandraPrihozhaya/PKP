import org.junit.Test;
import parsingpackage.DOMParser;
import parsingpackage.Factory;
import parsingpackage.SAXParser;
import strategypackage.SortByNumberOfDays;
import tourpackage.Tour;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestFactory {
    @Test
    public void testGetCurrentParser() {
        Factory factory = new Factory();
        assertTrue(factory.getCurrentParser(1) instanceof DOMParser);
    }
}
