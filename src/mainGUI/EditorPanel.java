package mainGUI;

import javax.swing.*;

public class EditorPanel extends JPanel {

    public static EditorPanel uniqueInstance;

    private EditorPanel() {
    }

    public static EditorPanel getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new EditorPanel();
        }
        return uniqueInstance;
    }

}
