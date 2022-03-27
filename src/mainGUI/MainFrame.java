package mainGUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String title){
        super(title);
    }

    public static void main(String[] args) {
        JFrame myFrame=new MainFrame("UML Editor");
        Container container = myFrame.getContentPane();
        EditorPanel editorPanel= EditorPanel.getInstance();
        ToolBar toolBar=new ToolBar();
        MenuBar menuBar=new MenuBar();

        myFrame.setLayout(new BorderLayout());
        container.add(menuBar,BorderLayout.NORTH);
        container.add(editorPanel);
        container.add(toolBar,BorderLayout.WEST);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(1200, 700);
        myFrame.setVisible(true);
    }
}
