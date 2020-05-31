package com.company;

import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        String[] AllWriter = new String[]
                {"Альфа", "Бета", "Гамма", "Дельта"};
        String[] AllPublisher = new String[]
                {"Москва", "Санкт-Петербург", "Волгоград", "Крым"};
        String[] AllName = new String[]
                {"Гравитация", "Сингулярность", "Комета", "Белый карлик", "Чёрная дыра", "Высадка"};
        String[] AllSkin = new String[]
                {"твёрдый", "мягкий"};
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[5];
        for(int i = 0; i < books.length; i++){
            Random r = new Random();
            books[i] = new Book(
                    i+1, AllName[r.nextInt(6)],
                    AllWriter[r.nextInt(4)], AllPublisher[r.nextInt(4)],
                    r.nextInt(70) + 1950, r.nextInt(150) + 300, r.nextDouble() * 1000,
                    AllSkin[r.nextInt(1)]);
            System.out.println(books[i].toString());
        }

        System.out.print("\n--------\nВведите искомого автора: ");
        String writer = sc.nextLine();
        int i = 0;
        for (Book b : books) {
            if (writer.equals(b.getWriter())) {
                System.out.println(b.toString());
                i += 1;
            }
        }
        if (i == 0) System.out.printf("Книги автора \"%s\" отсутствуют\n", writer);

        System.out.print("\n--------\nВведите искомое издательство: ");
        String publisher = sc.nextLine();
        i = 0;
        for (Book b : books){
            if (publisher.equals(b.getPublisher())) {
                System.out.println(b.toString());
                i += 1;
            }
        }
        if (i == 0) System.out.printf("Книги издательства \"%s\" отсутствуют\n", publisher);

        System.out.print("\n--------\nВведите минимальный год: ");
        int year = sc.nextInt();
        i = 0;
        for (Book b : books) {
            if (b.getYear() > year) {
                System.out.println(b.toString());
                i += 1;
            }
        }
        if (i == 0) System.out.printf("Книги выпущенные после %d года отсутствуют\n", year);

    }

}

class Book{

    private int Id = 0, Year = 0, Size = 0;
    private double Price = 0;
    private String Name = "", Writer = "", Publisher = "", Skin = "";

    Book(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите Id: ");
        setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Введите название книги: ");
        setName(sc.nextLine());
        System.out.print("Введите автора: ");
        setWriter(sc.nextLine());
        System.out.print("Введите издательство: ");
        setPublisher(sc.nextLine());
        System.out.print("Введите год издания: ");
        setYear(sc.nextInt());
        sc.nextLine();
        System.out.print("Введите количество страниц: ");
        setSize(sc.nextInt());
        sc.nextLine();
        System.out.print("Введите стоимость: ");
        setPrice(sc.nextDouble());
        sc.nextLine();
        System.out.print("Введите тип переплёта: ");
        setSkin(sc.next());
    }


    Book(int id, String name, String writer, String publisher, int year, int size, double price, String skin){
        setId(id);
        setName(name);
        setWriter(writer);
        setPublisher(publisher);
        setYear(year);
        setSize(size);
        setPrice(price);
        setSkin(skin);
    }

    public int getId(){ return Id; }
    public int getYear(){ return Year; }
    public int getSize(){ return Size; }
    public double getPrice(){ return Price; }
    public String getName(){ return Name; }
    public String getWriter(){ return Writer; }
    public String getPublisher(){ return Publisher; }
    public String getSkin(){ return Skin; }

    public void setId(int id){
        if(id > 0) Id = id;
        else System.out.println("Значение идентификатора Id должно быть больше нуля");
    }
    public void setYear(int year){
        if (year > 0) Year = year;
        else System.out.println("Откуда у Вас книга старше н.э.?");
    }
    public void setSize(int size){
        if (size > 0) Size = size;
        else System.out.println("Количество страниц должно быть больше нуля");
    }
    public void setPrice(double price){
        if (price >= 0) Price = price;
        else System.out.println("Стоимость не может быть ниже нуля");
    }
    public void setName(String name){
        String check = name.replaceAll(" ","");
        if (check.length() > 0) Name = name;
        else System.out.println("Необходимо указать наименование книги");
    }
    public void setWriter(String writer){
        String check = writer.replaceAll(" ","");
        if (check.length() > 0) Writer = writer;
        else Writer = "unknown";
    }
    public void setPublisher(String publisher){
        String check = publisher.replaceAll(" ","");
        if (check.length() > 0) Publisher = publisher;
        else Publisher = "unknown";
    }
    public void setSkin(String skin){
        if (skin.toLowerCase() == "твёрдый" || skin.toLowerCase() == "мягкий") Skin = skin.toLowerCase();
        else System.out.println("Для описания переплёта доступны значения: <твёрдый> и <мягкий>");
    }

    @Override
    public String toString() {
        String str =
                "Id: " + Id + "; Наименование: " + Name +
                "\nАвтор: " + Writer + "; Издательство: " + Publisher + "; Год издания: " + Year +
                "\nКоличество страниц: " + Size + "; Цена: " + Math.round(Price) + "; Переплёт: " + Skin;
        return str;
    }
}
