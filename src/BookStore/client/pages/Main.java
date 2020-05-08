package BookStore.client.pages;

import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends PanelApplication {
    private ClientFrame parent;
    private ButtonApplication loginButton, registerButton, exitButton;
    public Main(ClientFrame parent){
        this.parent=parent;
        loginButton=new ButtonApplication("SIGN IN");
        loginButton.setLocation(196,150);
        add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.mainMenu.setVisible(false);
                parent.loginPage.setVisible(true);
            }
        });

        registerButton=new ButtonApplication("REGISTRATION");
        registerButton.setLocation(196,220);
        add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.mainMenu.setVisible(false);
                parent.registerPage.setVisible(true);
            }
        });

        exitButton=new ButtonApplication("EXIT");
        exitButton.setLocation(196,290);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}

