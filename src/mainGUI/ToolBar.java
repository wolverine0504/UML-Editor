package mainGUI;

import UMLmode.LineMode;
import UMLmode.Mode;
import UMLmode.ObjectMode;
import UMLmode.SelectMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ToolBar extends JToolBar {

    private EditorPanel editorPanel;
    private int toolButtonCount=6;
    private Vector<ToolBtn> allButtonVector = new Vector();
    private JButton holdButton =null;


    public ToolBar() {
        editorPanel=EditorPanel.getInstance();
        this.setLayout(new GridLayout(toolButtonCount,1,3,3));
        ToolBtn selectionBtn=new ToolBtn("buttonImage/select.png", new SelectMode(),"selection");
        ToolBtn associationLineBtn=new ToolBtn("buttonImage/associationLine.png",new LineMode(),"associateLine");
        ToolBtn generalizationLineBtn=new ToolBtn("buttonImage/generalizationLine.png",new LineMode(),"generalLine");
        ToolBtn compositionLineBtn=new ToolBtn("buttonImage/compositionLine.png",new LineMode(),"compositeLine");
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
            allButtonVector.elementAt(i).addActionListener(new switchButtonModeListener());
        }

    }

    public void setHoldButton(JButton holdButton) {
        this.holdButton = holdButton;
    }

    class switchButtonModeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(holdButton!=null){
                holdButton.setBackground(Color.GRAY);
            }
            holdButton=(JButton)e.getSource();
            holdButton.setBackground(Color.RED);
            setHoldButton(holdButton);
            editorPanel.repaint();
        }
    }
}
