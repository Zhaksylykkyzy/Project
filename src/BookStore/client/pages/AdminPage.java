package BookStore.client.pages;

import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends PanelApplication {
    private ClientFrame parent;
    private LabelApplication label;
    private ButtonApplication plusButton,  incomeButton, logoutButton;
    public AdminPage(ClientFrame parent) {
        this.parent = parent;

        label=new LabelApplication("");
        label.setBounds(100, 120, 200, 50 );
        add(label);

        plusButton=new ButtonApplication("BOOKS");
        plusButton.setLocation(180, 200);
        add(plusButton);
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminPage.setVisible(false);
                parent.plusPage.setVisible(true);
            }
        });



        incomeButton=new ButtonApplication("PROFIT");
        incomeButton.setLocation(180, 260);
        add(incomeButton);
        incomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.adminPage.setVisible(false);
                parent.profitPage.setVisible(true);
            }
        });

        logoutButton=new ButtonApplication("LOGOUT");
        logoutButton.setLocation(180, 320);
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
