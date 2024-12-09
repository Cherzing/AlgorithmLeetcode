package cn.cherzing.lanqiao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/10 0010 17:14
 * @description TimeDisplay
 */
public class TimeDisplay {
    public void test() {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        long a = scan.nextLong();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");//创建SimpleDateFormat对象，即时间模板
        Date date = new Date(a);//创建Date对象

        System.out.println(sdf.format(date));//按SimpleDateFormat对象的时间模板将字符串格式化输出
        scan.close();
    }

    public static void main(String[] args) {
        new TimeDisplay().test();
    }
}
