package com.company;

import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Date firstDate = new Date(120, 01,01,14,20), lastDate = new Date();
        System.out.printf("Разработчик: Гришина А.М. \nЗадание получено: %tc \nЗадание сдано: %tc \n", firstDate, lastDate);

        System.out.println("Введите количество анализируемых строк:");
        int count = in.nextInt();
        String max = "", min = "";

        System.out.println("Введите анализируемые строки:");
        for (int i = 0; i <= count; i++) {
            String s = in.nextLine();
            if (i == 0)
                continue;
            if (i == 1){
                min = s;
                max = s;
            }
            if (s.length() > max.length())
                max = s;
            if (s.length() < min.length())
                min = s;
        }

        System.out.printf("Самая короткая строка: %d символов \n%s", min.length(), min);
        System.out.printf("\nСамая длинная строка: %d символов \n%s", max.length(), max);

    }
}

