package cn.cherzing.lanqiao;

/**
 * @author Cherzing
 * @date 2024/12/09 0009 16:57
 * @description RectangularCutting
 */
public class RectangularCutting {
    public void test() {
        int wide = 324;
        int length = 2019;
        int sub, count = 0;
        while ((wide >= 1) && (length >= 1)) {
            sub = length - wide; //1695

            count++;

            if (wide > sub) {
                length = wide;
                wide = sub;
            } else if (sub > wide) {
                length = sub;
            } else {
                count++;
                break;
            }

        }
        System.out.println("me:" + count);
    }

    public void test2() {
        int n = 0;
        int w = 324;
        int h = 2019;
        while (w != 1) {
            if (h > w) {
                h = h - w;
                n++;
            } else if (w > h) {
                w = w - h;
                n++;
            } else if (w == h) {
                n++;
                break;
            }
        }
        System.out.println("you:" + n);
    }

    public static void main(String[] args) {
        new RectangularCutting().test();
        //new RectangularCutting().test2();
    }
}
