package com.company;

public class Main {

    public static void main(String[] args) { //variant 8
        Tanker bigTheater = new Tanker("Black Pearl", "Rum", 400,
                100, "Moscow");
        bigTheater.Raid();
        bigTheater.change_allowed("coast of Malta");
        bigTheater.Raid();
        bigTheater.Raid();
    }
}