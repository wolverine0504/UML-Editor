package UMLObject;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class UseCaseObject extends BasicObject{
    public UseCaseObject(Point mouseLocation) {
        this.objectName="UseCase";
        initializeShapeLocation(mouseLocation);
        initializePortLocation();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        FontMetrics fm = g2.getFontMetrics();
        int textLocX = (int) this.objectLeftX + ((int) width - fm.stringWidth(objectName)) / 2;
        int textLocY = (int) this.objectLeftY + (int) height / 2;

        g2.setPaint(Color.BLACK);
        g2.draw(new Ellipse2D.Double(objectLeftX, objectLeftY,width, height));
        g2.drawString(objectName, textLocX, textLocY);

        if (isSelected == true) {
            for (int i = 0; i < ports.length; i++) {
                ports[i].drawPort(g2);
            }
        }
    }
}
