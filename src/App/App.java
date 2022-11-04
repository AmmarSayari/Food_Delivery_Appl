package App;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(1000);

        System.out.println("server waiting for connection...");

        db ddd = new db();
        ddd.DBconnection();
        try {
            ddd.Sign_up("ahmed","u2","0909","anozlah");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true){

            Socket socket = null;

            try {
                socket = server.accept();
                System.out.println("A new connection identified : " + socket);

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                //ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                System.out.println("Thread assigned");

                Thread tThread = new ClientHandler(socket, reader , writer);

                tThread.start();

            }catch (Exception e){
                socket.close();
                e.printStackTrace();
            }






//            Socket socket = server.accept();
//
//            //new Sender(socket).start();
//            new Receiver(socket).receiveOrderList();
//            //new Receiver(socket).start();
        }

    }
}
