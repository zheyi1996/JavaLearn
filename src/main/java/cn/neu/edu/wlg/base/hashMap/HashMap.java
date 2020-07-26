//package cn.neu.edu.wlg.base.hashMap;
//
//public class HashMap<K, V> implements Map<K, V> {
//
//    private Entry<K, V>[] table = null;
//    private int size = 0;
//    private static int defaultLength = 16;
//
//    public HashMap() {
//        table = new Entry[defaultLength];
//    }
//
//    @Override
//    public V put(K k, V v) {
//        // 通过hash把key算出来
//        int index = hash(k);
//        Entry<K, V> entry = table[index];
//        if (null == entry) { // 原来该数组下标下没有结点，则直接插入
//            table[index] = new Entry<>(k, v, index,  null );
//            ++size;
//        } else { // 如果该数组下标下有结点，则插入到原 链表头节点前
//            table[index] = new Entry<>(k, v, index, entry);
//        }
//        return table[index].getValue();
//    }
//
//    @Override
//    public V get(K k) {
//        if (0 == size) {
//            return null;
//        }
//        int index = hash(k);
//        Entry<K, V> entry = getEntry(k, index);
//        return null == entry ? null : entry.getValue();
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    private int hash(K k) {
//        return Math.abs(k.hashCode()%(defaultLength - 1));
//    }
//
//    private Entry<K, V> getEntry(K k, int index) {
//        for (Entry<K, V> e = table[index]; null != e; e = e.next) {
//            if (e.hash == index && (k == e.getKey() || k.equals(e.getKey()))) { // hash是hashcode还是index?
//                return e;
//            }
//        }
//        return null;
//    }
//
//    class Entry<K, V> implements Map.Entry {
//
//        K k;
//        V v;
//        int hash;
//        Entry<K, V> next;
//
//        public Entry(K k, V v, int hash, Entry<K, V> next) {
//            this.k = k;
//            this.v = v;
//            this.hash = hash;
//            this.next = next;
//        }
//
//        @Override
//        public K getKey() {
//            return k;
//        }
//
//        @Override
//        public V getValue() {
//            return v;
//        }
//    }
//}
