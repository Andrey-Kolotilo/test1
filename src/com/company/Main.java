package com.company;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in_str = new Scanner(System.in);
        System.out.print("Input a path: ");
        String in_str_val = in_str.nextLine();

        try(FileReader reader = new FileReader(in_str_val))
         //try(FileReader reader = new FileReader("d:/test/test.txt"))
        {
                 // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char) c);
            }
            System.out.println(System.getProperty("line.separator") + "чтение по символам завершено" + System.getProperty("line.separator"));
        }
        catch(IOException ex){
            System.out.println("неправильное имя файла: " + ex.getMessage());
            }
// по строкам
        try(
             FileReader reader2 = new FileReader(in_str_val);
               BufferedReader varRead = new BufferedReader(reader2);
              )
        {
            String t1=varRead.readLine();
            while( t1 !=null){
                System.out.println(t1);
                t1=varRead.readLine();
            }
            System.out.println(System.getProperty("line.separator") + "чтение по строкам завершено");
        }
        catch(IOException ex){
            System.out.println("неправильное имя файла: " + ex.getMessage());
        }
        try(FileWriter writer = new FileWriter("d:/test/test_write.txt", false);
            FileReader reader2 = new FileReader("d:/test/test.txt");
            BufferedReader varRead = new BufferedReader(reader2);
        )
        {
            String t1=varRead.readLine();
            while( t1 !=null) {
                writer.write(t1);
                writer.write(System.getProperty("line.separator"));
                t1 = varRead.readLine();
            }


        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
     /*
        System.out.println(in_str_val);
        System.out.printf("%s", in_str_val); */
    }
}
