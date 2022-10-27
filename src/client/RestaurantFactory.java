package client;

public class RestaurantFactory {

    public Restaurant choseRestaurant(String newRestaurantIs){

        Restaurant newRestaurant = null;

        if (newRestaurantIs.equalsIgnoreCase("1")) return new AlBaik();
        else if (newRestaurantIs.equalsIgnoreCase("2"))return new Kfc();
        else return null;
    }

}
