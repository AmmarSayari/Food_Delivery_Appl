package client;


import java.io.*;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws IOException {



        Scanner scan = new Scanner(System.in);
        System.out.println("welcome: ");
        System.out.println("chose one of the following:\n1. albaik\n2. kfc\n3. macdonalds");

        String restN = scan.nextLine();

        RestaurantFactory restaurantFactory = new RestaurantFactory();
        Restaurant restaurant = restaurantFactory.choseRestaurant(restN);


        Order order = new Order(restaurant.getMenuList());


        restaurant.displayReMe();
        order.choseOrder();

        String ordTol = "";
        while (true) {
            System.out.println("to show your full list enter (List)");
            System.out.println("to add order enter (o)");
            ordTol = scan.nextLine();
            order.choseOrder();
            if(ordTol.equalsIgnoreCase("list"))
            order.showFullOrderList();
//            for (String gg :
//                    order.getOrderList()) {
//                System.out.println(gg);
//            }

            //if(scan.nextLine().equalsIgnoreCase("done")) break;
        }


        //restaurant = restaurantFactory.choseRestaurant(restN);

        //System.out.println("chose to order");



//        Restaurants res = new Restaurants(restN);
//        String[] menS = res.getMenuList();
//        for (String men : menS) {
//            if(men != null)
//            System.out.println(men);
//        }











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
