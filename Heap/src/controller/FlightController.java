
package controller;

import model.Flight;
import model.Heap;

public class FlightController {
    private Heap data = new Heap();

    public FlightController() {
        data.insert(new Flight("AA101", "08:00", "New York", "Scheduled"));
        data.insert(new Flight("BA202", "09:30", "London", "Scheduled"));
        data.insert(new Flight("CA303", "07:45", "Toronto", "Scheduled"));
        data.insert(new Flight("DA404", "08:30", "Sydney", "Scheduled"));
        data.insert(new Flight("EA505", "10:00", "Tokyo", "Scheduled"));
        data.insert(new Flight("FA606", "11:15", "Paris", "Scheduled"));
        data.insert(new Flight("GA707", "07:00", "Berlin", "Scheduled"));
        data.insert(new Flight("HA808", "09:00", "Dubai", "Scheduled"));
        data.insert(new Flight("IA909", "10:30", "Mumbai", "Scheduled"));
        data.insert(new Flight("JA010", "06:30", "Beijing", "Scheduled"));
    }
    
    public void printPriority(){
        Flight[] flights = new Flight[data.getLength()];
        for(int i = 0;i<flights.length;i++){
            flights[i]=data.getMax();
        }
        for(int i = flights.length - 1;i>=0;i--){
            System.out.println(flights[i]);
        }
    }
    
    public void addFlight(Flight a){
        data.insert(a);
    }
    
}
