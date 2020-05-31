package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество квадратных уравнений для анализа:");
        int count = sc.nextInt();
        Quadratic[] Q = new Quadratic[count];
        double[] M = new double[count*2];
        for (int i = 0; i < Q.length; i++ ) {
            Q[i] = new Quadratic();
            Q[i].solution();
            M[2*i] = Q[i].x1;
            M[2*i+1] = Q[i].x2;
        }
        double min = M[0], max = M[0];
        for(double j : M){
            min = j < min ? j : min;
            max = j > max ? j : max;
        }
        System.out.printf(
                "В сформированном множестве уравнений:\n" +
                "Наименьший корень = %.3f\n" +
                "Наибольший корень = %.3f\n\n", min, max);
        Quadratic Q1 = new Quadratic();
        Q1.solution();
        Quadratic Q2 = new Quadratic();
        Q2.extremum();
        Quadratic Q3 = new Quadratic();
        Q3.intervals();
    }
}

class Quadratic {

    private double a, b, c, ex, ey;
    public double x1, x2;
    private String s = "";

    Quadratic(){
        Random r = new Random();
        while (a == 0) {
            a = r.nextInt(20) - 10;
        }
        while (b == 0) {
            b = r.nextInt(20) - 10;
        }
        while (c == 0) {
            c = r.nextInt(20) - 10;
        }
        Builder(true);
    }
    Quadratic(double qa){
        a = qa;
        Builder(false);
    }
    Quadratic(double qa, double qb){
        a = qa;
        b = qb;
        Builder(false);
    }
    Quadratic(double qa, double qb, double qc){
        a = qa;
        b = qb;
        c = qc;
        Builder(false);
    }

    private void Builder(Boolean R){
        if (a == 0)
            System.out.println("Коэффициент \"а\" не может быть равен 0");
        else{
            String x2 = a > 0 ? (a + " * X^2 ") : (a + " * X^2 ");
            String x1 = b == 0 ? "" : b > 0 ? ("+" + b + " * X ") : (b + " * X ");
            String x0 = c == 0 ? "" : c > 0 ? ("+" + c) : ("" + c);
            String t = R ? "случайное " : "";
            s = x2 + x1 + x0;
            System.out.printf("Сформировано %sквадратное уравнение: %s = 0\n", t, s);
        }
    }

    void solution(){
        double D;
        D = b * b - 4 * a * c;
        if (D >= 0){
            x1 = ( (-1) * b + Math.sqrt(D) ) / (2 * a);
            x2 = ( (-1) * b - Math.sqrt(D) ) / (2 * a);
            System.out.printf(">>> Квадратное уравнение: %s = 0\nИмеет корни: x1 = %.3f, x2 = %.3f\n", s, x1, x2);
        }
        else{
            System.out.printf(">>> Квадратное уравнение: %s = 0\nНе имеет корней\n", s);
        }
    }

    void extremum() {
        ex = (-1) * b / (2 * a);
        ey = a * ex * ex + b * ex + c;
        System.out.printf(">>> Квадратное уравнение: %s = 0\nИмеет экстремум в точке: x = %.3f, y = %.3f\n", s, ex, ey);
    }

    void intervals(){
        ex = (-1) * b / (2 * a);
        ey = a * ex * ex + b * ex + c;
        double ex1 = ex - 10, ey1 =  a * ex1 * ex1 + b * ex1 + c;
        System.out.printf(">>> Квадратное уравнение: %s = 0\n", s);
        if (ey1 > ey){
            System.out.printf("Убывает на промежутке: от -\u221E до %.3f\n", ex);
            System.out.printf("Возрастает на промежутке: от %.3f до \u221E \n", ex);
        }
        else{
            System.out.printf("Возрастает на промежутке: от -\u221E до %.3f\n", ex);
            System.out.printf("Убывает на промежутке: от %.3f до \u221E \n", ex);
        }
    }

}