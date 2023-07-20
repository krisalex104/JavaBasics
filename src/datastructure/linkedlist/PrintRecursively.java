package datastructure.linkedlist;

import java.util.Scanner;

public class PrintRecursively {
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

    public static  void printRecursiveReverse(Node<Integer> head){
        if(head==null){
            return;
        }
        printRecursiveReverse(head.next);
        System.out.print(head.data + " ");
    }
    public static void fun(Node<Integer> head) {
        if (head == null)
            return;

        fun(head.next);
        System.out.print(head.data);
    }

    public static void main(String[] args) {
        Node<Integer> node = takeInputBetterApproach();
//        printRecursive(node);
//        printRecursiveReverse(node);
        fun(node);
    }
}
