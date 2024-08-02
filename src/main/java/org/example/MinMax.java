package org.example;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinMax {

    public void range(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число диапазона:");
        int num1 = in.nextInt();
        System.out.println("Введите до какого числа весь диапазон:");
        int numN = in.nextInt();

        IntStream.range(num1,numN).forEach(System.out::println);
    }
    public static void main(String[] arg){
        MinMax minMax = new MinMax();
        minMax.range();
    }

}
