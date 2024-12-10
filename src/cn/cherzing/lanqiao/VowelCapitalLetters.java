package cn.cherzing.lanqiao;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/11 0011 19:19
 * @description VowelCapitalLetters
 */
public class VowelCapitalLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String upperString = string.toUpperCase();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' ||
                    string.charAt(i) == 'o' || string.charAt(i) == 'u') {
                System.out.print(upperString.charAt(i));
            } else {
                System.out.print(string.charAt(i));
            }
        }
    }
}
