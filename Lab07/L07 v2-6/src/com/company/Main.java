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
        System.out.println("\nСлова, в которых первая и последняя буква совпадают:");

        String[] S = base.split("[\\s.,'\"!?0-9]");

        for(String s : S){
            if (s.length() > 1 && s.charAt(0) == s.charAt(s.length()-1))
                System.out.println(s);
        }
    }
}
