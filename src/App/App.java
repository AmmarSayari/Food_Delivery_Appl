package App;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(1000);

        System.out.println("server waiting for connection...");

        while (true){
            Socket socket = server.accept();

            new Sender(socket).start();
            new Receiver(socket).start();
        }

    }
}
