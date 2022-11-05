package App;


import jdk.swing.interop.SwingInterOpUtils;

import java.sql.*;

public class db {

    private Connection con;

    String UserName , Password , phoneNumber , address;



    public  void DBconnection(){

        try {
            if (con == null){

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "passw0rd");
                //Statement test = con.createStatement();
                //ResultSet rs = test.executeQuery("SELECT * FROM signup");
                //while (rs.next()){
                 //   System.out.println(rs.getString(1));
               // }

            }
        } catch (Exception e) {
            System.out.println(e);

        }


    }

    public boolean Sign_up(String User_name , String Password , String phoneNumber, String address) throws SQLException{


        PreparedStatement pr = con.prepareStatement("Insert into signup(`Username`,`Passwordd`,`phoneNumber`,`Address`) VALUES (?,?,?,?)");

        pr.setString(1, User_name);
        pr.setString(2, Password);
        pr.setString(3, phoneNumber);
        pr.setString(4, address);
        int n = pr.executeUpdate();
        System.out.println(n);
        if(n == 1) return true;
        else if(n == 2) return false;

        con.close();
        return false;
    }



    public boolean loginDBCheck(String User_name , String Password) throws SQLException{


        PreparedStatement pr = con.prepareStatement("Select * from SignUp where Username LIKE ? AND Passwordd LIKE ?");

        pr.setString(1, User_name);
        pr.setString(2, Password);
        ResultSet rs = pr.executeQuery();

        return rs.next();
    }






}