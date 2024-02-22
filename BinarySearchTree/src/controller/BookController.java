
package controller;

import java.util.ArrayList;
import model.BSTree;
import model.Book;


public class BookController {
    private BSTree data = new BSTree();

    public BookController() {
        data.insert(new Book("978-0143127796","The Martian","Andy Weir"));
        data.insert(new Book("978-0316036733","The Hunger Games","Suzanne Collins"));
        data.insert(new Book("978-0439023528","Catching Fire","Suzanne Collins"));
        data.insert(new Book("978-0545010221","Harry Potter and the Deathly Hallows","J.K. Rowling"));
        data.insert(new Book("978-0525555374","Project Hail Mary","Andy Weir"));
        data.insert(new Book("978-0671027032","Angels & Demons"," Dan Brown"));
    }
    
    public void print(){
        data.inOrder();
        System.out.println("");
    }
    
    public void addBook(Book b){
        data.insert(b);
    }
    
    public void deleteBook(String ISBN){
        data.deleteByMerging(ISBN);
    }
    
    public Book searchBook(String ISBN){
        if(data.search(ISBN)!= null) return data.search(ISBN).getInfo();
        else return null;
    }
}
