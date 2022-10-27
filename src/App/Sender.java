package App;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {

    Socket socket;

    public Sender(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

    String line;

        try {
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out,true);

//            writer.println("choose one of the following restaurant: ");
//            writer.print("1. al-baik");
//            writer.print("2. Mac");
//            writer.print("3. KFC");


            while (true){
                Scanner keyBoard = new Scanner(System.in);
                System.out.println("msg: ");
                line = keyBoard.nextLine();


                writer.println(line);
                if(line.equalsIgnoreCase("exit"))break;

            }

            socket.shutdownOutput();

        } catch (IOException e) {
            //e.printStackTrace();
        }

    }

}
