
package model;


public class Flight implements Comparable<Flight> {
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

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-15s%-10s",flightNumber, takeoffTime, destination, status);
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
