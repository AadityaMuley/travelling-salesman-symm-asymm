import java.io.File;
/** ParseData is an Interface class 
 * @author Aditya Mule, Manasi Anantpurkar, Jash Kahar, Sarthak Vats
 */
public interface ParseData {
    
    /** Function getDimension is initialised here and needs to be implemented in a child class.
     * @params file is the input file which contains the raw data.
     */
    public int getDimension(File file);
    
    /** Function getCoords is initialised here and needs to be implemented in a child class.
     * @param file is the input data file
	 * @param arrLen is the dimension of file.
     */
    public float[][] getCoords(File file, int arrLen);
}
