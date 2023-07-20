package datastructure.linkedlist;

import java.util.Scanner;

public class SortEvenOdd {
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
    public static  void printRecursive(Node<Integer> head){
        if(head==null){
            return;
        }

        System.out.print(head.data + " ");
        printRecursive(head.next);
    }

    public static Node<Integer> sortEvenOdd(Node<Integer> head)
    {
        Node<Integer> evenHead=null,evenTail=null,oddHead=null,oddTail=null;
        while(head!=null){
            if(head.data%2==0){
                if(evenHead==null && evenTail==null)
                {
                    evenHead=head;
                    evenTail=head;

                }
                else{
                    evenTail.next=head;
                    evenTail=head;

                }
                head=head.next;
            }
            else{
                if(oddHead==null && oddTail==null)
                {
                    oddHead=head;
                    oddTail=head;
                }
                else{
                    oddTail.next=head;
                    oddTail=head;
                }
                head=head.next;
            }
        }
        if(oddHead!=null){
            oddTail.next=evenHead;
        }
        else{
            return evenHead;
        }
        if(evenHead!=null){
            evenTail.next=null;
        }
        return oddHead;
    }
    public static Node<Integer> sortEvenOdd2(Node<Integer> head)
    {   if(head==null)
        return head;
        if(head.next==null)
            return head;

        Node<Integer> smallHead=sortEvenOdd(head.next);
        Node<Integer> temp=smallHead;
        if(head.data%2==0)
        {   if(temp.data%2==0)
        {head.next=temp;
            return head;}
            while(temp.next!=null && temp.next.data%2!=0)
            {
                temp=temp.next;
            }
            // if(temp.next==null){
            //     head.next=temp;
            //     return head;}

            Node<Integer> t1=temp.next;
            temp.next=head;
            head.next=t1;
            return smallHead;}
        else
        {
            head.next=smallHead;

            return head;}
    }

    public static void main(String[] args) {
        Node<Integer> integerNode = takeInputBetterApproach();
        integerNode= sortEvenOdd(integerNode);
        printRecursive(integerNode);
    }
}
