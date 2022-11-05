package client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Sender {


         BufferedReader reader;
         PrintWriter writer;
         Socket socket;

    public Sender(Socket socket, BufferedReader reader, PrintWriter writer) {
        this.socket = socket;
        this.reader = reader;
        this.writer = writer;
    }


    public void contactServer() throws IOException {
        Scanner scan = new Scanner(System.in);

        String f = reader.readLine();
        System.out.println(f);
        String client = scan.nextLine();
        writer.println(client);
        writer.flush();
        if(client.equalsIgnoreCase("S")){
            signUp();
        }
        else if(client.equalsIgnoreCase("L")){
            logInServer();

        }




    }


    public void signUp()throws IOException{
        Scanner scan = new Scanner(System.in);

        System.out.print("user name:  ");
        String userName = scan.nextLine();
        writer.println(userName);

        System.out.print("password:  ");
        String pass = scan.nextLine();
        writer.println(pass);

        System.out.println("PhoneNumber  ");
        String phoneNum = scan.nextLine();
        writer.println(phoneNum);

        System.out.print("Address:  ");
        String address = scan.nextLine();
        writer.println(address);


        writer.flush();
        String resp = reader.readLine();
        //response
        System.out.println("server response:  "+resp);
    }

    public void logInServer() throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.print("user name:  ");
        String userName = scan.nextLine();
        writer.println(userName);

        //System.out.println();

        System.out.print("password:  ");
        String pass = scan.nextLine();
        writer.println(pass);

        writer.flush();

        String resp = reader.readLine();
        //response
        System.out.println("server response:  "+resp);
        //writer.flush();

    }




    public void sendOrderList(ArrayList<String> oList){
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(oList);
        }
        catch (IOException e){e.printStackTrace();}
    }



}
