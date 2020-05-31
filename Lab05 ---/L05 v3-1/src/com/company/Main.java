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

        Scanner cmd = new Scanner(System.in);
        System.out.print("Введите подстроку для удаления: ");
        String sub = cmd.nextLine();

        try(FileWriter writer = new FileWriter(r, false)){
            //BufferedWriter w = new BufferedWriter(writer);
            for (String s : bl)
                writer.write(s.replaceAll(sub, "") + "\n");
            System.out.println("Запись файла завершена");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

