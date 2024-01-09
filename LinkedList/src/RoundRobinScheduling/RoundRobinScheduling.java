package RoundRobinScheduling;

class Process {
    int bursttime,processid;
}

class Node {
    int bursttime;
    Node next;

    Node() {
    }

    Node(int bursttime, Node next) {
        this.bursttime = bursttime;
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
    
    void add(int time){
        if(isEmpty())   head=tail=new Node(time,null);
        else{
            Node q=new Node(time,null);
            tail.next=q;tail=q;tail.next=head;
        }
    }
    
    void traverse(){
        Node p =head;
        while(p!=null){
            System.out.print(" "+p.bursttime);
            p=p.next;
        }
//        System.out.println();
    }
    
    int size(){
        Node p =head;
        int k=1;
        while(p!=tail){
            k++;
            p=p.next;
        }
        return k;
    }
}

public class RoundRobinScheduling {
    int q;
    MyList a;

    public RoundRobinScheduling() {
        a= new MyList();
    }

    public RoundRobinScheduling(int q) {
        this.q = q;
        a= new MyList();
    }
    
    void doRoundRobin(){
        Node p =a.head;
        int time=0,n=1,m=a.size();
        while(n<=m ){
            if(p.bursttime>q){
                p.bursttime-=q;
                time+=q;
                System.out.println(time);
            }else if(p.bursttime>0){
                time+=p.bursttime;
                p.bursttime=0;
                n++;
                System.out.println(time);
            }
            p=p.next;
        }
        System.out.println(time);
    }

    public static void main(String[] args) {
        RoundRobinScheduling x = new RoundRobinScheduling(50);
        x.a.add(100);
        x.a.add(200);
        x.a.add(300);
//        x.a.traverse();
        x.doRoundRobin();
    }
    
}
