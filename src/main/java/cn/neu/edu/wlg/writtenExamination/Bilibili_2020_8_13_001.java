package cn.neu.edu.wlg.writtenExamination;

/*
    题目：给4个数1-10，加减乘除是否能够等于24，能就返回true，否则返回false
    思路：
        递归回溯

        1 2 3 4
        2 4 8 10
        3 8 9 10
 */
public class Bilibili_2020_8_13_001 {

    boolean flag = false;
    public static void main(String[] args) {
        // true
//        int [] arr = {3, 8, 9, 10};
//        int [] arr = {2, 1, 4, 3};
//        int [] arr = {10, 8, 2, 4};
//        int [] arr = {5, 2, 6, 2};
        int [] arr = {4, 8, 3, 6};

        // false
//        int [] arr = {7, 8, 9, 10};

        Bilibili_2020_8_13_001 bilibili_2020_8_13_001 = new Bilibili_2020_8_13_001();
        bilibili_2020_8_13_001.isEqual24(arr, 0,0);
        System.out.println(bilibili_2020_8_13_001.flag);
    }
    public void isEqual24(int [] arr, int result, int location) {
        if (3 == location) {
            if (24 == result) {
                flag = true;
            }
            return;
        }
        for (int i = 0; i < 4; ++i) {
            if (flag) {
                return;
            }
            if (-1 == arr[i]) {
                continue;
            }
            if (0 == location) {
                result = arr[0];
            }
            int temp = arr[i];
            arr[i] = -1;
            isEqual24(arr, result + temp, location + 1);
            isEqual24(arr, result - temp, location + 1);
            isEqual24(arr, result * temp, location + 1);
            isEqual24(arr, result / temp, location + 1);
            arr[i] = temp;
        }
    }
}
