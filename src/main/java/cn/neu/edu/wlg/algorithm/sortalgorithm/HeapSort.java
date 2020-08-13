package cn.neu.edu.wlg.algorithm.sortalgorithm;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int [] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }
    // 编写一个堆排序的方法
    public static void heapSort(int [] arr) {
        int temp = 0;
        // 将无序序列构建成一个堆
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; --j) {
            // 交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    // 将一个数组调(二叉树)整成一个大顶堆
    /*
        将以i对应的非叶子结点的树调整成大顶堆
     */
    public static void adjustHeap(int [] arr, int i, int length) {
        int temp = arr[i]; // 先取出当前元素的值，保存在临时变量
        // 开始调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 说明左子节点小于右子节点
                ++k; // !!!
            }
            if (arr[k] > temp) { // 子节点大于父节点
                arr[i] = arr[k]; // 将较大结点复赋值给当前结点
                i = k; // i指向k,继续循环比较
            } else {
                break;
            }
        }
        // 当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶(局部)
        arr[i] = temp; // 将temp放到调整后的位置
    }
}
