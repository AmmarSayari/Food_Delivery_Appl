package client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Sender {

        final DataInputStream inputStream;
        final DataOutputStream outputStream;
        final Socket socket;

    public Sender(Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    public void contactServer() throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.print("user name:  ");
        String userName = scan.nextLine();
        outputStream.writeUTF(userName);

        //System.out.println();

        System.out.print("password:  ");
        String pass = scan.nextLine();
        outputStream.writeUTF(pass);

        outputStream.flush();

        //response
        System.out.println("server response:  "+inputStream.readUTF());

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
