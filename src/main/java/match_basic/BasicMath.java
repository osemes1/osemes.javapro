package match_basic;

import java.util.*;

public class BasicMath {
    // Метод для знаходження суми
    public static double add(double a, double b) {
        return a + b;
    }

    // Метод для знаходження різниці
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Метод для знаходження добутку двох чисел
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Метод для поділу
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Поділ на нуль неможливий!");
        }
        return a / b;
    }

    // Метод для знаходження числа, піднесеного до степені
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Метод для знаходження квадратного кореня числа
    public static double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Від'ємне число не має дійсного квадратного кореня!");
        }
        return Math.sqrt(num);
    }

    // Метод для знаходження абсолютного значення числа
    public static double absoluteValue(double num) {
        return Math.abs(num);
    }

    public static void main(String[] args) {
        // Приклад використання методів класу
        double a = 10;
        double b = 3;

        System.out.println("Сума: " + add(a, b));
        System.out.println("Різниця: " + subtract(a, b));
        System.out.println("Добуток: " + multiply(a, b));
        System.out.println("Частка: " + divide(a, b));
        System.out.println("Число " + a + " піднесене до степені " + b + ": " + power(a, b));
        System.out.println("Квадратний корінь числа " + a + ": " + squareRoot(a));
        System.out.println("Абсолютне значення числа " + b + ": " + absoluteValue(b));
    }


}
