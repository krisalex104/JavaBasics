package datastructure.linkedlist;

public class PalindromeLinkedList {
    public static boolean isPalindrome(Node<Integer> head) {
        //Your code goes here
        Node<Integer> slow = head;
        Node<Integer> fast =  head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow=slow.next;
        }
        //here slow which is latter half of linked list is reversed
        slow = reversed(slow);
        fast = head;
        while(slow!=null)
        {
            //Now if step by setp data at both halves of linked list doesn't match
            if(slow.data.equals(fast.data))
            {
                slow = slow.next;
                fast = fast.next;
            }
            //then false will be returned
            else {
                return false;
            }
        }
        //if both halves of the linked list are same, then true is returned
        return true;
    }
    //Reversing a Linked List function
    public static Node <Integer> reversed(Node <Integer> root)
    {
        Node <Integer> prev = null;
        Node <Integer> next = null;
        while(root!=null)
        {
            next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        //we are returning prev as to return the reversed linked list
        return prev;

    }
}
