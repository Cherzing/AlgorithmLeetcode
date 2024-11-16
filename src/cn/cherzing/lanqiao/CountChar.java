package cn.cherzing.lanqiao;

import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/11/26 0026 21:16
 * @description CountChar
 */
public class CountChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        int length = string.length();
        int k = 0;
        for (int i = 0;i<length;i++){
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e'
                    || string.charAt(i) == 'i' || string.charAt(i) == 'o' ||string.charAt(i) == 'u'){
                k++;
            }
        }
        System.out.println(k);
        System.out.println(length - k);
        scan.close();
    }
}
