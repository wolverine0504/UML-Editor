package mainGUI;

import UMLObject.BasicObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenameDialog extends JDialog {
    JTextField textField=new JTextField("Default Name");
    JButton confirmButton =new JButton("OK");
    JButton cancelButton = new JButton("Cancel");
    Point dialogLocation;
    int textFieldLocationX;
    int textFieldLocationY;
    int buttonLocationY;
    int confirmButtonX;
    int cancelButtonX;
    EditorPanel editorPanel;

    public RenameDialog() {
        editorPanel=EditorPanel.getInstance();
        dialogLocation=getLocation();
        textFieldLocationX=(int)dialogLocation.x+25;
        textFieldLocationY=(int)dialogLocation.y+10;
        buttonLocationY=textFieldLocationY+50;
        confirmButtonX=textFieldLocationX+10;
        cancelButtonX=textFieldLocationX+140;

        textField.setBounds(textFieldLocationX,textFieldLocationY,250,40);
        confirmButton.setBounds(confirmButtonX,buttonLocationY,100,50);
        cancelButton.setBounds(cancelButtonX,buttonLocationY,100,50);

        confirmButton.addActionListener(new ConfirmListener());
        cancelButton.addActionListener(new CancelListener());

        setLayout(null);
        add(textField);
        add(confirmButton);
        add(cancelButton);
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    class ConfirmListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(editorPanel.getSelectedShape()!=null){
                ((BasicObject)editorPanel.getSelectedShape()).renameObject(textField.getText());
                dispose();
            }else {
                dispose();
            }
        }
    }

    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

}
