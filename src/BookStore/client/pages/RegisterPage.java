package BookStore.client.pages;

import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;
import BookStore.client.applications.FieldApplication;
import BookStore.data.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends PanelApplication {
    private ClientFrame parent;
    private LabelApplication loginLabel, passwordLabel,fioLabel;
    private FieldApplication loginField, passwordField, fioField;
    private ButtonApplication addButton, backButton;

    public RegisterPage(ClientFrame parent) {
        this.parent = parent;
        loginLabel=new LabelApplication("Login:");
        loginLabel.setLocation(100, 150);
        add(loginLabel);
        loginField=new FieldApplication();
        loginField.setLocation(250,150);
        add(loginField);

        passwordLabel=new LabelApplication("Password:");
        passwordLabel.setLocation(100, 210);
        add(passwordLabel);
        passwordField=new FieldApplication();
        passwordField.setLocation(250,210);
        add(passwordField);

        fioLabel=new LabelApplication("Full name:");
        fioLabel.setLocation(100, 270);
        add(fioLabel);
        fioField=new FieldApplication();
        fioField.setLocation(250,270);
        add(fioField);

        addButton=new ButtonApplication("ADD");
        addButton.setLocation(90, 330);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login=loginField.getText();
                String password=passwordField.getText();
                String imya=fioField.getText();
                if(login.isEmpty() || password.isEmpty() || imya.isEmpty()){
                    JOptionPane.showMessageDialog(parent,"Fill all fields!!!");

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

        backButton=new ButtonApplication("BACK");
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
