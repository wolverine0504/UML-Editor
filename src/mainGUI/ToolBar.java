package mainGUI;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

    public ToolBar() {
        this.setLayout(new GridLayout(6,1,3,3));
        ToolBtn selectBtn=new ToolBtn("buttonImage/select.png");
        ToolBtn associationLineBtn=new ToolBtn("buttonImage/associationLine.png");
        ToolBtn generalizationLineBtn=new ToolBtn("buttonImage/generalizationLine.png");
        ToolBtn compositionLineBtn=new ToolBtn("buttonImage/compositionLine.png");
        ToolBtn classBtn=new ToolBtn("buttonImage/class.png");
        ToolBtn useCase=new ToolBtn("buttonImage/useCase.png");


        this.add(selectBtn);
        this.add(associationLineBtn);
        this.add(generalizationLineBtn);
        this.add(compositionLineBtn);
        this.add(classBtn);
        this.add(useCase);


    }
}
