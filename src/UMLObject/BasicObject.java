package UMLObject;

import java.awt.*;

public class BasicObject extends Shape{

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

    public void initializePortLocation(){
        //specify the x and y of each port:左,下,右,上
        int coordinatesX[]={(int)(this.objectLeftX),(int)(this.objectLeftX+this.width/2),(int)(this.objectLeftX+width),(int)(this.objectLeftX+this.width/2)};
        int coordinatesY[]={(int)(this.objectLeftY+height/2),(int)(this.objectLeftY+height),(int)(this.objectLeftY+height/2),(int)(this.objectLeftY)};
        for (int i = 0; i < ports.length; i++) {
            Port port = new Port();
            port.setPort(coordinatesX[i],coordinatesY[i]);
            ports[i]=port;
        }
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void selectSwitch(Boolean chosen) {

    }


}
