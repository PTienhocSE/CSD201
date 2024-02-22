
package view;

public class MainMenu extends Menu {
    private static String[] mc={"Run Default Data","Add Contact","Delete Book","Search Contact","Print","Exit"};
    private ContactView bView = new ContactView();

    public MainMenu() {
        super("Contact Book Application", mc);
    }

    @Override
    public void execute(int ch) {
        switch(ch){
            case 1: bView.example();break;
            case 2: bView.addContact();System.err.flush();break;
            case 3: bView.deleteContact();System.err.flush();break;
            case 4: bView.searchContact();System.err.flush();break;
            case 5: bView.print();break;
            case 6: System.exit(0);
        }
    }

}
