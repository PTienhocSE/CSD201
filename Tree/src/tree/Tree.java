
package tree;

class Node {
    
    int info;
    Node left, right;

    public Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    public Node(int info) {
        this(info,null,null);
    }
}

class NodeQueue {
    Object info;
    NodeQueue next;
    
    public NodeQueue(Object info ,NodeQueue next) {
        this.info=info;
        this.next = next;
    }
    
    public NodeQueue(Object info) {
        this(info,null);
    }
}

class MyQueue{ 
    NodeQueue head,tail;

    public MyQueue(){ 
        head = tail = null; 
    }

    public boolean isEmpty(){ 
        return(head==null);
    }

    Object front() throws Exception{ 
        if(isEmpty()) throw new Exception();
        return(head.info);
    }
    
    public Object dequeue() throws Exception{ 
        if(isEmpty()) throw new Exception();
        Object x = head.info;
        head=head.next;
        if(head==null) tail=null;
        return(x);
    }
    
    public Object poll() { 
        if(isEmpty()) return null ;
        Object x = head.info;
        head=head.next;
        if(head==null) tail=null;
        return(x);
    }

    void enqueue(Object x){ 
        if(isEmpty()) head = tail = new NodeQueue(x);
        else{ 
            tail.next = new NodeQueue(x);
            tail = tail.next;
        }
    }
}

public class Tree {

    Node root;

    public Tree() {
        root = null;
    }
    
    public boolean isEmpty() {return root == null;}
    
    public void visit(Node p) {
        if(p == null) return;
        System.out.print(p.info + "  ");
    }
    
    public Node search(Node p, int key) {
        if(p == null) return null;
        if(p.info == key) return p;
        else if(p.info > key) return search(p.left, key);
        else return search(p.right, key);
    }

    public void insert(int x) {
        Node p = new Node(x);
        Node f = null, q = root;
        while(q != null) {
            if(q.info == x) {System.out.println("Key cannot be duplicated...");return;}
            if(q.info < x) {f = q; q = q.right;}
            else {f = q; q = q.left;}
        }
        if(f == null) root = p;
        else if(p.info > f.info) f.right = p;
        else f.left = p;
    }
    
    public void preOrder(Node p) {
        if(p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void postOrder(Node p) {
        if(p == null) return;
        postOrder(p.left);postOrder(p.right);visit(p);
    }

    public void inOrder(Node p) {
        if(p == null) return;
        inOrder(p.left);visit(p);inOrder(p.right);
    }
    
    public void BFT(Node p){
        if(p == null) return;
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while(!m.isEmpty()) {
            Node q = (Node)m.poll();
            visit(q);
            if(q.left != null) m.enqueue(q.left);
            if(q.right != null) m.enqueue(q.right);
        }
    }
    //height of tree
    int height(Node p) {
        if(p==null) {return 0;}
        else{
            int lDepth=height(p.left);//compute the depth of each subtree
            int rDepth=height(p.right);
            if (lDepth > rDepth) return (lDepth + 1);//use the larger one
            else return (rDepth + 1);
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
