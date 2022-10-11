import java.io.File;

public interface ParseData {
    
    public int getDimension(File file);

    public float[][] getCoords(File file, int arrLen);
}
