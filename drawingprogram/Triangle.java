package drawingprogram;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Kaylyn Harper
 */
public class Triangle extends Shape {

    private Color fillColour;
    //Arrays to hold the x and y points
    private int[] xArray;
    private int[] yArray;

    /**
     * @param startX The top left X coordinate
     * @param startY The top left Y coordinate
     * @param endX
     * @param endY
     * @param lineColor The line color
     * @param fillColor The fill color
     */
    public Triangle(int startX, int startY, int endX, int endY, Color lineColor, Color fillColor) {
        //Calls the Shape constructor
        super(startX, startY, endX, endY, lineColor);
        fillColour = fillColor;
        //The left x point
        int lX = 0;
        //The right x point
        int RX = 0;

        //Sets lX and RX based on the startX and endX values
        if (endX < startX) {
            lX = endX;
            RX = endX + ((startX - endX) * 2);
        } else if (endX > startX) {
            RX = endX;
            lX = endX + ((startX - endX) * 2);
        } else {
            RX = endX;
            lX = endX;
        }
        //Creates arrays to hold the x and y values
        int XVals[] = {lX, RX, startX};
        int YVals[] = {endY, endY, startY};
        //sets the xArray and the yArray to the X and y vals arrays
        xArray = XVals;
        yArray = YVals;

    }

    /**
     * Draws the Triangle
     *
     * @param g2d
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(fillColour);
        g2d.fillPolygon(xArray, yArray, 3);
        g2d.setColor(lineColor);
        g2d.drawPolygon(xArray, yArray, 3);

    }

    /**
     * This static method is used to draw a Triangle before an actual Triangle
     * object is created It is used to give the user interactive feedback as
     * they are dragging the cursor
     *
     * @param g2d The graphics context needed for drawing
     * @param x1 int x coordinate from where mouse pressed down
     * @param y1 int y coordinate from where mouse pressed down
     * @param x2 int x coordinate from where mouse released
     * @param y2 int y coordinate from where mouse released
     * @param lc Color for line color
     * @param fc Color for fill color
     */
    public static void draw(Graphics2D g2d, int x1, int y1, int x2, int y2, Color lc, Color fc) {
        int lX = 0;
        int rX = 0;

        if (x2 < x1) {
            lX = x2;
            rX = x2 + ((x1 - x2) * 2);
        } else if (x2 > x1) {
            rX = x2;
            lX = x2 + ((x1 - x2) * 2);

        } else {
            rX = x2;
            lX = x2;
        }
        int xs[] = {lX, rX, x1};
        int ys[] = {y2, y2, y1};

        g2d.setColor(fc);
        g2d.fillPolygon(xs, ys, 3);
        g2d.setColor(lc);
        g2d.drawPolygon(xs, ys, 3);

    }

}
