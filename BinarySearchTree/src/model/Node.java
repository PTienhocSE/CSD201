
package model;

public class Node {
    private Book info;
    private Node left,right;

    public Node(Book info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    public Node(Book info){
        this(info,null,null);
    }

    public Book getInfo() {
        return info;
    }

    public void setInfo(Book info) {
        this.info = info;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
}
