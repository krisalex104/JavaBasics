package datastructure.queue;

import java.util.Queue;

public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> input) {
        //Your code goes here
        if (input.size()==0 || input.size()==1)
        {
            return;
        }

        int temp=input.remove();
        reverseQueue(input);
        input.add(temp);
    }

    public static void main(String[] args) {

    }
}
