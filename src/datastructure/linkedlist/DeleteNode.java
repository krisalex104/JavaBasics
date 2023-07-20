package datastructure.linkedlist;

import java.util.Scanner;

public class DeleteNode {
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

    public static Node<Integer> delete(Node<Integer> head,int position){


        if(head==null )
            return null;

        if(position==0 && head.next!=null){
            head=head.next;
            return head;
        }

        int i=0;
        Node<Integer> temp=head;
        while(i<position-1 && temp.next!=null){
            temp=temp.next;
            i++;
        }
        if(temp.next!=null) {
            temp.next = temp.next.next;
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
        Node<Integer> head = takeInputBetterApproach();
        Node<Integer> node = delete(head,  0);
        print(node);

    }
}
