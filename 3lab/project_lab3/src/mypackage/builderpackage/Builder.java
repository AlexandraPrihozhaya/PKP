package mypackage.builderpackage;

import mypackage.tourpackage.Tour;

public interface Builder {
    public Builder setTitle(String title);
    public Builder setPrice(int price);
    public Builder setDate(String date);

    public Builder setNumberOfDays(int numberOfDays);

    public Builder setNumberOfPeople(int numberOfPeople);
    public Tour getResult();
}
