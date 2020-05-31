package com.company;

import java.util.Scanner;

public class Buyer {
    private static int Counter = 0;
    private int Id;
    String FIO;
    private int Age;
    private boolean BlackList = false;

    public int getId() {
        return Id;
    }
    public boolean getBlackList() {
        return BlackList;
    }

    Buyer(String fio) {
        Scanner sc = new Scanner(System.in);
        FIO = fio;
        System.out.print("Укажите возраст покупателя: ");
        Age = sc.nextInt();
        Id = ++Counter;
        System.out.printf("Зарегистрирован покупатель >>> Id: %d\t Ф.И.О.: %s\t Возраст: %d\n", Id, FIO, Age);
    }

    Buyer(String fio, int age){
        FIO = fio;
        Age = age;
        Id = ++Counter;
        System.out.printf("Зарегистрирован покупатель >>> Id: %d\t Ф.И.О.: %s\t Возраст: %d\n", Id, FIO, Age);
    }

    void info(){
        System.out.printf("Id: %d\t Ф.И.О.: %s\t Возраст: %d\t В ч.с.: %s\n", Id, FIO, Age, BlackList ? "Да" : "Нет");
    }

    boolean last(){
        return Id == Counter ? true : false;
    }

    void inBlackList(){
        BlackList = true;
    }

    void outBlackList(){
        BlackList = false;
    }
}
