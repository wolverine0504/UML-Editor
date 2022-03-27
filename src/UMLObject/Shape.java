package UMLObject;

import mainGUI.EditorPanel;

import java.awt.*;

public abstract class Shape {

    EditorPanel editorPanel = EditorPanel.getInstance();
    protected Boolean isSelected;

    public abstract void draw(Graphics g);
    public abstract void selectSwitch(Boolean chosen);

}
