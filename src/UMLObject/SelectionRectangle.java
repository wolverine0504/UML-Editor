package UMLObject;

import java.awt.*;

public class SelectionRectangle {
    private Point startPoint=new Point(0,0);
    private Point endPoint=new Point(0,0);
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

    public int getRectangleAlpha() {
        return rectangleAlpha;
    }

    public void drawPerfectRect(Graphics g) {
        int x = startPoint.x;
        int y = startPoint.y;
        int x2 = endPoint.x;
        int y2 = endPoint.y;
        int px = Math.min(x, x2);
        int py = Math.min(y, y2);
        int pw = Math.abs(x - x2);
        int ph = Math.abs(y - y2);
        g.fillRect(px, py, pw, ph);
    }
}
