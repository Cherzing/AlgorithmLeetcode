import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Cherzing
 * @date 2024/12/08 0008 17:51
 * @description ArrayToListConversion
 */
public class ArrayToListConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];

        // 数组赋值
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        // 将基本类型数组转换为对象数组
        Integer[] arrboxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // 将对象数组转换为列表
        List<Integer> list = new ArrayList<>(Arrays.asList(arrboxed));

        // 输出列表
        System.out.println(list);

        // 关闭scanner
        scanner.close();
    }

}
