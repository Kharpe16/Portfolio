/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingprogram;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Kaylyn Harper
 */
public abstract class Shape {

    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected Color lineColor;
    /**
     * Constructor that takes in the information need to draw a Shape
     * @param startX The top left X coordinate
     * @param startY The top left Y coordinate
     * @param endX
     * @param endY
     * @param lineColor The color of the line 
     */
    public Shape(int startX, int startY, int endX, int endY, Color lineColor) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lineColor = lineColor;
    }
    /**
     * Abstract method that draws the shape
     * @param g2d 
     */
    public abstract void draw(Graphics2D g2d);
    
}
