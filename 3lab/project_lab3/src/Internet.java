public class Internet implements Reservation, State {
    private static Internet internet = null;
    private State state;
    private Tour tour;

    private Internet (Tour tour) {
        this.tour = tour;
    }
    public static Internet getInstance(Tour tour) {
        if (internet == null) {
            internet = new Internet(tour);
        }
        return internet;
    }

    @Override
    public void buyTicketFromInternet() {
        this.tour.payTicket();
        this.tour.buyTicket();
    }

    public void setState(State state){
        this.state = state;
    }

    @Override
    public void doAction() {
        this.state.doAction();
    }
}