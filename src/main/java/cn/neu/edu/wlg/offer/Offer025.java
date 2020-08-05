package cn.neu.edu.wlg.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer025 {

    public RandomListNode Clone(RandomListNode pHead) {
        // 如果为null怎么办？
        RandomListNode nHead = new RandomListNode(-1);
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode pHeadTemp = pHead;
        RandomListNode nHeadTemp = nHead;
        while (null != pHeadTemp) {
            nHeadTemp.next = new RandomListNode(pHeadTemp.label);
            map.put(pHeadTemp, nHeadTemp.next);
            pHeadTemp = pHeadTemp.next;
            nHeadTemp = nHeadTemp.next;
        }
        pHeadTemp = pHead;
        nHeadTemp = nHead;
        while (null != pHeadTemp) {
            RandomListNode temp = map.get(pHeadTemp.random);
            pHeadTemp = pHeadTemp.next;
            nHeadTemp = nHeadTemp.next;
            nHeadTemp.random = temp;
        }
        return nHead.next;
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
