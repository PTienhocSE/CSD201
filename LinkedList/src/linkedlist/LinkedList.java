package linkedlist;

class Node {
    String info;
    Node next;

    Node() {
    }

    Node(String info, Node p) {
        this.info = info;
        this.next = p;
    }
    
}

class MyList {
    Node head,tail;
    
    MyList() {
        head=tail=null;
    }
    
    boolean isEmpty(){
        return head==null;
    }
    
    void clear(){
        head=tail=null;
    }
    
    void addEnd(String s){
        if(isEmpty())   head=tail=new Node(s,null);
        else{
            Node q=new Node(s,null);
            tail.next=q;tail=q;
        }
    }
    
    void addFirst(String s){
        if(isEmpty())   head=tail=new Node(s,null);
        else{
            Node q=new Node(s,null);
            q.next=head;head=q;
        }
    }
    
    void traverse(){
        Node p =head;
        String s="";
        while(p!=null){
//            System.out.print(" "+p.info);
            s=s.concat(p.info)+" ";
            p=p.next;
        }
        s.trim();
//        System.out.println();
        System.out.println(s);
    }
}


public class LinkedList {


    public static void main(String[] args) {
        System.out.println("Demo of my first data structure .. Linked List");
        MyList a = new MyList();
        a.addEnd("Happy");
        a.addEnd("New");
        a.addEnd("Year");
        a.traverse();
        
        MyList b = new MyList();
        b.addFirst("Year");
        b.addFirst("New");
        b.addFirst("Happy");
        b.traverse();
    }
    
}
