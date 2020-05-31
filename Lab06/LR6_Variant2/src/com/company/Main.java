package com.company;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] start_position = {1, 2, 3, 4, 5};
        int[] speed = {7, 6, 5, 4, 3};
        int buffer = 0;
        int num = 0;
        int result = 0;
        for (int k = 0; k < 10; k++){
            num = 0;
            for (int position: start_position) {
                start_position[num] = position + speed[num];
                num++;
            }
            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    if (start_position[i] > start_position[j]) {
                        result++;
                        buffer = start_position[i];
                        start_position[i] = start_position[j];
                        start_position[j] = buffer;
                        buffer = speed[i];
                        speed[i] = speed[j];
                        speed[j] = buffer;
                    }
                }
            }
            System.out.println("Current position:" + Arrays.toString(start_position));
        }
        System.out.println("Number of overtakings: " + result);
    }
}
