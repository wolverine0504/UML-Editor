package mainGUI;

import UMLObject.Group;
import UMLObject.LineObject;
import UMLObject.SelectionRectangle;
import UMLObject.Shape;
import UMLmode.Mode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;
import java.util.Vector;

public class EditorPanel extends JPanel {

    private static EditorPanel uniqueInstance;
    private EventListener currentListener = null;
    private Mode currentMode;
    private String currentShape;
    private Shape selectedShape = null;
    private Vector<Shape> allObjectVector = new Vector<>();
    private Vector<LineObject> lineVector = new Vector();
    private Vector<Shape> selectedShapeVector = new Vector();
    // 選取方塊
    private SelectionRectangle selectionRectangle = new SelectionRectangle();

    private EditorPanel() {
        setBackground(Color.WHITE);
    }

    public static EditorPanel getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new EditorPanel();
        }
        return uniqueInstance;
    }

    public void setCurrentMode(Mode currentMode) {
        this.currentMode = currentMode;
    }

    public void setCurrentShape(String currentShape) {
        this.currentShape = currentShape;
    }

    public Mode getCurrentMode() {
        return currentMode;
    }

    public String getCurrentShape() {
        return currentShape;
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public Vector<Shape> getAllObjectVector() {
        return allObjectVector;
    }

    public Vector<LineObject> getLineVector() {
        return lineVector;
    }

    public Vector<Shape> getSelectedShapeVector() {
        return selectedShapeVector;
    }

    public void addShape(Shape shape) {
        allObjectVector.add(shape);
    }

    public void addLineShape(LineObject line) {
        lineVector.add(line);
    }

    public SelectionRectangle getSelectionRectangle() {
        return selectionRectangle;
    }

    public void setSelectedShape(Shape selectedShape) {
        if (this.selectedShape != null) {
            (this.selectedShape).selectSwitch(false);
        }
        this.selectedShape = selectedShape;
        if (this.selectedShape != null) {
            (this.selectedShape).selectSwitch(true);
        }
        repaint();
    }

    public void setSelectedShapeFalse() {
        if (selectedShape != null) {
            this.selectedShape.selectSwitch(false);
        }
    }

    // selection的mouseDragged中，消除上一次還存在在selectedShapeVector裡面objects的port
    public void setSelectedShapeVectorFalse() {
        if (selectedShapeVector.size() != 0) {
            for (int i = 0; i < selectedShapeVector.size(); i++) {
                this.selectedShapeVector.elementAt(i).selectSwitch(false);
            }
        }
        repaint();
    }

    // selection的mouseDragged中，加入被框住object的ports
    public void setSelectedShapeVectorTrue() {
        if (selectedShapeVector.size() != 0) {
            for (int i = 0; i < selectedShapeVector.size(); i++) {
                this.selectedShapeVector.elementAt(i).selectSwitch(true);
            }
        }
        repaint();
    }

    public void setAllObjectVectorTop(Shape selectedShape) {
        for (int i = 0; i < allObjectVector.size(); i++) {
            if (selectedShape.equals(allObjectVector.elementAt(i))) {
                allObjectVector.remove(i);
                allObjectVector.add(selectedShape);
                return;
            }
        }
        return;
    }

    public void group() {
        Group group = new Group();
        group.addSelectedShapeToGroup(selectedShapeVector);
        clearOriginalShape();
        allObjectVector.add(group);
        group.getInitialPoint();
        group.selectSwitch(true);
        repaint();
    }
    //清除allObjectVector中原先被選擇的Shape
    //再把selectedShapeVector整個清掉因為已經是Group object了
    public void clearOriginalShape() {
        setSelectedShapeVectorFalse();
        for (int i = 0; i < selectedShapeVector.size(); i++) {
            allObjectVector.removeElement(selectedShapeVector.elementAt(i));
        }
        this.selectedShapeVector.removeAllElements();
    }

    public void ungroup() {
        Vector<Shape> originalSelectedShapeGroupVector = ((Group) selectedShape).getOriginalSelectedShapeGroupVector();
        allObjectVector.removeElement(selectedShape);
        for (int i = 0; i < originalSelectedShapeGroupVector.size(); i++) {
            allObjectVector.add(originalSelectedShapeGroupVector.elementAt(i));
        }
    }

    public void refreshListener() {
        System.out.println("refresh editorPanel Listener");
        setSelectedShapeFalse();
        setSelectedShapeVectorFalse();
        removeMouseListener((MouseListener) currentListener);
        removeMouseMotionListener((MouseMotionListener) currentListener);
        currentListener = currentMode;
        addMouseListener((MouseListener) currentListener);
        addMouseMotionListener((MouseMotionListener) currentListener);
    }

    public void paintComponent(Graphics g) {

        System.out.println("Panel repaint");

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < allObjectVector.size(); i++) {
            Shape object = allObjectVector.elementAt(i);
            object.draw(g2);
        }

        for (int i = 0; i < lineVector.size(); i++) {
            Shape line = lineVector.elementAt(i);
            line.draw(g2);
        }

        g2.setPaint(new Color(155, 200, 123, selectionRectangle.getRectangleAlpha()));
        selectionRectangle.drawPerfectRect(g2);

    }

}
