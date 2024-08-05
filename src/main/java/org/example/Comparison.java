package org.example;

import java.util.Scanner;

public class Comparison {

    public int first_number;

    public int second_number;

    public  void thatIsBigger() {

        System.out.println("Задание 2: Сравнение чисел и выведение большего");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число:");
        first_number = in.nextInt();
        System.out.println("Введите второе число:");
        second_number = in.nextInt();

        if (first_number > second_number) {
            System.out.println("Большее число: " + first_number);
        }
        else if (second_number > first_number) {
            System.out.println("Большее число: " + second_number);
        }
        else {
            System.out.println("Числа равны");
        }
    }

    public static void main(String[] arg){
        Comparison comparison = new Comparison();
        comparison.thatIsBigger();
    }
}
