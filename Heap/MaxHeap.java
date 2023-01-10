package Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    List<Integer> container;
    int size;

    MaxHeap() {
        container = new ArrayList<>();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    MaxHeap(int[] arr) {
        container = new ArrayList<>();
        size = arr.length;
        for (int i: arr)
            container.add(i);

        build();
    }


    private void heapify (int index) {
        int last = (size-2)/2;
        while (index <= last) {
            int max = index;
            int left = (index*2)+1;
            int right = (index*2)+2;

            if (container.get(left) < container.get(max))
                max = left;
            if (right < size && container.get(right) > container.get(max))
                max = right;

            if (max == index) return;

            int temp = container.get(max);
            container.set(max, container.get(index));
            container.set(index, temp);

            index = max;
        }
    }

    private void build() {
        if (size == 0) return;
        int last = (size-2)/2; // last

        for (int i = last; i >= 0; i--) {
            heapify(i);
        }
    }

    public void insert(int num) {
        size++;
        if (size == 0) container.add(num);
        else {
            container.add(num);
            int index = size-1;
            while (index > 0 && container.get(index) > container.get((index-1)/2)) {
                int temp = container.get(index);
                container.set(index, container.get((index-1)/2));
                container.set((index-1)/2, temp);

                index = (index-1)/2;
            }
        }
    }

    public int top() {
        if (size == 0) return -1;
        else return container.get(0);
    }

    public int pop() {
        if (size == 0) return -1;
        int top = container.get(0);
        container.set(0, container.get(size-1));
        container.remove(size-1);

        heapify(0);

        size--;
        return top;
    }
}
