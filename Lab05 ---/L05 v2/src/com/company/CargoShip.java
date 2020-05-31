package com.company;

public abstract class CargoShip implements Ship {
    private int width;
    private int heidth;
    protected String cargo;

    public CargoShip(int width, int heidth, String cargo){
        this.width = width;
        this.heidth = heidth;
        this.cargo = cargo;
    }

    public void Raid(){
        try {
            if (this.cargo == "danger")
                throw new Exception("Cargo is DANGER!");
            allowed();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            prohibited();
        }
    }
    @Override
    public void allowed(){
        System.out.println("Sea access allowed!");
    }
    @Override
    public void prohibited(){
        System.out.println("Sea access prohibited!");
    }

    }
