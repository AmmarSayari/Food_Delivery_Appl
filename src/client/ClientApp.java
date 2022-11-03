package client;


import client.RestaurantsClasses.Restaurant;
import client.RestaurantsClasses.RestaurantFactory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Socket socket = new Socket("localhost", 1000);
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outPutStream = new DataOutputStream(socket.getOutputStream());


        //main menu
        String ordTol = "";
        while (true){

            if(ordTol.equalsIgnoreCase("f")||ordTol.equalsIgnoreCase("exit"))break;

            System.out.println("welcome to main menu: ");
            System.out.println("chose one of the following:\n1. albaik\n2. kfc\n3. macdonalds");
            System.out.println("if you want to quit write (exit) ");

            String restN = scan.nextLine();
            if(restN.equalsIgnoreCase("exit"))break;

        RestaurantFactory restaurantFactory = new RestaurantFactory();
        Restaurant restaurant = restaurantFactory.choseRestaurant(restN);

        Order order = new Order(restaurant.getMenuList());

        restaurant.displayReMe();

        while (true) {
            System.out.println("to show your full list enter (List)");
            System.out.println("to add order enter (o)");
            System.out.println("to back to the main menu type (back): ");
            System.out.println("finish order (f)");
            System.out.println("to exit the App (exit)");
            ordTol = scan.nextLine();
            if (ordTol.equalsIgnoreCase("back") ||ordTol.equalsIgnoreCase("exit"))break;

            if (ordTol.equalsIgnoreCase("o"))
                order.choseOrder();
            if (ordTol.equalsIgnoreCase("list"))
                order.showFullOrderList();
            if (ordTol.equalsIgnoreCase("total"))
                order.showFullPrice();
            if (ordTol.equalsIgnoreCase("f")){
                new Sender(socket,inputStream,outPutStream).contactServer();
                break;
            }


        }
        }




//
      //  new Sender(socket).sendOrderList();
//        new Receiver(socket).start();
    }
}
