package BookStore.client.pages;

import BookStore.data.User;

import java.io.IOException;
import java.net.URISyntaxException;

public class ClientApp {
    public static User currentUser;
    public static void main(String args[]) throws IOException, URISyntaxException {
        ClientFrame clientFrame=new ClientFrame();
        clientFrame.setVisible(true);
    }
}
