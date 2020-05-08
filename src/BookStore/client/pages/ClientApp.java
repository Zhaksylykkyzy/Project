package BookStore.client.pages;

import BookStore.data.User;

public class ClientApp {
    public static User currentUser;
    public static void main(String args[]){
        ClientFrame clientFrame=new ClientFrame();
        clientFrame.setVisible(true);
    }
}
