
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

class MyQueue { 
    protected Order [] a;
    protected int max;
    protected int first, last;

    public MyQueue(){ 
        this(10);
    }
    
    public MyQueue(int max1){
        max = max1;
        a = new Order[max];
        first = last = -1;
    }
    
    public boolean isEmpty(){ 
        return(first==-1);
    }

    public boolean isFull(){ 
        return((first == 0 && last == max-1) || first == last+1);
    }
    
    private boolean grow(){ 
        int i,j;
        int max1 = max + max/2;
        Order [] a1 = new Order[max1];
        if(a1 == null) return(false);
        if(last>=first)
            for(i=first;i<=last;i++) a1[i-first]=a[i];
        else { 
            for(i=first;i<max;i++) a1[i-first]=a[i];
            i = max-first;
            for(j=0;j<=last;j++) a1[i+j]=a[j];
        }
        a = a1;
        first = 0;         
        last = max-1;
        max = max1;
        return(true); 
    }
    
    void enqueue(Order x){ 
        if(isFull() && !grow()) return;
        if(last == max-1 || last == -1){ 
            a[0] = x; last=0;
            if(first==-1) first = 0;
        }else   a[++last] = x;
    }
    
    Order front() throws Exception{ 
        if(isEmpty()) throw new Exception();
        return(a[first]);
    }
    
    public Order dequeue() throws Exception{ 
        if(isEmpty()) throw new Exception();
        Order x = a[first];
        if(first == last){
            first = last = -1;
        }else if(first==max-1) first = 0;
            else first++;
        return(x);
    }
    
    public Order poll() { 
        if(isEmpty()) return null;
        Order x = a[first];
        if(first == last){
            first = last = -1;
        }else if(first==max-1) first = 0;
            else first++;
        return(x);
    }
}

public class ArrayQueue {
    private MyQueue orderQueue= new MyQueue();
    public void addOrderToQueue(Order order) {
        orderQueue.enqueue(order);
    }
    
    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            System.out.println("Processing Order: " + order.orderId+ "-"+order.product.name);

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
