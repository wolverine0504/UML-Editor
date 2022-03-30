package UMLObject;

import java.awt.*;

public class AssociateLine extends LineObject{
    public AssociateLine(Point mouseStartPoint, Point mouseEndPoint) {
        this.objectLeftX=(int) mouseStartPoint.getX();
        this.objectLeftY = (int) mouseStartPoint.getY();
        this.objectRightX= (int) mouseEndPoint.getX();
        this.objectRightY = (int) mouseEndPoint.getY();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象
        //g2.setStroke(new BasicStroke(1.0f));

        g2.setColor(Color.BLACK);
        g2.drawLine(this.objectLeftX, this.objectLeftY, this.objectRightX, this.objectRightY);
    }
}
