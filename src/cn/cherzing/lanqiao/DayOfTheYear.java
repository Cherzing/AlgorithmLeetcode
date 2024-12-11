package cn.cherzing.lanqiao;

import java.util.Date;
import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/10 0010 19:05
 * @description DayOfTheYear
 */
public class DayOfTheYear {
    public void test() {
        Scanner scanner = new Scanner(System.in);
        /**
         * 我的想法：
         * 1. 判断是否小于2月；如果是小于二月，不考虑闰年；如果大于二月，考虑闰年
         * 2. 判断是否为闰年，是闰年+28；不是闰年+29
         * 3. 加上“月”，Switch case
         * 4. 加上日
         */
        int year, month, day;
        do {
            int count = 0;
            year = scanner.nextInt();
            month = scanner.nextInt();
            day = scanner.nextInt();
            switch (month - 1) {
                case 12:
                    count += 31;
                case 11:
                    count += 30;
                case 10:
                    count += 31;
                case 9:
                    count += 30;
                case 8:
                    count += 31;
                case 7:
                    count += 31;
                case 6:
                    count += 30;
                case 5:
                    count += 31;
                case 4:
                    count += 30;
                case 3:
                    count += 31;
                case 2:
                    count += 28;
                case 1:
                    count += 31;
                case 0:
                    break;
            }
            if (leapYear(year)) {
                count++;
            }
            count += day;
            System.out.println(count);
        }
        while (year != 0 && month != 0 && day != 0);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month, day;
        do {
            int count = 0;
            year = scanner.nextInt();
            month = scanner.nextInt();
            day = scanner.nextInt();
            switch (month - 1) {
                case 12:
                    count += 31;
                case 11:
                    count += 30;
                case 10:
                    count += 31;
                case 9:
                    count += 30;
                case 8:
                    count += 31;
                case 7:
                    count += 31;
                case 6:
                    count += 30;
                case 5:
                    count += 31;
                case 4:
                    count += 30;
                case 3:
                    count += 31;
                case 2:
                    count += 28;
                case 1:
                    count += 31;
                case 0:
                    break;
            }
            if (new DayOfTheYear().leapYear(year)) {
                count++;
            }
            count += day;
            System.out.println(count);
        }
        while (year != 0 && month != 0 && day != 0);
    }

    private boolean leapYear(int year) {
        //return ((year % 4) == 0 && (year % 400) != 0) || (year % 400) == 0;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
