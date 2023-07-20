package datastructure.linkedlist;

public class AppendLastNNodes {
    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
        //Your code goes here
        int count=0;
        Node<Integer>  temp=head;
        if(head==null || n==0){
            return head;
        }
        while(temp!=null ){
            temp=temp.next;
            count++;
        }
        int newcount=count-n;
        count=0;
        Node<Integer> temp1=head;
        while(count<newcount-1){
            temp1=temp1.next;
            count++;
        }
        Node<Integer> temp2=temp1.next;
        Node<Integer> temp3=temp1.next;
        while(temp2.next!=null){
            temp2=temp2.next;
        }
        temp2.next=head;
        temp1.next=null;
        return temp3;

    }
}
