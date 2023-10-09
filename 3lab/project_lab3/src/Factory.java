public class Factory {

    private static Factory instance = null;
    private Factory() {}
    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public Parser getCurrentParser (int choice) {
        Parser parser = null;
        if (choice == 1)
            parser = new DOMParser();
        else if (choice == 2)
            parser = new SAXParser();

        return parser;
    }
}
