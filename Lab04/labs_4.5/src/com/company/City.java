package com.company;
import java.util.Date;

public class City {
    public enum Avenue{
        Balaclava,
        Budyonny,
        Vernadsky
    }
    public enum Street{
        Tverskaya,
        Taganskaya,
        Kantemirovskaya
    }

    public class CityAvenue{
        public Avenue name;
        public String adress;

        public CityAvenue(){}
        public CityAvenue(Avenue city, String adress){
            this.name = city;
            this.adress = adress;
        }
    }
    public class Square{
        public Street name;
        public String monument;

        public Square(){}
        public Square(Street name, String monument){
            this.name = name;
            this.monument = monument;
        }
    }

    public City(){}
}