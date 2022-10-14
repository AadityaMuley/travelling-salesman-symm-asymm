import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Plot is the class that scales the coordinates of points to fit all of them in the plotted interface. It also calculates the 
 * minimum and maximum x and y coordinates of the map.
 * @author Aditya Muley(amuley2@asu.edu), Manasi Anantpurkar(manantpu@asu.edu), Jash Kahar(jkahar@asu.edu), Sarthak Vats(svats2@asu.edu)
 */

public class Plot extends JPanel {
    private static final double X_AXIS = 20.0;
    private static final double Y_AXIS = 20.0;
    private static final double POINT_DIAMETER = 2.0;

    private double min_x_axis, max_x_axis, min_y_axis, max_y_axis = 0.0;

    private float[][] coords;

    /**
    * Plot sets the background and border of the mapping section in GUI.
    */
    public Plot() {
        setBackground(Color.decode("#000000"));
        setBorder(BorderFactory.createLineBorder(Color.decode("#ebcd4b")));
    }

    @Override
    /**
     * paintComponent calculates the scaling factors of x and y coordinates. It then parses through all the coordinates
     * and then scales each of them to fit in the graphic interface. It then plots these scaled values on the graphics interface.
     * @param g inputs the graphical interface on which the points are to be plotted.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("In paintComponent");
        double scaleX = (max_x_axis - min_x_axis) != 0 ? ((getWidth()  - X_AXIS * 2) / (max_x_axis - min_x_axis)) : 1;
        double scaleY = (max_y_axis - min_y_axis) != 0 ? ((getHeight() - Y_AXIS * 2) / (max_y_axis - min_y_axis)) : 1;

        Graphics2D g2D = (Graphics2D) g;

        if (coords != null && coords.length > 0) {
            g2D.setColor(Color.decode("#dbc8d9"));
            for (float city[] : coords) {
                double x1 = (city[0] - min_x_axis) * scaleX + X_AXIS - POINT_DIAMETER / 2;
                double y1 = (city[1] - min_y_axis) * scaleY + Y_AXIS - POINT_DIAMETER / 2;
                g2D.fill(new Ellipse2D.Double(-x1+1400, y1, POINT_DIAMETER, POINT_DIAMETER));
            }
        }
    }
    
    /**
     * setCoords class defines the maximum and minimum value of x and y to create a box in which all points should lie.
     * @param coords is the matrix that contains coordinates of all nodes.
     */
    
    public void setCoords(float coords[][]) {
        this.coords = coords;

        if (coords != null && coords.length > 0) {
            min_x_axis = max_x_axis = coords[0][0];
            min_y_axis = max_y_axis = coords[0][1];

            for (float city[] : coords) {
                if (city[0] < min_x_axis) min_x_axis = city[0];
                if (city[0] > max_x_axis) max_x_axis = city[0];

                if (city[1] < min_y_axis) min_y_axis = city[1];
                if (city[1] > max_y_axis) max_y_axis = city[1];
            }

            System.out.println("Reached");
        } else min_x_axis = max_x_axis = min_y_axis = max_y_axis = 0.0;
    }
}
