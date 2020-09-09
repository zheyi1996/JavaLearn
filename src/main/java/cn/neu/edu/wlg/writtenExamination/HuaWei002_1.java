package cn.neu.edu.wlg.writtenExamination;

import java.util.Scanner;

public class HuaWei002_1 {

    private static int a[][],b[][],n,m;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            n=input.nextInt();
            m=input.nextInt();
            int max=0;
            a=new int[n+3][m+3];
            b=new int[n+3][m+3];
            for(int i=1;i<=n;i++)
                for(int j=1;j<=m;j++){
                    a[i][j]=input.nextInt();
                }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    b[i][j]=find(i,j);
                    if(b[i][j]>max)
                        max=b[i][j];
                }
            }
            System.out.println(max);
        }
    }
    private static int find(int i, int j) {
        int max=0;
        if(i<1||j<1||i>n||j>m)
            return 0;
        if(b[i][j]>0)
            return b[i][j];
        if(a[i-1][j]<a[i][j]){
            int sum=find(i-1,j);
            max=sum;
        }
        if(a[i+1][j]<a[i][j]){
            int sum=find(i+1,j);
            if(sum>max)
                max=sum;
        }
        if(a[i][j-1]<a[i][j]){
            int sum=find(i,j-1);
            if(sum>max)
                max=sum;
        }
        if(a[i][j+1]<a[i][j]){
            int sum=find(i,j+1);
            if(sum>max)
                max=sum;
        }
        return max+1;
    }
}