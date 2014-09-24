import java.awt.*;
import javax.swing.*;

/**
 * @author Tabetha Boushey
 * Date: 6/25/2013
 * CSCI232 Lab 1
 * Class: TreeFrame
 */

public class TreeFrame extends JFrame {

    public static TreeFrame instance;

    TreeFrame() {
        super("Binary Search Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(TreePanel.getInstance(), BorderLayout.CENTER);
        setSize(300,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static TreeFrame getInstance() {
        if (instance == null) {
            instance = new TreeFrame();
        }
        return instance;
    }
}
