package cn.neu.edu.wlg.offer;

/*
    题目：调整数组顺序使奇数位于偶数前面
    思路：
        思路一：辅助数组
            1. 建立辅助数组
            2. 从前后遍历该数组，从前面得到的奇数都放到辅助数组前，后面得到的偶数都放到辅助数组后面
            3. 再将结果复制到 array
       思路二：如果不能使用辅助数组 - 顺序遍历，前偶后奇就交换


*/
public class Offer013 {

    public static void main(String[] args) {
        Offer013 offer013 = new Offer013();
        int [] array = {1,2,3,4,5,6,7};
        offer013.reOrderArray(array);
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }
    public void reOrderArray(int [] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        int [] temp = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 1) {
                temp[j++] = array[i];
            }
        }
        j = array.length - 1;
        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i] % 2 == 0) {
                temp[j--] = array[i];
            }
        }

        for (int i = 0; i < array.length; ++i) {
            array[i] = temp[i];
        }
    }
}
