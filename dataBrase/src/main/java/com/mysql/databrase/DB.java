package com.mysql.databrase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
     Connection con ;
     String URL= "jdbc:mysql://localhost/dental_clinic";
      String User = "root";
      String Password = "root1234";

      public DB(){}
      public void connect(){
           try{
                Class.forName("com.mysql.jdbc.Driver");
                con =  DriverManager.getConnection(URL,User,Password);
                System.out.println("Connection Succeed..........");
               Statement start =null;
               start= con.createStatement();
               String sql ="insert into patient (PID , PName , PGender , state_Of_healthe , amountPaid , PAge , insurance_num ) values \n" +
                       "(125,'reem','female','good',56,20,36)";
           } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Connection Failed.......");
           }
      }
}
