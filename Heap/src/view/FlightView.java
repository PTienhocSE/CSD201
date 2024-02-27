
package view;

import Library.Validation;
import controller.FlightController;
import model.Flight;

public class FlightView {
    private FlightController controller = new FlightController();
    private Validation val = new Validation();
    
    public void example(){
        controller.printPriority();
    }
    
    public void addFlight(){
        String number = val.getString("Enter flight number");
        String time = val.getString("Enter take off time");
        String des= val.getString("Enter destination");
        String status = val.getString("Enter status");
        controller.addFlight(new Flight(number,time,des,status));
    }
    
    public void print(){
        controller.printPriority();
    }
}
