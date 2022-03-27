package UMLObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

public class Port {
    private int portX;
    private int portY;
    private final int portHeight = 10;
    private final int portWidth = 10;
    protected Vector<LineObject> lineObjVector = new Vector();

    public void setPort(int portX, int portY) {
        this.portX = portX;
        this.portY = portY;
    }

    public void drawPort(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.WHITE);
        g2.fill(new Rectangle2D.Double(portX - portWidth / 2, portY - portHeight / 2, portWidth, portHeight));
        for(int i = 0; i < lineObjVector.size(); i++) {
            lineObjVector.elementAt(i).draw(g2);
        }
    }
}
