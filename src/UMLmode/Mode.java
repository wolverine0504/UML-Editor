package UMLmode;

import mainGUI.EditorPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class Mode extends MouseInputAdapter {
    EditorPanel editorPanel = EditorPanel.getInstance();
    public void mousePressed(MouseEvent e){};
    public void mouseReleased(MouseEvent e) {};
    public void mouseClicked(MouseEvent e) {};
    public void mouseDragged(MouseEvent e) {};
}
