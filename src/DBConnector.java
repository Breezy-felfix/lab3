/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
 private Connection connection= null;
 
 public static void main (String [] args){
 new DBConnector().connector();
 }
public Connection connector (){
    try{
        Class.forName("com.mysql.jdbc.Driver");
    }catch (ClassNotFoundException e ) {
        System.out.println("Where is your MYSQL JDBC Driver?");
        e.printStackTrace();
        return connection;
    }
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost");
    }catch (SQLException e) {
        System.out.println("Connectio Failed! Check output console");
                e.printStackTrace();
                return connection;
             }
    if (connection!=null )  {
        System.out.println ("You made it,take control of your database");
    }else {
         System.out.println ("failed to make connection!");
    }
    return connection;
}
public void closeDB (){
    try{
  connection.close();
}catch (SQLException ex) {
 System.out.println ("Error"+ ex.getMessage());
}}}