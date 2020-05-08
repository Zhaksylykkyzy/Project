package BookStore.client.applications;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ButtonApplication extends JButton {
    public ButtonApplication(String text){
        setText(text);
        setSize(150,30);
        setBackground(Color.white);
        setForeground(Color.black);
        setFont(new Font("Arial",Font.BOLD, 15));
        setBorder(new EtchedBorder(Color.black,Color.black));
    }
}
