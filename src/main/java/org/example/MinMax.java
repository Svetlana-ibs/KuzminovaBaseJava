package org.example;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MinMax {

    public static boolean isPrime(int number){
        if(number<=1){
            return false;
        }
        for (int i =2; i <= Math.sqrt(number); i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
    public void range(){
        System.out.println("Задание 3: Вывод простых чисел в указанном промежутке");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число диапазона: ");
        int num1 = in.nextInt();
        System.out.println("Введите до какого числа весь диапазон: ");
        int numN = in.nextInt();

        IntStream.rangeClosed(num1,numN)
                .filter(MinMax::isPrime)
                .forEach(System.out::println);
    }

    public static void main(String[] arg){
        MinMax minMax = new MinMax();
        minMax.range();
    }
}
