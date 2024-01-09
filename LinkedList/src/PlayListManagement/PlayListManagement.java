
package PlayListManagement;

class Node {
    String name,info;
    Node next;

    Node() {
    }

    public Node(String name, String info, Node next) {
        this.name = name;
        this.info = info;
        this.next = next;
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
    void addEnd(String s,String content){
        if(isEmpty())   head=tail=new Node(s,content,null);
        else{
            Node q=new Node(s,content,null);
            tail.next=q;tail=q;
        }
    }
    
    void addFirst(String s,String content){
        if(isEmpty())   head=tail=new Node(s,content,null);
        else{
            Node q=new Node(s,content,null);
            q.next=head;head=q;
        }
    }
    
    void remove(String s){
        
    }
    
    void shuffle(){
        
    }
    
    void skipNext(){
        
    }
    
    void skipPrevious(){
        
    }
    
    void traverse(){
        Node p =head;
        while(p!=null){
            System.out.print(" "+p.info);
            p=p.next;
        }
        System.out.println();
    }
}

class PlayList {
    
}

public class PlayListManagement {
    
    public static void main(String[] args) {
        
    }
}
