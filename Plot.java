import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Plot extends JPanel {
    private static final double X_AXIS = 20.0;
    private static final double Y_AXIS = 20.0;
    private static final double POINT_DIAMETER = 2.0;

    private double min_x_axis, max_x_axis, min_y_axis, max_y_axis = 0.0;

    private float[][] coords;

    public Plot() {
        setBackground(Color.decode("#000000"));
        setBorder(BorderFactory.createLineBorder(Color.decode("#ebcd4b")));
    }

    @Override
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
                g2D.fill(new Ellipse2D.Double(x1, y1, POINT_DIAMETER, POINT_DIAMETER));
            }
        }
    }
    
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
