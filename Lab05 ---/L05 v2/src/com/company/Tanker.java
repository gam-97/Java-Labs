package com.company;

public class Tanker extends CargoShip {
    public String name;

    public Tanker(String name, String cargo, int width, int heidth, String Raid){
        super(width, heidth, cargo);
        this.name = name;
    }

    @Override
    public void allowed(){
        System.out.println(this.name  + " started!");
    }

    public void change_allowed(String departure){
        cargo = departure;
    }
}