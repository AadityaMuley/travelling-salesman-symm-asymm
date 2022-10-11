import java.io.File;
import java.util.Scanner;

public class ParseSymmetricData implements ParseData {

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
}
