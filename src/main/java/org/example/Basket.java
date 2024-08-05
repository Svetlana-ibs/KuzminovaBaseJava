package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Basket{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Задание 4: Корзина с продуктами");
        System.out.println(" Введите название продуктов. Для завершения ввода нажмите 'x'(На английской раскладке)");

        while (true){
            String input = in.nextLine();
            if (input.equalsIgnoreCase("x")){
                break;
            }
            list.add(input);
        }
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
