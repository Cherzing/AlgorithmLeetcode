package cn.cherzing.lanqiao;

/**
 * @author Cherzing
 * @date 2024/12/09 0009 19:49
 * @description Space
 */
public class Space {
    public void test(){
        int count = Math.abs(256*1024*1024*8/32);
        System.out.println(count);
    }
    public static void main(String[] args) {
        new Space().test();
    }
}
