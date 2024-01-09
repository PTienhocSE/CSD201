package DoubleLinkedList;

class Node {

    String item;
    int quantity;
    double price;
    Node next;
    Node prev;

    public Node(String item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }
}

public class ShoppingCart {

    private Node head;
    private Node tail;

    public ShoppingCart() {
    }

    public void addItem(String item, int quantity, double price) {
        Node newItem = new Node(item, quantity, price);
        if (head == null) {
            head = newItem;
            tail = newItem;
        } else {
            newItem.prev = tail;
            tail.next = newItem;
            tail = newItem;
        }
        System.out.println("Added Item: " + item);
    }

    public void removeItem(String item) {
        Node current = head;

        while (current != null) {
            if (current.item.equals(item)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                System.out.println("Item removed: " + item);

            }

            current = current.next;
        }

        System.out.println("Item not found: " + item);
    }

    public void adjustQuantity(String item, int newQuantity) {
        Node current = head;

        while (current != null) {
            if (current.item.equals(item)) {
                current.quantity = newQuantity;
                System.out.println("New quantity was change.");
            }

            current = current.next;
        }

        System.out.println("Item not found:" + item);
    }

    public void display() {
        Node current = head;
        System.out.println("SHOPPING CART:");
        if (current == null) {
            System.out.println("Shopping cart is empty.");
            return;
        }
        while (current != null) {
            System.out.println(current.item + " - Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Acer Nitro 5", 1, 20000000);
        cart.addItem("Macbook Pro M2", 2, 50000000);
        cart.addItem("Iphone 15 ProMax", 1, 30000000);

        cart.display();

        cart.adjustQuantity("Iphone 15 ProMax", 3);
        cart.removeItem("Acer Nitro 5");

        cart.display();
    }
}
