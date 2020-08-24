package cn.neu.edu.wlg.writtenExamination;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Arrays;
import java.util.Scanner;
public class Ali_2020_8_21_001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        for (int i = 0; i < nums; ++i) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; ++j) {
                arr[j] = in.nextInt();
            }
            Arrays.sort(arr);
            int sum = 0;
            while(n >= 4) {
                if(arr[1] * 2 + arr[n - 1] + arr[0] > (2 * arr[0] + arr[n - 1] + arr[n - 2])) {
                    sum += arr[n - 1];
                    sum += arr[0];
                    sum += arr[n - 2];
                    sum += arr[0];
                } else {
                    sum += arr[1];
                    sum += arr[0];
                    sum += arr[n - 1];
                    sum += arr[1];
                }
                n -= 2;
            }
            if (3 == n) {
                sum += arr[1] + arr[0] + arr[2];
            } else if(2 == n) {
                sum += arr[1];
            } else {
                sum += arr[0];
            }
            System.out.println(sum);
        }
    }
}









