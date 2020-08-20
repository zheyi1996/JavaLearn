package cn.neu.edu.wlg.ZJoffer;

import cn.neu.edu.wlg.ZJoffer.util.TwoTuple;

import java.util.HashMap;
import java.util.Map;

/*
    题目：第一个只出现一次的字符
    思路：
        26 + 26 个字母
        1. 数据结构记录(字母第一次出现的位置，字母出现的次数) -- 难点
        2. 遍历并记录次数
        3. 在所有只出现一次的数据中选出位置值最小的那个
    知识点：
        1. HashMap的遍历方式 Entry， entrySet()
        2. 设计新的数据结构TwoTuple
            public class TwoTuple<A, B> {

                public A first;
                public B second;

                public TwoTuple(A a, B b) {
                    this.first = a;
                    this.second = b;
                }
            }
 */
public class Offer034 {

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, TwoTuple<Integer, Integer>> records = new HashMap<>();
        char [] ch = str.toCharArray();
        for (int i = 0; i < ch.length; ++i) {
            if (records.containsKey(ch[i])) {
                TwoTuple<Integer, Integer> temp = records.get(ch[i]);
                temp.second += 1;
                records.put(ch[i], temp);
            } else {
                TwoTuple<Integer, Integer> temp = new TwoTuple<>(i, 1);
                records.put(ch[i], temp);
            }
        }
        int minLocation = 100000;
        for (Map.Entry<Character, TwoTuple<Integer, Integer>> entry : records.entrySet()) {
            if (1 == entry.getValue().second) {
                minLocation = minLocation < entry.getValue().first ? minLocation : entry.getValue().first;
            }
        }
        if (100000 == minLocation) {
            return -1;
        } else {
            return minLocation;
        }
    }
}
