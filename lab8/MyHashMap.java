import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class MyHashMap<K, V> implements Map61B<K, V>{

    int size;
    double loadfactor;
    Node<K,V>[] buckets;

    private class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;

    }


    public MyHashMap<K,V>(){
        size = 16;
        loadfactor = 0.75;
        buckets = new Node[size];

    }
    public MyHashMap(int initialSize);
    public MyHashMap(int initialSize, double loadFactor);
    public void clear(){

    }

    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        return false;
    }

    private class MyHahsMapIterator<K> extends Iterable<K> {

    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key);

    /** Returns the number of key-value mappings in this map. */
    public int size();

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    public void put(K key, V value);

    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet();

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    public V remove(K key, V value);
}
