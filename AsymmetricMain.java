import javax.swing.*;
import java.awt.*;

public class AsymmetricMain {

    private int arrLen;
	private float[][] asymmetricDistances;
	private int[] shortestPath;
	private float totalDistance;

	private JFrame asymmetricFrame;
    private JPanel asymmetricPanel;
    private JScrollPane scrollSymmetricView;

	private JLabel totalDistanceLabel;
	private JLabel shortestPathLabel;
    private JLabel path;

	public void asymmetricPanel() {

		asymmetricFrame = new JFrame();
		asymmetricPanel = new JPanel();
		asymmetricPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		asymmetricPanel.setLayout(new GridLayout(0, 1));

		ParseAsymmetricData parseAsymmetricData = new ParseAsymmetricData();
		asymmetricDistances = parseAsymmetricData.parseAsymmData();
		this.arrLen = parseAsymmetricData.arrLen;
		// for(int i=0; i<arrLen; i++) {
		// 		System.out.println(i+1 + " " + asymmetricDistances[i][0] + " " + asymmetricDistances[i][1]);
		// 	}
		// for(int i=0; i<arrLen; i++) {
		// 	for(int j=0; j<arrLen; j++){
		// 		System.out.print(symmetricDistances[i][j] + "            ");
		// 	}
		// 	System.out.println();
		// }

		TSPGreedy tspGreedy = new TSPGreedy();
		shortestPath = new int[arrLen];
		shortestPath = tspGreedy.greedyShortestPath(asymmetricDistances, arrLen);
		totalDistance = tspGreedy.totalDistance;
		// System.out.println(this.totalDistance);
		// for(int i: shortestPath) {
		// 	System.out.println(i);
		// }
		
		totalDistanceLabel = new JLabel();
		totalDistanceLabel.setText("Total distance travelled: " + Float.toString(totalDistance));
        asymmetricPanel.add(totalDistanceLabel);

        path = new JLabel();
		path.setText("The shortest path is: ");
		path.setFont(new Font("Serif", Font.PLAIN, 14));
		asymmetricPanel.add(path);

		String shortestPathString = Integer.toString(shortestPath[0]);
		for(int i=1; i<arrLen; i++) {
			shortestPathString = shortestPathString + " --> " + shortestPath[i];
		}
		shortestPathLabel = new JLabel(shortestPathString);
		shortestPathLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		asymmetricPanel.add(shortestPathLabel);

		scrollSymmetricView = new JScrollPane(asymmetricPanel, 
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        asymmetricFrame.add(scrollSymmetricView);
		// asymmetricFrame.add(asymmetricPanel, BorderLayout.WEST);
        
        asymmetricFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        asymmetricFrame.setTitle("Travelling Salesman Problem - Asymmetric");
        asymmetricFrame.pack();
        asymmetricFrame.setVisible(true);
	}
    
}
