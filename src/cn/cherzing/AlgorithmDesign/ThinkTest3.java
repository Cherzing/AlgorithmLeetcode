package cn.cherzing.AlgorithmDesign;

import org.junit.Test;

/**
 * @author Cherzing
 * @date 2024/11/02 0002 14:44
 * @description ThinkTest3
 */
public class ThinkTest3 {
    static double a = 123456789;
    static int b = 1000000000;
    static double k = 1000000007;
    @Test
    public void testEnumeration(){
        SolutionDiv solutionDiv = new SolutionDiv();
        solutionDiv.enumeration(a,b,k);
    }
    @Test
    public void testDiv(){
        new SolutionDiv().fastPower(a,b,k);
    }

}
class SolutionDiv{
    /**
     * 使用枚举法
     */
    public double enumeration(double a,int b, double k){
        double result = 1f;
        for (int i = 1;i <= b;i++){
            result = (result * a) % b;
        }
        return result;
    }
    public double fastPower(double a,int b, double k){
        int result = 0;
        double half = 0;
        if (b == 0){
            return 1;
        }
        if (b % 2 == 0){ //偶数
            half = fastPower(half * half,b/2,k);
            return (half * half) % k;
        }
        else  { //奇数
            return (a * fastPower(a,b-1,k) % k);
        }
    }
}