package datastructure.priorityqueue;

import java.util.*;

public class MergeKSortedArray {
    public static ArrayList<Integer> mergeArrays(ArrayList<ArrayList<Integer>> arrays) {
        // Create a min-heap
        PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>();

        // Initialize the min-heap with the first element from each array
        for (int i = 0; i < arrays.size(); i++) {
            ArrayList<Integer> array = arrays.get(i);
            if (!array.isEmpty()) {
                minHeap.add(new ArrayElement(array.get(0), i, 0));
            }
        }

        // Merge the arrays using the min-heap
        List<Integer> mergedList = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayElement element = minHeap.poll();
            mergedList.add(element.value);

            ArrayList<Integer> array = arrays.get(element.arrayIndex);
            int nextIndex = element.index + 1;
            if (nextIndex < array.size()) {
                minHeap.add(new ArrayElement(array.get(nextIndex), element.arrayIndex, nextIndex));
            }
        }

        // Convert the merged list to an array
        ArrayList<Integer> mergedArray = new ArrayList<>(mergedList.size());
        for (int i = 0; i < mergedList.size(); i++) {
            mergedArray.add(i, mergedList.get(i));
        }

        return mergedArray;
    }

    // Helper class to represent an element from the arrays
    static class ArrayElement implements Comparable<ArrayElement> {
        int value;
        int arrayIndex;
        int index;

        public ArrayElement(int value, int arrayIndex, int index) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayElement other) {
            return Integer.compare(this.value, other.value);
        }
    }

    /*
    * You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers,
    * print the resulting median.
    Print only the integer part of the median.*/
    public static void findMedian(int arr[]) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            // Add the number to the appropriate heap
            if (maxHeap.isEmpty() || num < maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Balance the heaps if necessary
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            }

            // Print the median
            if (maxHeap.size() == minHeap.size()) {
                int median = (maxHeap.peek() + minHeap.peek()) / 2;
                System.out.print(median + " ");
            } else {
                int median = maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
                System.out.print(median + " ");
            }
        }

    }

}
