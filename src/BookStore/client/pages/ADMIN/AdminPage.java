package BookStore.client.pages.ADMIN;

import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;
import BookStore.client.pages.ClientApp;
import BookStore.client.pages.ClientFrame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends PanelApplication {
    private ClientFrame parent;
    private JLabel label;
    private ButtonApplication plusButton,  incomeButton, logoutButton;
    public AdminPage(ClientFrame parent) {
        this.parent = parent;

        label=new LabelApplication("");
        label.setFont(new Font("Arial",Font.BOLD,18));
        label.setBounds(154, 120, 320, 50 );
        add(label);

        plusButton=new ButtonApplication("~BOOKS~");
        plusButton.setLocation(220, 200);
        add(plusButton);
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminPage.setVisible(false);
                parent.plusPage.setVisible(true);
            }
        });



        incomeButton=new ButtonApplication("~PROFIT~");
        incomeButton.setLocation(220, 260);
        add(incomeButton);
        incomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminPage.setVisible(false);
                parent.profitPage.setVisible(true);
            }
        });

        logoutButton=new ButtonApplication("~LOGOUT~");
        logoutButton.setLocation(220, 320);
        add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientApp.currentUser=null;
                parent.adminPage.setVisible(false);
                parent.loginPage.setVisible(true);

            }
        });
    }
    public void updateData(){
        label.setText("Welcome "+ClientApp.currentUser.getImya()+"!");
    }
}
