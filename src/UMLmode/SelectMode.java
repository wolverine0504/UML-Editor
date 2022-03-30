package UMLmode;

import UMLObject.BasicObject;
import UMLObject.SelectionRectangle;
import UMLObject.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class SelectMode extends Mode{

    private Point startPoint=null;
    private int px;
    private int py;
    private int pw;
    private int ph;


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Select Mode Mouse Clicked");
        SelectionRectangle selectionRectangle = editorPanel.getSelectionRectangle();
        //選取方塊座標歸零
        selectionRectangle.setStartPoint(new Point(0,0));
        selectionRectangle.setEndPoint(new Point(0,0));
        clickShapeDetection(e.getPoint());
        System.out.println("Panel current selected shape:"+editorPanel.getSelectedShape());
        editorPanel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("---Select Mode Press---");
        startPoint = e.getPoint();
        editorPanel.setSelectedShapeVectorFalse();
        if (editorPanel.getSelectedShapeVector().size() != 0) {
            editorPanel.getSelectedShapeVector().clear();
        }
        clickShapeDetection(e.getPoint());
        SelectionRectangle selectionRectangle = editorPanel.getSelectionRectangle();
        selectionRectangle.setStartPoint(startPoint);
        selectionRectangle.setEndPoint(startPoint);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("---Select Mode Drag---");
        int displacementX=(e.getX()-startPoint.x);
        int displacementY=(e.getY()-startPoint.y);

        Shape selectedShape=editorPanel.getSelectedShape();
        if(selectedShape!=null){
            //有已經選擇的Shape要移動
            selectedShape.resetObjectLocation(displacementX,displacementY);
            editorPanel.setAllObjectVectorTop(selectedShape);
            System.out.println("Dragging with Shape");
            this.startPoint=new Point(e.getX(),e.getY());
        }else{
            //沒有選擇Shape要畫選取方塊
            SelectionRectangle selectionRectangle = editorPanel.getSelectionRectangle();
            selectionRectangle.setEndPoint(e.getPoint());
            if (editorPanel.getSelectedShapeVector().size() != 0) {
                editorPanel.getSelectedShapeVector().removeAllElements();
            }
            setPerfectRectangle(selectionRectangle.getStartPoint().x,selectionRectangle.getStartPoint().y,selectionRectangle.getEndPoint().x,selectionRectangle.getEndPoint().y);
            dragShapeDetection();
        }
        editorPanel.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("---Select Mode Released---");
        SelectionRectangle selectionRectangle = editorPanel.getSelectionRectangle();
        selectionRectangle.setStartPoint(new Point(0,0));
        selectionRectangle.setEndPoint(new Point(0,0));
        editorPanel.repaint();
    }

    public void setPerfectRectangle(int x, int y, int x2, int y2) {
        this.px = Math.min(x, x2);
        this.py = Math.min(y, y2);
        this.pw = Math.abs(x - x2);
        this.ph = Math.abs(y - y2);
    }

    //判斷點擊有沒有在任何Shape的範圍
    public void clickShapeDetection(Point mouseLocation){
        System.out.println("clickShapeDetection Start at ("+mouseLocation.x+","+mouseLocation.y+")");
        Vector<Shape> allShapeVector=editorPanel.getAllObjectVector();
        System.out.println("All objects:=========================");
        //從最上面的開始找
        for (int i = allShapeVector.size()-1 ; i >= 0; i--) {
            System.out.println(((BasicObject)allShapeVector.elementAt(i)).getObjectName());
            int objectX=allShapeVector.elementAt(i).getInitialPoint().x;
            int objectY=allShapeVector.elementAt(i).getInitialPoint().y;
            int objectHeight=allShapeVector.elementAt(i).getHeight();
            int objectWidth=allShapeVector.elementAt(i).getWidth();
            int x=mouseLocation.x;
            int y=mouseLocation.y;

            if(x>=objectX && x<=(objectX+objectWidth) && y>=objectY && y<=(objectY+objectHeight)){
                System.out.println("click is in a Shape !!");
                editorPanel.setSelectedShape(allShapeVector.elementAt(i));
                return;
            }
        }
        editorPanel.setSelectedShape(null);
    }


    //判斷mouseDrag選取範圍有沒有Shape
    public void dragShapeDetection(){
        System.out.println("dragShapeDetection Start");
        Vector<Shape> allShapeVector=editorPanel.getAllObjectVector();
        System.out.println("All objects:=========================");
        //從最上面的開始找
        for (int i = 0 ; i < allShapeVector.size(); i++) {
            System.out.println(((BasicObject)allShapeVector.elementAt(i)).getObjectName());
            int objectX=allShapeVector.elementAt(i).getInitialPoint().x;
            int objectY=allShapeVector.elementAt(i).getInitialPoint().y;
            int objectHeight=allShapeVector.elementAt(i).getHeight();
            int objectWidth=allShapeVector.elementAt(i).getWidth();

            if(objectX>=px && (objectX+objectWidth)<=px+pw && objectY>=py && objectY+objectHeight<=py+ph){
                System.out.println("Shape is in the selectionRect !!");
                editorPanel.getSelectedShapeVector().add(allShapeVector.elementAt(i));
            }
        }
        editorPanel.setSelectedShapeVectorTrue();
    }


}
