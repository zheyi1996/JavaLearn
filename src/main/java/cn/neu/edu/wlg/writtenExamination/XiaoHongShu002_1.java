package cn.neu.edu.wlg.writtenExamination;

public class XiaoHongShu002_1 {

    static int solution(String s) {
        int l=s.length();
        int[] dp=new int[l+1];
        boolean[][] flag=new boolean[l][l];
        dp[l]=-1;

        for (int i = l-1; i >=0 ; i--) {
            dp[i]=Integer.MAX_VALUE;
            for(int j=i;j<l;j++){
                if(s.charAt(j)==s.charAt(i)){
                    flag[i][j] = true;
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }

        }
        return dp[0]+1;
    }
}
