import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public interface Parser {
    public void parse() throws ParserConfigurationException, SAXException;
}
