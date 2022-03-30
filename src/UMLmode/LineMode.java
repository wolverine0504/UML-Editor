package UMLmode;

import UMLObject.BasicObject;
import UMLObject.LineObject;
import UMLObject.Port;
import UMLObject.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineMode extends Mode{
    ShapeGenerator shapeGenerator;
    Point initPoint;
    Point endPoint;
    Port endPort;
    Port initPort;

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("---Line Mode Press---");
        this.initPort = PortDetection(e.getPoint());
        if (initPort != null) {
            System.out.println("Initial Point:("+initPort.getPortX()+","+initPort.getPortY()+")");
            this.initPoint = initPort.getPortPoint(); //取對準Port上面的Point
        }
        else{
            this.initPoint = null;
        }
        editorPanel.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("---Line Mode Drag---");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("---Line Mode Release---");
        this.endPort = PortDetection(e.getPoint());
        if (endPort!= null) {
            System.out.println("End Point:("+endPort.getPortX()+","+endPort.getPortY()+")");
            this.endPoint = endPort.getPortPoint();
            shapeGenerator = new LineObjectGenerator(editorPanel.getCurrentShape(), this.initPoint, this.endPoint);
            LineObject line = shapeGenerator.getLineObjectShape();
            this.initPort.addLine(line);
            this.endPort.addLine(line);
            line.setLinePort(initPort, endPort);
            editorPanel.addLineShape(line);
            //沒有delete 新的line直接覆蓋
        }
        else{
            //清空initial Point、Port
            this.initPoint = null;
            this.endPoint = null;
            this.endPort = null;
            this.initPort = null;
        }
        editorPanel.repaint();
    }

    //判斷這個點是否在任一個Object的其中一個port附近 是的話就回傳那個port
    public Port PortDetection(Point mouseLocation){
        System.out.println("PortDetection Start");
        int mouseLocX = (int) mouseLocation.getX();
        int mouseLocY = (int) mouseLocation.getY();
        System.out.println("mouseLocation:("+mouseLocX+","+mouseLocY+")");

        System.out.println("All objects:=========================");
        //iterate through every shape
        for (int i = 0; i < editorPanel.getAllObjectVector().size(); i++) {
            Shape object = editorPanel.getAllObjectVector().elementAt(i);
            Port[] allObjectPorts = object.getPorts();
            if(allObjectPorts.length!=0){
                System.out.println("each ports of "+((BasicObject)object).getObjectName());
                //iterate through every
                for (int j = 0; j < allObjectPorts.length; j++) {
                    int objectPortX=allObjectPorts[j].getPortX();
                    int objectPortY=allObjectPorts[j].getPortY();
                    int detectionLength=allObjectPorts[j].getDetectionRange();
                    System.out.println("port"+j+":("+objectPortX+","+objectPortY+")");

                    //判斷觸發點是否在port的偵測範圍內
                    if ((objectPortX - detectionLength / 2) <= mouseLocX &&
                            mouseLocX <= (objectPortX + detectionLength / 2) &&
                            (objectPortY - detectionLength / 2) <= mouseLocY &&
                            mouseLocY <= (objectPortY + detectionLength / 2)
                    ) {

                        System.out.println("It's in a port's range!");
                        return allObjectPorts[j];
                    }

                }
            }

        }
        System.out.println("PortDetection End");
        return null;

    }
}
