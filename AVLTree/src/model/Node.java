
package model;

public class Node {
    private Contact info;
    private Node left,right;
    private int height;

    public Node(Contact info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
        this.height=1;
    }

    public Node(Contact info) {
        this(info,null,null);
    }

    public Contact getInfo() {
        return info;
    }

    public void setInfo(Contact info) {
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
