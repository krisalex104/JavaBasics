package datastructure.linkedlist;

import java.util.Scanner;

public class DeleteNodeRecursively {

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

    public static Node<Integer> deleteRecursively(Node<Integer> head,int pos){
        if(pos==0 && head!=null){
            return head.next;
        }
        if(head==null){
            return head;
        }
      head.next=deleteRecursively(head.next,pos-1);
        return head;
    }
    public static void main(String[] args) {
        Node<Integer> integerNode = takeInputBetterApproach();
        Node<Integer> deleteRecursively = deleteRecursively(integerNode, 5);
        printRecursive(deleteRecursively);
    }
}
