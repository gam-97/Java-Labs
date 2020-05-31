package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество анализируемых чисел:");
        int range = in.nextInt();
        int[] m = new int[range];
        String ch = "", noch = "";

        System.out.println("Введите анализируемые числа:");
        for (int i = 0; i < m.length; i++) {
            m[i] = in.nextInt();
            if (m[i] % 2 == 0)
                ch += m[i] + " ";
            else
                noch += m[i] + " ";
       }

        System.out.println("Сформирован массив:");
        for (int j : m)
            System.out.print(j + " ");

        System.out.printf("\nЧётные числа: %s", ch.length()>0 ? ch : "отсутствуют");
        System.out.printf("\nНечётные числа: %s", noch.length()>0 ? noch : "отсутствуют");

    }
}

