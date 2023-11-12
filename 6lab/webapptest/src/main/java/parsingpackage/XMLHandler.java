package parsingpackage;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    private StringBuilder text = new StringBuilder();
    private String title;
    private int price;
    private String date;

    private int numberOfDays;
    private int numberOfPeople;

    public void startElement(String u, String m, String n, Attributes a) {
        if ("title".equals(n) || "price".equals(n) || "date".equals(n) || "numberOfDays".equals(n) || "numberOfPeople".equals(n)) {
            text.setLength(0);
        }
    }

    public void endElement(String u, String m, String n) {
        if ("tour".equals(n)) {
            if (title != null) {
                System.out.println("Название: " + title);
            }
            if (price != 0) {
                System.out.println("Цена: " + price + " руб.");
            }
            if (date != null) {
                System.out.println("Дата: " + date);
            }
            if (numberOfDays != 0) {
                System.out.println("Число дней: " + numberOfPeople);
            }
            if (numberOfPeople != 0) {
                System.out.println("Количество людей: " + numberOfPeople);
            }
            System.out.println("--------------------");

            title = null;
            price = 0;
            date = null;
            numberOfDays = 0;
            numberOfPeople = 0;
        } else if ("title".equals(n)) {
            title = text.toString();
        } else if ("price".equals(n)) {
            price = Integer.parseInt(text.toString());
        } else if ("date".equals(n)) {
            date = text.toString();
        } else if ("numberOfDays".equals(n)) {
            numberOfDays = Integer.parseInt(text.toString());
        } else if ("numberOfPeople".equals(n)) {
            numberOfPeople = Integer.parseInt(text.toString());
        }
    }

    public void characters(char[] c, int i, int n) {
        text.append(c, i, n);
    }
}
