package App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

class ClientHandler extends Thread {

    final DataInputStream inputStream;
    final DataOutputStream outputStream;
    final Socket socket;
    final ObjectInputStream objectInputStream;
    private ArrayList<String> list = new ArrayList<String>();


    // Constructor
    public ClientHandler(Socket mynewSocket, DataInputStream inputStream, DataOutputStream outputStream, ObjectInputStream objectInputStream) {
        this.socket = mynewSocket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {



        try {

            outputStream.writeUTF("please log in");

            logIn();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void logIn() throws IOException {

        String userName = inputStream.readUTF();
        System.out.println("username" + userName);
        String password = inputStream.readUTF();
        System.out.println("password" + password);

        if (userName.equals("ammar") && password.equals("pass")){
            outputStream.writeUTF("done"+userName);
        }else {
            outputStream.writeUTF("Login failed  ");
        }
        outputStream.flush();
        outputStream.close();
    }
}