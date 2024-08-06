package org.example;

import java.util.Scanner;

public class CoffeMachine {

    public boolean isOn = false;
    private int water;
    private int milk;
    private int coffee;
    public int maxValueWater = 1000;
    public int countCup;

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
        CoffeMachine machine = new CoffeMachine();

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
                        machine.addWater(1000);
                        break;
                    case 3:
                        machine.addMilk(200);
                        break;
                    case 4:
                        machine.addCoffee(100);
                        break;
                }
            }else {
                break;
            }
        }
    }

    public  void addWater(int countWater){
        water += countWater;
        System.out.println("Уровень воды в кофемашине " + water + "мл");
    }

    public void addMilk(int countMilk){
        milk += countMilk;
        System.out.println("Уровень молока в кофемашине " + milk + "мл");
    }

    public void addCoffee(int countCoffee){
        coffee += countCoffee;
        System.out.println("Уровень кофе в кофемашине " + coffee + "мл");
    }

    public void setWater(){
        if (water <= maxValueWater){
            System.out.println("Вода добавлена, можно приготовить кофе");
        }else {
            System.out.println();
        }
    }

    public void choiceDrinks(){
        System.out.println("Какой напиток приготовить? Введите номер");
        System.out.println("1 - Эспрессо" + "\n" + "2 - Капучино" + "\n" + "3 - Латте ");
        Scanner choice2 = new Scanner(System.in);
        int drink =  choice2.nextInt();

        switch (drink){
            case 1:
                cookEspresso();
                break;
            case 2:
                cookCapuchino();
                break;
            case 3:
                cookLatte();
                break;
        }
    }

    public void cookEspresso(){
        if (water>=150 || coffee>= 10){
            water -=150;
            coffee -=10;
            countCup ++;
        }else {
            System.out.println("Недостаточно ингредиентов. Проверьте уровень кофе и воды");
        }

    }
    public void cookCapuchino(){
        if (water>=110 || coffee>= 8 || milk>=40){
            water -=110;
            coffee -=8;
            milk -=40;
            countCup ++;
        }else {
            System.out.println("Недостаточно ингредиентов. Проверьте уровень кофе, молока и воды");
        }
    }
    public void cookLatte(){
        if (water>=80 || coffee>= 8 || milk>=70){
            water -=80;
            coffee -=8;
            milk -=70;
            countCup ++;
        }else {
            System.out.println("Недостаточно ингредиентов. Проверьте уровень кофе, молока и воды");
        }
    }

    public void cleanMachine(){
        if (countCup >= 15){
            System.out.println("\"Кофемашина требует очистки. Очистка будет выполнена автоматически");
            water -= 100;
            countCup = 0;
        }
    }
}
