
package view;

public class MainMenu extends Menu {
    private static String[] mc={"Run Default Data","Add Book","Delete Book","Search Book","Print","Exit"};
    private BookView bView = new BookView();

    public MainMenu() {
        super(" E-commerce Product Inventory", mc);
    }

    @Override
    public void execute(int ch) {
        switch(ch){
            case 1: bView.example();break;
            case 2: bView.addBook();System.err.flush();break;
            case 3: bView.deleteBook();System.err.flush();break;
            case 4: bView.searchBook();System.err.flush();break;
            case 5: bView.print();break;
            case 6: System.exit(0);
        }
    }

}
