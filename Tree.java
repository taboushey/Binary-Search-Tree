/**
 * @author Tabetha Boushey
 * Date: 6/25/2013 
 * CSCI232 Lab 1 
 * Class: Tree
 */

public class Tree {

    Node root;

    public Tree() {
        root = null;
    }

    private Node getSuccessor(Node delete) {
        Node successorParent = delete;
        Node successor = delete;
        Node current = delete.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor.equals(delete.right)) {
            successorParent.left = successor.right;
            successor.right = delete.right;
        }
        return successor;
    }

    public Node search(Comparable value) {
        Node current = root;
        while (current != null){
            if (value.equals(current.getData())) {
                return current;
            } else if (value.compareTo(current.getData()) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return current;
    }

    public void insert(Comparable value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    public boolean delete(Comparable value) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (!current.getData().equals(value)) {
            
            parent = current;
            
            if (value.compareTo(current.getData()) < 0) {
                isLeftChild = true;
                current = current.left;
            } else  {
                isLeftChild = false;
                current = current.right;
                System.out.println("2" + current);
            }
            if (current == null) {
                return false;
            }
        }
            
            // If there are no children.
            if (current.left == null && current.right == null) {
                if (current.equals(root)) {
                    root = null;
                } else if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } 
            
            // If no right child, replace with left subtree.
            else if (current.right == null) {
                if (current.equals(root)) {
                    root = current.left;
                } else if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } 
            
            // If no left child, replace with right subtree.
            else if (current.left == null) {
                if (current.equals(root)) {
                    root = current.right;
                } else if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } 
            
            // If there are two children, go to right child, then right child's left descendants.
            else {
                Node successor = getSuccessor(current);

                if (current.equals(root)) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.right = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
        return true;
    }

    public Node getRoot() {
        return root;
    }

    public static void preOrderTraversal(Node n) {
        if (n != null) {
            System.out.print(" " + n.getData());
        }
        if (n != null && n.getLeft() != null) {
            preOrderTraversal(n.getLeft());
        }
        if (n != null && n.getRight() != null) {
            preOrderTraversal(n.getRight());
        }
    }

    public static void inOrderTraversal(Node n) {
        if (n != null && n.getLeft() != null) {
            inOrderTraversal(n.getLeft());
        }
        if (n != null) {
            System.out.print(" " + n.getData());
        }
        if (n != null && n.getRight() != null) {
            inOrderTraversal(n.getRight());
        }
    }

    public static void postOrderTraversal(Node n) {
        if (n != null && n.getLeft() != null) {
            postOrderTraversal(n.getLeft());
        }
        if (n != null && n.getRight() != null) {
            postOrderTraversal(n.getRight());
        }
        if (n != null) {
            System.out.print(" " + n.getData());
        }
    }
}
