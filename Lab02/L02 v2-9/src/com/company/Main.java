package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите размерность квадратной матрицы:");
        int n = in.nextInt();
        double[][] m = new double[n][n];
        double[] sum = new double[n];

        System.out.println("Первоначальная матрица:");
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = r.nextInt(n*2) - n;
                sum[i] += m[i][j];
                System.out.print(m[i][j] + " \t");
            }
            System.out.print("\t -- среднее арифметическое: " + (sum[i]/n) + "\n");
        }

        System.out.println("Измененная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] -= sum[i] / n;
                System.out.print(m[i][j] + " \t");
            }
            System.out.print("\n");
        }
    }
}

