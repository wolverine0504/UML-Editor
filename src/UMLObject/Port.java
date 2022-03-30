package UMLObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

public class Port {
    private int portX;
    private int portY;
    private final int portHeight = 10;
    private final int portWidth = 10;
    public static final int portOffset=5;
    private final int detectionRange=50;
    private Vector<LineObject> lineObjectVector=new Vector<>();

    public int getPortWidth() { return portWidth; }

    public int getDetectionRange() {
        return detectionRange;
    }

    public int getPortX() {
        return portX;
    }

    public int getPortY() {return portY;}

    public Point getPortPoint(){
        return new Point(portX,portY);
    }

    public void setPort(int portX, int portY) {
        this.portX = portX;
        this.portY = portY;
    }

    public void addLine(LineObject line) {
        this.lineObjectVector.add(line);
    }

    public void drawPort(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.BLACK);
        g2.fill(new Rectangle2D.Double(portX - portWidth / 2, portY - portHeight / 2, portWidth, portHeight));
        for(int i = 0; i < lineObjectVector.size(); i++) {
            lineObjectVector.elementAt(i).draw(g2);
        }
    }

    public void resetAllLineLocationOfPort() {
        for (int i = 0; i < lineObjectVector.size(); i++) {
            LineObject line = lineObjectVector.elementAt(i);
            System.out.println(line);
            line.resetLineLocation();
        }
    }


}
