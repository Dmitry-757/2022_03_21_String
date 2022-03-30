package org.dng;

import java.util.Scanner;


/**
 Задание 1
 Ввести с клавиатуры строку текста, а затем один символ.
 Показать на консоль индексы и количество совпадений (ищем
 вхождения символа в строку). В случае если совпадений не
 найдено, вывести соответствующий текст.
 */


public class dz51_1 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String str1;
            char ch=(char)0;
            System.out.println("Input string");
            if (sc.hasNextLine()){
                str1 = sc.nextLine();
            }
            else{
                throw new Exception("Wrong input! try again...");
            }
            System.out.println("Input one char");
            if (sc.hasNextLine()){
                String str2 = sc.nextLine();
                if(str2.length()>1){
                    throw new Exception("Wrong input! Enter One char! try again...");
                }
                else{
                    ch = str2.charAt(0);
                }
            }
            System.out.println("str = "+str1);
            System.out.println("ch = "+ch);

            int start = 0;
            int idx = str1.substring(start).indexOf(ch);
            while (idx!=-1 ){
                start = start + idx + 1;
                System.out.println("match found at "+(start)+" symbol");
                idx = str1.substring(start).indexOf(ch);
            }
            if (idx == -1){
                System.out.println("matches was not found!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
