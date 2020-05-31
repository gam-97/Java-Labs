package com.company;

import java.util.ArrayList;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> base = new ArrayList<String>();
        base.add("Альфа");
        base.add("Бета");
        base.add("Вега");
        base.add("Гамма");
        base.add("Дельта");

        System.out.println("Коллекция строк:");
        for(String s : base)
            System.out.println(s);

        System.out.println("Последний элемент: " + base.stream().skip(base.size() - 1).findFirst().get());
        System.out.println("Третий элемент: " + base.stream().skip(2).findFirst().get());
    }
}
