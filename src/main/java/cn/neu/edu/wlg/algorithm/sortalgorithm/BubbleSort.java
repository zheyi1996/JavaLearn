package cn.neu.edu.wlg.algorithm.sortalgorithm;

public class BubbleSort {

    public static void main(String[] args) {
        int [] arr = {3, 9, -1, 10, -2};
        boolean flag = false; // 优化 - 标识变量，表示是否进行过交换
        for (int i = 1; i < arr.length; ++i) { // n - 1 次
            int temp = 0;
            for (int j = 0; j < arr.length - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }
}
