import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

/**
 * Assignment 02 TSP Solver CSE 564
 * Professor : Javier Gonzalez-Sanchez
 * 
 * @author Aaditya Muley, Manasi Anantpurkar, Jash Kahar, Sarthak Vatss
 * */

public class HomePanel implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton symmButton;
    private JButton asymmButton;
    /**
         * HomePanel class creates a new interface for the entire traveling salesman problem system. 
         * It creates two buttons for symmetric and asymmetric datasets and defines the properties for the interface.
     */

    HomePanel() {
        frame = new JFrame();
        panel = new JPanel();

        symmButton = new JButton("Symmetric Data");
        asymmButton = new JButton("Asymmetric Data");

        symmButton.addActionListener(this);
        asymmButton.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(symmButton);
        panel.add(asymmButton);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Travelling Salesman Problem - Symmetric and Asymmetric data");
        frame.pack();
        frame.setVisible(true);
    }
    /**
         * ActionPerformed redirects the system according to the button clicked.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == symmButton) {
            SymmetricMain symmetricMain = new SymmetricMain();
            symmetricMain.symmetricPanel();
        }
        if(e.getSource() == asymmButton) {
            AsymmetricMain asymmetricMain = new AsymmetricMain();
            asymmetricMain.asymmetricPanel();
        }
    }
    public static void main(String[] args) {
        new HomePanel();
    }
}
