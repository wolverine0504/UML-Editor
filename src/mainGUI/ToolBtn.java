package mainGUI;

import UMLmode.Mode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBtn extends JButton {
    Mode toolMode;
    ImageIcon icon;
    EditorPanel editorPanel;
    String createObject;

    public ToolBtn( String imgPath, Mode toolMode, String createObject) {
        this.icon=new ImageIcon(imgPath);
        this.toolMode = toolMode;
        this.createObject = createObject;
        this.editorPanel = EditorPanel.getInstance();
        this.addActionListener(new ToolBtnInnerListener());

        setIcon(icon);
        setFocusable(false);
        setBackground(Color.GRAY);
        setOpaque(true);
        setBorderPainted(false);
        setRolloverEnabled(true);
    }

    class ToolBtnInnerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Tool mode:"+toolMode+" Button Action Performed");
            editorPanel.setCurrentMode(toolMode);
            editorPanel.setCurrentShape(createObject);
            editorPanel.refreshListener();
        }
    }
}
