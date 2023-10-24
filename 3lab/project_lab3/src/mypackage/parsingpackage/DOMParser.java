package mypackage.parsingpackage;

import mypackage.tourpackage.Tour;
import mypackage.iteratorpackage.Iterator;
import mypackage.iteratorpackage.TourIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser implements Parser {

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
                    int numberOfDays = 0;
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
                        else if ("numberOfDays".equals(property.getTagName()))
                            numberOfDays = Integer.parseInt(property.getTextContent());
                        else if ("numberOfPeople".equals(property.getTagName()))
                            numberOfPeople = Integer.parseInt(property.getTextContent());

                    }

                    boolean isContained = false;
                    Tour tourItem = new Tour(title, price, date, numberOfDays, numberOfPeople);
                    Iterator iterator = new TourIterator(TourParser.toursCatalog);
                    while (iterator.hasNext()) {
                        if (tourItem.equals(iterator.next())) {
                            isContained = true;
                            break;
                        }
                    }

                    if (!isContained)
                        TourParser.toursCatalog.add(tourItem);
                }
            }

            for (Tour tour: TourParser.toursCatalog) {
                System.out.println("Название: " + tour.getTitle() + "\nЦена: " + tour.getPrice() + " руб." +
                        "\nДата: " + tour.getDate() + "\nЧисло дней: " + tour.getNumberOfDays() +
                        "\nКоличество людей: " + tour.getNumberOfPeople());
                System.out.println("--------------------");
            }

            //mypackage.drawing.Draw draw = new mypackage.drawing.Draw(tourCatalog);

        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка при создании построителя");
        } catch (IOException e) {
            System.out.println("Файл формата xml не найден в папке проекта");
        } catch (SAXException e) {
            System.out.println("Ошибка при парсинге");
        }
    }
}
