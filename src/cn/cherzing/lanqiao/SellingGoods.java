package cn.cherzing.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/12 0012 20:24
 * @description SellingGoods
 */
public class SellingGoods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] records = new int[num];
        for (int i = 0; i < num; i++) {
            records[i] = scanner.nextInt();
        }
//        System.out.println(new SellingGoods().isComputer(records));
        List<int[]> subArrays = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            for (int j = i; j < records.length; j++) {
                // 创建子数组
                int[] subArray = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    subArray[k - i] = records[k];
                }
                // 将子数组添加到列表中
                subArrays.add(subArray);
            }
        }
        int count = 0;
        for (int[] values : subArrays) {
            if (new SellingGoods().isComputer(values)) {
                count++;
            }
        }
        System.out.println(count);

    }

    /**
     * 电脑中记录的要求：<p>
     * 1. 在一天结束后，要求商品数恰好为<b>0</b><p>
     * 2. 当卖出商品时，商店里必须有商品<p>
     *
     * @param records
     * @return
     */
    private boolean isComputer(int[] records) {
        int count = 0;
        for (int i = 0; i < records.length; i++) {
            if (records[i] == -1 && count < 1) {
                return false;
            }
            count += records[i];
        }
        //循环结束之后，count==0
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
