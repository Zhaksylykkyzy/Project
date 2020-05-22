package BookStore.client.applications;

import javax.swing.*;
import java.awt.*;

public class LabelApplication extends JLabel {
    public LabelApplication( String text){
        setText(text);
        setSize(100, 30);
        setForeground(Color.white);
        setFont(new Font("Arial",Font.ITALIC, 18));
    }
}
