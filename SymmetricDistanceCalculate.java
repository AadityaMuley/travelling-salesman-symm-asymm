import java.lang.Math;

/**
 * SymmetricDistanceCalculate is the class that calculates the distance between two points, given their coordinates.
 * @author Aditya Muley(amuley2@asu.edu), Manasi Anantpurkar(manantpu@asu.edu), Jash Kahar(jkahar@asu.edu), Sarthak Vats(svats2@asu.edu)
 */

public class SymmetricDistanceCalculate {
    /**
     * euclidianDistance class calculates the distance between two points by using the Mathematics formula.
     * @param x1 represents the x coordinate of the first point.
     * @param y1 represents the y coordinate of the first point.
     * @param x2 represents the x coordinate of the second point.
     * @param y2 represents the y coordinate of the second point.
     * @return the calculated distance.
     */
    
    private float euclidianDistance(float x1, float y1, float x2, float y2) {
        
        float euclidianDistance = (float)Math.sqrt((Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2)));

        return(euclidianDistance);
    }

    /**
     * calculateDistances creates a matrix where distance between two nodes are added in the row,column position of the matrix.
     * @param arrLen is the dimension of the coordinates matrix, also represents number of nodes.
     * @param coords is the matrix that contains coordinates of all points.
     * @return symmetricDistance is matrix that contains distances of all points with all other points.
     */
    public float[][] calculateDistances(int arrLen, float[][] coords) {
        float[][] symmetricDistances = new float[arrLen][arrLen];
        float tempDist;

        for(int i=0; i<arrLen-1; i++) {
            symmetricDistances[i][i] = 0.0f;
            for(int j=i+1; j<arrLen; j++){
                tempDist = euclidianDistance(coords[i][0], coords[i][1], coords[j][0], coords[j][1]);
                symmetricDistances[i][j] = tempDist;
                symmetricDistances[j][i] = tempDist;
            }
        }

        return(symmetricDistances);
    }
}
