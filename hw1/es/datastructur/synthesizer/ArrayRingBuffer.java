package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        int pos;
        public ArrayRingBufferIterator(){
            pos = first;
        }
        @Override
        public boolean hasNext() {
            return pos != last;
        }

        @Override
        public T next() {
            int temp = pos;
            pos = (pos + 1) % capacity();
            return rb[temp];
        }

    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArrayRingBuffer<T> o = (ArrayRingBuffer<T>) other;
        if (o.capacity() != this.capacity()) {
            return false;
        }
        if (o.fillCount != this.fillCount) {
            return false;
        }
        int i = this.first;
        int j = o.first;
        while (i != last) {
            if (!this.rb[i].equals(o.rb[j])) {
                return false;
            }
            i = (i + 1) % this.capacity();
            j = (j + 1) % o.capacity();

        }
        return true;
    }

    @Override
    public int capacity(){
        return rb.length;
    }// return size of the buffer

    @Override
    public int fillCount(){
        return fillCount;
    }    // return number of items currently in the buffer

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        fillCount = 0;
        first = 0;
        last = 0;
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        if (fillCount == capacity()){
            throw new RuntimeException("Ring buffer overflow");
        } else {
            rb[last] = x;
            last = (last + 1) % capacity();
            fillCount++;
        }
        return;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
        fillCount--;
        T temp = rb[first];
        rb[first] = null;
        first = (first + 1) % capacity();
        return temp;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        if (fillCount == 0){
            throw new RuntimeException("Ring buffer underflow");
        } else {
            return rb[first];
        }
        // TODO: Return the first item. None of your instance variables should
        //       change.test
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.


}
    // TODO: Remove all comments that say TODO when you're done.
