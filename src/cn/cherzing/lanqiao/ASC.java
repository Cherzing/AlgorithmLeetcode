package cn.cherzing.lanqiao;

/**
 * @author Cherzing
 * @date 2024/12/09 0009 19:53
 * @description ASC
 */
public class ASC {
    public void test(){
        String a = "A";
        String l = "L";
        System.out.println(a.hashCode());
        System.out.println(l.hashCode());
    }
    public static void main(String[] args) {
        new ASC().test();
    }
}
