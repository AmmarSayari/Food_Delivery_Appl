package App;


import jdk.swing.interop.SwingInterOpUtils;

import java.sql.*;

public class db {

    private Connection con;

    String UserName , Password , phoneNumber , address;


  /*   public DB(String userName, String password) {
        UserName = userName;
         Password = password;

  */

    public  void DBconnection(){

        try {
            if (con == null){

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryapp", "root", "passw0rd");
                Statement test = con.createStatement();
                ResultSet rs = test.executeQuery("SELECT * FROM signup");
                //while (rs.next()){
                 //   System.out.println(rs.getString(1));
               // }

            }
        } catch (Exception e) {
            System.out.println(e);

        }


    }

    public void Sign_up(String User_name , String Password , String phoneNumber, String address) throws SQLException{


        PreparedStatement pr = con.prepareStatement("Insert into signup(`Username`,`Passwordd`,`phoneNumber`,`Address`) VALUES (?,?,?,?)");

        pr.setString(1, User_name);
        pr.setString(2, Password);
        pr.setString(3, phoneNumber);
        pr.setString(4, address);
        int n = pr.executeUpdate();
        System.out.println(n);
        con.close();
    }










    public void test(){

    }



}