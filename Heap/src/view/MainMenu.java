
package view;

public class MainMenu extends Menu {
    private static String[] mc={"Run Default Data","Add Flight","Print Priority Flight","Exit"};
    private FlightView fView = new FlightView();

    public MainMenu() {
        super("E-commerce Product Inventory", mc);
    }

    @Override
    public void execute(int ch) {
        switch(ch){
            case 1: fView.example();break;
            case 2: fView.addFlight();System.err.flush();break;
            case 3: fView.print();break;
            case 4: System.exit(0);
        }
    }

}
