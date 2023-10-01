import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParser implements Parser {
    @Override
    public void parse() {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();

            System.out.println("\n=====SAXParsing=====\n");
            parser.parse("parser.xml", handler);

        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка при создании построителя");
        } catch (SAXException e) {
            System.out.println("Ошибка при парсинге");
        } catch (IOException e) {
            System.out.println("Файл формата xml не найден в папке проекта");
        }

    }

    //ParserConfigurationException, SAXException

}
