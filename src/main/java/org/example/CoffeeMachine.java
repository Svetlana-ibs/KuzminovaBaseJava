package org.example;

import java.util.Scanner;
//Дописать код, отделить однотипные методы с помощью коментов, подкорректироватть код, добавить рецепт напитка с игредиентами
//Разобраться с геттерами и сеттерами
public class CoffeeMachine {

    public boolean isOn = false;

    private int water = 900;

    private int milk = 400;

    private int coffee = 90;
    //Сделать макс знач константами файнал
    public int maxValueWater = 1000;

    public int maxValueCoffee = 100;

    public int maxValueMilk = 500;

    public int countCup = 0;

    public int countCupToClean =15;

    public int countMilk;

    public int countWater;

    public int countCoffee;


    public void onOff() {
        if (!isOn) {
            System.out.println("Чтобы включить кофемашину нажмите '1'");
            Scanner indikator = new Scanner(System.in);
            String buttom = indikator.nextLine();

            if (buttom.equals("1")) {
                isOn = true;
            } else {
                System.out.println("Неверный ввод, попробуйте снова (используйте заглавные английские буквы)");
            }
        } else {
            System.out.println("Чтобы выключить кофемашину нажмите '0'");
            Scanner indikator = new Scanner(System.in);
            String buttom = indikator.nextLine();

            if (buttom.equals("0")) {
                isOn = false;
            } else {
                System.out.println("Неверный ввод, попробуйте снова (используйте заглавные английские буквы)");
            }

        }
    }


    public static void main(String[] args){
        CoffeeMachine machine = new CoffeeMachine();

        while (true){
            machine.onOff();

            if (machine.isOn){
                System.out.println("Чтобы выбрать тип напитка, нажмите '1'");
                System.out.println("Чтобы посмотреть уровень воды нажмите '2', уровень кофе '3', уровень молока '4'");

                Scanner choice1 = new Scanner(System.in);
                int num1 = choice1.nextInt();

                switch (num1) {
                    case 1:
                        machine.choiceDrinks();
                        break;
                    case 2:
                        machine.showWater();
                        break;
                    case 3:
                        machine.showCoffee();
                        break;
                    case 4:
                        machine.showMilk();
                        break;
                }
            }else {
                break;
            }
        }
    }
    public void choiceDrinks(){
        System.out.println("Какой напиток приготовить? Введите номер");
        System.out.println("1 - Эспрессо" + "\n" + "2 - Капучино" + "\n" + "3 - Латте ");
        Scanner choice2 = new Scanner(System.in);
        int drink =  choice2.nextInt();

        switch (drink){
            case 1:
                cookCoffee(Drinks.ESPRESSO);
                break;
            case 2:
                cookCoffee(Drinks.CAPPUCHINO);
                break;
            case 3:
                cookCoffee(Drinks.LATTE);
                break;
        }
    }

    public  void showWater(){
        System.out.println("Уровень воды в кофемашине " + water + "мл");
        System.out.println("Если хотите добавить воды, нажмите 'Y', выйти 'N'");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput.equals("Y")){
            addWater();
        }
    }

    public void showMilk(){
        System.out.println("Уровень молока в кофемашине " + milk + "мл");
        System.out.println("Если хотите добавить молока, нажмите 'Y', выйти 'N'");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput.equals("Y")){
            addMilk();
        }
    }
    public void showCoffee(){
        System.out.println("Уровень кофе в кофемашине " + coffee + "гр");
        System.out.println("Если хотите добавить кофе, нажмите 'Y', выйти 'N'");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput.equals("Y")){
            addCoffee();
        }
    }
    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }
    public int getWater(){
        return water;
    }


    public boolean setWater(int water){
        if (water <= maxValueWater){
            this.water = water;
            return true;
        }else {
            return false;
        }
    }

    public boolean setMilk(int milk){
        if (milk <= maxValueMilk){
            this.milk = milk;
            return true;
        }else {
            return false;
        }
    }
    public boolean setCoffee(int coffee){
        if (coffee <= maxValueCoffee){
            this.coffee = coffee;
            return true;
        }else {
            return false;
        }
    }

    public void addWater(){
        System.out.println("Сколько воды нужно добавить? Введите количество");
        while (true){
            Scanner pourTheWater = new Scanner(System.in);
            countWater = pourTheWater.nextInt();
            setWater(getWater() + countWater);

            if (setWater(getWater() + countWater)){
                System.out.println("Вода добавлена, можно приготовить кофе");
                break;
            }else {
                System.out.println("Вы собираетесь налить слишком много воды. Введите меньше");
            }
        }


    }
    public void addMilk(){
        System.out.println("Сколько молока нужно добавить? Введите количество");
        while (true) {
            Scanner pourTheMilk = new Scanner(System.in);
            countMilk = pourTheMilk.nextInt();
            setMilk(getMilk() + countMilk);

            if (setMilk(getMilk() + countMilk)) {
                System.out.println("Молоко добавлено, можно приготовить кофе");
                break;
            } else {
                System.out.println("Вы собираетесь налить слишком много молока. Введите меньше");
            }

        }
    }
    public void addCoffee(){
        System.out.println("Сколько кофе нужно добавить? Введите количество");
        while (true) {
            Scanner pourTheCoffee = new Scanner(System.in);
            countCoffee = pourTheCoffee.nextInt();
            if (setCoffee(getCoffee() + countCoffee)) {
                System.out.println("Кофе добавлен, можно приготовить напиток");
                break;
            } else {
                System.out.println("Вы собираетесь насыпать слишком много кофе. Введите меньше");
            }
        }
    }


    public void cookCoffee(Drinks drink){
        int portions = choiceCountCup();
        if (water>= portions * drink.getWaterDrink() && coffee>= portions * drink.getCoffeeDrink() && milk >= portions * drink.getMilkDrink()){
            setWater(getWater() - drink.getWaterDrink()) ;
            setCoffee(getCoffee() - drink.getCoffeeDrink());
            setMilk(getCoffee() - drink.getMilkDrink());
            countCup ++;
            System.out.println("Напиток успешно приготовлен!");
        }else {
            System.out.println("Недостаточно ингредиентов. Проверьте уровень кофе, молока и воды");
        }
    }

    //Внедрить в главный метод очистку
    public void cleanMachine(){
        if (countCup >= countCupToClean){
            System.out.println("Кофемашина требует очистки. Очистка будет выполнена автоматически");
            water -= 100;
            countCup = 0;
        }
    }

    public int choiceCountCup(){
        System.out.println("Сколько порций?");
        Scanner portions = new Scanner(System.in);
        countCup = portions.nextInt();
        return countCup;
        //Дописать и разобраться с каждым видом напитка
    }
}
