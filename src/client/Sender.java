package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Sender {

    Socket socket;

    public Sender(Socket socket){
        this.socket = socket;
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
