package cn.cherzing;

import javax.sound.midi.Soundbank;
import java.math.BigInteger;

/**
 * @author Cherzing
 * @date 2024/10/22 0022 20:21
 * @description AddBinary
 */
public class AddBinary {
    public static void main(String[] args) {
        SolutionAddBinary solution = new SolutionAddBinary();
        String result = solution.addBinaryTest("1011", "101");
        System.out.println(result);
    }
}

class SolutionAddBinary {
    /**
     * 从字符串ab开始从后往前遍历，
     * 如果字符串相同位置之和=1，保持不变；
     * 如果字符串相同位置之和!=2，往前进一
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int max = Math.max(len1, len2);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < max; i++) {

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
            int bitA = (i < n) ? a.charAt(n - 1 - i) - '0' : 0;
            int bitB = (i < m) ? b.charAt(m - 1 - i) - '0' : 0;
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


    public String addBinaryTest(String a, String b) {
        int aIndex = a.length() - 1;// 2
        int bIndex = b.length() - 1;// 3
        int maxIndex = Math.max(aIndex, bIndex); // 3
        int sub = Math.abs(aIndex - bIndex);
        StringBuilder stringBuilderA = new StringBuilder(a);
        StringBuilder stringBuilderB = new StringBuilder(b);
        StringBuilder result = new StringBuilder();

        //如果两个字符串长度不一，补零
        if (aIndex > bIndex) {
            for (int i = 0; i < sub; i++) {
                stringBuilderB.insert(0, '0');
            }
        } else {
            for (int i = 0; i < sub; i++) {
                stringBuilderA.insert(0, '0');
            }
        }
        int carry = 0;
        int sum = 0;
        //遍历每个字符串，上下两位相加
        for (int i = maxIndex; i >= 0; i--) {
            // 要么是 0，要么是 1
            int bitA = stringBuilderA.charAt(i) - '0';
            int bitB = stringBuilderB.charAt(i) - '0';
            //相加
            sum = bitA + bitB + carry; // 1+1+0
            result.append(sum & 1); // 2 & 1 = 0

            // 计算进位
            carry = sum >> 1; // 2 >> 1

        }
        if (carry != 0){
            result.append(carry);
        }
        return result.reverse().toString();
    }

    /**
     * 不使用BigInteger
     * 缺点： 超出范围
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinaryNB(String a, String b) {
        //将字符串转为整数
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);

        // 相加
        int sum = num1 + num2;

        // 将结果转换回二进制字符串
        return Integer.toBinaryString(sum);
    }
}