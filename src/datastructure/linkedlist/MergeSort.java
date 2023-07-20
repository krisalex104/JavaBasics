package datastructure.linkedlist;

import java.util.Scanner;

public class MergeSort {

    public static Node<Integer> takeInputBetterApproach(){
        Node<Integer> head=null,tail=null;
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        while(data!=-1){
            Node<Integer> newNode=new Node<>(data);
            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode; //tail=tail.next;
            }
            data= sc.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head){
        Node<Integer> temp = head;

        while(temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node<Integer> midPoint(Node<Integer> head) {
        //Your code goes here
        if(head==null){
            return null;
        }

        Node<Integer> slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        Node<Integer> t1=head1,t2=head2,tail=null,head=null;
        if(t1.data<=t2.data)
        {
            head=t1;
            tail=t1;
            t1=t1.next;
        }
        else
        {
            head=t2;
            tail=t2;
            t2=t2.next;
        }
        while(t1!=null &&t2!=null)
        {
            if(t1.data<=t2.data)
            {
                tail.next=t1;
                tail=t1;
                t1=t1.next;
            }
            else
            {
                tail.next=t2;
                tail=tail.next;
                t2=t2.next;
            }
        }
        if(t1==null)
            tail.next=t2;
        if(t2==null)
            tail.next=t1;
        return head;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        //Your code goes here
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        Node<Integer> midNode=midPoint(head);
        Node<Integer> h2=midNode.next;
        midNode.next=null;
        Node<Integer> part1=mergeSort(head);
        Node<Integer> part2=mergeSort(h2);
        Node<Integer> mergedList=mergeTwoSortedLinkedLists(part1,part2);
        return mergedList;
    }

    public static void main(String[] args) {
        Node<Integer> integerNode = takeInputBetterApproach();
        Node<Integer> mergeSort = mergeSort(integerNode);
        print(mergeSort);

    }
}
