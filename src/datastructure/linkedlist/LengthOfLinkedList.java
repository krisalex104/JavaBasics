package datastructure.linkedlist;

import java.util.Scanner;

public class LengthOfLinkedList {
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



    public static int length(Node<Integer> head){
        //Your code goes here
        int count=1;
        if(head==null){
            return 0;
        } else if (head.next==null) {
            return 1;
        }
        Node<Integer> temp=head;
        while (temp.next!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Node<Integer> node = takeInputBetterApproach();
        int length = length(node);
        System.out.println(length);
    }
}
