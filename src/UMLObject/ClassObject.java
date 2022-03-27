package UMLObject;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ClassObject extends BasicObject{
    public ClassObject(Point mouseLocation) {
        this.objectName="Class";
        initializeShapeLocation(mouseLocation);
        initializePortLocation();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        double firstSepLineLocY = this.objectLeftY + 50;
        double secondSepLineLocY = this.objectLeftY + 100;

        FontMetrics fm = g2.getFontMetrics();
        int textLocX = (int) this.objectLeftX + ((int) width - fm.stringWidth(objectName)) / 2;
        int textLocY = (int) this.objectLeftY + 30;

        g2.setPaint(Color.BLACK);
        g2.draw(new Rectangle2D.Double(objectLeftX, objectLeftY, width, height));
        g2.draw(new Line2D.Double(objectLeftX, firstSepLineLocY, objectLeftX+width, firstSepLineLocY));
        g2.draw(new Line2D.Double(objectLeftX, secondSepLineLocY, objectLeftX+width, secondSepLineLocY));
        g2.drawString(objectName, textLocX, textLocY);


        if (isSelected == true) {
            for (int i = 0; i < ports.length; i++){
                ports[i].drawPort(g2);
            }
        }
    }
}
