package BookStore.client.applications;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ButtonApplication extends JButton { // теперь разницы нету, писать JButton или ButtonApplication
    public ButtonApplication(String text){ // конструктор создаем и дальше он обеспечит нам дизайн и т д
        setText(text); // можно было бы и super использовать, но от дочерного конструктора вызываю конструктор JButton, передаю ~text~,
                        //я могу вызвать setText,  потому что я сам себе  Button
        setSize(150,30);
        setBackground(Color.lightGray);
        setForeground(Color.black);
        setFont(new Font("Arial",Font.BOLD, 14));
        setBorder(new EtchedBorder(Color.black,Color.black));


}}
