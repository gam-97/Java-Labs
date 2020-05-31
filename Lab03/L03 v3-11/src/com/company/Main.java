package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Minute m1 = new Minute();
        Hour h1 = new Hour();
        Day d1 = new Day();

        System.out.printf(
                "Заданы объекты:\n\tm1 = Minute(%.1f),\n\th1 = Hour(%.1f),\n\td1 = Day(%.1f)\n",
                m1.getValue(), h1.getValue(), d1.getValue());
        System.out.println("--------------");
        System.out.println("m1.equals(h1) - " + (m1.equals(h1) ? "верно" : "неверно"));
        System.out.println("m1.equals(d1) - " + (m1.equals(d1) ? "верно" : "неверно"));
        System.out.println("h1.equals(m1) - " + (h1.equals(m1) ? "верно" : "неверно"));
        System.out.println("h1.equals(d1) - " + (h1.equals(d1) ? "верно" : "неверно"));
        System.out.println("d1.equals(m1) - " + (d1.equals(m1) ? "верно" : "неверно"));
        System.out.println("d1.equals(h1) - " + (d1.equals(h1) ? "верно" : "неверно"));
        System.out.println("--------------");
        System.out.println("m1.hashCode() == h1.hashCode() - " + (m1.hashCode() == h1.hashCode() ? "верно" : "неверно"));
        System.out.println("h1.hashCode() == d1.hashCode() - " + (h1.hashCode() == d1.hashCode() ? "верно" : "неверно"));
        System.out.println("d1.hashCode() == m1.hashCode() - " + (d1.hashCode() == m1.hashCode() ? "верно" : "неверно"));
        System.out.println("--------------");
        m1.CurrentTime();
        h1.CurrentTime();
        d1.CurrentTime();
        System.out.println("--------------");
        System.out.println(m1.toString());
        System.out.println(h1.toString());
        System.out.println(d1.toString());
    }
}

class Minute{
    private double Value = 0;
    public double getValue(){
        return Value;
    }
    Minute(double value){
        Value = value;
    }
    Minute(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество минут: ");
        Value = sc.nextDouble();
    }
    void CurrentTime(){
        int d = (int)(Value) / 1440;
        int h = (int)(Value - d * 1440) / 60;
        double m = Value - d * 1440 - h * 60;
        String dt = "";
        if (h < 6) dt = "Ночь";
        else if (h < 12) dt = "Утро";
        else if (h < 18) dt = "День";
        else if (h < 24) dt = "Вечер";
        System.out.printf("Текущее время: %d день %d часов %.2f минут - %s\n", d, h, m, dt);
    }
    @Override
    public boolean equals(Object o){
        if (o.getClass().getName() == "com.company.Hour" ){
            Hour h = (Hour) o;
            return Value / 60 == h.getValue();
        }
        if (o.getClass().getName() == "com.company.Day" ){
            Day d = (Day) o;
            return Value / 24 / 60 == d.getValue();
        }
        return false;
    }
    @Override
    public int hashCode(){
        return (int)(Value);
    }
    @Override
    public String toString(){
        return "Текущее количество минут: " + Value;
    }
}

class Hour{
    private double Value = 0;
    public double getValue(){
        return Value;
    }
    Hour(double value){
        Value = value;
    }
    Hour(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество часов: ");
        Value = sc.nextDouble();
    }
    void CurrentTime(){
        Minute m = new Minute(Value * 60);
        m.CurrentTime();
    }
    @Override
    public boolean equals(Object o){
        if (o.getClass().getName() == "com.company.Minute" ){
            Minute m = (Minute) o;
            return Value * 60 == m.getValue();
        }
        if (o.getClass().getName() == "com.company.Day" ){
            Day d = (Day) o;
            return Value / 24 == d.getValue();
        }
        return false;
    }
    @Override
    public int hashCode(){
        return (int)(Value * 60);
    }
    @Override
    public String toString(){
        return "Текущее количество часов: " + Value;
    }
}

class Day{
    private double Value = 0;
    public double getValue(){
        return Value;
    }
    Day(double value){
        Value = value;
    }
    Day(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество дней: ");
        Value = sc.nextDouble();
    }
    void CurrentTime(){
        Minute m = new Minute(Value * 24 * 60);
        m.CurrentTime();
    }
    @Override
    public boolean equals(Object o){
        if (o.getClass().getName() == "com.company.Minute" ){
            Minute m = (Minute) o;
            return Value * 24 * 60 == m.getValue();
        }
        if (o.getClass().getName() == "com.company.Hour" ){
            Hour h = (Hour) o;
            return Value * 24 == h.getValue();
        }
        return false;
    }
    @Override
    public int hashCode(){
        return (int)(Value * 60 * 24);
    }
    @Override
    public String toString(){
        return "Текущее количество суток: " + Value;
    }
}