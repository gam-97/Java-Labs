package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество строк:");
        int lines = in.nextInt();

        if (lines == 0)
            System.out.print("Задано количество строк равное 0");
        else{
            System.out.printf("Вывод %d строк без перехода на новую строку: \n", lines);
            for ( int i = 1; i <= lines; i++)
                System.out.print("Строка №" + i + "; ");
            System.out.printf("\nВывод %d строк c переходом на новую строку: \n", lines);
            for ( int i = 1; i <= lines; i++)
                System.out.println("Строка №" + i + "; ");
        }

    }
}
