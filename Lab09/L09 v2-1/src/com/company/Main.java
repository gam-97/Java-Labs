package com.company;

import java.util.ArrayList;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> base = new ArrayList<String>();
        base.add("Вега");
        base.add("Гамма");
        base.add("Альфа");
        base.add("Дельта");
        base.add("Альфа");
        base.add("Вега");
        base.add("Гамма");
        base.add("Альфа");
        base.add("Альфа");
        base.add("Бета");

        System.out.println("Коллекция строк:");
        for(String s : base)
            System.out.print(s + "\t");

        System.out.println("\nОбработанная коллекция:");
        for(String z : base.stream().distinct().sorted().collect(Collectors.toList()))
            System.out.print(z + "\t");

    }
}
