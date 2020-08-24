package cn.neu.edu.wlg.base.hashMap;

import org.junit.jupiter.api.Test;

public class MyHashMapTest {

    @Test
    public void test() {
        MyMap<String, String> map = new MyHashMap<>();

        for (int i = 0; i < 100; i++) {
            map.put("key" + i, "value" + i);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("key" + i + ",value is：" + map.get("key" + i));
        }

        System.out.println(map.get("key88"));
    }
}
