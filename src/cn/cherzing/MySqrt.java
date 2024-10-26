package cn.cherzing;

/**
 * @author Cherzing
 * @date 2024/10/26 0026 11:01
 * @description MySqrt
 */
public class MySqrt {
    public static void main(String[] args) {
        SolutionMySqrt solutionMySqrt = new SolutionMySqrt();
        System.out.println(solutionMySqrt.mySqrtBinarySearch(6));
    }
}

class SolutionMySqrt {

    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     * @param x
     * @return
     */
    public int mySqrtCircle(int x){
        int time = 0;
        if (x == 0){
            return 0;
        }
        while (!(square(time) <= x && x < square(time + 1))){
            time++;
        }
        return time;
    }
    public int square(int x){
        return x * x;
    }

    public int mySqrtBinarySearch(int x){
        int left = 1; //左边
        int right = x;//右边

        if (x == 0){
            return 0;
        }

        while(left <= right){
            int mid = (right - left)/2 + left; //避免溢出
            //如果mid > x
            if (mid*mid > x){
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        return right;
    }
}