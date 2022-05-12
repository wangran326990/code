package data;

public class Pair <K, V>{
    private K k;
    private V v;
    public Pair(K key, V value) {
       this.k = key;
       this.v= value;
    }
    public K getKey() {
        return this.k;
    }

    public V getValue() {
        return this.v;
    }
}
