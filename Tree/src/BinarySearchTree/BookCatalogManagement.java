
class Node {

    String title, author;
    String ISBN;
    Node left, right;

    public Node(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.left = null;
        this.right = null;
    }
}

class BookCatalog {

    Node root;

    public BookCatalog() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void addBook(String title, String author, String ISBN) {
        Node newBook = new Node(title, author, ISBN);
        if (isEmpty()) {
            root = newBook;
        } else {
            Node current = root;
            while (current.right != null) {
                current = current.right;
            }
            current.right = newBook;
        }
        System.out.println("Added Successful.");
    }

    public Node searchBook(String ISBN) {
        return search(root, ISBN);
    }

    private Node search(Node node, String ISBN) {
        if (node == null || node.ISBN.equals(ISBN)) {
            return node;
        }

        if (ISBN.compareTo(node.ISBN) < 0) {
            return search(node.left, ISBN);
        } else {
            return search(node.right, ISBN);
        }
    }

    // Display all books
    public void displayallBook() {
        Node current = root;
        System.out.println("LIST BOOK:");
        if (isEmpty()) {
            System.out.println("No book catalog or book not found!!");
            return;
        }
        System.out.printf("%-40s%-30s%-20s\n", "Title", "Author", "ISBN");
        while (current != null) {
            System.out.printf("%-40s%-30s%-20s\n", current.title, current.author, current.ISBN);
            current = current.right;
        }
    }

// Display found book
    public void displayBookFound(Node book) {
        System.out.println("\nBOOK FOUNDED:");
        if (book == null) {
            System.out.println("No book catalog or book not found!!");
            return;
        }
        System.out.printf("%-40s%-30s%-20s\n", "Title", "Author", "ISBN");
        System.out.printf("%-40s%-30s%-20s\n", book.title, book.author, book.ISBN);
    }

//
//    public void displayBookDetails(Node node) {
//        if (isEmpty() || node == null) {
//            System.out.println("No book catalog or book not found!!");
//            return;
//        }
//        System.out.printf("%-30s%-30s%-20s\n", "Title", "Author", "ISBN");
//        displayInOrder(node);
//    }
//
//    private void displayInOrder(Node node) {
//        if (node != null) {
//            displayInOrder(node.left);
//            System.out.printf("%-30s%-30s%-20s\n", node.title, node.author, node.ISBN);
//            displayInOrder(node.right);
//        }
//    }
}

public class BookCatalogManagement {

    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();

        catalog.addBook("The Martian", "Andy Weir", "978-0143127796");
        catalog.addBook("The Hunger Games", "Suzanne Collins", "978-0316036733");
        catalog.addBook("Catching Fire", "Suzanne Collins", "978-0439023528");
        catalog.addBook("Harry Potter and the Deathly Hallows", "J.K. Rowling", "978-0545010221");
        catalog.addBook("Project Hail Mary", "Andy Weir", "978-0525555374");
        catalog.addBook("Angels & Demons", "Dan Brown", "978-0671027032");
        catalog.displayallBook();

        String searchISBN = "978-0545010221";
        Node foundBook = catalog.searchBook(searchISBN);
        catalog.displayBookFound(foundBook);
    }
}
