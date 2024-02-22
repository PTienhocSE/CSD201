
package view;

import Library.Validation;
import controller.ContactController;
import model.Contact;

public class ContactView {
    private Validation val = new Validation();
    private ContactController controller = new ContactController();
    
    public void example(){
        System.out.println("----------------Default----------------");
        controller.print();
    }
    
    public void addContact(){
        String name = val.getWord("Enter name");
        String phone = val.getString("Enter phone");
        String email;
        while (true) {            
            email = val.getString("Enter email");
            if (!val.checkEmail(email)) {
                System.out.println("Wrong format!!!\nEnter again: ");
            } else {
                break;
            }
        }
        controller.addContact(new Contact(name,phone,email));
        System.err.flush();
    }
    
    public void deleteContact(){
        String name = val.getWord("Enter name");
        controller.deleteContact(name);
        System.err.flush();
    }
    
    public void searchContact(){
        String name = val.getWord("Enter name");
        Contact a = controller.searchContact(name);
        if(a != null){
            System.out.println(a);
        }else {
            System.err.println("Don't find !!!");
        }
        System.err.flush();
    }
    
    public void print(){
        controller.print();
    }
}
