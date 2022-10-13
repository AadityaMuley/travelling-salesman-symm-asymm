import javax.swing.*;
import java.awt.*;

public class SymmetricMain {
    private int arrLen;
	private float[][] coords;
	private float[][] symmetricDistances;
	private int[] shortestPath;
	private float totalDistance;

	private JFrame symmetricFrame;
    private JPanel symmetricPanel;
	private JScrollPane scrollSymmetricView;

	private JLabel totalDistanceLabel;
	private JLabel[] shortestPathLabel;
	private JLabel path;

	public void symmetricPanel() {

		symmetricFrame = new JFrame();
		symmetricPanel = new JPanel();
		scrollSymmetricView = new JScrollPane(symmetricPanel);
		symmetricPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		symmetricPanel.setLayout(new GridLayout(0, 1));

		ParseSymmetricData parseSymmetricData = new ParseSymmetricData();
		coords = parseSymmetricData.parseSymmData();
		this.arrLen = parseSymmetricData.arrLen;
		// for(int i=0; i<arrLen; i++) {
		// 		System.out.println(i+1 + " " + coords[i][0] + " " + coords[i][1]);
		// 	}

		SymmetricDistanceCalculate symmetricDistanceCalculate = new SymmetricDistanceCalculate();
		symmetricDistances = symmetricDistanceCalculate.calculateDistances(arrLen, coords);
		// for(int i=0; i<arrLen; i++) {
		// 	for(int j=0; j<arrLen; j++){
		// 		System.out.print(symmetricDistances[i][j] + "            ");
		// 	}
		// 	System.out.println();
		// }

		TSPGreedy tspGreedy = new TSPGreedy();
		shortestPath = new int[arrLen];
		shortestPath = tspGreedy.greedyShortestPath(symmetricDistances, arrLen);
		totalDistance = tspGreedy.totalDistance;
		// System.out.println(this.totalDistance);
		// for(int i: shortestPath) {
		// 	System.out.println(i);
		// }
		
		totalDistanceLabel = new JLabel();
		totalDistanceLabel.setText("Total distance travelled: " + Float.toString(totalDistance));
		symmetricPanel.add(totalDistanceLabel);

		path = new JLabel();
		path.setText("The shortest path is: ");
		symmetricPanel.add(path);
		shortestPathLabel = new JLabel[arrLen];
		for(int i=0; i<arrLen; i++) {
			shortestPathLabel[i] = new JLabel();
			shortestPathLabel[i].setText(Integer.toString(shortestPath[i]));
			symmetricPanel.add(shortestPathLabel[i]);
		}
		
		symmetricFrame.add(scrollSymmetricView);
		symmetricFrame.add(symmetricPanel, BorderLayout.WEST);
        symmetricFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        symmetricFrame.setTitle("Travelling Salesman Problem - Symmetric");
        symmetricFrame.pack();
        symmetricFrame.setVisible(true);
	}
}
