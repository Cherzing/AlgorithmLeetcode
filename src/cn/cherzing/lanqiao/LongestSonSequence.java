package cn.cherzing.lanqiao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Cherzing
 * @date 2024/11/26 0026 21:23
 * @description LongestSonSequence
 */
public class LongestSonSequence {
    /**
     * 垃圾暴力算法
     */
    public void findLongestSubsequence() {
        Scanner scan = new Scanner(System.in);

        String S = scan.next();
        int lengthS = S.length();

        String T = scan.next();
        int lengthT = T.length();

        int k = 0;
        for (int i = 0; i < lengthS; i++) {
            for (int j = 0; j < lengthT; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    k++;
                }
            }
        }
        scan.close();
        System.out.println(k / 2);
    }

    /**
     * 首先对T、S字符串进行清洗，然后再计数
     *
     * @return
     */
    public int findLongestSubsequence2() {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        String T = scan.next();

        HashMap<Character, Integer> hmS = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            hmS.put(S.charAt(i), i);
        }

        int k = 0;

        for (int i = 0; i < T.length(); i++) {
            if (hmS.containsKey(T.charAt(i))) {
                k++;
            }
        }

        System.out.print(k);

        return 0;
    }

    /**
     * 动态规划
     */
    public void findLongestSubsequence3() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int index = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == t.charAt(index))
                index++;
        System.out.print(index);
    }

    public void resolution() {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int i = 0, j = 0, len = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                len++;
            }
            i++;
        }

        System.out.println(len);
    }

    public void testDynamic1() {
        Scanner scanner = new Scanner(System.in);
        String strS = scanner.next();
        String strT = scanner.next();

        int index = 0;
        for (int i = 0; i < strS.length(); i++) {
            if (strS.charAt(i) == strT.charAt(index)) {
                index++;
            }
        }
        System.out.println(index);
    }

    public void testDynamic2() {
        Scanner scanner = new Scanner(System.in);
        String strS = scanner.next();
        String strT = scanner.next();

        int i = 0, j = 0, len = 0;
        while (i < strS.length() && j < strT.length()) {
            if (strS.charAt(i) == strT.charAt(j)){
                j++;
                len++;
            }
            i++;
        }
    }

    /**
     * 双指针
     *
     * @param args
     */
    public static void main(String[] args) {
        new LongestSonSequence().findLongestSubsequence3();
    }
}
