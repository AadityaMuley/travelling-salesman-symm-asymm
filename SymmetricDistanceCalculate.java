import java.lang.Math;

public class SymmetricDistanceCalculate {

    private float euclidianDistance(float x1, float y1, float x2, float y2) {
        
        float euclidianDistance = (float)Math.sqrt((Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2)));

        return(euclidianDistance);
    }

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
