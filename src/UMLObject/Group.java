package UMLObject;

import java.awt.*;
import java.util.Vector;

public class Group extends Shape{

    private Vector<Shape> originalSelectedShapeGroupVector = new Vector<>();
    private int groupLeftX;
    private int groupLeftY;
    private int groupRightX;
    private int groupRightY;
    private int width;
    private int height;
    private boolean isSelected = false;

    public void addSelectedShapeToGroup(Vector selectedShapeVector){
        for (int i = 0; i < selectedShapeVector.size(); i++) {
            this.originalSelectedShapeGroupVector.add((Shape)selectedShapeVector.elementAt(i));
        }
    }

    public Vector<Shape> getOriginalSelectedShapeGroupVector() {
        return originalSelectedShapeGroupVector;
    }

    @Override
    public Port[] getPorts() {
        return new Port[0];
    }

    @Override
    public Point getInitialPoint() {
        this.groupRightX = 0;
        this.groupRightY = 0;
        this.groupLeftX = 1200;
        this.groupLeftY = 1200;
        //找到最左邊最上面的點當group的 Left(X,Y) 最右邊最下面的點當group的 Right(X,Y)
        for (int i = 0; i < originalSelectedShapeGroupVector.size(); i++) {
            Shape object=originalSelectedShapeGroupVector.elementAt(i);
            int tmpGroupLeftX = (int) object.getInitialPoint().getX();
            int tmpGroupLeftY = (int) object.getInitialPoint().getY();
            int tmpGroupRightX = (int) object.getInitialPoint().getX() + object.getWidth();
            int tmpGroupRightY = (int) object.getInitialPoint().getY() + object.getHeight();

            if (tmpGroupLeftX < this.groupLeftX){
                this.groupLeftX = tmpGroupLeftX;
            }
            if (tmpGroupLeftY < this.groupLeftY) {
                this.groupLeftY = tmpGroupLeftY;
            }
            if (tmpGroupRightX > this.groupRightX){
                this.groupRightX = tmpGroupRightX;
            }
            if (tmpGroupRightY > this.groupRightY){
                this.groupRightY = tmpGroupRightY;
            }
        }
        return new Point(groupLeftX,groupLeftY);
    }

    @Override
    public int getHeight() {
        height = this.groupRightY - this.groupLeftY;
        return height;
    }

    @Override
    public int getWidth() {
        width = this.groupRightX - this.groupLeftX;
        return width;
    }

    @Override
    public void resetObjectLocation(int deltaX, int deltaY) {
        //reset every object's location in the group
        for (int i = 0; i < originalSelectedShapeGroupVector.size(); i++) {
            Shape object=originalSelectedShapeGroupVector.elementAt(i);
            object.resetObjectLocation(deltaX,deltaY);
        }
        getInitialPoint();
    }

    @Override
    public void resetLineLocation() {

    }

    @Override
    public void draw(Graphics g) {
        System.out.println("Repaint group shape");
        for (int i = 0; i < originalSelectedShapeGroupVector.size(); i++) {
            Shape object= originalSelectedShapeGroupVector.elementAt(i);
            object.draw(g);
        }

        if(isSelected==true){
            System.out.println("group selected");
            g.setColor(new Color(155, 200, 123, 127));
            g.fillRect(this.groupLeftX, this.groupLeftY, width, height);
        }
    }

    @Override
    public void selectSwitch(Boolean choice) {
        this.isSelected=choice;
        for (int i = 0; i < originalSelectedShapeGroupVector.size(); i++) {
            Shape object=originalSelectedShapeGroupVector.elementAt(i);
            object.selectSwitch(choice);
        }

    }
}
