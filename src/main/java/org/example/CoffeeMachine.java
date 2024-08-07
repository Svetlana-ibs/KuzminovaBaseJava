package org.example;

import java.util.Scanner;
//Дописать код, отделить однотипные методы с помощью коментов, подкорректироватть код, добавить рецепт напитка с игредиентами
//Разобраться с геттерами и сеттерами
public class CoffeeMachine {

    public static boolean isOn = false;

    private int water;

    private int milk;

    private int coffee;

    public int maxValueWater = 1000;

    public int maxValueCoffee = 100;

    public int maxValueMilk = 500;

    public int countCup = 0;

    public int countCupToClean =15;

    public int countMilk;

    public int countWater;

    public int countCoffee;





    public void onOff() {

        System.out.println("Чтобы включить кофемашину нажмите 'O', чтобы выключить нажмите 'X'");
        Scanner indikator = new Scanner(System.in);
        String buttom = indikator.nextLine();

        if(buttom.equals("O")){
            isOn = true;
        }
        else if (buttom.equals("X")){
            isOn = false;
        }
        else {
            System.out.println("Неверный ввод, попробуйте снова (используйте заглавные английские буквы)");
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
        if (choiceInput == "Y"){
            addWater();
        }else {
            //Дописать переход назад
        }
    }

    public void showMilk(){
        System.out.println("Уровень молока в кофемашине " + milk + "мл");
        System.out.println("Если хотите добавить молока, нажмите 'Y', выйти 'N'");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput == "Y"){
            addMilk();
        }else {
            //Дописать переход назад
        }
    }

    public void showCoffee(){
        System.out.println("Уровень кофе в кофемашине " + coffee + "гр");
        System.out.println("Если хотите добавить кофе, нажмите 'Y', выйти 'N'");
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        if (choiceInput == "Y"){
            addCoffee();
        }else {
            //Дописать переход назад
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


    public void setWater(int water){
        if (water <= maxValueWater){
            this.water = water;
            System.out.println("Вода добавлена, можно приготовить кофе");
        }else {
            System.out.println("Вы собираетесь налить слишком много воды. Введите меньше");
            //Добавить цикл, чтобы ещё раз ввести значения
        }
    }

    public void setMilk(int milk){
        if (milk <= maxValueMilk){
            this.milk = milk;
            System.out.println("Молоко добавлено, можно приготовить кофе");
        }else {
            System.out.println("Вы собираетесь налить слишком много молока. Введите меньше");
            //Добавить цикл, чтобы ещё раз ввести значения
        }
    }
    public void setCoffee(int coffee){
        if (coffee <= maxValueCoffee){
            this.coffee = coffee;
            System.out.println("Кофе добавлен, можно приготовить напиток");
        }else {
            System.out.println("Вы собираетесь насыпать слишком много кофе. Введите меньше");
            //Добавить цикл, чтобы ещё раз ввести значения
        }
    }

    public void addWater(){
        System.out.println("Сколько воды нужно добавить? Введите количество");
        Scanner pourTheWater = new Scanner(System.in);
        countWater = pourTheWater.nextInt();
        setWater(getWater() + countWater);
    }
    public void addMilk(){
        System.out.println("Сколько молока нужно добавить? Введите количество");
        Scanner pourTheMilk = new Scanner(System.in);
        countMilk = pourTheMilk.nextInt();
        setMilk(getMilk() + countMilk);
    }
    public void addCoffee(){
        System.out.println("Сколько кофе нужно добавить? Введите количество");
        Scanner pourTheCoffee = new Scanner(System.in);
        countCoffee = pourTheCoffee.nextInt();
        setCoffee(getCoffee() + countCoffee);
    }


    public void cookCoffee(Drinks drink){

        //Drinks dr = Drinks.valueOf(drinks);

        if (water>= drink.getWaterDrink() || coffee>= drink.getCoffeeDrink() || milk >= drink.getMilkDrink()){
            setWater(getWater() - drink.getWaterDrink()) ;
            setCoffee(getCoffee() - drink.getCoffeeDrink());
            setMilk(getCoffee() - drink.getMilkDrink());
            countCup ++;
        }else {
            System.out.println("Недостаточно ингредиентов. Проверьте уровень кофе и воды");
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

    public void choiceCountCup(){
        System.out.println("Сколько порций?");
        Scanner portions = new Scanner(System.in);
        countCup = portions.nextInt();

        //Дописать и разобраться с каждым видом напитка
    }
}
