package UMLObject;

import mainGUI.EditorPanel;

import java.awt.*;

public abstract class Shape {

    EditorPanel editorPanel = EditorPanel.getInstance();
    protected Boolean isSelected;

    public abstract Port[] getPorts();
    public abstract Point getInitialPoint();
    public abstract int getHeight();
    public abstract int getWidth();
    public abstract void resetObjectLocation(int deltaX,int deltaY);
    public abstract void resetLineLocation();
    public abstract void draw(Graphics g);
    public abstract void selectSwitch(Boolean chosen);


}
