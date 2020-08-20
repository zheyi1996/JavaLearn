package cn.neu.edu.wlg.ZJoffer;

/*
Offer003:二维数组中的查找
思路：
    从右上角开始遍历，有三种情况:
       1. 如果相等，则直接返回。
       2. 如果值大于目标值，列减小。(因为从坐到右增大，因此右边的值不可能存在目标值)
       3. 如果值小于目标值，增大行。（从上往下增大，该值在最右上角为当前行最大，因此当前行没有更大的，可以往下一行找）

 */
public class Offer001 {

    public boolean find(int [][] array, int target) {
        if (array == null || array[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = array.length - 1; // array.length,array[0].length
        while (row < array.length && col >= 0) {
            if (target > array[row][col]) {
                ++ row;
            } else if (target < array[row][col]) {
                -- col;
            } else {
                return true;
            }
        }
        return false;
    }
}
