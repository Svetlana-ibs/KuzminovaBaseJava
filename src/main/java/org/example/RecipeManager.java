package org.example;

import java.util.HashMap;
import java.util.Map;

public class RecipeManager {
    private Map<String,Drinks> recipes;

    public RecipeManager(){
        recipes = new HashMap<>();
        recipes.put("Эспрессо", Drinks.ESPRESSO);
        recipes.put("Капучино", Drinks.CAPPUCHINO);
        recipes.put("Латте", Drinks.LATTE);
    }

    public Drinks getRecipe(String name){
        return recipes.get(name);
    }

    public void showRecipe(String name){
        Drinks drinks = getRecipe(name);
        if (drinks != null){
            System.out.println("Рецепт " + name + ":");
            System.out.println("Вода: " + drinks.getWaterDrink() + " мл");
            System.out.println("Молоко: " + drinks.getMilkDrink() + " мл");
            System.out.println("Кофе: " + drinks.getCoffeeDrink() + " гр");
        }else {
            System.out.println("Напиток с таким названием не найден");
        }
    }
}
