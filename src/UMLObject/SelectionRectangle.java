package UMLObject;

import java.awt.*;

public class SelectionRectangle {
    private Point startPoint;
    private Point endPoint;
    private int rectangleAlpha=127;



    public SelectionRectangle(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public SelectionRectangle() {

    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
