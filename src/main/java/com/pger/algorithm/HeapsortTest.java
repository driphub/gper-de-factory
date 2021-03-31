package com.pger.algorithm;

import java.util.Arrays;

/**
 * <b>Description: Heapsort 堆排序算法 </b>
 * <p>
 * //  https://blog.csdn.net/qq_36186690/article/details/82505569
 *      每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆
 *      每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 *
 *      大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 *      小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 * </p>
 *
 * @author song
 * @ClassName HeapsortTest
 * @Date 3/26/21 10:06 AM song Exp $$
 * @since V1.0
 */
public class HeapsortTest {


    public static void main(String[] args) {
        int arr[] = {7, 6, 7, 11, 5, 12, 3, 0, 1};
        System.out.printf("-----------> 排序前：" + Arrays.toString(arr) + "\n");

        sort(arr);

        System.out.printf("-----------> 排序后：" + Arrays.toString(arr));
    }

    private static void sort(int arr[]) {
        if (arr.length > 0) {
            // 构建大顶堆
            for (int i = arr.length/2-1; i >=0; i--) {
                // 从第一个非叶子节点从下至顶，从右至左调整
                adjustHeapSort(arr, i, arr.length);
            }

            // 调整堆结构，交换堆顶元素与末尾元素
            for (int j = arr.length - 1; j > 0; j--) {
                // 堆顶元素与末尾元素交换
                swap(arr, 0, j);

                // 堆重新调整
                adjustHeapSort(arr, 0, j);
            }
        }
    }

    /**
     * 调整大顶
     * @param arr
     * @param count
     * @param length
     */
    private static void adjustHeapSort(int arr[], int count, int length) {
        // 取出当前元素count
        int temp = arr[count];
        // 从count节点在左子节点开始，2count+1处开始
        for (int k = count*2+1; k < length; k=k*2+1) {
            // 如果左子节点小于右子节点，k指向右子节点
            if (k+1 < length && arr[k] < arr[k+1]) {
                k++;
            }

            // 如果子节点大于父节点，将子节点值赋给父节点
            if (arr[k] > temp) {
                arr[count] = arr[k];
                count = k;
            } else {
                break;
            }
        }

        // 将temp放到最终的位置
        arr[count] = temp;
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
