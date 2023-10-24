package mypackage.parsingpackage;

public class Factory {

    public Parser getCurrentParser (int choice) {
        Parser parser = null;
        if (choice == 1)
            parser = new DOMParser();
        else if (choice == 2)
            parser = new SAXParser();

        return parser;
    }
}
