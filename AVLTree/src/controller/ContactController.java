
package controller;

import model.AVLTree;
import model.Contact;

public class ContactController {
    private AVLTree data= new AVLTree();

    public ContactController() {
        data.setRoot(data.insert(new Contact("Alice Johnson","555-0101","alice.johnson@email.com")));
        data.setRoot(data.insert(new Contact("Bob Smith","555-0102","bob.smith@email.com")));
        data.setRoot(data.insert(new Contact("Charlie Davis","555-0103","charlie.davis@email.com")));
        data.setRoot(data.insert(new Contact("Diana Hayes","555-0104","diana.hayes@email.com")));
        data.setRoot(data.insert(new Contact("Ethan Moore","555-0105","ethan.moore@email.com")));
        data.setRoot(data.insert(new Contact("Fiona Campbell","555-0106","fiona.campbell@email.com")));
        data.setRoot(data.insert(new Contact("George Wright","555-0107","george.wright@email.com")));
        data.setRoot(data.insert(new Contact("Hannah Torres","555-0108","hannah.torres@email.com")));
        data.setRoot(data.insert(new Contact("Ian Scott","555-0109","ian.scott@email.com")));
        data.setRoot(data.insert(new Contact("Jenny Adams","555-0110","jenny.adams@email.com")));
    }
    
    public void print(){
        data.inOrder();
    }
    
    public void addContact(Contact b){
        try{
            data.setRoot(data.insert(b));
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteContact(String name){
        
    }
    
    public Contact searchContact(String name){
        if(data.search(name)!= null) return data.search(name).getInfo();
        else return null;
    }
        
}
