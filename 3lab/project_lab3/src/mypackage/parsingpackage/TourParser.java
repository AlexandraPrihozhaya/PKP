package mypackage.parsingpackage;

import mypackage.drawingpackage.Draw;
import mypackage.drawingpackage.DrawNumberOfDays;
import mypackage.drawingpackage.DrawNumberOfPeople;
import mypackage.drawingpackage.DrawPrice;
import mypackage.strategypackage.Context;
import mypackage.strategypackage.SortByNumberOfDays;
import mypackage.strategypackage.SortByNumberOfPeople;
import mypackage.strategypackage.SortByPrice;
import mypackage.tourpackage.Tour;
import mypackage.builderpackage.Builder;
import mypackage.builderpackage.TourBuilder;

import java.util.ArrayList;
import java.util.Scanner;
public class TourParser {

    static ArrayList<Tour> toursCatalog = new ArrayList<>();



    public static void main(String[] args) {

        Scanner scanner;
        int choice2;
        while (true) {
            System.out.print("\nВведите\n1, если хотите просмотреть туры,\n2, если хотите спарсить данные," +
                    "\n3, если хотите добавить тур,\n4, если хотите отсортировать данные,\n5, если хотите построить график," +
                    "\n6, если хотите выйти:\nВаш выбор: ");

            scanner = new Scanner(System.in);
            choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    printTours();
                    break;
                case 2:
                    chooseParsing();
                    break;
                case 3:
                    addTour();
                    break;
                case 4:
                    sortTours();
                    break;
                case 5:
                    chooseDrawing();
                    break;
                case 6:
                    return;
            }
        }
    }

    private static void sortTours() {
        System.out.print("\nВыберите, по какому полю хотите отсортировать данные\n1 - количество человек\n2 - число дней\n3 - цена\nВаш выбор: ");
        int choice;
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            while (choice != 1 && choice != 2 && choice != 3) {
                System.out.print("Введите корректное значение: ");
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            }

            Context context = new Context();

            switch (choice) {
                case 1:
                    context.setSortStrategy(new SortByNumberOfPeople());
                    break;
                case 2:
                    context.setSortStrategy(new SortByNumberOfDays());
                    break;
                case 3:
                    context.setSortStrategy(new SortByPrice());
                    break;
            }

            context.executeSortStrategy(toursCatalog);
            printTours();


        } catch (Exception e) {
            System.out.print("Error\n");
        }
    }

    private static void chooseDrawing() {
        System.out.print("\nВыберите, какой график хотите построить\n1 - количество человек\n2 - число дней\n3 - цена\nВаш выбор: ");
        int choice;
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            while (choice != 1 && choice != 2 && choice != 3) {
                System.out.print("Введите корректное значение: ");
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            }

            switch (choice) {
                case 1:
                    Draw draw = new DrawNumberOfPeople(toursCatalog);
                    break;
                case 2:
                    Draw draw2 = new DrawNumberOfDays(toursCatalog);
                    break;
                case 3:
                    Draw draw3 = new DrawPrice(toursCatalog);
                    break;
            }

        } catch (Exception e) {
            System.out.print("Error\n");
        }
    }

    public static void printTours() {
        System.out.println("\n-----------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\tНазвание\t\t\t|\t" + "Цена\t|\t\t" + "Дата\t|\t" + "Число дней\t|\t" + "Количество людей\t|");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Tour tour: toursCatalog) {
            System.out.println("|  " + tour.getTitle() + "\t|\t" + tour.getPrice() +
                    "\t\t|\t" + tour.getDate() + "\t|\t\t" + tour.getNumberOfDays() + "\t\t|\t\t\t" + tour.getNumberOfPeople() + "\t\t\t|");
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
    }

    public static void addTour() {
        System.out.print("\nНазвание: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.print("Цена: ");
        int price;
        try {
            scanner = new Scanner(System.in);
            price = scanner.nextInt();
        } catch (Exception e) {
            System.out.print("Введите корректную цену: ");
            scanner = new Scanner(System.in);
            price = scanner.nextInt();
        }
        System.out.print("Дата: ");
        scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        System.out.print("Число дней: ");
        int numberOfDays;
        try {
            scanner = new Scanner(System.in);
            numberOfDays = scanner.nextInt();
        } catch (Exception e) {
            System.out.print("Введите корректное число дней: ");
            scanner = new Scanner(System.in);
            numberOfDays = scanner.nextInt();
        }
        System.out.print("Количество человек: ");
        int numberOfPeople;
        try {
            scanner = new Scanner(System.in);
            numberOfPeople = scanner.nextInt();
        } catch (Exception e) {
            System.out.print("Введите корректное количество человек: ");
            scanner = new Scanner(System.in);
            numberOfPeople = scanner.nextInt();
        }

        Builder builder =  new TourBuilder();
        builder.setTitle(title).setPrice(price).setDate(date).setNumberOfDays(numberOfDays).setNumberOfPeople(numberOfPeople);
        Tour newTour = builder.getResult();
        toursCatalog.add(newTour);
    }

    public static void chooseParsing () {
        System.out.print("\nВыберите, какой метод хотите использовать для парсинга\n1 - DOMParser\n2 - SAXParser\nВаш выбор: ");
        int choice;
        try {
            Scanner scanner = new Scanner(System.in);
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
            System.out.print("Error\n");
        }
    }
}
