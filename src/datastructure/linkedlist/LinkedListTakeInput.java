package datastructure.linkedlist;

import java.util.Scanner;

public class LinkedListTakeInput {
    public static Node<Integer> takeInput(){
        Node<Integer> head=null;
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        while(data!=-1){
            Node<Integer> newNode=new Node<>(data);
            if(head==null){
                head=newNode;
            }else{
                Node<Integer> temp=head;
                while (temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newNode;
            }
            data= sc.nextInt();
        }
        return head;
    }

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
    public static void main(String[] args) {
       // Node<Integer> node = takeInput();
        Node<Integer> node = takeInputBetterApproach();
        print(node);
    }
}
