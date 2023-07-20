package datastructure.priorityqueue;

import java.util.*;

public class PriorityQueueUse {

    private static void insertIntoVirtualHeap(int[] arr, int i) {
        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;
        while(childIndex > 0){
            if(arr[childIndex] < arr[parentIndex] ){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }else{
                return;
            }
        }

    }

    private static int removeMinFromVirtualHeap(int[] arr, int heapSize) {

        int temp = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        int index = 0;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        while(leftChildIndex < heapSize){

            int minIndex = index;
            if(arr[leftChildIndex] < arr[minIndex]){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex]){
                minIndex = rightChildIndex;
            }
            if(minIndex != index){
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex]  = temp1;
                index = minIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }else{
                break;
            }
        }
        return temp;
    }

    public static void inplaceHeapSort(int arr[]) {
        for(int i = 0; i < arr.length; i++){
            insertIntoVirtualHeap(arr,i);
        }

        for(int i = 0; i < arr.length; i++){
            arr[arr.length - 1 - i] = removeMinFromVirtualHeap(arr, arr.length - i);
        }
    }

    public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ArrayList<Integer> output=new ArrayList<>();
        int i=0;
        for(;i<k;i++){
            pq.add(input[i]);
        }
        for(;i<input.length;i++){
            int min=pq.element();
            if(min<input[i]){
                pq.remove();
                pq.add(input[i]);
            }
        }
        for(int j=0;j<k;j++){
            output.add(pq.remove());
        }
       return output;
    }

    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        // Write your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> output=new ArrayList<>();
        int i=0;
        for(;i<k;i++){
            pq.add(input[i]);
        }
        for(;i<input.length;i++){
            int max=pq.element();
            if(input[i]<max){
                pq.remove();
                pq.add(input[i]);
            }
        }
        for(int j=0;j<k;j++){
            output.add(pq.remove());
        }
        return output;

    }

    public static boolean checkMaxHeap(int arr[]) {
        return checkMaxHeapHelper(arr,0);
    }

    private static boolean checkMaxHeapHelper(int[] arr, int startIndex)
    {
        //Base case - if the current parent node index (startIndex) is greater than array size,
        //then, we have successfully reached the end of the heap nd at each level the max heap property is satisfied
        //Hence, we return true
        if(startIndex==arr.length)
            return true;

        //Calculate the current indices of the parent and its children
        int parentIndex=startIndex;
        int leftChildIndex=2*parentIndex+1,rightChildIndex=2*parentIndex+2;

        //Assume that the max heap property is satisfied for both children of the current parent
        boolean leftAns=true,rightAns=true;

        //If index of left child > array size, then the left child does not exist. Hence, we retain the leftAns=true
        //If the condition is satisfied, we check if the parent<left child. If it is true, we return false as
        //max heap property is violated. Else, we continue with the checks by making the left child the new parent
        if(leftChildIndex<arr.length)
        {
            if(arr[parentIndex]<arr[leftChildIndex])
                return false;
            else
                leftAns=checkMaxHeapHelper(arr,leftChildIndex);
        }

        //The if-condition for the right child follows same logic as of the left child
        if(rightChildIndex<arr.length)
        {
            if(arr[parentIndex]<arr[rightChildIndex])
                return false;
            else
                rightAns=checkMaxHeapHelper(arr,rightChildIndex);
        }

        //If current parent satisfies the max heap property, then the results for its left and/or right child are
        //used to determine if the property is maintained.
        return (leftAns && rightAns);

    }

    public static int kthLargest(int n, int[] input, int k) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++)
        {
            pq.add(input[i]);
        }

        for(int i=k;i<input.length;i++)
        {
            int minVal=pq.peek();
            if(minVal<input[i]){
                minVal=input[i];
                pq.poll();
                pq.add(minVal);
            }
        }

        int minVal=Integer.MAX_VALUE;
        while(!pq.isEmpty())
        {
            int check=pq.poll();
            if(check<minVal)
                minVal=check;
        }
        return minVal;
    }

    public static int buyTicket(int input[], int k) {

        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<input.length;i++){
            queue.add(i);
            pq.add(input[i]);
        }
        int time=0;
        while (!queue.isEmpty()){
            if (input[queue.peek()] < pq.peek())
            {
                queue.add(queue.poll());
            }
            else
            {
                int idx = queue.poll();
                pq.remove();
                time++;
                if (idx == k)
                {
                    break;
                }
            }
        }
        return time;
    }
    static  class MinPQComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1<o2){
                return -1;
            } else if (o1>02) {
                return 1;
            }
            return 0;
        }
    }

   static class MaxPQComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1<o2){
                return 1;
            } else if (o1>02) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws PriorityQueueException {
     //   Priority_Queue pq=new Priority_Queue();
        int []arr={3,44,5,1,7,8};
//        for(int num:arr){
//            pq.insert(num);
//        }
//
//        while (!pq.isEmpty()){
//            System.out.print(pq.removeMin() + " ");
//        }
//        System.out.println();
        int input[]={87,79,67,15,68,58,89,85,30};

        ArrayList<Integer> arrayList = kLargest(input, 3);
        for(int num:arrayList){
            System.out.print(num +" ");
        }
        System.out.println();

        int kthLargest = kthLargest(4, input, 3);
        System.out.println(kthLargest);
    }
}
