package BookStore.client.pages;


import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;
import BookStore.client.applications.FieldApplication;
import BookStore.data.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends PanelApplication {
    private ClientFrame parent;
    private LabelApplication loginLabel, passwordLabel;
    private FieldApplication loginField, passwordField;
    private ButtonApplication addButton, backButton;
    public LoginPage(ClientFrame parent){
        this.parent=parent;
        loginLabel=new LabelApplication("Login:");
        loginLabel.setLocation(100, 200);
        add(loginLabel);
        loginField=new FieldApplication();
        loginField.setLocation(250, 200);
        add(loginField);

        passwordLabel=new LabelApplication("Password:");
        passwordLabel.setLocation(100, 250);
        add(passwordLabel);
        passwordField=new FieldApplication();
        passwordField.setLocation(250, 250);
        add(passwordField);

        addButton=new ButtonApplication("SIGN IN");
        addButton.setLocation(84, 300);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login=loginField.getText();
                String password=passwordField.getText();
                User user=parent.clientSocket.toLogin(new User(null, login, password, null, 0));
                if(user!=null){
                    //1-admin,2-user
                    ClientApp.currentUser=user;
                    if(user.getRole()==1){
                        parent.loginPage.setVisible(false);
                        parent.adminPage.updateData();
                        parent.adminPage.setVisible(true);
                    }
                    else if(user.getRole()==2){
                        parent.loginPage.setVisible(false);
                        parent.userPage.updateData();
                        parent.userPage.setVisible(true);
                    }
                }
                else {
                    loginField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(parent, "Login or Password is incorrect!!!");
                }
            }
        });

        backButton=new ButtonApplication("BACK");
        backButton.setLocation(311, 300);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.loginPage.setVisible(false);
                parent.mainMenu.setVisible(true);
            }
        });
    }
}
