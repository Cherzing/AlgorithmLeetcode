package cn.cherzing;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Cherzing
 * @date 2024/11/05 0005 20:12
 * @description Merge
 */
public class Merge {
    @Test
    public void testMerge() {
        int[] nums = {1, 2, 3};
        int[] nums2 = {2, 5, 6};
        int m = nums.length;
        int n = nums2.length;

        int[] nums1 = new int[m + n];


        SolutionMerge solutionMerge = new SolutionMerge();
        solutionMerge.merge(nums1, m, nums2, n);
        solutionMerge.dualPointerTest(nums1, m, nums2, n);
    }

}

class SolutionMerge {
    /*
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     */

    /**
     * 首先将nums1数组和nums2数组合并,我的想法是使用fill，
     * 在使用sort方法将数组排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 先将num1数组放入num中，剩余的使用0填充
        int[] nums = Arrays.copyOf(nums1, m + n);  // Arrays.copyOf(array, newLength); 复制数组，并返回新数组

        //将数组nums和数组nums2合并
        for (int i = 0; i < n; i++) {
            nums[i + m] = nums2[i];
        }

        for (int i = 0; i < m + n; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("------------------------");

        Arrays.sort(nums);

        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums[i];
        }
    }

    public void dualPoints(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;

        while (p1 < m || p2 < n) {

            if (p1 == m) {  // nums1 中的元素已经全部处理完毕，此时将 nums2[p2] 的值赋给 cur，并将 p2 向后移动一位
                cur = nums2[p2++];
            } else if (p2 == n) {  // nums2 中的元素已经全部处理完毕，此时将 nums1[p1] 的值赋给 cur，并将 p1 向后移动一位。
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) { // nums1[p1] 应该是下一个最小的元素，将 nums1[p1] 的值赋给 cur，并将 p1 向后移动一位
                cur = nums1[p1++];
            } else {  // nums2[p2] 应该是下一个最小的元素，将 nums2[p2] 的值赋给 cur，并将 p2 向后移动一位
                cur = nums2[p2++];
            }

            sorted[p1 + p2 - 1] = cur;

        }

        for (int i = 0; i != m + n; ++i) {
            System.out.println(sorted[i]);
        }

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    public void dualPointerTest(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] full = new int[m + n];
        int cur;

        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {  //
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }

            full[p1 + p2 - 1] = cur;

        }

        for (int i = 0; i != m + n; i++) {
            System.out.println(full[i]);
        }

    }
}
