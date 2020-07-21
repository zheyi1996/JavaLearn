package cn.neu.edu.wlg.offer;

/*
    题目：数组中的逆序对
    思路：
        思路一：最朴素的暴力求解法 -- 时间上不能通过
        思路二: 归并排序
        1,2,3,4,5,6,7,0
        7,6,5,4,3,2,1
    算法步骤：
        1. 函数InversePairs中调用函数mergeSort(int [] array, int low, int high)进行归并排序
        2. 在mergeSort中拆分array为左右两个子数组，然后调用函数merge(int [] array, int low, int mid, int high)合并两个子数组
        3. 在merge函数中，降序排列两个子数组，如果左边的数大于右边的数，则计数器count加1
            要保证右侧较小的数能一直和左侧的数比较
 */
public class Offer035 {

    private int count = 0;
    public static void main(String[] args) {
        Offer035 offer035 = new Offer035();
//        int [] array = {1,2,3,4,5,6,7,0};
        int [] array = {4,3,2,1};
        System.out.println(offer035.InversePairs(array));
    }
    public int InversePairs(int [] array) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
        return count;
    }
    private void mergeSort(int [] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左右拆分
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            // 左右归并
            merge(array, low, mid, high);
        }
    }
    private void merge(int [] arr, int low, int mid, int high) {
        int [] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        // 两个有序数组排序
        // 把较大的数移动到新数组中
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[k++] = arr[right++];
            } else {
                count += high - right + 1; // 左侧数字大于右侧数字，则count加所有右侧数字的个数
                count %= 1000000007;
                temp[k++] = arr[left++];
            }
        }
        // 把左边剩余的数移动到新数组
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        // 把右边剩余的数移动到新数组
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        // 使用有序的新数组覆盖原数组
        for (int i = 0; i < temp.length; ++i) {
            arr[low + i] = temp[i];
        }
    }
}
