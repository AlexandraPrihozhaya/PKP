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

public class TourParser {
    public static void main(String[] args) {

        Scanner scanner;
        int choice2;
        do {
            System.out.print("\nВыберите, какой метод хотите использовать для парсинга\n1 - DOMParser\n2 - SAXParser\nВаш выбор: ");

            int choice;
            try {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();

                while (choice != 1 && choice != 2) {
                    System.out.print("Введите корректное значение: ");
                    scanner = new Scanner(System.in);
                    choice = scanner.nextInt();
                }

                Factory factory = new Factory();
                Parser parser = factory.getCurrentParser(choice);
                parser.parse();
            } catch (Exception e) {
                System.out.print("Error");
            }

            System.out.print("\nВведите 1, если хотите продолжить, 2, если хотите выйти: ");
            scanner = new Scanner(System.in);
            choice2 = scanner.nextInt();

        } while(choice2 == 1);



//        System.out.print("\nВведите номер тура, для которого хотите купить билет: ");
//        Scanner scanner = new Scanner(System.in);
//        int numberOfTour = scanner.nextInt();
//
//        try {
//            //pattern adapter, singleton, state
//            Internet internet = Internet.getInstance(tourCatalog.get(numberOfTour - 1));
//            internet.buyTicketFromInternet();
//
//            State sellTicket = new SellTicket();
//            State buyTicket = new BuyTicket();
//
//            internet.setState(sellTicket);
//            internet.doAction();
//            internet.setState(buyTicket);
//            internet.doAction();
//
//        } catch (Exception e) {
//            System.out.println("\nВведено некорректное значение");
//        }
    }
}
