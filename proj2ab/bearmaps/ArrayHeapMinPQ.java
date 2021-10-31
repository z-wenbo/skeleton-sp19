package bearmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {
    private ArrayList<Node> items;
    private HashMap<T,Integer> itemToIndex;
    private int size;

    public ArrayHeapMinPQ(){
        items = new ArrayList<>();
        size = 0;
        items.add(null);
        itemToIndex = new HashMap();
        itemToIndex.put(null,0);
    }

    @Override
    public void add(T item, double priority) {
        if (item == null || contains(item)) throw new IllegalArgumentException();
        items.add(new Node(item, priority));
        size += 1;
        itemToIndex.put(item,size);
        swim(size);

    }

    private void swim(int k){
        if (k == 1) return;
        if (items.get(parent(k)).compareTo(items.get(k)) > 0) {
            exchange(parent(k),k);
            swim(parent(k));
        }
    }

    private void sink(int k){
        if(2*k > size) return;
        if(items.get(k).compareTo(items.get(2*k))>0) {
            if(2*k+1<=size &&items.get(k).compareTo(items.get(2*k+1))>0){
                if(items.get(2*k).compareTo(items.get(2*k+1))>0) {
                    exchange(k, 2*k+1);
                    sink(2*k+1);
                } else  {
                    exchange(k, 2*k);
                    sink(2*k);
                }
                return;
            }
            exchange(k, 2 * k);
            sink(2*k);
        } else if(2*k+1<=size &&items.get(k).compareTo(items.get(2*k+1))>0) {
            exchange(k, 2 * k +1);
            sink(2*k+1);
        }

    }

    private static int parent(int k){
        return k/2;
    }

    @Override
    public boolean contains(T item) {
        return itemToIndex.containsKey(item);
    }

    @Override
    public T getSmallest() {
        return items.get(1).getItem();
    }

    @Override
    public T removeSmallest() {
        if (size() == 0) throw new NoSuchElementException();
        T temp = items.get(1).item;
        exchange(1,size);
        items.remove(size);
        itemToIndex.remove(temp);
        size --;
        sink(1);
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void changePriority(T item, double priority) {
        if (size() == 0 || !contains(item)) throw new NoSuchElementException();
        int index = itemToIndex.get(item);
        double oldPriority = items.get(index).getPriority();
        items.get(index).setPriority(priority);
        if (priority < oldPriority) {
            swim(index);
        } else if (priority > oldPriority) {
            sink(index);
        }
    }

    private void exchange(int i, int j){
        Node temp = items.get(i);
        itemToIndex.put(items.get(i).item,j);
        itemToIndex.put(items.get(j).item,i);
        items.set(i,items.get(j));
        items.set(j,temp);
    }

    private class Node implements Comparable<Node> {
        private T item;
        private double priority;

        Node(T e, double p) {
            this.item = e;
            this.priority = p;
        }

        T getItem() {
            return item;
        }

        double getPriority() {
            return priority;
        }

        void setPriority(double priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(Node other) {
            if (other == null) {
                return -1;
            }
            return Double.compare(this.getPriority(), other.getPriority());
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            } else {
                return ((Node) o).getItem().equals(getItem());
            }
        }

        @Override
        public int hashCode() {
            return item.hashCode();
        }

        }
    }
