package cn.neu.edu.wlg.writtenExamination;

import java.util.*;

/*
    2 5 3 6

    2 3 5 6
    1 3 2 4

    1 5
    2 3
    3 5
    4 3

    1 4
    2 4
    3 4
    4 3
    5 3
    6 3
 */
public class TengXun004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i = 1; i <= n; ++i) {
            int temp = scanner.nextInt();
            map.put(i, temp);
            arr[i] = temp;
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int a = 0;
        int b = 0;
        int k = 1;
        for (Map.Entry<Integer, Integer> mapping : list) {
            hashMap.put(mapping.getKey(), mapping.getValue());
            if (k == n / 2 + 1) {
                b = mapping.getValue();
            }
            if (k == n / 2) {
                a = mapping.getValue();
            }
            k++;
        }
        for(int i = 1; i <= n / 2; ++i) {
            System.out.println(b);
        }

        for(int i = 1; i <= n / 2; ++i) {
            System.out.println(a);
        }
    }
}
