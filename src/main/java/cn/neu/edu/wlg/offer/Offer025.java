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

    public RandomListNode Clone2(RandomListNode pHead) {
        RandomListNode p = pHead;
        while(null != p) { // 逐个插入
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
        p = pHead;
        int i = 0;
        while(null != p) {
            if(0 == i % 2){
                RandomListNode s = p.next;
                if(null != p.random) {
                    s.random = p.random.next;
                } else {
                    s.random = null;
                }
            }
            ++i;
            p = p.next;
        }
        i = 0;
        RandomListNode strhead = pHead.next;
        RandomListNode str = strhead;
        p = str.next;
        while(null != p) {
            if(1 == i % 2) {
                str.next = p;
                str = str.next;
            }
            i++;
            p = p.next;
        }
        return strhead;
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
