import java.io.File;
import java.util.Scanner;

/**
 * ParseSymmetricData is a child class of ParseData which handles processing
 * of symmetric data.
 * @author Aditya Muley(amuley2@asu.edu), Manasi Anantpurkar(manantpu@asu.edu), Jash Kahar(jkahar@asu.edu), Sarthak Vats(svats2@asu.edu)
 */
public class ParseSymmetricData implements ParseData {

	public int arrLen;
	public float[][] coords;
	
	/**
	 * This fucntion is used to read the input data.
	 * @param file is the input file which contains the raw data.
	 * @return the dimension of the file.
	 */
	public int getDimension(File file) {
		try {
			Scanner sc = new Scanner(file);

        	while(sc.nextLine().equals("EOF") == false) {
				
				String currWord = sc.next();

				if(currWord.equalsIgnoreCase("DIMENSION:")) {
					String len = sc.next();
					sc.close();
					return(Integer.parseInt(len));
				}
        	}

			sc.close();
		}
		catch(Exception e) {
			System.out.println("Error in dimension: " + e.getMessage());
		}
		return(0);
	}

	/** This function is used to get the coordinates of the points in the data.
	 * @param file is the input data file
	 * @param arrLen is the dimension of file.
	 * @return coordinates in a matrix format.
	 */
	public float[][] getCoords(File file, int arrLen) {
		float coords[][] = new float[arrLen][2];

		try {
			Scanner sc = new Scanner(file);

        	while(sc.nextLine().equals("EOF") == false) {
				
				String currWord = sc.next();

				if(currWord.equalsIgnoreCase("NODE_COORD_SECTION")) {
					for(int i=0; i<arrLen; i++) {
						sc.next();
						coords[i][0] = Float.parseFloat(sc.next());
						coords[i][1] = Float.parseFloat(sc.next());
					}
					sc.close();
					return(coords);
				}
        	}

			sc.close();
		}
		catch(Exception e) {
			System.out.println("Error in coords: " + e.getMessage());
		}
		return(coords);
	}

	/** This function loads the file which contains the input data.
	 * @return coordinates in a matrix format.
	 */
	public float[][] parseSymmData() {
        try {
            File file = new File("data/symmetric/symmetric_data.tsp");
			arrLen = getDimension(file);
			//System.out.println(arrLen);

			coords = new float[arrLen][2];
        	coords = getCoords(file, arrLen);
			// for(int i=0; i<arrLen; i++) {
			// 	System.out.println(i+1 + " " + coords[i][0] + " " + coords[i][1]);
			// }

			return(coords);
        }
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
			coords = new float[0][0];
			return(coords);
		}
    }
}
