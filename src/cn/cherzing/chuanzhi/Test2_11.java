package cn.cherzing.chuanzhi;

/**
 * @author Cherzing
 * @date 2024/12/29 0029 16:54
 * @description Test2_11
 */
import java.util.*;

public class Test2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] prefixSum = new int[1001];
            for (int i = 0; i < n; i++) {
                prefixSum[a[i]]++;
            }
            for (int i = 1; i < 1001; i++) {
                prefixSum[i] += prefixSum[i - 1];
            }
            int q = scanner.nextInt();
            for (int j = 0; j < q; j++) {
                int d = scanner.nextInt();
                int sum = prefixSum[Math.min(d, 1000)];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
