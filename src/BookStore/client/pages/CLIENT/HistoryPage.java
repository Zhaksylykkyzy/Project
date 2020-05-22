package BookStore.client.pages.CLIENT;

import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;
import BookStore.client.pages.ClientApp;
import BookStore.client.pages.ClientFrame;
import BookStore.data.UserBuy;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HistoryPage extends PanelApplication {
    private ClientFrame parent;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane pane;
    private ButtonApplication backButton, refreshButton;
    private Object[] columns={"#","GENRE", "COUNT", "PRICE"};
    private ArrayList<UserBuy> userBuys;
    private UserBuy userBuy;
    public HistoryPage(ClientFrame parent) {
        this.parent = parent;
        table=new JTable();
        model=new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.lightGray);
        table.setForeground(Color.black);
        table.setFont(new Font("Arial", 1, 16));
        table.setRowHeight(30);
        pane=new JScrollPane(table);
        pane.setBounds(0,0, 600, 400);
        add(pane);
        if(ClientApp.currentUser!=null){
            updateBook();
        }

        refreshButton=new ButtonApplication("~REFRESH~");
        refreshButton.setLocation(200, 450);
        add(refreshButton);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearBook();
                updateBook();
            }
        });

        backButton=new ButtonApplication("~BACK~");
        backButton.setLocation(200, 500);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.historyPage.setVisible(false);
                parent.userPage.setVisible(true);
            }
        });
    }
    private void updateBook(){
        userBuy=new UserBuy(null, ClientApp.currentUser.getId(), null, 0, 0);
        userBuys=parent.clientSocket.getAllBooks(userBuy);
        Object[] row=new Object[4];
        for(UserBuy u:userBuys){
            row[0]=u.getId();
            row[1]=u.getGenre();
            row[2]=u.getCount();
            row[3]=u.getTotalsum();
            model.addRow(row);
        }
    }
    private void clearBook(){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
    }

}

