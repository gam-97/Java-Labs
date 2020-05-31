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
        System.out.println("\nСлова первого предложения, отсутствующие в последующих:");

        String[] S1 = base.split("[.!?]");
        String[] S2 = S1[0].split("[\\s.,'\":;!@#$%^&()]");

        for(String s : S2) {
            boolean f = false;
            for (int i = 1; i < S1.length; i++)
                if (S1[i].toLowerCase().contains(s.toLowerCase())) {
                    f = true;
                    break;
                }
            if (!f) System.out.println(s);
        }
    }
}
