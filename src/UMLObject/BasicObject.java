package UMLObject;

import java.awt.*;
import java.net.PortUnreachableException;

public class BasicObject extends Shape {

    protected String objectName = null;
    protected Port[] ports = new Port[4];
    protected boolean isSelected = false;
    protected double width = 130;
    protected double height = 150;
    protected double mouseLocationX;
    protected double mouseLocationY;
    protected double objectLeftX;
    protected double objectLeftY;

    public void initializeShapeLocation(Point mouseLocation) {
        this.mouseLocationX = mouseLocation.getX();
        this.mouseLocationY = mouseLocation.getY();
        this.objectLeftX = this.mouseLocationX;
        this.objectLeftY = this.mouseLocationY;
    }

    public void initializePortLocation() {
        // specify the x and y of each port:左,下,右,上
        int portOffset = Port.portOffset;
        int coordinatesX[] = { (int) (this.objectLeftX - portOffset), (int) (this.objectLeftX + this.width / 2),
                (int) (this.objectLeftX + width + portOffset), (int) (this.objectLeftX + this.width / 2) };
        int coordinatesY[] = { (int) (this.objectLeftY + height / 2), (int) (this.objectLeftY + height + portOffset),
                (int) (this.objectLeftY + height / 2), (int) (this.objectLeftY - portOffset) };
        for (int i = 0; i < ports.length; i++) {
            Port port = new Port();
            port.setPort(coordinatesX[i], coordinatesY[i]);
            ports[i] = port;
        }
    }

    public void renameObject(String newName) {
        this.objectName = newName;
        editorPanel.repaint();
    }

    public String getObjectName() {
        return objectName;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void selectSwitch(Boolean choice) {
        this.isSelected = choice;
    }

    @Override
    public Port[] getPorts() {
        return ports;
    }

    @Override
    public Point getInitialPoint() {
        return new Point((int) objectLeftX, (int) objectLeftY);
    }

    @Override
    public int getHeight() {
        return (int) height;
    }

    @Override
    public int getWidth() {
        return (int) width;
    }

    @Override
    public void resetObjectLocation(int deltaX, int deltaY) {
        this.objectLeftX = objectLeftX + deltaX;
        this.objectLeftY = objectLeftY + deltaY;

        for (int i = 0; i < ports.length; i++) {
            int portX = ports[i].getPortX();
            int portY = ports[i].getPortY();
            ports[i].setPort(portX + deltaX, portY + deltaY);
            ports[i].resetAllLineLocationOfPort();
        }

    }

    @Override
    public void resetLineLocation() {
        return;
    }

}
