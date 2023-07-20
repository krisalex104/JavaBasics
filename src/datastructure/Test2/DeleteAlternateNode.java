package datastructure.Test2;

public class DeleteAlternateNode {

    public static void deleteAlternateNodes(Node<Integer> head) {
        //Your code goes here
        if (head == null || head.next == null) {
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (prev != null && curr != null) {
            prev.next = curr.next;
            curr = null;

            if (prev.next != null) {
                prev = prev.next;
                curr = prev.next;
            }
        }
    }
}
