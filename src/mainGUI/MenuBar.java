package mainGUI;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    JMenuItem renameItem = new JMenuItem("Rename");
    JMenuItem ungroupItem = new JMenuItem("Ungroup");
    JMenuItem groupItem = new JMenuItem("Group");
    EditorPanel mainPanel;

    public MenuBar() {
        editMenu.add(renameItem);
        editMenu.add(ungroupItem);
        editMenu.add(groupItem);
        this.add(editMenu);
        this.add(fileMenu);
    }
}
