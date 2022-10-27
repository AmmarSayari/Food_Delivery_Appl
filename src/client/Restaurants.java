package client;

import java.io.*;

public class Restaurants {

    private String restN;
    private String[] menu = new String[20];
    BufferedReader reader = null;


    public Restaurants(String restN) {
        this.restN = restN;
    }

    public String getRestN() {
        return restN;
    }

    public void setRestN(String restN) {
        this.restN = restN;
    }


    public String[] getMenuList(){

        String tol = "";
        int x = 0;
        if(restN.equalsIgnoreCase("1")){
            try {
                reader = reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(
                      "E:\\food_delivery_App\\src\\Al-baik menu"))));
                while ((tol = reader.readLine()) != null){
                    menu[x] = tol;
                    //System.out.println(menu[x]);
                    x++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return menu;

        }else if(restN.equalsIgnoreCase("2")){

        }else if(restN.equalsIgnoreCase("3")){

        }
   return menu;
    }


}
