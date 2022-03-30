package mainGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    JMenuItem renameItem = new JMenuItem("Rename");
    JMenuItem ungroupItem = new JMenuItem("Ungroup");
    JMenuItem groupItem = new JMenuItem("Group");
    RenameDialog renameDialog;
    EditorPanel editorPanelPanel;

    public MenuBar() {
        editorPanelPanel=EditorPanel.getInstance();
        editMenu.add(renameItem);
        editMenu.add(ungroupItem);
        editMenu.add(groupItem);
        this.add(editMenu);
        this.add(fileMenu);
        renameItem.addActionListener(new ReNameListner());
        groupItem.addActionListener(new GroupListener());
        ungroupItem.addActionListener(new GroupListener());
    }

    class ReNameListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            renameDialog=new RenameDialog();
            renameDialog.setVisible(true);
        }
    }

    class UnGroupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class GroupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
