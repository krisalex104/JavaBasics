package datastructure.linkedlist;

import java.util.Scanner;

public class DeleteEveryNNodes {
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
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if(head==null)
            return head;
        if(M==0)
            return null;
        if(N==0)
            return head;
        Node<Integer> curr=head,t;
        int count;
        while(curr!=null)
        {
            for(count=1;count<M && curr!=null;count++)
            {
                curr=curr.next;
            }
            if(curr==null)
                return head;
            t=curr.next;
            for(count=1;count<=N && t!=null;count++)
            {
                t=t.next;
            }
            curr.next=t;
            curr=t;}
        return head;

    }
    public static void main(String[] args) {

    }
}
