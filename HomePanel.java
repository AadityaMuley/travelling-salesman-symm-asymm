import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class HomePanel implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton symmButton;
    private JButton asymmButton;

    // private Plot plot;

    HomePanel() {
        frame = new JFrame();
        panel = new JPanel();

        // GridBagConstraints constraints = new GridBagConstraints();
        // plot = new Plot();
        // frame.setLayout(new GridBagLayout());
        // constraints.fill = GridBagConstraints.BOTH;
        // constraints.weightx = 1.0; constraints.weighty = 1.0;
        // constraints.gridx = 0; constraints.gridy = 1; constraints.gridwidth = 2;
        // constraints.insets = new Insets(5,10,5,10);
        // frame.add(plot, constraints);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == symmButton) {
            SymmetricMain symmetricMain = new SymmetricMain();
            symmetricMain.symmetricPanel();
            // plot.repaint();
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