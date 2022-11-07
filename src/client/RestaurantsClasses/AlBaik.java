package client.RestaurantsClasses;

import java.io.*;
import java.util.ArrayList;

public class AlBaik extends Restaurant {

    //ArrayList<String> albaikMenu = new ArrayList<String>();
    public AlBaik(){
        ArrayList<String> albaikMenu = new ArrayList<String>();
        setName("Al-Baik");
        String tol = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(
                    "E:\\food_delivery_App\\src\\Al-baik_menu"))));
            while ((tol = reader.readLine()) != null) {

                albaikMenu.add(tol);

            }
            setMenuList(albaikMenu);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
