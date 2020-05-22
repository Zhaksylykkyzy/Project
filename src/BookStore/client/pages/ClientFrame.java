package BookStore.client.pages;

import BookStore.client.pages.ADMIN.AdminPage;
import BookStore.client.pages.ADMIN.PlusPage;
import BookStore.client.pages.ADMIN.ProfitPage;
import BookStore.client.pages.CLIENT.AboutPage;
import BookStore.client.pages.CLIENT.BuyPlusPage;
import BookStore.client.pages.CLIENT.HistoryPage;
import BookStore.client.pages.CLIENT.UserPage;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ClientFrame extends JFrame {
    public ClientSocket clientSocket;
    public Main mainMenu;
    public RegisterPage registerPage;
    public LoginPage loginPage;
    public AdminPage adminPage;
    public AboutPage aboutPage;
    public PlusPage plusPage;
    public UserPage userPage;
    public BuyPlusPage buyPlusPage;
    public HistoryPage historyPage;
    public ProfitPage profitPage;
    public ClientFrame() throws IOException, URISyntaxException {
        setSize(600, 800);
        setTitle("Book Store");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clientSocket=new ClientSocket();

        mainMenu=new Main(this); // this-себя отправляю в main
        mainMenu.setVisible(true);
        add(mainMenu);

        registerPage=new RegisterPage(this);
        registerPage.setVisible(false);
        add(registerPage);

        loginPage=new LoginPage(this);
        loginPage.setVisible(false);
        add(loginPage);

        aboutPage=new AboutPage(this);
        aboutPage.setVisible(false);
        add(aboutPage);

        adminPage=new AdminPage(this);
        adminPage.setVisible(false);
        add(adminPage);

        plusPage=new PlusPage(this);
        plusPage.setVisible(false);
        add(plusPage);

        userPage=new UserPage(this);
        userPage.setVisible(false);
        add(userPage);

        buyPlusPage=new BuyPlusPage(this);
        buyPlusPage.setVisible(false);
        add(buyPlusPage);

        historyPage=new HistoryPage(this);
        historyPage.setVisible(false);
        add(historyPage);

        profitPage =new ProfitPage(this);
        profitPage.setVisible(false);
        add(profitPage);
    }
}

