package org.dng;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Написать программу, проверяющую является ли одна
 * строка анаграммой для другой строки (строка может состоять
 * из нескольких слов и символов пунктуации). Пробелы и
 * пунктуация должны игнорироваться при анализе. Разница
 * в больших и маленьких буквах должна игнорироваться. Обе
 * строки должны вводиться с клавиатуры. Программа должна
 * выводить Yes, если строки являются анаграммой, и No –
 * иначе.
 * Пример анаграммы в стихах:
 * Строка 1 «Аз есмь строка, живу я, мерой остр».
 * Строка 2 «За семь морей ростка я вижу рост!»
 */

public class dz51_9 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first sentence:");
            String str1 = "", str2 = "";
            if (sc.hasNextLine()) {
                str1 = sc.nextLine();
            }

            System.out.println("Enter second sentence:");
            if (sc.hasNextLine()) {
                str2 = sc.nextLine();
            }


            Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
            Matcher matcher = pattern.matcher(str1);
            Matcher matcher2 = pattern.matcher(str2);

            int counterWords = 0, counterWords2 = 0;

            while (matcher.find()) {
                counterWords++;
            }
            while (matcher2.find()) {
                counterWords2++;
            }
            if (counterWords != counterWords2)
                throw new Exception("number of words in 1-th sentence is not equal number of words in second sentence!");

            matcher = pattern.matcher(str1);
            matcher2 = pattern.matcher(str2);

            String word1[] = new String[counterWords];
            counterWords = 0;
            String word;
            while (matcher.find()) {
                word = matcher.group();
//                System.out.println(word);
                word1[counterWords] = word.toLowerCase();
                counterWords++;
            }


            String word2[] = new String[counterWords];
            counterWords = 0;
            while (matcher2.find()) {
                word = matcher2.group();
//                System.out.println(word);
                word2[counterWords] = word.toLowerCase();
                counterWords++;
            }
//            System.out.println(Arrays.stream(word1).collect(Collectors.toList()));
//            System.out.println(Arrays.stream(word2).collect(Collectors.toList()));

            boolean findSuitWord = true;
            for (String w : word1) { //take word from first sentence and compare it with all words from second sentence
                for (String w2 : word2) { //take word from second sentence for comparison
                    findSuitWord = true; //let`s hope that w2 is suitable for w
                    if (w.length() == w2.length()) {
                        for (int i = 0; i < w.length(); i++) {
                            if (!w2.contains(String.valueOf(w.charAt(i)))) { //if letter of word1 does not occur in word2
                                findSuitWord = false;//Ooops, such letter doesn`t occur in word2 - word2 isn`t pair for w!
                                break;
                            }
                        }
                    } else { //number of letters in word w is not equal number of letter in word w2. Need to skip this word
                        findSuitWord = false;
                    }

                    if (findSuitWord) {
                        System.out.println("word = " + w + "  it`s pair = " + w2);
                        break; //find suitable word2 for word
                    }
                }
                if (!findSuitWord) {
                    System.out.println("for word \"" + w + "\" absent suitable pare! The sentences can`t be anagrams!");
                    break;
                }
            }
            System.out.println("If i am not mistaken, this sentaces are anagram");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
