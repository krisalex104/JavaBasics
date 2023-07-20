package datastructure.linkedlist;


import java.util.Scanner;

public class FindMidPoint {
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

    public static void print(Node<Integer> head){
        Node<Integer> temp = head;

        while(temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> node = takeInputBetterApproach();
        Node<Integer> midPoint = midPoint(node);
        print(midPoint);
    }
}
