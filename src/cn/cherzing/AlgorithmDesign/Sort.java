package cn.cherzing.AlgorithmDesign;

import org.junit.Test;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 10:44
 * @description Sort
 */
public class Sort {
    @Test
    public void testSort() {
        int[] arr = {64, 25, 12, 22, 11, 22};
        int n = arr.length;
        SortSolution sortSolution = new SortSolution();

        sortSolution.selectionSort(arr);


        sortSolution.bubbleSort(arr);


        sortSolution.insertionSort(arr);


        sortSolution.quickSort(arr, 0, n - 1);


        sortSolution.mergeSort(arr, 0, n - 1);
    }
}

class SortSolution {
    /**
     * 选择排序
     * <p>
     * 不断地从未排序的序列中找到最小（或最大）的元素，存放到排序序列的起始位置，直到未排序序列为空
     * </p>
     *
     * @param arr
     */
    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // 找到从i到n-1中最小的元素
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将找到的最小元素与第i个位置的元素交换
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 它重复地遍历要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。遍历数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * </P>
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换arr[j]和arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * </p>
     *
     * @param arr
     */
    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // 将大于key的元素向右移动
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * 快速排序：
     * <p>
     * 采用分而治之的策略来把一个序列分为两个子序列
     * 它的基本思想是选择一个“基准”元素，通过一趟排序，
     * 将待排序的数据分割成独立的两部分，
     * 其中一部分的所有数据都比另外一部分的所有数据要小，
     * 然后再按此方法对这两部分数据分别进行快速排序，
     * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * </p>
     *
     * @param arr
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找到pivot元素的正确位置
            int pivotIndex = partition(arr, low, high);

            // 递归地对pivot左侧的子数组进行快速排序
            quickSort(arr, low, pivotIndex - 1);
            // 递归地对pivot右侧的子数组进行快速排序
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // 指向小于pivot的元素的索引
        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于pivot
            if (arr[j] <= pivot) {
                i++;

                // 交换arr[i]和arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 交换arr[i+1]和arr[high]（或pivot）
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * 归并排序：
     * <p>
     * 基本思想是将一个大的数组分成两个较小的数组，分别对这两个较小的数组进行排序，
     * 然后将排序后的两个数组合并成一个有序的数组。
     * 这个过程可以递归地进行，直到数组被分成单个元素，因为单个元素被认为是有序的。
     * </P>
     *
     * @param arr
     */
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 找到中间索引
            int middle = (left + right) / 2;

            // 递归地对左侧子数组进行归并排序
            mergeSort(arr, left, middle);
            // 递归地对右侧子数组进行归并排序
            mergeSort(arr, middle + 1, right);

            // 合并两个有序的子数组
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        // 找到两个子数组的长度
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 创建临时数组
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 复制数据到临时数组
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[middle + 1 + j];

        // 合并临时数组回到原数组
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 复制剩余的元素
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}