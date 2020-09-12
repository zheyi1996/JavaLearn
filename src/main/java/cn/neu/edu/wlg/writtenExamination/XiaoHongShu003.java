package cn.neu.edu.wlg.writtenExamination;

import java.util.Arrays;

public class XiaoHongShu001 {
    public static int findMin(int[] tree) {
        Arrays.sort(tree);
        if(tree[0] > 1) {
            return 1;
        }
        int min = 0;
        for(int i = 0, j = 1; i < tree.length && j < tree.length; ++i, ++j) {
            if(tree[i] + 1 == tree[j] || tree[i] == tree[j]) {
                continue;
            } else {
                min = 1 + tree[i];
                break;
            }
        }
        return min;
    }
}
