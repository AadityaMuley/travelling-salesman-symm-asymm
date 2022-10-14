import javax.swing.*;
import java.awt.*;
/**
 * AsymmetricMain is the class that controls all operations of the Asymmetric DataSet. It displays 
 * the traversal order of nodes and the total distance travelled.
 * @author Aditya Muley(amuley2@asu.edu), Manasi Anantpurkar(manantpu@asu.edu), Jash Kahar(jkahar@asu.edu), Sarthak Vats(svats2@asu.edu)
 */

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
	/**
    	* AsymmetricPanel class uses a new interface. It called ParseAsymmetric Data class to obtain the input data in matrix type.
	* It calls TSPGreedy class to implement the logic on the given matrix and then displays total distance and path in which it traverses.
	* The path is displayed in a scrollable window in the Panel.
	*/ 
	public void asymmetricPanel() {

		asymmetricFrame = new JFrame();
		asymmetricPanel = new JPanel();
		asymmetricPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		asymmetricPanel.setLayout(new GridLayout(0, 1));

		ParseAsymmetricData parseAsymmetricData = new ParseAsymmetricData();
		asymmetricDistances = parseAsymmetricData.parseAsymmData();
		this.arrLen = parseAsymmetricData.arrLen;

		TSPGreedy tspGreedy = new TSPGreedy();
		shortestPath = new int[arrLen];
		shortestPath = tspGreedy.greedyShortestPath(asymmetricDistances, arrLen);
		totalDistance = tspGreedy.totalDistance;
		
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
        
        asymmetricFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        asymmetricFrame.setTitle("Travelling Salesman Problem - Asymmetric");
        asymmetricFrame.pack();
        asymmetricFrame.setVisible(true);
	}
    
}
