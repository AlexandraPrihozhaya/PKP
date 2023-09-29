public class SellTicket implements State{
    @Override
    public void doAction() {
        System.out.println("\nСостояние 1: билет продан");
    }
}
