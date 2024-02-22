
package model;

import java.util.Comparator;

public class Contact implements Comparator<Contact> {
    private String name,phone,email;

    public Contact() {
    }

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        return (int)(o1.name.compareTo(o2.name));
    }

    @Override
    public String toString() {
        return '{' + "name=" + name + ", phone=" + phone + ", email=" + email + '}';
    }
    
}
