
package StackWeb;

class Node {
    
    String info;
    Node next;
    
    Node(String info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    Node(String info) {
        this(info, null);
    }
}

class Stack {
    
    Node head;

    public Stack() {head = null;}
    
    public boolean isEmpty() {return head == null;}
    
    public void push(String info) {
        Node p = new Node(info);
        if(isEmpty()) head = p;
        else {p.next = head; head = p;}
    }
    
    public String pop() {
        if(isEmpty()) return null;
        String info = head.info;
        head = head.next;
        return info;
    }
    
    public String top() {
        if(isEmpty()) return null;
        String info = head.info;
        return info;
    }
    
    public void clear() {head = null;}
    
}

class Web {

    private Stack backButton;
    private Stack forwardButton;
    private String currentPage;

    public Web() {
        backButton = new Stack();
        forwardButton = new Stack();
        currentPage = "Home";
    }

    public void visitPage(String url) {
        System.out.println("Visiting Page: " + url);
        backButton.push(currentPage);
        forwardButton.clear();
        currentPage = url;
    }

    public void goBack() {
        if (!backButton.isEmpty()) {
            forwardButton.push(currentPage);
            currentPage = backButton.pop();
            System.out.println("Back to Page: " + currentPage);
        } else {
            System.out.println("Cannot go back. Back history is empty.");
        }
    }

    public void goForward() {
        if (!forwardButton.isEmpty()) {
            backButton.push(currentPage);
            currentPage = forwardButton.pop();
            System.out.println("Going forward to: " + currentPage);
        } else {
            System.out.println("Cannot go forward. Forward history is empty.");
        }
    }

    public String getCurrentPage() {
        return currentPage;
    }
}

public class LinkedListStack {
     public static void main(String[] args) {
        Web web = new Web();

        web.visitPage("https://dnuni.fpt.edu.vn/");
        web.visitPage("https://www.facebook.com/");
        web.visitPage("https://www.instagram.com/");

        System.out.println("Current Page: " + web.getCurrentPage());

        web.goBack();
        System.out.println("Current Page: " + web.getCurrentPage());

        web.goForward();
        System.out.println("Current Page: " + web.getCurrentPage());

        web.goBack();
        System.out.println("Current Page: " + web.getCurrentPage());
    }
}
