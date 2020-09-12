package cn.neu.edu.wlg.NC;

import java.util.*;

public class NC054 {
    static HashSet<String> set = new HashSet<>();
    static int INF = 0x3f3f3f3f; // 0x3f3f3f3f + 0x3f3f3f3f = 0x3f3f3f3f

    public static void main(String[] args) {
//        int[] num = {1, 1, 1};
        int[] num = {-1, 0, 1, 2, -1, -4};
        threeSum(num);
    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
//        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        int[] ch = new int[3];
        getResult(num, ch, -1);
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            String[] str = iterator.next().split(",");
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(str[0]));
            temp.add(Integer.parseInt(str[1]));
            temp.add(Integer.parseInt(str[2]));
//            System.out.println(str[0] + ' ' + str[1] + ' ' + str[2]);
            arr.add(temp);
        }
        return arr;
    }
    public static void getResult(int[] num, int[] ch, int loc) {
        if(loc == 2) {
            Arrays.sort(ch);
            if(0 == (ch[0] + ch[1] + ch[2])) {
                StringBuilder str = new StringBuilder();
                str.append(ch[0]);
                str.append(',');
                str.append(ch[1]);
                str.append(',');
                str.append(ch[2]);
                str.append(',');
                set.add(str.toString());
//                System.out.println(str.toString());
            }
            return;
        }
        for(int i = 0; i < num.length; ++i) {
            if(INF == num[i]) {
                continue;
            }
            int temp = num[i];
            num[i] = INF;
            ch[loc + 1] = temp;
            getResult(num, ch, loc + 1);
            num[i] = temp;
        }
    }
}