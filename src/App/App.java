package App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(1000);

        System.out.println("server waiting for connection...");

        while (true){

            Socket socket = null;

            try {
                socket = server.accept();
                System.out.println("A new connection identified : " + socket);

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outPutStream = new DataOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                System.out.println("Thread assigned");

                Thread tThread = new ClientHandler(socket, inputStream , outPutStream, objectInputStream);

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
