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
        System.out.println("Если хотите добавить воды, нажмите 'Y',чтобы выйти - нажмите любой символ");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput.equals("Y")) {
            addWater();
        }
    }

    public void showMilk() {
        System.out.println("Уровень молока в кофемашине " + milk + "мл");
        System.out.println("Если хотите добавить молока, нажмите 'Y',чтобы выйти - нажмите любой символ");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput.equals("Y")) {
            addMilk();
        }
    }

    public void showCoffee() {
        System.out.println("Уровень кофе в кофемашине " + coffee + "гр");
        System.out.println("Если хотите добавить кофе, нажмите 'Y',чтобы выйти - нажмите любой символ");
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

            if (countWater > 10){
                if (setWater(getWater() + countWater)) {
                    System.out.println("Вода добавлена");
                    break;
                } else {
                    System.out.println("Вы собираетесь налить слишком много воды. Введите меньше");
                }
            } else {
                System.out.println("Нельзя добавить такое количество воды." + "\n" + "Минимальное значение 10 мл, а максимальное количество воды может быть " + MAX_VALUE_WATER);
                System.out.println("Вы собираетесь налить слишком мало воды. Введите больше");
            }
        }
    }

    public void addMilk() {
        System.out.println("Сколько молока нужно добавить? Введите количество");
        while (true) {
            Scanner pourTheMilk = new Scanner(System.in);
            int countMilk = pourTheMilk.nextInt();

            if (countMilk > 10){
                if (setMilk(getMilk() + countMilk)) {
                    System.out.println("Молоко добавлено, можно приготовить кофе");
                    break;
                } else {
                    System.out.println("Вы собираетесь налить слишком много молока. Введите меньше");
                }
            } else {
                System.out.println("Нельзя добавить такое количество молока." + "\n" + "Минимальное значение 10 мл, а максимальное количество молока может быть " + MAX_VALUE_MILK);
                System.out.println("Вы собираетесь налить слишком мало молока. Введите больше");
            }
        }
    }

    public void addCoffee() {
        System.out.println("Сколько кофе нужно добавить? Введите количество");
        while (true) {
            Scanner pourTheCoffee = new Scanner(System.in);
            int countCoffee = pourTheCoffee.nextInt();

            if (countCoffee > 10){
                if (setCoffee(getCoffee() + countCoffee)) {
                    System.out.println("Кофе добавлен, можно приготовить напиток");
                    break;
                } else {
                    System.out.println("Вы собираетесь насыпать слишком много кофе. Введите меньше");
                }
            } else {
                System.out.println("Нельзя добавить такое количество кофе." + "\n" + "Минимальное значение 10 гр., а максимальное количество кофе может быть " + MAX_VALUE_COFFEE);
                System.out.println("Вы собираетесь насыпать слишком мало кофе. Введите больше");
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
