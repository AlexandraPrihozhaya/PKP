package mypackage.builderpackage;

import mypackage.tourpackage.Tour;

public class TourBuilder implements Builder {

    private String title;
    private int price;
    private String date;

    private int numberOfDays;
    private int numberOfPeople;


    @Override
    public Builder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public Builder setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public Builder setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    public Builder setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
        return this;
    }

    @Override
    public Builder setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        return this;
    }

    @Override
    public Tour getResult() {
        return new Tour(title, price, date, numberOfDays, numberOfPeople);
    }
}
