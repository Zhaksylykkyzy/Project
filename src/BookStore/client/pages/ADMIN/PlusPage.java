package BookStore.client.pages.ADMIN;

// Admin->Books(Админ может добавить книги, редактировать, удалить книг)
import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.applications.ButtonApplication;
import BookStore.client.applications.FieldApplication;
import BookStore.client.pages.ClientFrame;
import BookStore.data.Plus;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PlusPage extends PanelApplication {
    private ClientFrame clientFrame;
    private LabelApplication idLabel, nameLabel, priceLabel, countLabel, countryLabel, yearLabel, gtLabel;
    private ButtonApplication addButton, editButton, deleteButton, backButton, refreshButton;
    private FieldApplication idField, nameField, priceField, countField, yearField;
    private String[] genre={"","Fantastic", "Scientific", "Mistery", "Romance","Adventure","Horror"};
    private String[] countries={"","Kazakhstan","Russia","USA","Uzbekistan","France","Ukraine"};
    private Object[] columns={"ID", "NAME", "PRICE", "COUNT1", "COUNTRY", "YEAR", "GENRE"};
    private JComboBox jComboBox, jCombocountries;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane pane;
    private ArrayList<Plus> pluses;

    public PlusPage(ClientFrame clientFrame) {
        this.clientFrame = clientFrame;
        table=new JTable();
        model=new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.lightGray);
        table.setForeground(Color.black);
        table.setFont(new Font("Arial", Font.BOLD, 16));
        table.setRowHeight(30);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=table.getSelectedRow();
                idField.setText(model.getValueAt(i,0).toString());
                nameField.setText(model.getValueAt(i,1).toString());
                priceField.setText(model.getValueAt(i,2).toString());
                countField.setText(model.getValueAt(i,3).toString());
                jCombocountries.setSelectedItem(model.getValueAt(i,4).toString());
                yearField.setText(model.getValueAt(i,5).toString());
                jComboBox.setSelectedItem(model.getValueAt(i,6).toString());
            }

            /*ДЛЯ ЭТИХ МЕТОДОВ
            *   Когда событие от нажатия мыши происходит, соответствуйюший метод в объекте слушателя вызывается, и MouseEvent передается к MouseListener*/
            @Override
            public void mousePressed(MouseEvent e) { // метод, вызванный, когда кнопка мыши была нажата на компоненте

            }

            @Override
            public void mouseReleased(MouseEvent e) {// метод, вызванный, когда кнопка мыши была отпущена на компоненте

            }

            @Override
            public void mouseEntered(MouseEvent e) { //метод, вызванный, когда мышь вводит компонент

            }

            @Override
            public void mouseExited(MouseEvent e) {// метод, вызванный, когда мышь входит из компонента

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

        countryLabel =new LabelApplication("Country:");
        countryLabel.setLocation(20, 580);
        add(countryLabel);
        jCombocountries=new JComboBox(countries);
        jCombocountries.setBounds(150, 580, 200, 30);
        jCombocountries.setBackground(Color.lightGray);
        jCombocountries.setForeground(Color.black);
        jCombocountries.setFont(new Font("Arial",1, 16));
        jCombocountries.setBorder(new EtchedBorder(Color.black,Color.black));
        add(jCombocountries);


        yearLabel =new LabelApplication("Year:");
        yearLabel.setLocation(20, 620);
        add(yearLabel);
        yearField=new FieldApplication();
        yearField.setLocation(150, 620);
        add(yearField);

        gtLabel=new LabelApplication("Genre:");
        gtLabel.setLocation(20, 660);
        add(gtLabel);

        jComboBox=new JComboBox(genre);
        jComboBox.setBounds(150, 660, 200, 30);
        jComboBox.setBackground(Color.lightGray);
        jComboBox.setForeground(Color.black);
        jComboBox.setFont(new Font("Arial",1, 16));
        jComboBox.setBorder(new EtchedBorder(Color.black,Color.black));
        add(jComboBox);

        addButton=new ButtonApplication("~ADD~");
        addButton.setLocation(388, 445);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameField.getText();
                int price=Integer.parseInt(priceField.getText());
                int count=Integer.parseInt(countField.getText());
                String country=jCombocountries.getSelectedItem().toString();
                int year=Integer.parseInt(yearField.getText());
                String gt=jComboBox.getSelectedItem().toString();
                if(name.isEmpty() || country.isEmpty()){
                    JOptionPane.showMessageDialog(clientFrame, "Please, fill all fields!!!");
                }
                else{
                    Plus plus=new Plus(null,name,price,count,country,year,gt);
                    clientFrame.clientSocket.addPlus(plus);
                    idField.setText("");
                    nameField.setText("");
                    priceField.setText("");
                    countField.setText("");
                    jCombocountries.setSelectedIndex(0);
                    yearField.setText("");
                    jComboBox.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(clientFrame, "Book is added successfully!!!");
                    clearPlus();
                    updatePlus();
                }
            }
        });

        editButton=new ButtonApplication("~EDIT~");
        editButton.setLocation(388, 495);
        add(editButton);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id=Long.valueOf(idField.getText());
                String name=nameField.getText();
                int price=Integer.parseInt(priceField.getText());
                int count=Integer.parseInt(countField.getText());
                String country=jCombocountries.getSelectedItem().toString();
                int year=Integer.parseInt(yearField.getText());
                String gt=jComboBox.getSelectedItem().toString();
                Plus device=new Plus(id, name, price, count, country, year, gt);
                clientFrame.clientSocket.editPlus(device);
                idField.setText("");
                nameField.setText("");
                priceField.setText("");
                countField.setText("");
                jCombocountries.setSelectedIndex(0);
                yearField.setText("");
                jComboBox.setSelectedIndex(0);
                clearPlus();
                updatePlus();
            }
        });

        deleteButton=new ButtonApplication("~DELETE~");
        deleteButton.setLocation(388, 545);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long id=Long.valueOf(idField.getText());
                Plus plus=new Plus(id, null, 0, 0, null, 0 , null);
                clientFrame.clientSocket.deletePlus(plus);
                idField.setText("");
                nameField.setText("");
                priceField.setText("");
                countField.setText("");
                jCombocountries.setSelectedIndex(0);
                yearField.setText("");
                jComboBox.setSelectedIndex(0);
                clearPlus();
                updatePlus();
            }
        });

        backButton=new ButtonApplication("~BACK~");
        backButton.setLocation(388, 645);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientFrame.plusPage.setVisible(false);
                clientFrame.adminPage.setVisible(true);
            }
        });
        refreshButton=new ButtonApplication("~REFRESH~");
        refreshButton.setLocation(388,595);
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
        pluses=clientFrame.clientSocket.getAllPluses();
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
