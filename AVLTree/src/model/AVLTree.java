
package model;

public class AVLTree {
    private Node root;

    public AVLTree() {
        root=null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public void updateHeight(Node n) {
        n.setHeight(1 + Math.max(heightNode(n.getLeft()), heightNode(n.getRight())));
    } 
    
    public int heightNode(Node n) {
        return n == null ? 0 : n.getHeight();
    } 
    
    public int getBalance(Node n) {
        return (n == null) ? 0 : heightNode(n.getRight()) - heightNode(n.getLeft());
    }
    
    public Node rotateRight(Node y) {
        Node x = y.getLeft();
        Node z = x.getRight();
        x.setRight(y);
        y.setLeft(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    
    public Node rotateLeft(Node y) {
        Node x = y.getRight();
        Node z = x.getLeft();
        x.setLeft(y);
        y.setRight(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    
    public Node rebalance(){
        return rebalance(root);
    } 
    
    public Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (heightNode(z.getRight().getRight()) > heightNode(z.getRight().getLeft())) {
                z = rotateLeft(z);
            } else {
                z.setRight(rotateRight(z.getRight()));
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (heightNode(z.getLeft().getLeft()) > heightNode(z.getLeft().getRight()))
                z = rotateRight(z);
            else {
                z.setLeft(rotateLeft(z.getLeft())); 
                z = rotateRight(z);
            }
        } 
        return z;
    }
    
    public Node insert(String name){
        return insert(root,new Contact(name));
    }
    
    public Node insert(Contact key){
        return insert(root,key);
    }
    
    public Node insert(Node root, Contact key) {
        if (root == null) {
            return new Node(key);
        } else if (root.getInfo().getName().compareTo(key.getName()) > 0) {
            root.setLeft(insert(root.getLeft(), key));
        } else if (root.getInfo().getName().compareTo(key.getName()) < 0) {
            root.setRight(insert(root.getRight(), key));
        } else {
            throw new RuntimeException("Duplicate Name!!!");
        }
        return rebalance(root);
    }
    
    public Node delete(String name){
        return delete(root,new Contact(name));
    }
    
    public Node delete(Node node, Contact key) {
        if (node == null) {
            return node;
        } else if (node.getInfo().getName().compareTo(key.getName()) > 0) {
            node.setLeft(delete(node.getLeft(), key));
        } else if (node.getInfo().getName().compareTo(key.getName()) < 0) {
            node.setRight(delete(node.getRight(), key));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
            } else {
                Node mostLeftChild = mostLeftChild(node.getRight());
                node.setInfo(mostLeftChild.getInfo());
                node.setRight(delete(node.getRight(), node.getInfo()));
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }
    
    public Node mostLeftChild(Node p){
        if(p.getLeft() != null){
            return mostLeftChild(p.getLeft());
        }
        return p;
    }
    
    public Node search(String name){
        return search(root,name);
    }
    
    public Node search(Node p, String key){
        if(p == null) return null;
        if(p.getInfo().getName().equals(key)) return p;
        else if(p.getInfo().getName().compareTo(key)>0) return search(p.getLeft(), key);
        else return search(p.getRight(), key);
    }
    
    public void visit(Node p) {
        if(p == null) return;
        Node q = visitParent(p);
        if(q == null){
            System.out.println(p.getInfo().getName() + ", Parent: null" );
        } else {
            System.out.println(p.getInfo().getName() + ", Parent: " + q.getInfo().getName() );
        }
    }
    
    public Node visitParent(Node p){
        Node f = null, q = root;
        while(q!=p){
            f=q;
            if(q.getInfo().getName().compareTo(p.getInfo().getName())>0)    q=q.getLeft();
            else    q=q.getRight();
        }
        return f;
    }
    
    public void preOrder(){
        preOrder(root);
    }
    
    public void preOrder(Node p) {
        if(p == null) return;
        visit(p);
        preOrder(p.getLeft());
        preOrder(p.getRight());
    }
    
    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(Node p) {
        if(p == null) return;
        postOrder(p.getLeft());postOrder(p.getRight());visit(p);
    }
    
    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(Node p) {
        if(p == null) return;
        inOrder(p.getLeft());visit(p);inOrder(p.getRight());
    }
}
