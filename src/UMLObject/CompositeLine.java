package UMLObject;

import java.awt.*;

public class CompositeLine extends LineObject{

    private int diamondW = 10, diamondH = 10;
    public CompositeLine(Point mouseStartPoint, Point mouseEndPoint) {
        this.objectLeftX=(int) mouseStartPoint.getX();
        this.objectLeftY = (int) mouseStartPoint.getY();
        this.objectRightX= (int) mouseEndPoint.getX();
        this.objectRightY = (int) mouseEndPoint.getY();
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象

        g2.setColor(Color.BLACK);
        g2.drawLine(this.objectLeftX, this.objectLeftY, this.objectRightX, this.objectRightY);

        int dx = this.objectRightX - this.objectLeftX;
        int dy = this.objectRightY - this.objectLeftY;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + this.objectLeftX;
        ym = xm*sin + ym*cos + this.objectLeftY;
        xm = x;

        x = xn*cos - yn*sin + this.objectLeftX;
        yn = xn*sin + yn*cos + this.objectLeftY;
        xn = x;


        double xq = (diamondH*2/D)*this.objectLeftX + ((D-diamondH*2)/D)*this.objectRightX;
        double yq = (diamondH*2/D)*this.objectLeftY + ((D-diamondH*2)/D)*this.objectRightY;

        int[] xpoints = {this.objectRightX, (int) xm, (int) xq, (int) xn};
        int[] ypoints = {this.objectRightY, (int) ym, (int) yq, (int) yn};

        g2.fillPolygon(xpoints, ypoints, 4);
        g2.setPaint(Color.BLACK);

    }
}
