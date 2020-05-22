package BookStore.server;

import BookStore.data.Plus;
import BookStore.data.User;
import BookStore.data.UserBuy;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class ServerApp {    //Все методы в ServerApp будут STATIC потому что работаем с THREAD
    public static Connection connection; // сделаем static обязательно
    public static void main(String args[]){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store?useUnicode=true&serverTimezone=UTC","root", "");
            ServerSocket serverSocket=new ServerSocket(2015);
            System.out.println("Now it's the client's turn...");
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("Client connected!");
                ServerThread serverThread=new ServerThread(socket);
                serverThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addUser(User user){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO user(id, login, password,imya, role)"+
                    " VALUES(null, ?, ?, ?, ?) ");
            statement.setString(1,user.getLogin());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getImya());
            statement.setInt(4,user.getRole());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addUserBuy(UserBuy userBuy){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO userbuy(id, user_id, genre, count1, totalsum)"+
                    " VALUES(null, ?, ?, ?, ?) ");
            statement.setLong(1,userBuy.getUser_id());
            statement.setString(2,userBuy.getGenre());
            statement.setInt(3,userBuy.getCount());
            statement.setInt(4,userBuy.getTotalsum());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static User getUser(String login, String password){
        User user=null;
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM user where login=? and password=? ");
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String login1=resultSet.getString("login");
                String password1=resultSet.getString("password");
                String imya=resultSet.getString("imya");
                int role=resultSet.getInt("role");
                user=new User(id, login1, password1, imya, role);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void addPlus(Plus plus){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "INSERT INTO plus" +
                    "" +
                    "" +
                    "(id, name, price, count1, country, year, genre, sold )"+
                    " VALUES(null, ?,?,?,?,?,?,?)");
            statement.setString(1,plus.getName());
            statement.setInt(2,plus.getPrice());
            statement.setInt(3,plus.getCount());
            statement.setString(4,plus.getCountry());
            statement.setInt(5,plus.getYear());
            statement.setString(6,plus.getGenre());
            statement.setInt(7,0);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Plus> getAllPluses(){
        ArrayList<Plus> pluses=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT * FROM plus");
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String name=resultSet.getString("name");
                int price=resultSet.getInt("price");
                int count=resultSet.getInt("count1");
                String country=resultSet.getString("country");
                int year=resultSet.getInt("year");
                String gt=resultSet.getString("genre");
                int sold=resultSet.getInt("sold");
                pluses.add(new Plus(id, name, price, count,sold,country,year, gt));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pluses;
    }


    public static Plus getPlus(Long id){
        Plus plus=new Plus();
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT * FROM plus where id=?");
            statement.setLong(1,id);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Long id1=resultSet.getLong("id");
                String name=resultSet.getString("name");
                int price=resultSet.getInt("price");
                int count=resultSet.getInt("count1");
                String country=resultSet.getString("country");
                int year=resultSet.getInt("year");
                String gt=resultSet.getString("genre");
                plus=new Plus(id1, name, price, count, country, year, gt);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plus;
    }
    public static void updatePlusBuy(Long id, int newcount, int sold){
        try {
            PreparedStatement statement=connection.prepareStatement("UPDATE plus set count1=?, sold=? WHERE id=?");
            statement.setInt(1, newcount);
            statement.setInt(2,sold);
            statement.setLong(3, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void editPlus(Plus plus){
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    " UPDATE plus set name=?,price=?,count1=?,country=?,year=?,genre=?"+
                    " WHERE id=?");
            statement.setString(1,plus.getName());
            statement.setInt(2,plus.getPrice());
            statement.setInt(3,plus.getCount());
            statement.setString(4,plus.getCountry());
            statement.setInt(5,plus.getYear());
            statement.setString(6,plus.getGenre());
            statement.setLong(7,plus.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deletePlus(Long id){
        try {
            PreparedStatement statement=connection.prepareStatement("DELETE FROM plus WHERE id=? ");
            statement.setLong(1,id);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<UserBuy> getAllBooks(Long user_id){
        ArrayList<UserBuy> userBuys=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "SELECT * FROM userbuy WHERE user_id=?");
            statement.setLong(1, user_id);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                Long user_id1=resultSet.getLong("user_id");
                String genre=resultSet.getString("genre");
                int count=resultSet.getInt("count1");
                int totalsum=resultSet.getInt("totalsum");

                UserBuy userBuy=new UserBuy(id, user_id1, genre, count, totalsum);
                userBuys.add(userBuy);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBuys;
    }
}

