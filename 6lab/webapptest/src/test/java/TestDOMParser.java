import builderpackage.TourBuilder;
import org.junit.Test;
import org.xml.sax.SAXException;
import parsingpackage.DOMParser;

import javax.xml.parsers.ParserConfigurationException;
import static mainpackage.JspServlet.toursCatalog;

import static org.junit.Assert.*;

public class TestDOMParser {
    @Test
    public void testParse() throws ParserConfigurationException, SAXException {
        DOMParser parser = new DOMParser();
        parser.parse();
        assertFalse(toursCatalog.isEmpty());
    }
}
