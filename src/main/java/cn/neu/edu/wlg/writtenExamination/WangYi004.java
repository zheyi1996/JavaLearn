package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class WangYi004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().trim().split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0; i < strs.length; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(maxSumDivSeven(arr));
    }
    public static int maxSumDivSeven(int[] nums) {
        int n1 = nums[0] % 7 == 1 ? nums[0] : 0;
        int n2 = nums[0] % 7 == 2 ? nums[0] : 0;
        int ans = nums[0] % 7 == 0 ? nums[0] : 0;
        //System.out.println(ans + ", " + n1 + ", " + n2);
        for (int i = 1; i < nums.length; i++){
            int num = nums[i];
            if (num % 7 == 0) {
                ans += num;
                if (n1 != 0) n1 += num;
                if (n2 != 0) n2 += num;
            }
            else if (num % 7 == 1) {
                int tmp = n2;
                if (n1 != 0) n2 = Math.max(n2,n1+num);
                n1 = Math.max(n1,ans+num);
                if (tmp != 0) ans = Math.max(ans,num+tmp);
            }
            else {
                int tmp = n1;
                if (n2 != 0) n1 = Math.max(n1,n2+num);
                n2 = Math.max(n2,ans+num);
                if (tmp != 0) ans = Math.max(ans,num+tmp);
            }
        }
        return ans;
    }
}
