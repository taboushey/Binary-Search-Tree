import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Tabetha Boushey
 * Date: 6/25/2013 
 * CSCI232 Lab 1 
 * Class: TreePanel
 */

public class TreePanel extends JPanel {

    public static TreePanel inst;
    public JButton insert, delete, preOrder, inOrder, postOrder;
    public static JTextField textBox;
    Tree t = new Tree();
    Random r = new Random();

    public TreePanel() {
//        You will have to use the GUI to insert your tree.
//        For practice purposes.
//        for(int i = 0 ; i < 10; i++) {
//            t.insert(i);
//        }

        this.setLayout(new GridLayout(6, 1));

        textBox = new JTextField();
        Font bigFont = new Font("Serif", Font.PLAIN, 20);
        textBox.setFont(bigFont);
        textBox.setEditable(true);
        textBox.getText();
        this.add(textBox);
        this.setVisible(true);

//      Insert Button
        insert = new JButton("Insert");
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Data value = Data.fromString(textBox.getText());
                    Node foundNode = t.search(value);
                    if (foundNode == null) {
                        t.insert(value);
                    } else {
                        JOptionPane.showMessageDialog(null, value + " already exists in the tree.");
                    }
                    textBox.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter an integer, then a string.");
                }
            }
        });
        add(insert);

//      Delete Button
        delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Data value = Data.fromString(textBox.getText());
                    Node foundNode = t.search(value);
                    if (foundNode == null) {
                        JOptionPane.showMessageDialog( null, "Number " + value + " does not exists in the tree.");
                    } else {
                        System.out.println("You have deleted " + foundNode + ".");
                        t.delete(value);
                    }
                    textBox.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter an integer, then a string.");
                }
            }
        });
        add(delete);

//      Pre-Order Traversal Button
        preOrder = new JButton("Pre-Order Traversal");
        preOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pre-order traversal: ");
                Tree.preOrderTraversal(t.getRoot());
                System.out.println();
            }
        });
        add(preOrder);

//      In-Order Traversal Button        
        inOrder = new JButton("In-Order Traversal");
        inOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("In-order traversal: ");
                Tree.inOrderTraversal(t.getRoot());
                System.out.println();
            }
        });
        add(inOrder);

//      Post-Order Traversal Button
        postOrder = new JButton("Post-Order Traversal");
        postOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Post-order traversal: ");
                Tree.postOrderTraversal(t.getRoot());
                System.out.println();
            }
        });
        add(postOrder);
    }

    public static TreePanel getInstance() {
        if (inst == null) {
            inst = new TreePanel();
        }
        return inst;
    }
}
