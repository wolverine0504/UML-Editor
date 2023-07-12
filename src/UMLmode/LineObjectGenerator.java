package UMLmode;

import UMLObject.*;

import java.awt.*;

public class LineObjectGenerator extends ShapeGenerator {

    private String lineObjectType;
    private Point mouseStartPoint;
    private Point mouseEndPoint;

    public LineObjectGenerator(String lineObjectType, Point mouseStartPoint, Point mouseEndPoint) {
        this.lineObjectType = lineObjectType;
        this.mouseStartPoint = mouseStartPoint;
        this.mouseEndPoint = mouseEndPoint;
    }

    @Override
    public LineObject getLineObjectShape() {
        if (lineObjectType.equals("associateLine")) {
            return new AssociateLine(mouseStartPoint, mouseEndPoint);
        } else if (lineObjectType.equals("generalLine")) {
            return new GeneralLine(mouseStartPoint, mouseEndPoint);
        } else if (lineObjectType.equals("compositeLine")) {
            return new CompositeLine(mouseStartPoint, mouseEndPoint);
        }
        return null;
    }

    @Override
    public BasicObject getBasicObjectShape() {
        return null;
    }
}
