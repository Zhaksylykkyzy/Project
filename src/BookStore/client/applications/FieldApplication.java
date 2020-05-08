package BookStore.client.applications;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class FieldApplication extends JTextField {
    public FieldApplication(){
        setSize(200, 30);
        setBackground(Color.white);
        setForeground(Color.black);
        setFont(new Font("Arial",Font.BOLD, 16));
        setBorder(new EtchedBorder(Color.GRAY,Color.GRAY));
    }


}
