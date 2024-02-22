
package view;

import Library.Validation;
import controller.BookController;
import model.Book;

public class BookView {
    private Validation val = new Validation();
    private BookController controller = new BookController();
    
    public void example(){
        System.out.println("----------------Default----------------");
        controller.print();
    }
    
    public void addBook(){
        String ISBN = val.getString("Enter ISBN");
        String title = val.getWord("Enter Title");
        String author = val.getWord("Enter Author");
        controller.addBook(new Book(ISBN,title,author));
        System.err.flush();
    }
    
    public void deleteBook(){
        String ISBN = val.getString("Enter ISBN");
        controller.deleteBook(ISBN);
        System.err.flush();
    }
    
    public void searchBook(){
        String ISBN = val.getString("Enter ISBN");
        Book a = controller.searchBook(ISBN);
        if(a != null){
            System.out.println(a);
        }else {
            System.err.println("Don't find !!!");
        }
        System.err.flush();
    }
    
    public void print(){
        controller.print();
    }
}
