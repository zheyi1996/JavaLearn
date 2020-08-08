package cn.neu.edu.wlg.algorithm.searchalgorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int [] arr = {3, 7, 9, 10, 10};
        int location = BinarySearch.binarySearch(arr, 0, arr.length - 1, 10);
        if (-1 == location) {
            System.out.println("没有找到");
        } else {
            System.out.println(arr[location]);
        }
    }
    public static int binarySearch(int [] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
