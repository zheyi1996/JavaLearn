package cn.neu.edu.wlg.algorithm.sortalgorithm;

public class SelectSort {

    public static void main(String[] args) {
        int [] arr = {3, 9, -1, 10, -2};
        for (int i = 0; i < arr.length - 1; ++i) { // n - 1 次
            int min = Integer.MAX_VALUE;
            int location = -1;
            for (int j = i; j < arr.length; ++j) {
                if (arr[j] < min) {
                    min = arr[j];
                    location = j;
                }
            }
            if (-1 != location) {
                int temp = arr[location];
                arr[location] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }
}
