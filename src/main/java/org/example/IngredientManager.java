package org.example;

import java.util.Scanner;

public class IngredientManager {

    private int water;

    private int milk;

    private int coffee;

    public final int MAX_VALUE_WATER;

    public final int MAX_VALUE_COFFEE;

    public final int MAX_VALUE_MILK;

    public IngredientManager(int water, int milk, int coffee, int MAX_VALUE_WATER, int MAX_VALUE_MILK, int MAX_VALUE_COFFEE) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.MAX_VALUE_WATER = MAX_VALUE_WATER;
        this.MAX_VALUE_MILK = MAX_VALUE_MILK;
        this.MAX_VALUE_COFFEE = MAX_VALUE_COFFEE;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public void showWater() {
        System.out.println("Уровень воды в кофемашине " + water + "мл");
        System.out.println("Если хотите добавить воды, нажмите 'Y', выйти 'N'");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput.equals("Y")) {
            addWater();
        }
    }

    public void showMilk() {
        System.out.println("Уровень молока в кофемашине " + milk + "мл");
        System.out.println("Если хотите добавить молока, нажмите 'Y', выйти 'N'");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput.equals("Y")) {
            addMilk();
        }
    }

    public void showCoffee() {
        System.out.println("Уровень кофе в кофемашине " + coffee + "гр");
        System.out.println("Если хотите добавить кофе, нажмите 'Y', выйти 'N'");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput.equals("Y")) {
            addCoffee();
        }
    }

    public boolean setWater(int water) {
        if (water <= MAX_VALUE_WATER) {
            this.water = water;
            return true;
        } else {
            return false;
        }
    }

    public boolean setMilk(int milk) {
        if (milk <= MAX_VALUE_MILK) {
            this.milk = milk;
            return true;
        } else {
            return false;
        }
    }

    public boolean setCoffee(int coffee) {
        if (coffee <= MAX_VALUE_COFFEE) {
            this.coffee = coffee;
            return true;
        } else {
            return false;
        }
    }

    public void addWater() {
        System.out.println("Сколько воды нужно добавить? Введите количество");
        while (true) {
            Scanner pourTheWater = new Scanner(System.in);
            int countWater = pourTheWater.nextInt();
            setWater(getWater() + countWater);

            if (setWater(getWater() + countWater)) {
                System.out.println("Вода добавлена, можно приготовить кофе");
                break;
            } else {
                System.out.println("Вы собираетесь налить слишком много воды. Введите меньше");
            }
        }
    }

    public void addMilk() {
        System.out.println("Сколько молока нужно добавить? Введите количество");
        while (true) {
            Scanner pourTheMilk = new Scanner(System.in);
            int countMilk = pourTheMilk.nextInt();
            setMilk(getMilk() + countMilk);

            if (setMilk(getMilk() + countMilk)) {
                System.out.println("Молоко добавлено, можно приготовить кофе");
                break;
            } else {
                System.out.println("Вы собираетесь налить слишком много молока. Введите меньше");
            }
        }
    }

    public void addCoffee() {
        System.out.println("Сколько кофе нужно добавить? Введите количество");
        while (true) {
            Scanner pourTheCoffee = new Scanner(System.in);
            int countCoffee = pourTheCoffee.nextInt();
            if (setCoffee(getCoffee() + countCoffee)) {
                System.out.println("Кофе добавлен, можно приготовить напиток");
                break;
            } else {
                System.out.println("Вы собираетесь насыпать слишком много кофе. Введите меньше");
            }
        }
    }

    public boolean useIngredients(int water,int milk,int coffee){
        if (this.water >= water && this.milk >= milk && this.coffee >= coffee){
            this.water -= water;
            this.milk -= milk;
            this.coffee -= coffee;
            return true;
        }
        return false;
    }
}
