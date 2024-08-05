package org.example;

import java.util.Scanner;

public class Password {

    public static void main(String[] args) {

        System.out.println("Задание 5: Ввод пароля");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Установите новый пароль: ");
        String rightPassword = scanner.nextLine();

        System.out.println("Пароль установлен");
        System.out.println("Введите пароль для доступа: ");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals(rightPassword)) {
                System.out.println("Пароль верный. Программа завершена.");
                break;
            } else {
                System.out.println("Пароль неверный. Попробуйте снова:");
            }
        }
        scanner.close();
    }
}
