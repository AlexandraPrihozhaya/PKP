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

                Factory factory = Factory.getInstance();
                Parser parser = factory.getCurrentParser(choice);
                parser.parse();
            } catch (Exception e) {
                System.out.print("Error");
            }

            System.out.print("\nВведите 1, если хотите продолжить, 2, если хотите выйти: ");
            scanner = new Scanner(System.in);
            choice2 = scanner.nextInt();

        } while(choice2 == 1);

    }
}
