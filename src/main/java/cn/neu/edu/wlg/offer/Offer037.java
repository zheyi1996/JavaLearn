package cn.neu.edu.wlg.offer;

/*
    题目：统计一个数字在排序数组中出现的次数
    思路一：如果使用一个for循环是可以的，不过似乎没必要要求数组是排序的
    思路二：或许可以先使用二分法定位此数字，
 */
public class Offer037 {

    public int GetNumberOfK(int [] array , int k) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (k == array[i]) {
                ++count;
            }
        }
        return count;
    }
    public int GetNumberOfK2(int [] array , int k) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = array.length - 1;
        // 2 3 4 4 7 8
        // k = 4
        int location = -1;
        int mid = (left + right) / 2;
        while (left < right) {
            if (k > array[mid]) { // 在前半部分查找
                right = mid - 1;
            } else if (k < array[mid]) {
                left = mid + 1;
            } else {
                break;
            }
            mid = (left + right) / 2;
        }
        if (array[mid] == k) {
            location = mid;
            ++count;
        }
        if (-1 != location) {
            for (int i = location-1; i >=0; --i) {
                if (array[i] != array[location]) {
                    break;
                } else {
                    ++count;
                }
            }
            for (int i = location + 1; i < array.length; ++i) {
                if (array[i] != array[location]) {
                    break;
                } else {
                    ++count;
                }
            }
        }
        return count;
    }
}
