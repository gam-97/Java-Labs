package com.company;

public class Main {

    public static void main(String[] args) { //Variant 1
        try {
            City city = new City();
            City.CityAvenue avenue = city.new CityAvenue(City.Avenue.Balaclava, "Moscow,  Butovo");
            City.Square square = city.new Square(City.Street.Tverskaya, "Plane");
        }
        catch (OutOfMemoryError ex){
            System.out.println("Ошибка работы динамической памяти");
            ex.printStackTrace();
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Недопустимый аргумент, используемый для вызова метода");
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}