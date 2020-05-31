package com.company;

public class Order {
    private static int Counter = 0;
    private int Id;
    private Buyer Man;
    private Product Name;
    private int Count;
    private double Total;
    private boolean Purchase = false;

    public int getId() {
        return Id;
    }

    Order(Buyer man, Product name, int count) {
        Man = man;
        Name = name;
        Count = count;
        Total = count * name.getPrice();
        Id = ++Counter;
        System.out.printf(
                "Добавлен заказ >>> №: %d\t Покупатель: %s\t Товар: %s\t Количество: %d\t Сумма: %.2f\t Оплачено: %s\n",
                Id, Man.FIO, Name.getName(), Count, Total, Purchase ? "да" : "нет");
    }

    void info(){
        System.out.printf(
                "Заказ №: %d\t Покупатель: %s\t Товар: %s\t Количество: %d\t Сумма: %.2f\t Оплачено: %s\n",
                Id, Man.FIO, Name.getName(), Count, Total, Purchase ? "да" : "нет");
    }

    boolean last(){
        return Id == Counter ? true : false;
    }

    void purchase(){
        Purchase = true;
    }
}
