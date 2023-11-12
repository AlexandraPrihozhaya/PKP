package tourpackage;

import java.io.Serializable;
import java.util.Objects;

public class Tour {


    private String title;
    private int price;
    private String date;

    private int numberOfDays;
    private int numberOfPeople;


    public Tour(String title, int price, String date, int numberOfDays, int numberOfPeople) {
        this.title = title;
        this.price = price;
        this.date = date;
        this.numberOfDays = numberOfDays;
        this.numberOfPeople = numberOfPeople;
    }

    public Tour() {
        this.title = "";
        this.price = 0;
        this.date = "";
        this.numberOfDays = 0;
        this.numberOfPeople = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public boolean equals(Object obj) {
        Tour tour = (Tour) obj;
        return Objects.equals(tour.getTitle(), this.getTitle()) &&
                tour.getPrice() == this.getPrice() &&
                Objects.equals(tour.getDate(), this.getDate()) &&
                tour.getNumberOfDays() == this.getNumberOfDays() &&
                tour.getNumberOfPeople() == this.getNumberOfPeople();
    }

}