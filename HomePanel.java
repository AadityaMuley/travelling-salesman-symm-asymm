import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class HomePanel implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton symmButton;
    private JButton asymmButton;

    HomePanel() {
        frame = new JFrame();
        panel = new JPanel();

        symmButton = new JButton("Symmetric Data");
        asymmButton = new JButton("Asymmetric Data");

        symmButton.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.add(symmButton);
        panel.add(asymmButton);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Travelling Salesman Problem - Symmetric and Asymmetric data");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == symmButton) {
            SymmetricMain symmetricMain = new SymmetricMain();
            symmetricMain.parseSymmData();
        }
        if(e.getSource() == asymmButton) {
            AsymmetricMain asymmetricMain = new AsymmetricMain();
        }
    }
    public static void main(String[] args) {
        new HomePanel();
    }
}
