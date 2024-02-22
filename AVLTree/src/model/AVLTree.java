
package model;

public class AVLTree {
    private Node root;

    public AVLTree() {
        root=null;
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
}
