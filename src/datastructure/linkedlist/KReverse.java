package datastructure.linkedlist;

public class KReverse {
    private static DoubleNode reversePart(Node<Integer> head)
    {
        if(head==null || head.next==null)
        { DoubleNode ans=new DoubleNode();
            ans.head=head;
            ans.tail=head;
            return ans;}

        DoubleNode ans=reversePart(head.next);
        ans.tail.next=head;
        head.next=null;
        ans.tail=ans.tail.next;
        return ans;
    }
    public static Node<Integer> kReverse(Node<Integer> head, int k) {
        //Your code goes here
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        if(k==0)
            return head;
        Node<Integer> h1=head,h2,t1=head;
        int count=1;
        while(count<k && t1.next!=null)
        {
            t1=t1.next;
            count++;
        }

        h2=t1.next;
        t1.next=null;


        DoubleNode ans=reversePart(h1);
        Node<Integer> secondHead=kReverse(h2,k);
        ans.tail.next=secondHead;
        return ans.head;
    }

}


