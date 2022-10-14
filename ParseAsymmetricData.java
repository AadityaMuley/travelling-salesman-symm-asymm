import java.io.File;
import java.util.Scanner;

public class ParseAsymmetricData implements ParseData {

    public int arrLen;
	public float[][] coords;

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
		float coords[][] = new float[arrLen][arrLen];

		try {
			Scanner sc = new Scanner(file);

        	while(sc.nextLine().equals("EOF") == false) {
				
				String currWord = sc.next();
                if(currWord.equals("EOF")) break;
				if(currWord.equalsIgnoreCase("EDGE_WEIGHT_SECTION")) {
					for(int i=0; i<arrLen; i++) {
						sc.next();

						for(int j=0;j<arrLen;j++){
							coords[i][j] = Float.parseFloat(sc.next());
							//System.out.println(coords[i][j]);
						}

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

	public float[][] parseAsymmData() {
        try {
            File file = new File("data/asymmetric/asymmetric_data.txt");
			arrLen = getDimension(file);
			//System.out.println(arrLen);

			coords = new float[arrLen][arrLen];
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
