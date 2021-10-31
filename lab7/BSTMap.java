import java.util.Set;
import java.util.Iterator;
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
     private BST root;
     private int size;

    /** Removes all of the mappings from this map. */
    private class BST<K, V> {
        protected K label;
        protected V value;
        protected BST<K, V> left, right;

        public BST(K l, V v) {
            label = l;
            value = v;
            left = null;
            right = null;
        }
    }

    public BSTMap (){
        root = null;
        size = 0;
    }

    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear(){

        root = null;
        size = 0;
    }

   private V find(BST<K, V> t, K k){
       if (t== null) {
           return null;
       }
        if (t.label.equals(k)){
            return t.value;
        }
        if (k.compareTo(t.label) < 0) {
            return find(t.left, k);
        } else {
            return find(t.right, k);
        }
    }

    private V find(K k){
        if (k == null) {
            throw new IllegalArgumentException();
        }
        return (V) find(root, k);
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        return find(key) != null;

    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key) {
        return (V) this.find(root, key);
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value){
        root = put(root, key, value);
    }

    private BST<K, V> put(BST<K,V> t, K k, V v) {
        if (t == null) {
            size++;
            return new BST<>(k,v);
        }
        if (t.label.equals(k)) {
            t.value = v;
        }
        if (t.label.compareTo(k) > 0) {
            t.left = put(t.left, k, v);
        }
        if (t.label.compareTo(k) < 0) {
            t.right = put(t.right, k, v);
        }
        return t;
    }

    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    public void printInOrder(){}

}
