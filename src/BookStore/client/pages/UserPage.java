package BookStore.client.pages;

import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends PanelApplication {
    private ClientFrame parent;
    private LabelApplication userLabel;
    private ButtonApplication buyPlus,historyButton,logoutButton;
    public UserPage(ClientFrame parent) {
        this.parent = parent;
        userLabel=new LabelApplication("");
        userLabel.setBounds(140, 120, 200, 50 );
        add(userLabel);

        buyPlus=new ButtonApplication("BUY BOOKS");
        buyPlus.setLocation(185, 200);
        add(buyPlus);
        buyPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.userPage.setVisible(false);
                parent.buyPlusPage.setVisible(true);
            }
        });



        historyButton=new ButtonApplication("HISTORY");
        historyButton.setLocation(185, 260);
        add(historyButton);
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.userPage.setVisible(false);
                parent.historyPage.setVisible(true);
            }
        });


        logoutButton=new ButtonApplication("LOGOUT");
        logoutButton.setLocation(185, 320);
        add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientApp.currentUser=null;
                parent.userPage.setVisible(false);
                parent.loginPage.setVisible(true);
            }
        });
    }

    public void updateData(){
        userLabel.setText("Welcome "+ClientApp.currentUser.getImya()+"!");
    }

}

