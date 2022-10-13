import java.io.File;

public class SymmetricMain {
    private int arrLen;
	private float[][] coords;
	private float[][] symmetricDistances;
	private float[][] shortestPath;
	private double totalDistance;

	public void symmetricPanel() {

		ParseSymmetricData parseSymmetricData = new ParseSymmetricData();
		coords = parseSymmetricData.parseSymmData();
		this.arrLen = parseSymmetricData.arrLen;
		// for(int i=0; i<arrLen; i++) {
		// 		System.out.println(i+1 + " " + coords[i][0] + " " + coords[i][1]);
		// 	}

		SymmetricDistanceCalculate symmetricDistanceCalculate = new SymmetricDistanceCalculate();
		symmetricDistances = symmetricDistanceCalculate.calculateDistances(arrLen, coords);
		for(int i=0; i<arrLen; i++) {
			for(int j=0; j<arrLen; j++){
				System.out.print(symmetricDistances[i][j] + "            ");
			}
			System.out.println();
		}

		TSPGreedy tspGreedy = new TSPGreedy();
		shortestPath = tspGreedy.greedyShortestPath(arrLen, coords);
		totalDistance = tspGreedy.totalDistance;
		// System.out.println(this.totalDistance);
	}
}
