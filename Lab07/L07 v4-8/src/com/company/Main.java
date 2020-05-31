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
        System.out.print("\nВведите искомое слово:");
        String f = cmd.next();

        String[] S = base.split("[\\s.,'\":;!@#$%^&()]");

        int counter = 0;
        for(String s : S) {
            if (s.toLowerCase().equals(f.toLowerCase()))
                counter++;
        }
        System.out.printf("Указанное слово найдено в тексте %d раз", counter);

    }
}
