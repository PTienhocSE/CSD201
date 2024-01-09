package RoundRobinScheduling;

class Process {
    int bursttime;
    int processid;
    static int count=0;

    public Process(int bursttime) {
        this.bursttime = bursttime;
        this.processid = ++count;
    }
    
}

class Node {
    Process process;
    Node next;

    Node() {
    }
    
    public Node(int time,Node next){
        this.process = new Process(time);
        this.next=next;
    }
    
    public Node(Process process, Node next) {
        this.process = process;
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
            System.out.print(" "+p.process.bursttime);
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
    
    void show () {
        Node p =head;
        int n=1,m=size();
        while(n<=m){
            System.out.println("Process "+p.process.processid+": "+p.process.bursttime);
            n++;
            p=p.next;
        }
    }
}

public class RoundRobinScheduling extends Menu{
    static String[] mc={"Quantum Time","Add Process","Show Process","Do Round Robin Scheduling"};
    int q;
    MyList a;

    public RoundRobinScheduling() {
        super("Round Robin Scheduling",mc);
        a= new MyList();
    }

    public RoundRobinScheduling(int q) {
        super("Round Robin Scheduling",mc);
        this.q = q;
        a= new MyList();
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }
    
    void doRoundRobin(){
        Node p =a.head;
        int time=0,n=1,m=a.size();
        while(n<=m ){
            if(p.process.bursttime>q){
                System.out.print(time+"  ");
                System.out.print("ID:"+p.process.processid+"  ");
                p.process.bursttime-=q;
                time+=q;
            }else if(p.process.bursttime>0){
                System.out.print(time+"  ");
                System.out.print(p.process.processid+"  ");
                time+=p.process.bursttime;
                p.process.bursttime=0;
                n++;
            }
            p=p.next;
        }
        System.out.println(time);
        System.out.println("Total: "+time);
    }

    public static void main(String[] args) {
        new RoundRobinScheduling().run();
    }

    @Override
    public void execute(int ch) {
        switch(ch){
            case 1: q=Utils.getInt("Enter");this.setQ(q);System.out.println(this.getQ());;break;
            case 2: a.add(Utils.getInt("Enter"));break;
            case 3: a.show();break;
            case 4: this.doRoundRobin();break;
            default: System.exit(0);
        }
    }
    
}
