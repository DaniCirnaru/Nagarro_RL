package com.nagarro.remotelearning;

import com.nagarro.remotelearning.exceptions.PriorityQueueEmptyException;
import com.nagarro.remotelearning.exceptions.PriorityQueueFullException;

import java.util.ArrayList;
import java.util.List;

public class CustomPriorityQueue<E extends Comparable<E>> implements Comparable<CustomPriorityQueue<E>> {
    public static final int DEFAULT_MAX_SIZE = 10000;
    private List<E> heap;
    private int maxSize;

    public CustomPriorityQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    public CustomPriorityQueue(int maxSize) {
        this.heap = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public int getSize() {
        return heap.size();
    }

    public void insert(E e) {
        if (heap.size() >= maxSize)
            throw new PriorityQueueFullException();

        heap.add(e);
        heapifyUp(heap.size() - 1);
    }

    public E remove() {
        if (isEmpty())
            throw new PriorityQueueEmptyException();

        E removed = heap.get(0);
        E last = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return removed;
    }

    public void clear() {
        heap.clear();
    }

    public E head() {
        if (isEmpty())
            throw new PriorityQueueEmptyException();

        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) <= 0)
                break;

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(largest)) > 0)
                largest = leftChild;

            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(largest)) > 0)
                largest = rightChild;

            if (largest == index)
                break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public int compareTo(CustomPriorityQueue<E> other) {
        if (isEmpty() && other.isEmpty())
            return 0;
        else if (isEmpty())
            return -1;
        else if (other.isEmpty())
            return 1;
        else
            return head().compareTo(other.head());
    }

    public <E extends Comparable<E>> List<E> sort(List<E> inputList) {
        CustomPriorityQueue<E> priorityQueue = new CustomPriorityQueue<>(inputList.size());
        List<E> sortedList = new ArrayList<>(inputList.size());

        for (E element : inputList) {
            priorityQueue.insert(element);
        }

        while (!priorityQueue.isEmpty()) {
            sortedList.add(priorityQueue.remove());
        }

        return sortedList;
    }

}
