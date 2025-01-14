package Quizz;
import java.util.Iterator;
/**
 * Complete the implementation of the methods below in the DynamicArrayStack class.
 * It implements a stack abstract data type.
 * Remember: A dynamic array is an array that resizes itself as needed
 *           (double its size when full, halve its size when one-quarter full).
 *
 * - You cannot use any Java collections, only arrays are allowed in your implementation.
 * - Leave the interface unchanged but feel free to modify DynamicArrayStack.
 * - In DynamicArrayStack, you can add fields, methods, and nested classes if you want.
 *
 * Notice that the iterator should iterate over the elements in the stack from top to bottom.
 *
 * The amortized time complexity of the methods push/pop is O(1),
 * although in some cases it can be O(n).
 */
public interface Stack<T> extends Iterable<T> {

    /**
     * @param item the item to be pushed onto this stack
     */
    void push(T item);

    /**
     * @return the item at the top of this stack and removes it
     */
    T pop();

    /**
     * @return the item at the top of this stack without removing it
     */
    T peek();

    /**
     * @return true if this stack is empty
     */
    boolean isEmpty();

    /**
     * @return the number of items in this stack
     */
    public int size();
}

/**
 * Implementation of a stack using a dynamic array.
 * The size of the array is doubled when the stack is full
 * and halved when the stack is one-quarter full.
 */

class DynamicArrayStack<T> implements Stack<T> {
    private T[] array;
    private int size;
    /**
     * Construct the data structure with the given initial capacity.
     */
    public DynamicArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        array = (T[]) new Object[initialCapacity];
        size = 0;
    }é

    @Override
    public void push(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }else if(size==(array.length/4)){
            resize(array.length+(array.length/2));
        }
        array[size++] = item;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
        T item = array[--size];
        array[size] = null;

        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }

        return item;}
        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return array[size - 1];
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
    return false;}

    @Override
    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Don't forget that the iterator should iterate
    // over the elements in the stack from top to bottom.
    //
    // You can assume that there will be no modification
    // of the stack while it is iterated over.
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = size - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    return null;
                }
                return array[currentIndex--];
            }
        };
    }
}
