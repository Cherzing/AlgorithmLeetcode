package cn.cherzing.AlgorithmDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cherzing
 * @date 2024/12/04 0004 17:29
 * @description IntegerDecomposition
 */
public class IntegerDecomposition {
    public static List<Integer> decomposeInteger(int n) {
        List<Integer> result = new ArrayList<>();

        // 最小的数至少为1，因此从1开始尝试
        for (int i = 1; i <= n / 3; i++) {
            // 第二个数至少和第一个数相等
            for (int j = i; j <= (n - i) / 2; j++) {
                // 第三个数是剩余的部分
                int k = n - i - j;
                // 确保第三个数不小于第二个数
                if (k >= j) {
                    result.add(i);
                    result.add(j);
                    result.add(k);
                    return result;
                }
            }
        }

        // 如果没有找到合适的分解，返回空列表
        return result;
    }
    public static void main(String[] args) {
        int n = 5;
        List<Integer> decomposition = decomposeInteger(n);
        if (!decomposition.isEmpty()) {
            System.out.println(n + " = " + decomposition.get(0) + " + " + decomposition.get(1) + " + " + decomposition.get(2));
        } else {
            System.out.println("无法将 " + n + " 分解为三个非递减整数之和。");
        }
    }
}
