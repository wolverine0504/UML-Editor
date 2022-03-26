package mainGUI;

import javax.swing.*;
import java.awt.*;

public class ToolBtn extends JButton {
    ImageIcon icon;
    public ToolBtn(String imgPath) {
        icon=new ImageIcon(imgPath);
        this.setIcon(icon);
        setFocusable(false);
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        setBorderPainted(false);
        setRolloverEnabled(true);
    }
}
