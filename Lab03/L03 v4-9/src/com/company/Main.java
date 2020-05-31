package com.company;

import java.util.Scanner;

public class Main {

    static Product[] products = new Product[100];
    static Order[] orders = new Order[100];
    static Buyer[] buyers = new Buyer[100];

    static void all(Product[] o){
        for (int i = 0; i < o.length; i++) {
            o[i].info();
            if (o[i].last()) break;
        }
    }
    static void all(Order[] o){
        for (int i = 0; i < o.length; i++) {
            o[i].info();
            if (o[i].last()) break;
        }
    }
    static void all(Buyer[] o){
        for (int i = 0; i < o.length; i++) {
            o[i].info();
            if (o[i].last()) break;
        }
    }

    public static void main(String[] args) {
        Scanner cmd = new Scanner(System.in);
        boolean done = false;
        String temp;
        int itemp;

        products[0] = new Product("Альфа", 420.75, 15);
        buyers[0] = new Buyer("Администратор", 50);
        orders[0] = new Order(buyers[0], products[0], 1);

        //all(products); all(buyers); all(orders);

        System.out.println("--------------");

        while (true) {
            System.out.print("Введите команду (для подсказки \"?\"): ");
            String com = cmd.nextLine();
            switch (com) {
                case "?":
                    System.out.println("Доступны следующие команды: ");
                    System.out.println("\"поступление\" - изменение кол-ва товара");
                    System.out.println("\"заказ\" - сформировать заказ");
                    System.out.println("\"оплата\" - фиксация оплаты пользователя");
                    System.out.println("\"чёрный\" - добавление пользователя в чёрный список");
                    System.out.println("\"белый\" - удаление пользователя из чёрный список");
                    System.out.println("\"заказы\" - все заказы");
                    System.out.println("\"товары\" - все товары");
                    System.out.println("\"покупатели\" - все покупатели");
                    cmd.nextLine();
                    break;

                case "поступление":
                    done = false;
                    all(products);
                    System.out.print("Введите наименование продукта: ");
                    temp = cmd.nextLine();
                    for (int p = 1; !products[p-1].last(); p++) {
                        if (products[p-1].getName().equals(temp)) {
                            System.out.print("Введите изменение количества: ");
                            products[p].changeCount(cmd.nextInt());
                            products[p].info();
                            done = true;
                            break;
                        }
                    }
                    System.out.println(done ? "Выполнено" : "Не найден указанный товар: " + temp);
                    for (int p = 0; p < products.length; p++) {
                        if (products[p].last())
                            products[p + 1] = new Product();
                        break;
                    }
                    break;

                case "заказ":
                    done = false;
                    all(products);
                    System.out.print("Введите Id товара: ");
                    int oP = cmd.nextInt();

                    for (int p = 0; p < products.length; p++) {
                        if (products[p].getId() == oP) {
                            done = true;
                            System.out.print("Введите запрашиваемое количество: ");
                            int oCount = cmd.nextInt();
                            if (products[p].getCount() >= oCount) {
                                System.out.print("Введите фамилию и имя покупателя: ");
                                cmd.nextLine();
                                String oBuyer = cmd.nextLine();
                                boolean f = false;
                                for (int b = 0; b < buyers.length; b++) {
                                    if (oBuyer.equals(buyers[b].FIO)) {
                                        f = true;
                                        if (buyers[b].getBlackList() == true) {
                                            System.out.println("Покупатель находится в чёрном списке");
                                            break;
                                        }
                                        else{
                                            for (int o = 0; o < orders.length; o++) {
                                                if (orders[o].last())
                                                    orders[o + 1] = new Order(buyers[b], products[p], oCount);
                                                break;
                                            }
                                            products[p].changeCount((-1)*oCount);
                                        }
                                    }
                                    if (buyers[b].last()) break;
                                }
                                if (!f) {
                                    for (int b = 0; b < buyers.length; b++) {
                                        if (buyers[b].last())
                                            buyers[b + 1] = new Buyer(oBuyer);
                                        for (int o = 0; o < orders.length; o++) {
                                            if (orders[o].last())
                                                orders[o + 1] = new Order(buyers[b + 1], products[p], oCount);
                                            break;
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            else {
                                System.out.printf("Указанного количества %d нет в наличии\n", oCount);
                                break;
                            }
                        }
                        if (products[p].last()) break;
                    }
                    System.out.println(done ? "" : "Не найден запрашиваемый товар: Id = " + oP);
                    break;

                case "оплата":
                    done = false;
                    all(orders);
                    System.out.println("Введите № заказа: ");
                    itemp = cmd.nextInt();
                    for (int i = 0; i < orders.length; i++) {
                        if (orders[i].getId() == itemp) {
                            orders[i].purchase();
                            orders[i].info();
                            done = true;
                            break;
                        }
                        if (orders[i].last()) break;
                    }
                    System.out.println(done ? "Выполнено" : "Не найден указанный заказ: " + itemp);
                    break;

                case "чёрный":
                    done = false;
                    all(buyers);
                    System.out.println("Введите Id покупателя: ");
                    itemp = cmd.nextInt();
                    for (int i = 0; i < buyers.length; i++) {
                        if (buyers[i].getId() == itemp) {
                            buyers[i].inBlackList();
                            done = true;
                            break;
                        }
                        if (buyers[i].last()) break;
                    }
                    System.out.println(done ? "Выполнено" : "Не найден указанный покупатель: " + itemp);
                    cmd.nextLine();
                    break;

                case "белый":
                    done = false;
                    all(buyers);
                    System.out.println("Введите Id покупателя: ");
                    itemp = cmd.nextInt();
                    for (int i = 0; i < buyers.length; i++) {
                        if (buyers[i].getId() == itemp) {
                            buyers[i].outBlackList();
                            done = true;
                            break;
                        }
                        if (buyers[i].last()) break;
                    }
                    System.out.println(done ? "Выполнено" : "Не найден указанный покупатель: " + itemp);
                    cmd.nextLine();
                    break;

                case "заказы":
                    all(orders);
                    cmd.nextLine();
                    break;

                case "товары":
                    all(products);
                    cmd.nextLine();
                    break;

                case "покупатели":
                    all(buyers);
                    cmd.nextLine();
                    break;

                default:
                    System.out.println("Неизвестная команда");
            }

        }
    }
}
