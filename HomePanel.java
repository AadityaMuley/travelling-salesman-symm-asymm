import javax.swing.JFrame;  
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;

public class HomePanel {

    HomePanel() {
        JFrame f = new JFrame();
        JPanel p = new JPanel();

        p.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        
        f.add(p, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Travelling Salesman Problem - Symmetric and Asymmetric data");
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        
        
    }
}
