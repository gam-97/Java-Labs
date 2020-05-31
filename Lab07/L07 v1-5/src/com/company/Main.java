package com.company;

import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner cmd = new Scanner(System.in);

        String base =
                "Тестовый текст, используемый в работе приложения.\n" +
                "Текст содержит набор повторяющихся слов, используемых в работе приложения.\n" +
                "А так же слова 'Артемида', 'сенокос', 'олово' для иных тестов.";

        System.out.println("Используемый текст:\n" + base);
        System.out.println("Введите подстроку для последующей вставки:");
        String alt = cmd.nextLine();
        System.out.println("Введите номер символа для вставки:");
        int k = cmd.nextInt();
        StringBuffer sb = new StringBuffer(base);
        sb.insert(k, alt);
        System.out.println("Полученный результат:\n" + sb);

    }
}
