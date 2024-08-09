package org.example;

public enum Drinks {
    LATTE(8,80,70),
    CAPPUCHINO(8,110, 40),
    ESPRESSO(10,150,0);

    public int waterDrink;

    public int milkDrink;

    public int coffeeDrink;

    Drinks(int coffeeDrink, int waterDrink, int milkDrink){
        this.coffeeDrink = coffeeDrink;
        this.waterDrink = waterDrink;
        this.milkDrink = milkDrink;
    }

    public int getWaterDrink() {
        return waterDrink;
    }

    public int getMilkDrink(){
        return milkDrink;
    }

    public int getCoffeeDrink(){
        return coffeeDrink;
    }
}
