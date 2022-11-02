package client;


import java.io.*;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

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
            if (ordTol.equalsIgnoreCase("back") ||ordTol.equalsIgnoreCase("f")||ordTol.equalsIgnoreCase("exit"))break;

            if (ordTol.equalsIgnoreCase("o"))
                order.choseOrder();
            if (ordTol.equalsIgnoreCase("list"))
                order.showFullOrderList();
            if (ordTol.equalsIgnoreCase("total"))
                order.showFullPrice();

        }
        }




//        BufferedReader reader = null;
//        reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(
//                "E:\\food_delivery_App\\src\\Restuarants"))));
//
//        Restaurants restaurants = new Restaurants();
//
//        String rest = "";
//        while ((rest = reader.readLine()) != null){
//
//            //restaurants = new Restaurants(rest);
//            System.out.println(rest);
//
//
//        }
//        System.out.println(restaurants.getName());
//        System.out.println(restaurants.getName());
//        System.out.println(restaurants.getName());


//        Socket socket = new Socket("localhost", 1000);
//
//        new Sender(socket).start();
//        new Receiver(socket).start();
    }
}
