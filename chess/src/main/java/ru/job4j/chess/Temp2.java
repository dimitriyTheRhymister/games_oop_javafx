package ru.job4j.chess;

public class Temp2 {
    public static void numCompare(int num1, int num2) {
        if (num1 > num2) {
            System.out.print(num2);
            System.out.print(" ");
            System.out.print(num1);
            System.out.println();
            System.out.print(num1);
            System.out.print(" ");
            System.out.print(num2);
        } else {
            System.out.print(num1);
            System.out.print(" ");
            System.out.print(num2);
            System.out.println();
            System.out.print(num2);
            System.out.print(" ");
            System.out.print(num1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println();
        numCompare(1, 2);
        numCompare(2, 1);
        numCompare(-2, 1);
        numCompare(1, 0);
        numCompare(0, -1);
    }
}
