package cn.neu.edu.wlg.ZJoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    题目：把数组排成最小的数
    思路：
    知识点:
        1. String 类实现了Comparable类，并重写了 compareTo() 方法
        2. Comparable -- compareTo() 在类设计中使用
           Comparator -- compare() 在类设计已经完成的情况下使用

 */
public class Offer032 {

    public String PrintMinNumber(int [] numbers) {
        if (null == numbers || 0 == numbers.length) {
            return "";
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < numbers.length; ++i) {
            arrayList.add(numbers[i]);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
       for (int i = 0; i < arrayList.size(); ++i) {
           stringBuffer.append(arrayList.get(i).toString());
       }
       return stringBuffer.toString();
    }
}
