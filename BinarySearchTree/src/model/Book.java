
package model;

import java.util.Comparator;

public class Book implements Comparator<Book> {
    private String ISBN, Title, Author;

    public Book() {
    }
    

    public Book(String ISBN, String Title, String Author) {
        this.ISBN = ISBN;
        this.Title = Title;
        this.Author = Author;
    }

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    @Override
    public int compare(Book o1, Book o2) {
        return o1.ISBN.compareTo(o2.ISBN);
    }

    @Override
    public String toString() {
        return '{' + "ISBN=" + ISBN + ", Title=" + Title + ", Author=" + Author + '}';
    }
    
}
