package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class TianYiYun002 {
    public int getResult(int index) {
        if(index<=0){
            return 0;
        }
        int pos1=0;
        int pos2=0;
        int pos3=0;
        int[] result=new int[index];
        result[0]=1;
        for(int i=1;i<index;i++){
            result[i]=Math.min(Math.min(result[pos1]*2,result[pos2]*3),result[pos3]*5);
            if(result[i]==result[pos1]*2){
                pos1++;
            }else if(result[i]==result[pos2]*3){
                pos2++;
            }else{
                pos3++;
            }
            if(result[i]==result[i-1]){
                i--;
            }
        }
        return result[index-1];
    }
}

