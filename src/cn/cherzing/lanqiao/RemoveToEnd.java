package cn.cherzing.lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/08 0008 17:17
 * @description RemoveToEnd
 */
public class RemoveToEnd {
    public void test1() {
        /**
         * 我的想法：
         * 使用类似于C++中的erase函数方法，但是，没找到相类似的函数；
         * 如果要使用相类似的函数，把int[]转为List，使用remove()
         * */
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        //数组赋值
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0; // 记录非零数的个数
        for (int i = 0; i < length; i++) {
            if (0 != arr[i]){
                arr[count] = arr[i];
                count++;
            }
        }
        // System.out.println(count);
        while (count < length){
            arr[count] = 0;
            count++;
        }
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        new RemoveToEnd().test1();
    }
}
