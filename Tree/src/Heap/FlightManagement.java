package Heap;

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

public class FlightManagement {
    public static int PARENT(int i) {
        return (i - 1) / 2;
    }

    public static int LEFT(int i) {
        return 2 * i + 1;
    }

    public static int RIGHT(int i) {
        return 2 * (i + 1);
    }

    public static void heapify(Flight[] flights, int n) {
        for (int i = 1; i < n; i++) {
            Flight x = flights[i];
            int s = i;
            while (s > 0 && x.compareTo(flights[PARENT(s)]) > 0) {
                flights[s] = flights[PARENT(s)];
                s = PARENT(s);
            }
            flights[s] = x;
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
            new Flight("JA010", "06:30", "Beijing", "Scheduled")
        };

        int n = flights.length;

        heapify(flights, n);

        heapSort(flights, n);

        Flight.displayAllFlights(flights);
    }
}
