package cn.neu.edu.wlg.writtenExamination;

import java.util.ArrayList;
import java.util.Scanner;

public class JD_002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<Integer> linkedList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String[] strArr = scanner.nextLine().trim().split(" ");
            if (strArr[0].equals("1")) {
                linkedList.add(Integer.parseInt(strArr[1]) - 1, Integer.parseInt(strArr[2]));
            } else if (strArr[0].equals("2")) {
                linkedList.remove(Integer.parseInt(strArr[1]) - 1);
            } else if (strArr[0].equals("3")) {
                for (int j = 0; j < linkedList.size() - 1; ++j) {
                    System.out.print(linkedList.get(j) + " ");
                }
                if (linkedList.size() - 1 >= 0) {
                    System.out.println(linkedList.get(linkedList.size() - 1));
                } else {
                    System.out.println("");
                }
            }
        }
    }
}







