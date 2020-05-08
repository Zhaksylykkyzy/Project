package BookStore.client.pages;

import BookStore.data.Plus;
import BookStore.data.Packet;
import BookStore.data.User;
import BookStore.data.UserBuy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSocket {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ClientSocket() {
        try {
            socket=new Socket("localhost",2015);
            oos=new ObjectOutputStream(socket.getOutputStream());
            ois=new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void disconnect(){
        try {
            oos.close();
            ois.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addUser(User user){
        Packet packet=new Packet("ADD_USER",user);
        try {
            oos.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public User toLogin(User user){
        User result=null;
        try {
            Packet packet=new Packet("AUTH", user);
            oos.writeObject(packet);

            Packet packet1=(Packet)ois.readObject();
            result=(User) packet1.getData();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public void addPlus(Plus plus){
        Packet packet=new Packet("ADD_PLUS", plus);
        try {
            oos.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Plus> getAllPluses(){
        ArrayList<Plus> pluses=new ArrayList<>();
        Packet packet=new Packet("LIST_PLUSES", null);
        try {
            oos.writeObject(packet);
            Packet response=(Packet)ois.readObject();
            pluses=(ArrayList<Plus>)response.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pluses;
    }
    public void editPlus(Plus plus){
        Packet packet=new Packet("EDIT_PLUS", plus);
        try {
            oos.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void editPlusBuy(Plus plus){
        Packet packet=new Packet("EDIT_PLUS_BUY", plus);
        try {
            oos.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deletePlus(Plus plus){
        Packet packet=new Packet("DELETE_PLUS", plus);
        try {
            oos.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void buyPlus(UserBuy userBuy){
        Packet packet=new Packet("BUY_PLUS", userBuy);
        try {
            oos.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<UserBuy> getAllBooks(UserBuy userBuy){
        ArrayList<UserBuy> userBuys=new ArrayList<>();
        Packet packet=new Packet("LIST_USER_BOOKS", userBuy);
        try {
            oos.writeObject(packet);
            Packet response=(Packet)ois.readObject();
            userBuys=(ArrayList<UserBuy>)response.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBuys;
    }

}
