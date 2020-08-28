package cn.neu.edu.wlg.writtenExamination;

import java.util.*;

public class Three360_001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (0 == b) {
                sum += a;
            } else {
                arrayList.add(a);
            }
        }
        Collections.sort(arrayList);
//        sum += arrayList.get(arrayList.size() - 1);
        for (int i = arrayList.size() - 1; i >=0; --i) {
            int temp = Math.max(sum * 2, sum + arrayList.get(i));
            sum = temp;
        }
        System.out.println(sum);
    }
}


//public class Three360_001 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Set<Character> set = new HashSet();
//        set.add('A');
//        set.add('H');
//        set.add('I');
//        set.add('M');
//        set.add('O');
//        set.add('T');
//        set.add('U');
//        set.add('V');
//        set.add('W');
//        set.add('X');
//        set.add('Y');
//        while(true) {
//            boolean flag = true;
//            String str = in.next();
//            for (int i = 0; i <= str.length() / 2 - 1; ++i) {
//                if (!set.contains(str.charAt(i)) || !set.contains(str.charAt(i))) {
//                    flag = false;
//                }
//                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
//                    flag = false;
//                }
//            }
//            if (!set.contains(str.charAt(str.length() / 2))) {
//                flag = false;
//            }
//            if (flag) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//
//        }
//    }
//}








