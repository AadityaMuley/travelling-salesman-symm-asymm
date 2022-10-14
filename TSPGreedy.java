
/**
 * TSPGreedy is the Traveling Salesman solver class 
 * @author Aditya Muley(amuley2@asu.edu), Manasi Anantpurkar(manantpu@asu.edu), Jash Kahar(jkahar@asu.edu), Sarthak Vats(svats2@asu.edu)
 */
public class TSPGreedy {
	public float totalDistance = 0.0f;
	public int[] shortestPath;
	private boolean[] visitedCities;
	
	/** This function uses greedy approach to solve the TSP.
	 * @param symmetricDistances is the distance matrix
	 * @param arrLen dimension of the input.
	 * @return the result which is an array of the cities in the order of traversal.
	 */
    public int[] greedyShortestPath(float symmetricDistances[][], int arrLen) {
        
		visitedCities = new boolean[arrLen];
		shortestPath = new int[arrLen];
		visitedCities[0] = true;
		shortestPath[0] += 1;

		float tempShortestDistance;
		int nxtCity = 0;
		int i,j, k=1;
		for(i=0; i<arrLen-1; i++) {
			tempShortestDistance = 0.0f;
			for(j=0; j<arrLen; j++) {
				if(visitedCities[j] == false && tempShortestDistance<symmetricDistances[i][j]) {
					tempShortestDistance = symmetricDistances[i][j];
					nxtCity = j;
				}
			}
			totalDistance += tempShortestDistance;
			shortestPath[k] += nxtCity+1;
			k++;
			visitedCities[nxtCity] = true;
		}

		return(shortestPath);
    }
}
