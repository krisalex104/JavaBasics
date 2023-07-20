package datastructure.priorityqueue;

import java.util.ArrayList;

public class Priority_Queue {

    private ArrayList<Integer> heap;

    public Priority_Queue() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public int getMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }
        return heap.get(0);
    }

    public void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws PriorityQueueException {
        // Complete this function
        // Throw the exception PriorityQueueException if queue is empty
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        int value = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while ((leftChildIndex < heap.size())) {

            if (heap.get(leftChildIndex) < heap.get(minIndex)) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
                minIndex = rightChildIndex;
            }
            if (index == minIndex) {
                break;
            } else {
                int temp = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp);
                index = minIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }

        return value;
    }

    void insertMax(int element) {
        // Implement the insert() function here
        //Insert new element at the end of the arraylist
        heap.add(element);
        int childIndex=heap.size()-1;
        int parentIndex=(childIndex-1)/2;

        while(parentIndex>=0)
        {
            //Check if parent has lesser priority than the child. If it does, swap them
            if(heap.get(childIndex)>heap.get(parentIndex))
            {
                int temp=heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex,temp);

                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;

            }
            else
            {
                return;
            }
        }

    }

    int removeMax() {
        // Implement the removeMax() function here
        if(heap.isEmpty())
            return Integer.MIN_VALUE;

        //Remove the Max element and store it
        int maxEle=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //Start reinstating max. heap property from root to leaf
        int parentIndex=0;
        int leftChildIndex=2*parentIndex+1, rightChildIndex=2*parentIndex+2;

        while(leftChildIndex<heap.size())
        {
            int maxIndex=parentIndex;
            if(heap.get(maxIndex)<heap.get(leftChildIndex))
            {
                maxIndex=leftChildIndex;
            }

            if(rightChildIndex<heap.size())
            {
                if(heap.get(maxIndex)<heap.get(rightChildIndex))
                {
                    maxIndex=rightChildIndex;
                }
            }

            if(maxIndex==parentIndex)
            {
                return maxEle;
            }

            int temp=heap.get(maxIndex);
            heap.set(maxIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);

            parentIndex=maxIndex;
            leftChildIndex=2*parentIndex+1;
            rightChildIndex=2*parentIndex+2;
        }

        return maxEle;
    }
}

class PriorityQueueException extends Exception {

}
