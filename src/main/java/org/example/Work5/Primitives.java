package org.example.Work5;

import java.util.Arrays;

public class Primitives {

    public static void main(String[] args) {

        char charMin = Character.MIN_VALUE;
        char charMax = Character.MAX_VALUE;

        boolean booleanMin = false;
        boolean booleanMax = true;

        byte byteMin = Byte.MIN_VALUE;
        byte byteMax = Byte.MAX_VALUE;

        short shortMin = Short.MIN_VALUE;
        short shortMax = Short.MAX_VALUE;

        int intMin = Integer.MIN_VALUE;
        int intMax = Integer.MAX_VALUE;

        long longMin = Long.MIN_VALUE;
        long longMax = Long.MAX_VALUE;

        float floatMin = Float.MIN_VALUE;
        float floatMax = Float.MAX_VALUE;

        double doubleMin = Double.MIN_VALUE;
        double doubleMax = Double.MAX_VALUE;

        String StringMin = "''";
        int maxCharsInString = Integer.MAX_VALUE - 1;
        String StringMax = String.valueOf(maxCharsInString);

        int[] ArrayInt = {intMin, intMax};
        String[] ArrayString = {StringMin,StringMax};

        System.out.println("Задание 1: Вывести минимальное и максимальное значения для примитивов, строк и массивов");
        System.out.println("Минимальное значение для char: " + (int)charMin + "  Максимальное значение: " + (int)charMax);
        System.out.println("Минимальное значение для boolean: " + booleanMin + "  Максимальное значение: " + booleanMax);
        System.out.println("Минимальное значение для byte: " + byteMin + "  Максимальное значение: " + byteMax);
        System.out.println("Минимальное значение для short: " + shortMin + "  Максимальное значение: " + shortMax);
        System.out.println("Минимальное значение для int: " + intMin + "  Максимальное значение: " + intMax);
        System.out.println("Минимальное значение для long: " + longMin + "  Максимальное значение: " + longMax);
        System.out.println("Минимальное значение для float: " + floatMin + "  Максимальное значение: " + floatMax);
        System.out.println("Минимальное значение для double: " + doubleMin + "  Максимальное значение: " + doubleMax);
        System.out.println("Минимальное значение для String: " + StringMin + "  Максимальное значение в теории, но а так зависит от объёма памяти: " + StringMax);
        System.out.println("Минимальное и максимальное значения для Array (массив чисел): " + Arrays.toString(ArrayInt));
        System.out.println("Минимальное и максимальное значения для Array (массив строк): " + Arrays.toString(ArrayString));
    }
}
