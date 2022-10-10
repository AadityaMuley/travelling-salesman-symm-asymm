import java.io.File;
import java.util.Scanner;

public class ParseSymmetricData {

	public static int arrLen;
	public static float[][] coords;

	public static void getDimension(File file) {
		try {
			Scanner sc = new Scanner(file);

        	while(sc.nextLine().equals("EOF") == false) {
				
				String currWord = sc.next();

				if(currWord.equalsIgnoreCase("DIMENSION:")) {
					String len = sc.next();
					arrLen = Integer.parseInt(len);
					break;
				}
        	}

			sc.close();
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void getCoords(File file) {
		try {
			Scanner sc = new Scanner(file);

        	while(sc.nextLine().equals("EOF") == false) {
				
				String currWord = sc.next();

				if(currWord.equalsIgnoreCase("NODE_COORD_SECTION")) {
					for(int i=0; i<arrLen; i++) {
						sc.next();
						coords[arrLen][0] = Float.parseFloat(sc.next());
						coords[arrLen][1] = Float.parseFloat(sc.next());
					}
				}
        	}

			sc.close();
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static void main(String[] args) throws Exception {

        try {
            File file = new File("data/symmetric/djibouti.tsp");
			getDimension(file);
			//System.out.println(arrLen);

			coords = new float[arrLen][2];
        	getCoords(file);
			for(int i=0; i<arrLen; i++) {
				System.out.print(i+1 + " " + coords[arrLen][0] + " ");
				System.out.println(coords[arrLen][1]);
			}
        }
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
}
