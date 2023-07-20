package datastructure.linkedlist;

import test.D;

import java.util.Scanner;
public class ReverseRecursively {

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

    public static Node<Integer> reverseLLRecursive1(Node<Integer> head){
        if(head==null || head.next==null){
            return head;
        }
        Node<Integer> finalHead=reverseLLRecursive1(head.next);
        Node<Integer> temp=finalHead;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head.next=null;
        return finalHead;
    }

    public static DoubleNode reverseLLRecursive2(Node<Integer> head){
        if(head==null || head.next==null){
            DoubleNode ans=new DoubleNode();
            ans.head=head;
            ans.tail=head;
            return ans;
        }
        DoubleNode smallAns=reverseLLRecursive2(head.next);
        smallAns.tail.next=head;
        head.next=null;

        DoubleNode ans=new DoubleNode();
        ans.head=smallAns.head;
        ans.tail=head;
        return ans;
    }
    public static Node<Integer> reverseLLRecursive3(Node<Integer> head){
        if(head==null || head.next==null){
          return head;
        }
       Node<Integer> reversedTail=head.next;
        Node<Integer> smallHead=reverseLLRecursive3(head.next);
        reversedTail.next=head;
        head.next=null;
        return smallHead;
    }


    public static void main(String[] args) {
        Node<Integer> integerNode = takeInputBetterApproach();
      //  integerNode= reverseLLRecursive1(integerNode);
       // printRecursive(integerNode);
//        DoubleNode doubleNode = reverseLLRecursive2(integerNode);
//        integerNode=doubleNode.getHead();
        integerNode=reverseLLRecursive3(integerNode);
        printRecursive(integerNode);

    }

}
