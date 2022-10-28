package client;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private ArrayList<String> orderList = new ArrayList<String>();
    private ArrayList<String> menuList = new ArrayList<String>();

    public Order(ArrayList<String> menuList) {
        this.menuList = menuList;
    }

    public ArrayList<String> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<String> orderList) {
        this.orderList = orderList;
    }

    public ArrayList<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<String> menuList) {
        this.menuList = menuList;
    }

    public void choseOrder(){
        System.out.println("chose an order: ");
        Scanner scan = new Scanner(System.in);
        String customerReader = scan.nextLine();

        int tol = Integer.parseInt(customerReader) - 1;

        orderList.add(menuList.get(tol));
        System.out.println("this order add to your list:   "+menuList.get(tol));


        //if(customerReader.equalsIgnoreCase("1")){

           // orderList.add(menuList.get())


//            for (String x : menuList) {
//
//                System.out.println("- "+ x);
//        }
//        }


    }

    public void showFullOrderList(){
        for (String gg :
                orderList) {
            System.out.println(gg);
        }
    }

     //public ArrayList<String> customerOrderList(){}
}
