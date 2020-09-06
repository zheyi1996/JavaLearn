package cn.neu.edu.wlg.writtenExamination;

import java.util.*;

public class TengXun002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, HashSet> hashMap = new HashMap<>();
        for(int i = 0; i < m; ++i) {
            int t = scanner.nextInt();
            HashSet<Integer> temp = new HashSet<>();
            for (int j = 0; j < t; ++j) {
                temp.add(scanner.nextInt());
            }
            hashMap.put(i, (HashSet) temp.clone());
            temp = null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> already = new HashSet<>();
        Set<Integer> remove = new HashSet<>();
        while(!queue.isEmpty() && !hashMap.isEmpty()) {
            int v = queue.poll();
            if (already.contains(v)) {
                continue;
            } else {
                for(int i = 0; i < hashMap.size(); ++i) {
                    if (remove.contains(i)) {
                        continue;
                    }
                    if(hashMap.get(i).contains(v)) {
                        set.addAll(hashMap.get(i));
                        Iterator<Integer> iterator = hashMap.get(i).iterator();
                        while (iterator.hasNext()) {
                            int tt = iterator.next();
                            if(!already.contains(tt)) {
                                queue.offer(tt);
                            }
                        }
//                        hashMap.remove(i);
                    }
                }
            }
            already.add(v);
        }
        System.out.println(set.size());
    }
}
