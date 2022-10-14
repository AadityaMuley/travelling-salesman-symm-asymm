import javax.swing.*;
import java.awt.*;
/**
 * SymmetricMain is the class that controls all operations of the Symmetric DataSet. It displays the plot of all city coordinates, 
 * the traversal order of nodes, and the total distance travelled.
 * @author Aditya Muley(amuley2@asu.edu), Manasi Anantpurkar(manantpu@asu.edu), Jash Kahar(jkahar@asu.edu), Sarthak Vats(svats2@asu.edu)
 */

public class SymmetricMain extends JFrame{

    private int arrLen;
	private float[][] coords;
	private float[][] symmetricDistances;
	private int[] shortestPath;
	private float totalDistance;

	private JFrame symmetricFrame;
    private JPanel symmetricPanel;
	private JScrollPane scrollSymmetricView;

	private JLabel totalDistanceLabel;
	private JLabel shortestPathLabel;
	private JLabel path;

	private Plot plot;
	/**
    	* Symmetric Main calls the Plot class to display all city coordinates as points on a map. 
	* It creates a new grid for mapping the coordinates of cities on the interface. 
	*/
	SymmetricMain() {
		this.plot = new Plot();

		GridBagConstraints constraints = new GridBagConstraints();
        plot = new Plot();
        setLayout(new GridBagLayout());
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0; constraints.weighty = 1.0;
        constraints.gridx = 0; constraints.gridy = 1; constraints.gridwidth = 2;
        constraints.insets = new Insets(5,10,5,10);
        add(plot, constraints);

		setSize(1300, 2000);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
    	* SymmetricPanel class uses a new interface. It called ParseSymmetric Data class to obtain the input data in matrix type.
	* It calls TSPGreedy class to implement the logic on the given matrix and then displays total distance and path in which it traverses.
	* The path is displayed in a scrollable window in the Panel.
	*/ 
	
	public void symmetricPanel() {

		symmetricFrame = new JFrame();
		symmetricPanel = new JPanel();

		symmetricPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		symmetricPanel.setLayout(new GridLayout(0, 1));

		ParseSymmetricData parseSymmetricData = new ParseSymmetricData();
		coords = parseSymmetricData.parseSymmData();
		this.arrLen = parseSymmetricData.arrLen;
		plot.setCoords(coords);
		plot.repaint();
		
		SymmetricDistanceCalculate symmetricDistanceCalculate = new SymmetricDistanceCalculate();
		symmetricDistances = symmetricDistanceCalculate.calculateDistances(arrLen, coords);

		TSPGreedy tspGreedy = new TSPGreedy();
		shortestPath = new int[arrLen];
		shortestPath = tspGreedy.greedyShortestPath(symmetricDistances, arrLen);
		totalDistance = tspGreedy.totalDistance;
		
		totalDistanceLabel = new JLabel();
		totalDistanceLabel.setText("Total distance travelled: " + Float.toString(totalDistance));
		symmetricPanel.add(totalDistanceLabel);

		path = new JLabel();
		path.setText("The shortest path is: ");
		path.setFont(new Font("Serif", Font.PLAIN, 14));
		symmetricPanel.add(path);

		String shortestPathString = Integer.toString(shortestPath[0]);
		for(int i=1; i<arrLen; i++) {
			shortestPathString = shortestPathString + " --> " + shortestPath[i];
		}
		shortestPathLabel = new JLabel(shortestPathString);
		shortestPathLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		symmetricPanel.add(shortestPathLabel);
		
		scrollSymmetricView = new JScrollPane(symmetricPanel, 
			ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		symmetricFrame.add(scrollSymmetricView);
		
        symmetricFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        symmetricFrame.setTitle("Travelling Salesman Problem - Symmetric");
        symmetricFrame.pack();
        symmetricFrame.setVisible(true);
	}
}
