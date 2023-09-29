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
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        List<Tour> tourCatalog = new ArrayList<>();

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse("scheme.xml");

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

            System.out.println("Туры по Беларуси:\n");
            for (Tour tour:tourCatalog) {
                System.out.println("Название: " + tour.getTitle() + "\nЦена: " + tour.getPrice() + " руб." +
                        "\nДата: " + tour.getDate() + "\nКоличество людей: " + tour.getNumberOfPeople());
                System.out.println("--------------------");
            }

        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка при создании построителя");
        } catch (IOException e) {
            System.out.println("Файл формата xml не найден в папке проекта");
        } catch (SAXException e) {
            System.out.println("Ошибка при парсинге");
        }

        System.out.print("\nВведите номер тура, для которого хотите купить билет: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfTour = scanner.nextInt();

        try {
            //pattern adapter, singleton, state
            Internet internet = Internet.getInstance(tourCatalog.get(numberOfTour - 1));
            internet.buyTicketFromInternet();

            State sellTicket = new SellTicket();
            State buyTicket = new BuyTicket();

            internet.setState(sellTicket);
            internet.doAction();
            internet.setState(buyTicket);
            internet.doAction();

        } catch (Exception e) {
            System.out.println("\nВведено некорректное значение");
        }
    }
}
