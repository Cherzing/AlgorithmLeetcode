package cn.cherzing.AlgorithmDesign;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/12 0012 10:32
 * @description Greedy
 * <p>
 * 1. 输入处理：读取输入数据，包括节目的总数和每个节目的开始时间和结束时间。</p>
 * 2. 排序：将所有节目按照结束时间进行升序排列。这样可以确保在安排节目时，尽量减少冲突。<p>
 * 3. 选择节目：从第一个节目开始，依次判断下一个节目是否与当前选择的节目有重叠（即下一个节目的开始时间早于当前节目的结束时间）。如果没有重叠，则选择这个节目作为新的当前节目；如果有重叠，则跳过该节目。<p>
 * 4. 计数：记录没有冲突并被选择的节目数量。<p>
 */
public class Greedy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] shows = new int[n][2];

        for (int i = 0; i < n; i++) {
            shows[i][0] = scanner.nextInt(); // 开始时间
            shows[i][1] = scanner.nextInt(); // 结束时间
        }

        int maxShows = maxTVShows(shows);
        System.out.println(maxShows);
        scanner.close();
    }

    /**
     *
     * @param shows
     * @return
     */
    private static int maxTVShows(int[][] shows) {
        // 按照结束时间对节目进行排序
        Arrays.sort(shows, Comparator.comparingInt(a -> a[1])); //对数组的第二个元素进行比较

        int count = 0;
        int lastEndTime = 0;

        for (int[] show : shows) {
            if (show[0] >= lastEndTime) {
                count++;
                lastEndTime = show[1];
            }
        }

        return count;
    }
}
