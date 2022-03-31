package org.dng;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Пользователь вводит с клавиатуры любую строку.
 * Поменять в исходной строке все большие буквы на
 * маленькие, а маленькие – на большие. Если в строке присутствуют цифры, заменить на символ подчеркивания и
 * вывести результат на консоль.
 */


public class dz51_7 {
    public static String Revers(String letter) {
        //if letter converted to lower register is equal to itself - it means that the letter originally is in lower register
        if (letter.toLowerCase().equals(letter))
            return letter.toUpperCase();
        else
            return letter.toLowerCase();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter sentence");
            if (sc.hasNextLine()) {
                String str = sc.nextLine();

                Pattern pattern = Pattern.compile("[A-ZА-Яa-zа-я]");
                Matcher matcher = pattern.matcher(str);
                str = matcher.replaceAll((match) -> Revers(match.group()));
                System.out.println("The reversed sentence is : " + str);
            }
        }

    }
}
