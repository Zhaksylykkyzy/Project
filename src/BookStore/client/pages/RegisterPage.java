package BookStore.client.pages;

import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;
import BookStore.client.applications.FieldApplication;
import BookStore.data.User;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends PanelApplication {
    private ClientFrame parent;// Через parent управляем: из RegisterPage переключит в LoginPage
                               // еще для того чтобы достать внутри ClientFrame объект ClientSocket
                               // для того чтобы зарегистировать  Usera
                               //RegisterPage не может переключит без Frame  и он должен иметь доступ к нему

    private LabelApplication loginLabel, passwordLabel,fioLabel;
    private JLabel label1,label2;
    private FieldApplication loginField, fioField;
    private ButtonApplication addButton, backButton;
    private JPasswordField passwordField;

    public RegisterPage(ClientFrame parent) {
        this.parent = parent;
        loginLabel=new LabelApplication("Login:");
        loginLabel.setLocation(100, 150);
        add(loginLabel);
        loginField=new FieldApplication();
        loginField.setLocation(250,150);
        add(loginField);

        label1=new LabelApplication("* By clicking on add you agree to the preservation");
        label1.setFont(new Font("Arial",Font.BOLD,13));
        label1.setBounds(80, 360, 500, 50 );
        add(label1);


        label2=new LabelApplication("  of your actions in this application");
        label2.setFont(new Font("Arial",Font.BOLD,13));
        label2.setBounds(80, 375, 500, 50 );
        add(label2);

        passwordLabel=new LabelApplication("Password:");
        passwordLabel.setLocation(100, 210);
        add(passwordLabel);
        passwordField=new JPasswordField();
        passwordField.setBounds(250,210,200,30);
        passwordField.setBackground(Color.white);
        passwordField.setForeground(Color.black);
        passwordField.setFont(new Font("Arial",Font.BOLD, 16));
        passwordField.setBorder(new EtchedBorder(Color.black,Color.black));
        add(passwordField);
        passwordField.setVisible(true);



        fioLabel=new LabelApplication("Full name:");
        fioLabel.setLocation(100, 270);
        add(fioLabel);
        fioField=new FieldApplication();
        fioField.setLocation(250,270);
        add(fioField);

        addButton=new ButtonApplication("~ADD~");
        addButton.setLocation(90, 330);
        add(addButton);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login=loginField.getText();
                String password=passwordField.getText();
                String imya=fioField.getText();
                if(login.isEmpty() || password.isEmpty() || imya.isEmpty()){
                    JOptionPane.showMessageDialog(parent,"Fill all fields!!!"); // подключаем класс JOptionPane

                }
                else{
                    User user=new User(null, login, password,imya,2);
                    parent.clientSocket.addUser(user);
                    loginField.setText("");
                    passwordField.setText("");
                    fioField.setText("");
                    JOptionPane.showMessageDialog(parent,"You are registered!!!");

                }
            }
        });

        backButton=new ButtonApplication("~BACK~");
        backButton.setLocation(310, 330);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.registerPage.setVisible(false);
                parent.mainMenu.setVisible(true);
            }
        });


    }
}
