
package model;

public class BSTree {
    private Node root;

    public BSTree() {
        root=null;
    }

    public BSTree(Node root) {
        this.root = root;
    }
    public boolean isEmpty() {return root == null;}
    
    public void visit(Node p) {
        if(p == null) return;
        System.out.print(p.getInfo().getISBN() + "  ");
    }
    
    public Node search(String key){
        return search(root,key);
    }
    
    public Node search(Node p, String key) {
        if(p == null) return null;
        if(p.getInfo().getISBN().equals(key)) return p;
        else if(p.getInfo().getISBN().compareTo(key)>0) return search(p.getLeft(), key);
        else return search(p.getRight(), key);
    }
    
    public void insert(String ISBN){
        insert(new Book(ISBN));
    }

    public void insert(Book ISBN) {
        Node p = new Node(ISBN);
        Node f = null, q = root;
        while(q != null) {
            if(q.getInfo().getISBN().equals(ISBN.getISBN())) {System.err.println("ISBN cannot be duplicated...");return;}
            if(q.getInfo().getISBN().compareTo(ISBN.getISBN())<0) {f = q; q = q.getRight();}
            else {f = q; q = q.getLeft();}
        }
        if(f == null) root = p;
        else if(p.getInfo().getISBN().compareTo(f.getInfo().getISBN())>0) f.setRight(p);
        else f.setLeft(p);
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

    public void deleteByMerging(String ISBN){
        Node p = search(ISBN);
        if(p==null){
            System.err.println("ISBN: "+ISBN+" does not exists, deletion failed");
            return;
        }
        
        Node f = null, q = root;
        while(q!=p){
            f=q;
            if(q.getInfo().getISBN().compareTo(p.getInfo().getISBN())>0)    q=q.getLeft();
            else    q=q.getRight();
        }
        
        if(p.getLeft() == null && p.getRight() == null){
            if(f == null)   root=null;
            else if(f.getLeft() == p)    f.setLeft(null);
            else f.setRight(null);
        } else if (p.getLeft() != null && p.getRight() == null){
            if(f == null)   root=p.getLeft();
            else if(f.getLeft() == p)    f.setLeft(p.getLeft());
            else f.setRight(p.getLeft());
        } else if (p.getLeft() == null && p.getRight() != null){
            if(f == null)   root=p.getRight();
            else if(f.getLeft() == p)    f.setLeft(p.getRight());
            else f.setRight(p.getRight());
        } else {
            Node t = p.getLeft();
                while(t.getRight() != null){
                    t = t.getRight();
                }
                t.setRight(p.getRight());
            if(f == null)   root=p.getLeft();
            else if(f.getLeft() == p)    f.setLeft(p.getLeft());
            else f.setRight(p.getLeft());
        }
    }
    
}
