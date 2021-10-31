package es.datastructur.synthesizer;

import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{
    public int capacity();     // return size of the buffer
    public int fillCount();    // return number of items currently in the buffer
    public void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front
    public default boolean isEmpty(){
        if (fillCount() == 0){
            return  true;
        } else {
            return false;
        }
    }
    // is the buffer full (fillCount is same as capacity)?
    public default boolean isFull(){
        if(capacity() == fillCount()){
            return  true;
        } else {
            return false;
        }
    }

}
