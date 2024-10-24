package cn.cherzing;

import java.math.BigInteger;

/**
 * @author Cherzing
 * @date 2024/10/22 0022 20:21
 * @description AddBinary
 */
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String string = solution.addBinaryBit("10111","1010");
        String a = "0111";
        System.out.println(string);
        // System.out.println(s);
        int aaa = a.charAt(0);
        System.out.println(aaa);

    }
}
class Solution {
    /**
     * 从字符串ab开始从后往前遍历，
     * 如果字符串相同位置之和=1，保持不变；
     * 如果字符串相同位置之和!=2，往前进一
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int max = Math.max(len1, len2);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < max; i++){

            int aI = a.charAt(max - i) - '0';
            int bI = b.charAt(max - i) - '0';

        }
        String string = result.reverse().toString();
        return string;
    }
    public String addBinaryBit(String a, String b) {
        int n = a.length(), m = b.length();
        int max = Math.max(n, m);
        int carry = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < max; i++) {

            int bitA = ( i < n ) ? a.charAt(n - 1 - i) - '0' : 0; //要么是1，要么是0
            int bitB = ( i < m ) ? b.charAt(m - 1 - i) - '0' : 0; //要么是1，要么是0
            int sum = bitA + bitB + carry;
            result.append(sum & 1); // 添加当前位的结果
            carry = sum >> 1; // 计算新的进位

        }

        if (carry != 0) {
            result.append(carry); // 如果最后有进位，添加到结果中
        }

        return result.reverse().toString();
    }

    public String addBinaryBigInteger(String a, String b) {
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);
        BigInteger sum = num1.add(num2);
        return sum.toString(2);
    }

    //双指针方法

}