
package stack;

import java.util.Scanner;

class Node {
    
    Object info;
    Node next;
    
    Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    Node(Object info) {
        this(info, null);
    }
}

public class Stack {
    
    Node head;

    public Stack() {head = null;}
    
    public boolean isEmpty() {return head == null;}
    
    public void push(Object info) {
        Node p = new Node(info);
        if(isEmpty()) head = p;
        else {p.next = head; head = p;}
    }
    
    public Object pop() {
        if(isEmpty()) return null;
        Object info = head.info;
        head = head.next;
        return info;
    }
    
    public Object top() {
        if(isEmpty()) return null;
        Object info = head.info;
        return info;
    }
    
    public void clear() {head = null;}

    public static void main(String[] args) {
        Stack s= new Stack();
        String b;
        char c;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter: ");
        b=sc.nextLine();
        for(int i=0;i<b.length();i++){
            c=b.charAt(i);
            if(c=='('){
                s.push(c);
            }else if(c=='['){
                s.push(c);
            }else if(c=='{'){
                s.push(c);
            } else {
                if(c==')'){
                    c--;
                }else   c-=2;
                if(!s.pop().equals(c)){
                    System.out.println("Incorrect");
                    System.exit(0);
                }
            }
        }
        if(s.isEmpty()){
            System.out.println("Correct");
            System.exit(0);
        }
        System.out.println("Incorrect");
        
    }
    
}
