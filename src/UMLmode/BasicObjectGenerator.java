package UMLmode;

import UMLObject.BasicObject;
import UMLObject.ClassObject;
import UMLObject.LineObject;
import UMLObject.UseCaseObject;

import java.awt.*;

public class BasicObjectGenerator extends ShapeGenerator{

    private Point mouseLocation;
    private String basicObjectType;

    public BasicObjectGenerator(Point mouseLocation, String basicObjectType) {
        this.mouseLocation = mouseLocation;
        this.basicObjectType = basicObjectType;
    }

    @Override
    public LineObject getLineObjectShape() {
        return null;
    }

    @Override
    public BasicObject getBasicObjectShape() {
        if(basicObjectType.equals("useCaseObject")){
            return new UseCaseObject(mouseLocation);
        }else if(basicObjectType.equals("classObject")){
            return new ClassObject(mouseLocation);
        }
        return null;
    }
}
