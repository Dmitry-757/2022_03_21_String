package org.dng;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 3
 * Подсчитать среднюю длину слова, во введенном с
 * клавиатуры предложении.
 */
public class dz51_3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter sentence");
            if (sc.hasNextLine()) {
                String str = sc.nextLine();

                Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
                Matcher matcher = pattern.matcher(str);
                int counterWords = 0, counterLetters = 0;
                String word;
                while (matcher.find()) {
                    word = matcher.group();
                    System.out.println(word);
                    counterWords++;
                    counterLetters += word.length();
                }
                double averageNum = counterLetters / counterWords;

                System.out.println("Average number letters in original sentence is " + averageNum);
            }
        }

    }
}
