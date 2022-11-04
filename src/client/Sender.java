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










//
//    @Override
//    public void run(){
//
//    String line;
//
//        try {
//            OutputStream out = socket.getOutputStream();
//            PrintWriter writer = new PrintWriter(out,true);
//
//            while (true){
//                Scanner keyBoard = new Scanner(System.in);
//                System.out.println("msg: ");
//                line = keyBoard.nextLine();
//
//
//                writer.println(line);
//                if(line.equalsIgnoreCase("exit"))break;
//
//            }
//
//            socket.shutdownOutput();
//
//        } catch (IOException e) {
//            //e.printStackTrace();
//        }
//
//    }

}
