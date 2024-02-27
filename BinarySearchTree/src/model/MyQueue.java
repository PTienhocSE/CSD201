package model;

//class Node {
//
//    public Object info;
//    public Node next;
//
//    public Node(Object info, Node next) {
//        this.info = info;
//        this.next = next;
//    }
//
//    public Node(Object info) {
//        this(info, null);
//    }
//};
//
//public class MyQueue {
//
//    public Node head, tail;
//
//    public MyQueue() {
//        head = tail = null;
//    }
//
//    public boolean isEmpty() {
//        return (head == null);
//    }
//
//    Object front() {
//        if (isEmpty()) {
//            return null;
//        }
//        return (head.info);
//    }
//
//    public Object dequeue() {
//        if (isEmpty()) {
//            return null;
//        }
//        Object x = head.info;
//        head = head.next;
//        if (head == null) {
//            tail = null;
//        }
//        return (x);
//    }
//
//    void enqueue(Object x) {
//        if (isEmpty()) {
//            head = tail = new Node(x);
//        } else {
//            tail.next = new Node(x);
//            tail = tail.next;
//        }
//    }
//
//}

class Flight implements Comparable<Flight> {
    private String flightNumber;
    private String takeoffTime;
    private String destination;
    private String status;

    public Flight(String flightNumber, String takeoffTime, String destination, String status) {
        this.flightNumber = flightNumber;
        this.takeoffTime = takeoffTime;
        this.destination = destination;
        this.status = status;
    }

    public String getTakeoffTime() {
        return takeoffTime;
    }
    
    @Override
    public int compareTo(Flight otherFlight) {
        return this.takeoffTime.compareTo(otherFlight.getTakeoffTime());
    }
    
    //DISPLAY
    public static void displayAllFlights(Flight[] flights) {
        System.out.println("FLIGHTS:");
        System.out.printf("%-10s%-20s%-15s%-10s\n", "Number", "Takeoff Time", "Destination", "Status");
        for (Flight flight : flights) {
            System.out.printf("%-10s%-20s%-15s%-10s\n",
                    flight.flightNumber, flight.takeoffTime, flight.destination, flight.status);
        }
    }
}

public class MyQueue {
    public static int PARENT(int i) {
        return (i - 1) / 2;
    }

    public static int LEFT(int i) {
        return 2 * i + 1;
    }

    public static int RIGHT(int i) {
        return 2 * (i + 1);
    }

//    public static void heapify(Flight[] flights, int n) {
//        for (int i = 1; i < n; i++) {
//            Flight x = flights[i];
//            int s = i;
//            while (s > 0 && x.compareTo(flights[PARENT(s)]) > 0) {
//                flights[s] = flights[PARENT(s)];
//                s = PARENT(s);
//            }
//            flights[s] = x;
//        }
//    }
    
    public static void sort(Flight[] flights) {
        int n = flights.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(flights, n, i);
        for (int i = n - 1; i > 0; i--) {
            Flight temp = flights[0];
            flights[0] = flights[i];
            flights[i] = temp;
            heapify(flights, i, 0);
        }
    }
    
    public static void heapify(Flight[] flights,int n, int i){
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        if (l < n && flights[l].compareTo(flights[largest]) > 0)
            largest = l;
        if (r < n && flights[r].compareTo(flights[largest]) > 0)
            largest = r;     
        if (largest != i) {
            Flight swap = flights[i];
            flights[i] = flights[largest];
            flights[largest] = swap;

            heapify(flights, n, largest);
        }
    }

    public static void heapSort(Flight[] flights, int n) {
        for (int i = n - 1; i > 0; i--) {
            Flight x = flights[i];
            flights[i] = flights[0];
            int f = 0;
            int s = LEFT(f);
            if (s + 1 < i && flights[s].compareTo(flights[s + 1]) < 0)
                s = s + 1;
            while (s < i && x.compareTo(flights[s]) < 0) {
                flights[f] = flights[s];
                f = s;
                s = LEFT(f);
                if (s + 1 < i && flights[s].compareTo(flights[s + 1]) < 0)
                    s = s + 1;
            }
            flights[f] = x;
        }
    }

    public static void main(String[] args) {
        Flight[] flights = {
            new Flight("AA101", "08:00", "New York", "Scheduled"),
            new Flight("BA202", "09:30", "London", "Scheduled"),
            new Flight("CA303", "07:45", "Toronto", "Scheduled"),
            new Flight("DA404", "08:30", "Sydney", "Scheduled"),
            new Flight("EA505", "10:00", "Tokyo", "Scheduled"),
            new Flight("FA606", "11:15", "Paris", "Scheduled"),
            new Flight("GA707", "07:00", "Berlin", "Scheduled"),
            new Flight("HA808", "09:00", "Dubai", "Scheduled"),
            new Flight("IA909", "10:30", "Mumbai", "Scheduled"),
            new Flight("IA909", "10:40", "Mumbai", "Scheduled"),
            new Flight("IA909", "19:22", "Mumbai", "Scheduled"),
            new Flight("IA909", "10:31", "Mumbai", "Scheduled"),
            new Flight("IA909", "10:32", "Mumbai", "Scheduled"),
            new Flight("IA909", "10:33", "Mumbai", "Scheduled"),
            new Flight("IA909", "10:11", "Mumbai", "Scheduled"),
            new Flight("IA909", "10:12", "Mumbai", "Scheduled"),
            new Flight("JA010", "06:30", "Beijing", "Scheduled")
        };

        int n = flights.length;

//        heapify(flights, n);

//        heapSort(flights, n);
        
        sort(flights);

        Flight.displayAllFlights(flights);
    }
}

