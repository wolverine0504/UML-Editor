package UMLmode;

import UMLObject.Shape;
import mainGUI.EditorPanel;

import java.awt.event.MouseEvent;

public class ObjectMode extends Mode {
    ShapeGenerator shapeGenerator;

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Object Mode mouse release");
        shapeGenerator=new BasicObjectGenerator(e.getPoint(),editorPanel.getCurrentShape());
        Shape basicObjectShape = shapeGenerator.getBasicObjectShape();
        editorPanel.addShape(basicObjectShape);
        editorPanel.repaint();
    }
}
