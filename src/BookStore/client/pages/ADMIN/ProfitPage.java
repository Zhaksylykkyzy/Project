package BookStore.client.pages.ADMIN;

import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;
import BookStore.client.pages.ClientFrame;
import BookStore.data.Plus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfitPage extends PanelApplication {
    public ClientFrame parent;
    private ButtonApplication backButton, refreshButton;
    private JLabel label;
    private Object[] columns={"ID", "NAME", "PRICE", "COUNT", "COUNTRY", "YEAR", "GENRE", "SOLD"};
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane pane;
    private ArrayList<Plus> pluses;

    public ProfitPage(ClientFrame parent) {
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
        updatePlus();


        label=new LabelApplication("Total profit: "+Integer.toString(getTotalPrice())+" tg");
        label.setFont(new Font("Arial",Font.BOLD,17));
        label.setBounds(370, 450, 300, 30);
        add(label);

        refreshButton=new ButtonApplication("~REFRESH~");
        refreshButton.setLocation(212, 500);
        add(refreshButton);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("Arial",Font.BOLD,17));
                label.setText("Total profit: "+Integer.toString(getTotalPrice()) + " tg");
                clearPlus();
                updatePlus();
            }
        });

        backButton=new ButtonApplication("~BACK~");
        backButton.setLocation(212, 550);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.profitPage.setVisible(false);
                parent.adminPage.setVisible(true);
            }
        });

    }
    public void updatePlus(){
        pluses=parent.clientSocket.getAllPluses();
        Object[] row=new Object[8];
        int total=0;
        for(Plus d:pluses){
            if(d.getSold()>0){
                row[0]=d.getId();
                row[1]=d.getName();
                row[2]=d.getPrice();
                row[3]=d.getCount();
                row[4]=d.getCountry();
                row[5]=d.getYear();
                row[6]=d.getGenre();
                row[7]=d.getSold();
                model.addRow(row);
               // total+=d.getSold()*d.getPrice();
            }

        }
    }
    public int getTotalPrice(){
        pluses=parent.clientSocket.getAllPluses();

        int total=0;
        for(Plus d:pluses){
            if(d.getSold()>0){
                total+=d.getSold()*d.getPrice();
            }
        }
        return total;
    }
    public void clearPlus(){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
    }
}

