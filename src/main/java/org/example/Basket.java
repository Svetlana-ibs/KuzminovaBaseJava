package org.example;
import java.util.Scanner;

public class Basket {
    String prod = " ";
    String productInBasket;
    public void products(){
        while (prod != "Х"){
            Scanner in = new Scanner(System.in);
            System.out.println("Введите название продукта. Чтобы закончить ввод продуктов нажмите Х");
            prod = in.nextLine();
            productInBasket += prod;
        }
        System.out.println();
    }
    public static void main(String[] arg) {
        Basket basket = new Basket();
        basket.products();
    }
}

