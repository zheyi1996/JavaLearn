package cn.neu.edu.wlg.base.hashMap;


import sun.util.PreHashedMap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> implements MyMap<K, V> {

    // Entry数组的默认初始化长度是16
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    // 默认负载因子
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    // 可设置的初始化值
    private int size;
    // 可设置的负载因子
    private float loadFactor;
    // 当前已存入的元素的数量
    private int entryUseSize;
    // 存放<K, V>键值对对象的数组
    private Entry<K, V>[] table = null;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initSize, float loadFactor) {
        this.size = initSize;
        this.loadFactor = loadFactor;
        table = new Entry[this.size];
    }

    @Override
    public V put(K k, V v) {
        V oldValue = null;
        int index = hash(k) & (size - 1);
        if (null == table[index]) {
            table[index] = new Entry<>(k, v, null);
            ++entryUseSize;
        } else {
            // 是否需要扩容
            // 1. HashMap存放的数据量大于阈值 2. 发生冲突
            if (entryUseSize >= size * loadFactor) {
                resize(2 * size);
            }

            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while(null != e) {
                if(k == e.getKey() || k.equals(e.getKey())) {
                    oldValue = e.getValue();
                    // key已经存在，直接更新value
                    e.value = v;
                    return oldValue;
                }
                e = e.next;
            }
            // JDK1.7中链表头插法，直接占据数组下标位置
            table[index] = new Entry<>(k, v, entry);
            ++entryUseSize;
        }
        return oldValue;
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (size -1);
        if (null == table[index]) {
            return null;
        } else {
            //获取到数组下标位置元素
            Entry<K, V> entry = table[index];
            Entry<K, V> e = entry;
            while (null != entry) {
                if (k.equals(e.getKey())) {
                    return e.getValue();
                }
                //获取数组下标位置对应列表中的下一个元素
                e = e.next;
            }
        }
        return null;
    }

    public void resize(int size) {
        Entry<K, V>[] newTable = new Entry[size];
        // 改变数组的大小
        this.size = size;
        entryUseSize = 0;
        rehash(newTable);
    }

    // 重新进行散列
    public void rehash(Entry<K, V>[] newTable) {
        List<Entry<K, V>> entryList = new ArrayList<>();
        for(Entry<K, V> entry : table) {
            while (null != entry) {
                entryList.add(entry);
                entry = entry.next;
            }
        }
        if (newTable.length > 0) {
            table = newTable;
        }
        // 重新散列，即将元素重新放入到扩容后的集合中
        for (Entry<K, V> entry : entryList) {
            put(entry.getKey(), entry.getValue());
        }
    }

    // 高16位不变，低16位部分与高16位部分做异或运算
    public int hash(K key) {
        int h;
        return (null == key) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    class Entry<K, V> implements MyMap.Entry<K, V> {

        private K key;
        private volatile V value;
        private Entry<K, V> next;

        public Entry() {

        }
        public Entry(K key, V value, Entry<K, V> next) {
            super();
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
}