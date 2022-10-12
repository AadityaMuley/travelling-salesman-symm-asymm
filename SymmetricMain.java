import java.io.File;

public class SymmetricMain {
    private int arrLen;
	private float[][] coords;
	private float[][] shortestPath;
	private double totalDistance;

	public void symmetricPanel() {
		ParseSymmetricData parseSymmetricData = new ParseSymmetricData();
		coords = parseSymmetricData.parseSymmData();
		this.arrLen = parseSymmetricData.arrLen;
		// for(int i=0; i<arrLen; i++) {
		// 		System.out.println(i+1 + " " + coords[i][0] + " " + coords[i][1]);
		// 	}

		TSPGreedy tspGreedy = new TSPGreedy();
		shortestPath = tspGreedy.greedyShortestPath(arrLen, coords);
		totalDistance = tspGreedy.totalDistance;
		// System.out.println(this.totalDistance);
	}
}
