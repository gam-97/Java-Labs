package com.company;

public class Main {

    public static void main(String[] args) { //Variant 1
        City city = new City();
        City.CityAvenue avenue = city.new CityAvenue(City.Avenue.Balaclava, "Moscow,  Butovo");
        City.Square square = city.new Square(City.Street.Tverskaya, "Plane");
    }
}