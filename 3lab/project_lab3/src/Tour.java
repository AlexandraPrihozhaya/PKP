public class Tour {
    private String title;
    private int price;
    private String date;
    private int numberOfPeople;

    public Tour(String title, int price, String date, int numberOfPeople) {
        this.title = title;
        this.price = price;
        this.date = date;
        this.numberOfPeople = numberOfPeople;
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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
}
