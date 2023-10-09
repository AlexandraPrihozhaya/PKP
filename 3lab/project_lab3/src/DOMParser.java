import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements Parser {
    ArrayList<Tour> tourCatalog = new ArrayList<>();

    @Override
    public void parse() {

        try {
            System.out.println("\n=====DOMParsing=====\n");

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse("parser.xml");

            Element tourcat = document.getDocumentElement();

            if ("tourCatalog".equals(tourcat.getTagName())) {

                NodeList tours = tourcat.getElementsByTagName("tour");
                for (int i = 0; i < tours.getLength(); i++) {

                    Element tour = (Element) tours.item(i);
                    String title = null;
                    int price = 0;
                    String date = null;
                    int numberOfPeople = 0;

                    NodeList properties = tour.getElementsByTagName("*");
                    for (int j = 0; j < properties.getLength(); j++) {

                        Element property = (Element) properties.item(j);
                        if ("title".equals(property.getTagName()))
                            title = property.getTextContent();
                        else if ("price".equals(property.getTagName()))
                            price = Integer.parseInt(property.getTextContent());
                        else if ("date".equals(property.getTagName()))
                            date = property.getTextContent();
                        else if ("numberOfPeople".equals(property.getTagName()))
                            numberOfPeople = Integer.parseInt(property.getTextContent());
                    }

                    Tour tourItem = new Tour(title, price, date, numberOfPeople);
                    tourCatalog.add(tourItem);
                }
            }

            //табличка
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("|\t\t\tНазвание\t\t\t|\t" + "Цена\t|\t\t" + "Дата\t|\t" + "Количество людей\t|");
            System.out.println("-------------------------------------------------------------------------------------");
            for (Tour tour:tourCatalog) {
                System.out.println("|  " + tour.getTitle() + "\t|\t" + tour.getPrice() +
                        "\t\t|\t" + tour.getDate() + "\t|\t\t\t" + tour.getNumberOfPeople() + "\t\t\t|");
                System.out.println("-------------------------------------------------------------------------------------");
            }

//            for (Tour tour:tourCatalog) {
//                System.out.println("Название: " + tour.getTitle() + "\nЦена: " + tour.getPrice() + " руб." +
//                        "\nДата: " + tour.getDate() + "\nКоличество людей: " + tour.getNumberOfPeople());
//                System.out.println("--------------------");
//            }

            //Draw draw = new Draw(tourCatalog);

        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка при создании построителя");
        } catch (IOException e) {
            System.out.println("Файл формата xml не найден в папке проекта");
        } catch (SAXException e) {
            System.out.println("Ошибка при парсинге");
        }
    }
}
