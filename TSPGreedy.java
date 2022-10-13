public class TSPGreedy {

    public float totalDistance = 0.0f;
	public int[] shortestPath;

	private boolean[] visitedCities;
    
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
