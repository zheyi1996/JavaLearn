package cn.neu.edu.wlg.ZJoffer;

/*
    题目：数组中次数超过一半的数字 - 如果不存在则输出0
    思路一：快排，取中位数 - 修改数组 - 如果不存在则输出0？
    思路二：利用数组中有一个数字出现的次数超过数组长度的一半
 */
public class Offer028 {

    public static void main(String[] args) {
        Offer028 offer028 = new Offer028();
        int [] nums = {3, 2, 2, 3};
//        int value = offer028.MoreThanHalfNum_Solution(nums);
        int value = offer028.MoreThanHalfNum_Solution2(nums);
        System.out.println(value);
    }

    // 方法1
    public int MoreThanHalfNum_Solution(int [] array) {
        quickSort(array, 0, array.length - 1);
        int num = array[array.length / 2];
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if(num == array[i]) {
                ++count;
            }
        }
        if (count <= array.length/2)
            return 0;
        return num;
    }
    public void quickSort(int [] array, int low, int high) {
        if(low >= high) {
            return;
        }
        int index = partition(array, low, high);
        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);
    }
    public int partition(int [] array, int low, int high) {
        int key = array[low];
        while (low < high) {
            while (array[high] >= key && low < high) {
                --high;
            }
            array[low] = array[high];
            while (array[low] <= key && low < high) {
                ++low;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }

    // 方法二
    public int MoreThanHalfNum_Solution2(int [] array) {
        int location = 0;
        int counts = 1;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == array[location]) {
                ++counts;
            } else {
                --counts;
                if (counts == 0) {
                    location = i;
                    counts = 1;
                }
            }
        }
        int num = array[location];
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if(num == array[i]) {
                ++count;
            }
        }
        if (array.length >= count * 2)
            return 0;
        return array[location];
    }
}
