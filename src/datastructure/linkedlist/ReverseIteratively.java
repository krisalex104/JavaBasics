package datastructure.linkedlist;

import java.util.Scanner;

public class ReverseIteratively {

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

    public static Node<Integer> reverseIteratively(Node<Integer> head){
        Node<Integer> curr=head,prev=null;
        Node<Integer> temp;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node<Integer> integerNode = takeInputBetterApproach();
        Node<Integer> node = reverseIteratively(integerNode);
        printRecursive(node);

    }
}
