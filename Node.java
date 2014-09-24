/**
 * @author Tabetha Boushey
 * Date: 6/25/2013 
 * CSCI232 Lab 1 
 * Class: Node
 */

public class Node {

    Comparable data;
    Node parent;
    Node left;
    Node right;

    public Node(Comparable a) {
        System.out.println("New node constructed with value: " + a);
        data = a;
        parent = null;
        left = null;
        right = null;
    }

    public Comparable getData() {
        return data;
    }

    public void setParent(Node n) {
        parent = n;
    }

    public Node getParent() {
        return parent;
    }

    public void setLeft(Node n) {
        left = n;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node n) {
        right = n;
    }

    public Node getRight() {
        return right;
    }
    
    public void insert(Comparable newValue) {
        if (newValue.compareTo(data) < 0) {
            if (left == null) {
                left = new Node(newValue);
            } else {
                left.insert(newValue);
            }
        } else {
            if (right == null) {
                right = new Node(newValue);
            } else {
                right.insert(newValue);
            }
        }
    }

    @Override
    public String toString() {
        return "(" + data.toString() + ")";
    }
}
