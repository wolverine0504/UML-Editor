package UMLObject;

import java.awt.*;

public class GeneralLine extends LineObject{
    private int arrowW = 10, arrowH = 10;
    public GeneralLine(Point mouseStartPoint, Point mouseEndPoint) {
        this.objectLeftX=(int) mouseStartPoint.getX();
        this.objectLeftY = (int) mouseStartPoint.getY();
        this.objectRightX= (int) mouseEndPoint.getX();
        this.objectRightY = (int) mouseEndPoint.getY();
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(this.objectLeftX, this.objectLeftY, this.objectRightX, this.objectRightY);

        int dx = this.objectRightX - this.objectLeftX, dy = this.objectRightY - this.objectLeftY;
        double D = Math.sqrt(dx*dx + dy*dy);

        double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + this.objectLeftX;
        ym = xm*sin + ym*cos + this.objectLeftY;
        xm = x;

        x = xn*cos - yn*sin + this.objectLeftX;
        yn = xn*sin + yn*cos + this.objectLeftY;
        xn = x;

        int[] xpoints = {this.objectRightX, (int) xm, (int) xn};
        int[] ypoints = {this.objectRightY, (int) ym, (int) yn};

        g.fillPolygon(xpoints, ypoints, 3);
    }
}
