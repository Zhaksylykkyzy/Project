package BookStore.client.pages.CLIENT;

import BookStore.client.applications.ButtonApplication;
import BookStore.client.applications.LabelApplication;
import BookStore.client.applications.PanelApplication;
import BookStore.client.pages.ClientFrame;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;

public class AboutPage extends PanelApplication {
    private ClientFrame parent;
    private ButtonApplication backButton;
    private JButton linkButton,vk,inst,twi,youtube,address;
    private LabelApplication label,label1,label2,label3,label4,label5;


    public AboutPage(ClientFrame parent) throws URISyntaxException, IOException {


        label =new LabelApplication("AOne");
        label.setBounds(270,40,550,50);
        add(label);


        label1=new LabelApplication("We are glad to see you in the application of the bookstore ~AOne~.");
        label1.setBounds(35, 80, 550, 50 );
        add(label1);

        label2=new LabelApplication("We were founded in 2020. But also we have a large selection of books");
        label2.setBounds(14, 101, 550, 50 );
        add(label2);

        label3=new LabelApplication("And any user can find a book and buy it directly in the application, in-");
        label3.setBounds(14, 121, 550, 50 );
        add(label3);

        label4=new LabelApplication("cluding you. You can also come to our store if you are a resident of");
        label4.setBounds(14,141,560,50);
        add(label4);

        label5=new LabelApplication("Almaty.");
        label5.setBounds(14,161,550,50);
        add(label5);

        File f = new File("9.jpg");
        JLabel imgLabel2 = new JLabel (new ImageIcon(f.getName()));
        imgLabel2.setBounds(45, 200, 499, 373);
        add(imgLabel2);

        linkButton=new ButtonApplication("~SITE~");
        linkButton.setLocation(230,585);
        add(linkButton);
        linkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Desktop d=Desktop.getDesktop();
                try {
                    d.browse(new URI("https://bookshop.org/lists/simon-schuster-support-indie-bookstores-in-need"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        address=new ButtonApplication("~ADDRESS~");
        address.setLocation(230,630);
        add(address);
        address.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Desktop d5=Desktop.getDesktop();
                try {
                    d5.browse(new URI("https://bookshop.org/pages/store_locator"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        backButton = new ButtonApplication("~BACK~");
        backButton.setLocation(230, 675);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.aboutPage.setVisible(false);
                parent.userPage.setVisible(true);
            }
        });
    }}
