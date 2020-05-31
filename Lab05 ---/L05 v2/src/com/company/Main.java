package com.company;

public class Main {

    public static void main(String[] args) { //variant 8
        try {
            Tanker bigTheater = new Tanker("Black Pearl", "Rum", 400,
                    100, "Moscow");
            bigTheater.Raid();
            bigTheater.change_allowed("danger");
            bigTheater.Raid();
            bigTheater.Raid();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}