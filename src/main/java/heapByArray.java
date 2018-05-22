/**
 * Created by Ealing on 4/17/18.
 */
import java.util.*;

public class heapByArray {
    private final int capacity;
    private int[] array;
    private int size;

    public heapByArray(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        size = 0;
    }

    public void insert(int newVal) {
        if (size == capacity) {
            remove();
        }

        array[size] = newVal;
        size++;
        moveUp();
    }

    private int remove() {
        int max = array[0];
        array[0] = array[size-1];
        size--;
        moveDown();
        return max;
    }

    private void moveUp() {
        int cur = size - 1;
        int val = array[cur];
        int parent = (cur - 1) / 2;

        while (cur > 0 && val > array[parent]) {
            array[cur] = array[parent];
            cur = parent;
            parent = (cur - 1) / 2;
        }
        array[cur] = val;
    }

    private void moveDown() {
        int cur = 0;
        int val = array[cur];

        while (cur < size / 2) {
            int leftChild = 2 * cur + 1;
            int rightChild = 2 * cur + 2;
            int largeChild;

            if (rightChild >= size) {
                largeChild = leftChild;
            } else {
                largeChild = (array[leftChild] >= array[rightChild])? leftChild:rightChild;
            }

            if (val >= array[largeChild]) {
                break;
            }
            array[cur] = array[largeChild];
            cur = largeChild;
        }
        array[cur] = val;
    }
}