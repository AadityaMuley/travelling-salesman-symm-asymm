import java.io.File;

public class SymmetricMain {
    private int arrLen;
	private float[][] coords;

    public void parseSymmData() {
        try {
            File file = new File("data/symmetric/djibouti.tsp");

            ParseSymmetricData parseSymmetricData = new ParseSymmetricData();
			arrLen = parseSymmetricData.getDimension(file);
			//System.out.println(arrLen);

			coords = new float[arrLen][2];
        	coords = parseSymmetricData.getCoords(file, arrLen);
			for(int i=0; i<arrLen; i++) {
				System.out.print(i+1 + " " + coords[i][0] + " ");
				System.out.println(coords[i][1]);
			}
        }
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
}
