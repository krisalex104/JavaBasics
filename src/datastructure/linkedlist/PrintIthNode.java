package datastructure.linkedlist;

import java.util.Scanner;

public class PrintIthNode {

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

    public static void printIthNode(Node<Integer> head, int i){
        //Your code goes here
        int count=0;
        if(head==null){
            return;
        }
        Node<Integer> temp=head;
        while(temp!=null && i>0){
            if(count==i){
                System.out.println(temp.data);
                break;
            }
            count++;
            temp=temp.next;
        }

    }

    public static void main(String[] args) {
        Node<Integer> node = takeInputBetterApproach();
        printIthNode(node,2);
    }
}
