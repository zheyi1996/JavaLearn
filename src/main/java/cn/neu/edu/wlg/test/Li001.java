package cn.neu.edu.wlg.test;

import java.util.ArrayList;

/*
    题目：输入一组各不相同的数，输出其可能的全部排列
    思考：考察递归
 */
public class Li001 {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        Li001 li001 = new Li001();
        li001.printArrange(arr);
    }
    public ArrayList<String> printArrange(int [] arr) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (null == arr || 0 == arr.length) {
            return arrayList;
        }
        printArr(0, arr, arrayList);
        return arrayList;
    }
    private void printArr(int pos, int [] arr, ArrayList<String> arrayList) {
        if (pos + 1 == arr.length) {
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < arr.length; ++i) {
                str.append(Integer.toString(arr[i]));
                if (i != arr.length - 1) {
                    str.append(',');
                }
            }
            System.out.println(str);
            return;
        }
        for (int i = pos; i < arr.length; ++i) {
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
            printArr(pos + 1, arr, arrayList);
            temp = arr[pos]; // 回溯
            arr[pos] = arr[i];
            arr[i] = temp;
        }
    }
}
