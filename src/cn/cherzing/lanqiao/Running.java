package cn.cherzing.lanqiao;

import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/12 0012 16:45
 * @description Running
 */
public class Running {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int month=1;
        int day=1;
        int weekday=6;
        int[] mon={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int count=0;
        while (true){
            if (weekday==6||weekday==7||day==1||day==11||day==21||day==31){
                count++;
            }
            day++;
            weekday++;
            if (day>mon[month]){
                day=1;
                month++;
            }
            if (weekday>7){
                weekday%=7;
            }
            if (month==12&&day==31){
                count+=1;
                break;
            }
        }
        System.out.print(count);
    }
}
