package com.company;

import java.util.Scanner;

public class Product {
    private static int Counter = 0; // общее кол-во товаров
    private int Id; // номер текущего товара
    private String Name; // название
    private double Price; // цена
    private int Count; // количество

    public int getId() {
        return Id;
    }
    public int getCount() {
        return Count;
    }
    public String getName() {
        return Name;
    }
    public double getPrice() {
        return Price;
    }

    void setCount(int count) {
        if (count >= 0)
            Count = count;
        else
            System.out.println("Количество товара не может быть ниже 0");
    }
    void setPrice(double price) {
        if (price >= 0)
            Price = price;
        else
            System.out.println("Стоимость товара не может быть ниже 0");
    }

    void changeCount(int count) {
        if ((Count + count) >= 0)
            Count += count;
        else
            System.out.printf("Товар %s отсутствует в требуемом количестве. В наличии: %d\n", Name, Count);
    }

    Product() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nФормирование нового товара >>>");
        System.out.print("Укажите наименование товара: ");
        Name = sc.nextLine();
        System.out.print("Укажите стоимость товара: ");
        Price = sc.nextDouble();
        System.out.print("Укажите количество товара: ");
        Count = sc.nextInt();
        Id = ++Counter;
        System.out.printf("Добавлен товар >>> Id: %d\t Наименование: %s\t Стоимость: %.2f\t Количество: %d\n", Id, Name, Price, Count);
    }

    Product(String name, double price, int count) {
        Name = name.replaceAll(" ", "").length() > 0 ? name : "unknown";
        setPrice(price);
        setCount(count);
        Id = ++Counter;
        System.out.printf("Добавлен товар >>> Id: %d\t Наименование: %s\t Стоимость: %.2f\t Количество: %d \n", Id, Name, Price, Count);
    }

    boolean last(){
        return Id == Counter ? true : false;
    }

    void info(){
        System.out.printf("Id: %d\t Наименование: %s\t Цена: %.2f\t Количество: %d \n", Id, Name, Price, Count);
    }
}
