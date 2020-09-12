package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;
public class HaoWeiLai001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().trim().split(",");
        int[] arr = new int[strs.length];
        int i = 0;
        for(String str : strs) {
            arr[i++] = Integer.parseInt(str);
        }
        reOrderArray1(arr);
        System.out.print("{");
        for(int j = 0; j < arr.length - 1; ++j) {
            System.out.print(arr[j] + ",");
        }
        System.out.println(arr[arr.length - 1] + "}");
    }
    public static void reOrderArray1(int[] array) {
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
