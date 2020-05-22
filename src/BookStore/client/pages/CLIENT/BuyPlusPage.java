package BookStore.client.pages.CLIENT;

//Клиент может купить книги
import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;
import BookStore.client.applications.FieldApplication;
import BookStore.client.pages.ClientApp;
import BookStore.client.pages.ClientFrame;
import BookStore.data.Plus;
import BookStore.data.UserBuy;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BuyPlusPage extends PanelApplication {
    public ClientFrame parent;
    private LabelApplication idLabel, nameLabel, priceLabel, countLabel, countryLabel, yearLabel, gtLabel;
    private ButtonApplication buyButton, backButton, refreshButton;
    private FieldApplication idField, nameField, priceField, countField, yearField;
    private String[] combo={"","Fantastic", "Scientific", "Mistery", "Romance","Adventure","Horror"};
    private String[] country={"","Kazakhstan","Russia","USA","Uzbekistan","France","Ukraine"};
    private Object[] columns={"ID", "NAME", "PRICE", "COUNT", "COUNTRY", "YEAR", "GENRE"};
    private JComboBox jCombodt, jCombocountry;
    // чтобы работать с таблицой надо следующие три объекта:
    private JTable table;
    private DefaultTableModel model; //model  нужен для того чтобы,работать с данными,model будет находится внутри table
    private JScrollPane pane;// надо при изменении размера слайдеры автоматический вышли
    private ArrayList<Plus> pluses;

    public BuyPlusPage(ClientFrame parent) {
        this.parent = parent;
        table=new JTable();
        model=new DefaultTableModel();
        model.setColumnIdentifiers(columns);//columns из-за того что у нас таблица не STRING, а OBJECT
        table.setModel(model);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.black);
        table.setFont(new Font("Arial", 1, 16));
        table.setRowHeight(30);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=table.getSelectedRow();
                idField.setText(model.getValueAt(i,0).toString());
                nameField.setText(model.getValueAt(i,1).toString());
                priceField.setText(model.getValueAt(i,2).toString());
                countField.setText("");
                jCombocountry.setSelectedItem(model.getValueAt(i,4).toString());
                yearField.setText(model.getValueAt(i,5).toString());
                jCombodt.setSelectedItem(model.getValueAt(i,6).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        pane=new JScrollPane(table);
        pane.setBounds(0,0, 600, 400);
        add(pane);
        updatePlus();
        idLabel=new LabelApplication("ID:");
        idLabel.setLocation(20, 420);
        add(idLabel);
        idField=new FieldApplication();
        idField.setLocation(150, 420);
        add(idField);

        nameLabel=new LabelApplication("Name:");
        nameLabel.setLocation(20, 460);
        add(nameLabel);
        nameField=new FieldApplication();
        nameField.setLocation(150, 460);
        add(nameField);

        priceLabel=new LabelApplication("Price:");
        priceLabel.setLocation(20, 500);
        add(priceLabel);
        priceField=new FieldApplication();
        priceField.setLocation(150, 500);
        add(priceField);

        countLabel=new LabelApplication("Count:");
        countLabel.setLocation(20, 540);
        add(countLabel);
        countField=new FieldApplication();
        countField.setLocation(150, 540);
        add(countField);

        countryLabel=new LabelApplication("Country:");
        countryLabel.setLocation(20, 580);
        add(countryLabel);
        jCombocountry=new JComboBox(country);
        jCombocountry.setBounds(150, 580, 200, 30);
        jCombocountry.setBackground(Color.lightGray);
        jCombocountry.setForeground(Color.black);
        jCombocountry.setFont(new Font("Arial",1, 16));
        jCombocountry.setBorder(new EtchedBorder(Color.black,Color.black));
        add(jCombocountry);

        yearLabel=new LabelApplication("Year:");
        yearLabel.setLocation(20, 620);
        add(yearLabel);
        yearField=new FieldApplication();
        yearField.setLocation(150, 620);
        add(yearField);

        gtLabel=new LabelApplication("Genre:");
        gtLabel.setLocation(20, 660);
        add(gtLabel);

        jCombodt=new JComboBox(combo);
        jCombodt.setBounds(150, 660, 200, 30);
        jCombodt.setBackground(Color.lightGray);
        jCombodt.setForeground(Color.black);
        jCombodt.setFont(new Font("Arial",1, 16));
        jCombodt.setBorder(new EtchedBorder(Color.black,Color.black));
        add(jCombodt);

        buyButton=new ButtonApplication("~BUY~");
        buyButton.setLocation(360, 450);
        add(buyButton);
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id=Long.valueOf(idField.getText());
                String name=nameField.getText();
                int price=Integer.parseInt(priceField.getText());
                int count=Integer.parseInt(countField.getText());
                String country=jCombocountry.getSelectedItem().toString();
                int year=Integer.parseInt(yearField.getText());
                String gt=jCombodt.getSelectedItem().toString();
                if(name.isEmpty() || country.isEmpty()){
                    JOptionPane.showMessageDialog(parent, "Please, fill all fields!!!");
                }
                else{
                    UserBuy userBuy=new UserBuy(null, ClientApp.currentUser.getId(),gt, count, price*count);
                    parent.clientSocket.buyPlus(userBuy);
                    Plus plus=new Plus(id, null, 0, count, null, 0, null);
                    parent.clientSocket.editPlusBuy(plus);
                    idField.setText("");
                    nameField.setText("");
                    priceField.setText("");
                    countField.setText("");
                    jCombocountry.setSelectedIndex(0);
                    yearField.setText("");
                    jCombodt.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(parent, "Book was bought successfully!!!");
                    clearPlus();
                    updatePlus();
                }
            }
        });

        backButton=new ButtonApplication("~BACK~");
        backButton.setLocation(360, 550);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.buyPlusPage.setVisible(false);
                parent.userPage.setVisible(true);
            }
        });
        refreshButton=new ButtonApplication("~REFRESH~");
        refreshButton.setLocation(360,500);
        add(refreshButton);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPlus();
                updatePlus();
            }
        });

    }
    public void updatePlus(){
        pluses=parent.clientSocket.getAllPluses();
        Object[] row=new Object[7];
        for(Plus d:pluses){
            row[0]=d.getId();
            row[1]=d.getName();
            row[2]=d.getPrice();
            row[3]=d.getCount();
            row[4]=d.getCountry();
            row[5]=d.getYear();
            row[6]=d.getGenre();
            model.addRow(row);
        }
    }
    private void clearPlus(){
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        while(dm.getRowCount() > 0)
        {
            dm.removeRow(0);
        }
    }
}
