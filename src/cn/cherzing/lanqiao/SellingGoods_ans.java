package cn.cherzing.lanqiao;

import java.util.*;

/**
 * @author Cherzing
 * @date 2024/12/15 0015 17:27
 * @description SellingGoods_ans
 */
public class SellingGoods_ans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // dp[i]:以i结尾的合法子序列数量
        // stack:存储所有未进行匹配的1的位置
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        Stack<Integer> stack = new Stack<>();
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();

            if (a == 1) {//1不可能是合法子序列的结尾
                stack.push(i);
            } else if (!stack.isEmpty()) {
                //stack.pop()-1最近未匹配的1的前一位,dp[..]为前面有多少个能拼接的序列
                //System.out.println("stack.pop():"+stack.pop()+"----------");
                dp[i] = dp[stack.pop() - 1] + 1;
            }

            ans += dp[i];
        }

        System.out.println(ans);
    }
}
