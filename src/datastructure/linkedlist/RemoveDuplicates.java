package datastructure.linkedlist;

public class RemoveDuplicates {
    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        //Your code goes here
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        Node<Integer> t1=head,t2=head.next;
        Node<Integer> finalhead=head;
        while(t2!=null){
            if(t1.data.equals(t2.data))
            {
                t2=t2.next;
            }
            else{
                t1.next=t2;
                t1=t2;
            }
        }

        t1.next=null;
        return finalhead;
    }
}
