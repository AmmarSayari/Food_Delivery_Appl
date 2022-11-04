package App;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

class ClientHandler extends Thread {

     BufferedReader reader;
     PrintWriter writer;
     Socket socket;
    //final ObjectInputStream objectInputStream;
    private ArrayList<String> list = new ArrayList<String>();


    // Constructor
    public ClientHandler(Socket socket, BufferedReader inputStream, PrintWriter outputStream) {
        this.socket = socket;
        this.reader = inputStream;
        this.writer = outputStream;
        //this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {


        try {

            writer.println("please log in");
            writer.flush();

            logIn();

            //writer.println("please log in2");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void logIn() throws IOException, InterruptedException {

        String userName = reader.readLine();
        System.out.println("username  " + userName);
        String password = reader.readLine();
        System.out.println("password  " + password);

        if (userName.equals("ammar") && password.equals("pass")){
            writer.println("done"+ userName);
        }else {
            writer.println("Login failed  ");
        }
        //Thread.sleep(1000);
        writer.flush();
        writer.close();
    }
}