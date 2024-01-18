
package OrderProcessingSystem;

class Product {
    String name;
    int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

//cái Node sẽ chứa dữ liệu của một món hàng được order bởi khách hàng
//orderId được set up như vậy bởi vì một khách hàng có thể order cùng lúc nhiều món hàng nhưng sẽ có thể đặt mua một ít trong đó
class Order{
    int orderId;
    String customerName;
    Product product;
    String status;
    int quantity;
   
    public Order(int orderId, String customerName, Product product,int quantity){
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.quantity= quantity;
        this.status = "Pending"; 
    }
}

class Node {
    Order info;
    Node next;
    
    public Node(Order info ,Node next) {
        this.info=info;
        this.next = next;
    }
    
    public Node(Order info) {
        this(info,null);
    }
}

class Inventory {
    static int getProductAvailability(Product product) {
        return product.quantity;
    }

    static void updateInventory(Product product, int soldQuantity) {
        product.quantity -= soldQuantity;
    }
}

class MyQueue{ 
    protected Node head,tail;

    public MyQueue(){ 
        head = tail = null; 
    }

    public boolean isEmpty(){ 
        return(head==null);
    }

    Order front() throws Exception{ 
        if(isEmpty()) throw new Exception();
        return(head.info);
    }
    
    public Order dequeue() throws Exception{ 
        if(isEmpty()) throw new Exception();
        Order x = head.info;
        head=head.next;
        if(head==null) tail=null;
        return(x);
    }
    
    public Order poll() { 
        if(isEmpty()) return null ;
        Order x = head.info;
        head=head.next;
        if(head==null) tail=null;
        return(x);
    }

    void enqueue(Order x){ 
        if(isEmpty()) head = tail = new Node(x);
        else{ 
            tail.next = new Node(x);
            tail = tail.next;
        }
    }
}

public class LinkedListQueue {
    private MyQueue orderQueue= new MyQueue();
    public void addOrderToQueue(Order order) {
        orderQueue.enqueue(order);
    }
    
    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            System.out.println("Processing Order: " + order.orderId + "-"+order.product.name);

            int availableQuantity = Inventory.getProductAvailability(order.product);
            int getQuantity = order.quantity;

            if (availableQuantity - getQuantity>= 0) {
                order.status = "Processing";
                System.out.println("Order " + order.orderId + " is being processed.");

                order.status = "Payment Confirmed";
                System.out.println("Payment confirmed for Order " + order.orderId);

                order.status = "Shipped";
                System.out.println("Order " + order.orderId + " has been shipped.");

                Inventory.updateInventory(order.product, getQuantity);

                order.status = "Delivered";
                System.out.println("Order " + order.orderId + " has been delivered.\n");
            } else {
                System.out.println("Insufficient stock for Order " + order.orderId + ". Cannot process.\n");
            }
        }
    }
    
    public static void main(String[] args) {
        LinkedListQueue queue=new LinkedListQueue();
        Product product1 = new Product("Laptop", 10);
        Product product2 = new Product("Smartphone", 20);
        Product product3 = new Product("Headphone",10);

        Order order1 = new Order(1, "John Doe", product1,2);
        Order order2 = new Order(2, "Jane Smith", product2,3);
        Order order3 = new Order(1, "John Doe",product3,2);
        queue.addOrderToQueue(order1);
        queue.addOrderToQueue(order2);
        queue.addOrderToQueue(order3);
        
        queue.processOrders();
    }
}
