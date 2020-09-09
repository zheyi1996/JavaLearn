package cn.neu.edu.wlg.writtenExamination;

public class TianYiYun {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(dp_opt(arr));
    }

    public static int rec_opt(int[] arr, int i) {
        if (i == 0)
            return arr[0];
        else if (i == 1)
            return Math.max(arr[0], arr[1]);
        else {
            int a = rec_opt(arr, i - 2) + arr[i];
            int b = rec_opt(arr, i - 1);
            return Math.max(a, b);
        }
    }

    public static int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int a = opt[i - 2] + arr[i];
            int b = opt[i - 1];
            opt[i] = Math.max(a, b);
        }
        return opt[arr.length - 1];
    }
}

