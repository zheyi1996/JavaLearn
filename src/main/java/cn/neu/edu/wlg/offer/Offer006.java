package cn.neu.edu.wlg.offer;

import org.junit.Test;
import org.junit.jupiter.params.provider.ValueSource;

/*
    题目：旋转数组的最小数字
    思路：二分查找
        如果mid大于等于low，则说明mid属于前面的递增数组
        如果mid小于等于low，说明mid属于后面的递增数组
        ps:考虑low, mid, high三处值相等的情况
        (1 0 1 1 1),(1 1 1 0 1)
    盲点：
        1. 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 */
public class Offer006 {

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        if (array[mid] == array[low] && array[mid] == array[high]) {
            findMinInOrder(array);
        }
        while (high - low > 1) {
            if(array[mid] >= array[low]) {
                low = mid;
            } else {
                high = mid;
            }
            mid = (low + high) / 2;
        }
        return array[high];
    }
    public int findMinInOrder(int [] array) {
        int min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
