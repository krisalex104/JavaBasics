package datastructure.linkedlist;

import java.util.Scanner;

public class InsertRecursively {
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

    public static Node<Integer> insertRecursively(Node<Integer> head,int pos, int elem){
        if(pos==0){
            Node<Integer> newNode=new Node<>(elem);
            newNode.next=head;
            return newNode;
        }
        if(head==null){
            return head;
        }
        head.next=insertRecursively(head.next,pos-1,elem);
        return head;
    }


    public static void main(String[] args) {
        Node<Integer> node = takeInputBetterApproach();
        Node<Integer> insertRecursively = insertRecursively(node, 8, 10);
        printRecursive(insertRecursively);
    }
}
