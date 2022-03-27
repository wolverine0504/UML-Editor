package mainGUI;

import UMLmode.LineMode;
import UMLmode.Mode;
import UMLmode.ObjectMode;
import UMLmode.SelectMode;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ToolBar extends JToolBar {

    private EditorPanel editorPanel;
    private Vector<ToolBtn> allButtonVector = new Vector<>();
    private int toolButtonCount=6;

    public ToolBar() {
        this.setLayout(new GridLayout(toolButtonCount,1,3,3));
        ToolBtn selectionBtn=new ToolBtn("buttonImage/select.png", new SelectMode(),"selection");
        ToolBtn associationLineBtn=new ToolBtn("buttonImage/associationLine.png",new LineMode(),"associationLine");
        ToolBtn generalizationLineBtn=new ToolBtn("buttonImage/generalizationLine.png",new LineMode(),"generalizationLine");
        ToolBtn compositionLineBtn=new ToolBtn("buttonImage/compositionLine.png",new LineMode(),"compositionLine");
        ToolBtn classObjectBtn=new ToolBtn("buttonImage/class.png",new ObjectMode(),"classObject");
        ToolBtn useCaseObjectBtn=new ToolBtn("buttonImage/useCase.png",new ObjectMode(),"useCaseObject");

        allButtonVector.add(selectionBtn);
        allButtonVector.add(associationLineBtn);
        allButtonVector.add(generalizationLineBtn);
        allButtonVector.add(compositionLineBtn);
        allButtonVector.add(classObjectBtn);
        allButtonVector.add(useCaseObjectBtn);

        for (int i = 0; i < toolButtonCount; i++) {
            add(allButtonVector.elementAt(i));
        }

    }
}
