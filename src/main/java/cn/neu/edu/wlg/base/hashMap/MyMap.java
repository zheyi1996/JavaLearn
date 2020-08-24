package cn.neu.edu.wlg.base.hashMap;

import java.util.HashMap;

public interface MyMap<K, V> {

    public V put(K k, V v);
    public V get(K v);
    interface Entry<K, V> {
        public K getKey();
        public V getValue();
    }
}
