package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        boolean key = true;
        BufferedReader newReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        System.out.println("Input string: ");
        char[] str = newReader.readLine().toCharArray();
        Stack sym1 = new Stack();
        Stack sym2 = new Stack();
        Stack sym3 = new Stack();
        for (char label: str) {
            if (label == '('){
                sym1.push(label);
            } else if (label == ')'){
                if (!sym1.empty()){
                    sym1.pop();
                } else{
                    System.out.println("Invalid exeption!");
                    key = false;
                    break;
                }
            } else if (label == '['){
                sym2.push(label);
            } else if (label == ']'){
                if (!sym1.empty()){
                    sym1.pop();
                } else{
                    System.out.println("Invalid exeption!");
                    key = false;
                    break;
                }
            } else if (label == '}'){
                sym3.push(label);
            } else if (label == '{'){
                if (!sym1.empty()){
                    sym1.pop();
                } else{
                    System.out.println("Invalid exeption!");
                    key = false;
                    break;
                }
            }
        }
        if (key){
            if (sym1.empty()){
                System.out.println("')' - correct");
            }
            if (sym2.empty()){
                System.out.println("']' - correct");
            }
            if (sym3.empty()){
                System.out.println("'}' - correct");
            }
        }
    }
}
