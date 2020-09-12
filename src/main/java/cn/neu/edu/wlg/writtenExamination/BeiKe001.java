package cn.neu.edu.wlg.writtenExamination;

import java.util.HashMap;
import java.util.Scanner;

public class BeiKe001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String b = scanner.nextLine();
        int t = Integer.valueOf(b);
        String[] arr = new String[t];
        for (int i = 0; i < t; ++i) {
            arr[i] = scanner.nextLine();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("S", "J");
        map.put("J", "B");
        map.put("B", "S");
        for(int i = 0; i < t; ++i) {
            String[] a= arr[i].split("\\s+");
            int left = 0;
            int right = 0;
            if(map.get(a[0]).equals(a[2])) {
                ++left;
            } else {
                --left;
            }
            if(map.get(a[0]).equals(a[3])) {
                ++left;
            } else {
                --left;
            }

            if(map.get(a[1]).equals(a[2])) {
                ++right;
            } else {
                --right;
            }
            if(map.get(a[1]).equals(a[2])) {
                ++right;
            } else {
                --right;
            }
            if(left > right) {
                System.out.println("left");
            } else if(left < right) {
                System.out.println("right");
            } else {
                System.out.println("same");
            }
        }
    }
}
