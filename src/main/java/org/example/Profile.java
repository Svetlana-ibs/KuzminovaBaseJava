package org.example;

import java.util.HashMap;
import java.util.Map;

public class Profile {

    private String name;

    private Map<Drinks,Integer>favoriteDrinks;

    public Profile(String name){
        this.name = name;
        this.favoriteDrinks = new HashMap<>();
    }

    public  String getName(){
        return name;
    }

    public void addFavoriteDrink(Drinks drinks, int portions){
        favoriteDrinks.put(drinks,portions);
    }

    public  Map<Drinks,Integer>getFavoriteDrinks(){
        return  favoriteDrinks;
    }
}
