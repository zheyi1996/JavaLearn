package cn.neu.edu.wlg.leetcode;

/*
    题目： 数组中第k个最大的元素
    思路：
        一，快速排序，然后返回数组第K个的值
 */
public class LeetCode215 {

    public static void main(String[] args) {
        LeetCode215 leetCode215 = new LeetCode215();
        int [] nums = {3, 2, 1, 5, 6, 4};
        int value = leetCode215.findKthLargest(nums, 4);
        System.out.println(value);
    }
    public int findKthLargest(int[] nums, int k) {
        qucikSort(nums, 0, nums.length - 1);
        return nums[k-1];
    }
    public void qucikSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(array, low, high);
        qucikSort(array, low, index - 1);
        qucikSort(array, index + 1 , high);
    }
    public int partition(int[] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (array[high] <= key && low < high) {
                --high;
            }
            array[low] = array[high];
            while (array[low] >= key && low < high) {
                ++low;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }
}
