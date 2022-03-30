package org.dng;

import java.util.Scanner;

/**
 * Задание 2
 * Написать программу, которая создаст строку, в которой
 * находятся все целые числа, начиная с 1, выписаны в одну
 * строку «123456789101112131415...». Строка должна быть
 * длиной не более 1 000 символов.
 * По числу n (введенного с клавиатуры), выведите цифру на
 * n-й позиции (используется нумерация с 1).
 */

public class dz51_2 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int maxCount = 20;
        int counter = 1;
        while (sb.length() < maxCount) {
            sb.append(counter);
            counter++;
        }
        sb.delete(maxCount, sb.length());
        System.out.println(" original string is: " + sb.toString());

        try (Scanner sc = new Scanner(System.in)) {
            int pos = 0;
            System.out.println("Enter position of char");
            if (sc.hasNextInt()) {
                pos = sc.nextInt();
                if ((pos < 0) || (pos > maxCount)) {
                    throw new Exception("position must be between 0 and " + maxCount);
                }
                System.out.println("The char on " + pos + "-th position is " + sb.charAt(pos - 1));
            } else {
                throw new Exception("Wrong input!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
