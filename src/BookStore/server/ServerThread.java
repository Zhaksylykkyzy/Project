package BookStore.server;

import BookStore.data.Plus;
import BookStore.data.Packet;
import BookStore.data.User;
import BookStore.data.UserBuy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try {
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
            while(true){
                Packet packet=(Packet)ois.readObject();
                if(packet.getCode().equals("ADD_USER")){
                    User user=(User)packet.getData();
                    ServerApp.addUser(user);
                }
                else if(packet.getCode().equals("AUTH")){
                    User user=(User)packet.getData();
                    User response=ServerApp.getUser(user.getLogin(), user.getPassword());
                    Packet packet1=new Packet("AUTH", response);
                    oos.writeObject(packet1);
                }
                else if(packet.getCode().equals("ADD_PLUS")){
                    Plus plus=(Plus)packet.getData();
                    ServerApp.addPlus(plus);
                }
                else if(packet.getCode().equals("LIST_PLUSES")){
                    ArrayList<Plus> pluses=ServerApp.getAllPluses();
                    Packet packet1=new Packet("LIST_PLUSES", pluses);
                    oos.writeObject(packet1);
                }
                else if(packet.getCode().equals("EDIT_PLUS")){
                    Plus plus=(Plus)packet.getData();
                    ServerApp.editPlus(plus);
                }
                else if(packet.getCode().equals("DELETE_PLUS")){
                    Plus plus=(Plus)packet.getData();
                    ServerApp.deletePlus(plus.getId());
                }
                else if(packet.getCode().equals("BUY_PLUS")){
                    UserBuy userBuy=(UserBuy)packet.getData();
                    ServerApp.addUserBuy(userBuy);
                }
                else if(packet.getCode().equals("EDIT_PLUS_BUY")){
                    Plus plus=(Plus)packet.getData();
                    Plus frDB=ServerApp.getPlus(plus.getId());
                    int newcount=frDB.getCount()-plus.getCount();
                    ServerApp.updatePlusBuy(plus.getId(), newcount, plus.getCount());
                }
                else if(packet.getCode().equals("LIST_USER_BOOKS")){
                    UserBuy userBuy=(UserBuy)packet.getData();
                    ArrayList<UserBuy> userBuys=ServerApp.getAllBooks(userBuy.getUser_id());
                    Packet packet1=new Packet("LIST_USER_BOOKS", userBuys);
                    oos.writeObject(packet1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

