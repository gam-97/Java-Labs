package com.company;

import java.io.*;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        File b = new File(dir + "\\Base.txt");
        File r = new File(dir + "\\Result.txt");

        List<String> bl = new ArrayList<String>();

        try(FileReader reader = new FileReader(b)){
            BufferedReader br = new BufferedReader(reader);
            String line;
            while((line = br.readLine()) != null){
                bl.add(line);
                System.out.println(line);
            }
            System.out.println("Чтение файла завершено");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        try(FileWriter writer = new FileWriter(r, false)){
            for (String s : bl){
                    String[] words = s.split("\\s");
                    if (words.length > 1){
                        String line = words[words.length - 1] + " ";
                        for (int i = 1; i < words.length - 1; i++)
                            line += words[i] + " ";
                        line += words[0];
                        writer.write(line + "\n");
                    }
                    else
                        writer.write(s + "\n");
            }
            System.out.println("Запись файла завершена");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

