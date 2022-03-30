package UMLObject;

import java.awt.*;

public class LineObject extends Shape{
    protected Port[] ports = new Port[2];
    int objectLeftX;
    int objectLeftY;
    int objectRightX;
    int objectRightY;
    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void selectSwitch(Boolean chosen) {
        return;
    }

    @Override
    public Port[] getPorts() {
        return ports;
    }

    @Override
    public Point getInitialPoint() {
        return null;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void resetObjectLocation(int deltaX, int deltaY) {
        return;
    }


    @Override
    public void resetLineLocation() {
        this.objectLeftX = (int) ports[0].getPortPoint().getX();
        this.objectLeftY = (int) ports[0].getPortPoint().getY();
        this.objectRightX = (int) ports[1].getPortPoint().getX();
        this.objectRightY = (int) ports[1].getPortPoint().getY();
    }

    public void setLinePort(Port initPort, Port endPort) {
        ports[0]=initPort;
        ports[1]=endPort;
    }
}
