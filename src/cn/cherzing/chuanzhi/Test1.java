package cn.cherzing.chuanzhi;

import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/29 0029 15:37
 * @description Test1
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int div = a/b;
            int mo = a%b;
            System.out.println(a + "=" + div + "*" + b + "+" + mo);
        }
    }
}
