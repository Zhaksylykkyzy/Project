package BookStore.client.pages;

import javax.swing.*;

public class ClientFrame extends JFrame {
    public ClientSocket clientSocket;
    public Main mainMenu;
    public RegisterPage registerPage;
    public LoginPage loginPage;
    public AdminPage adminPage;
    public PlusPage plusPage;
    public UserPage userPage;
    public BuyPlusPage buyPlusPage;
    public HistoryPage historyPage;
    public ProfitPage profitPage;
    public ClientFrame(){
        setSize(600, 800);
        setTitle("Book Store");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clientSocket=new ClientSocket();

        mainMenu=new Main(this);
        mainMenu.setVisible(true);
        add(mainMenu);

        registerPage=new RegisterPage(this);
        registerPage.setVisible(false);
        add(registerPage);

        loginPage=new LoginPage(this);
        loginPage.setVisible(false);
        add(loginPage);

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

