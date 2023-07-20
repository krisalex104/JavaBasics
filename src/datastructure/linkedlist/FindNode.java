package datastructure.linkedlist;

import java.util.Scanner;

public class FindNode {

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

    public static int findNode(Node<Integer> head, int n) {
        // Write your code here.
        if(head==null){
            return -1;
        }
        int count=0;
        Boolean b=Boolean.FALSE;
        Node<Integer> temp=head;
        while (temp!=null){
            if(temp.data==n){
                b=Boolean.TRUE;
                break;
            }else{
                count++;
                temp=temp.next;
            }
        }
        if(b){
            return count;
        }else{
            return -1;
        }
    }

    public static int findNodeRecursive(Node<Integer> head , int n){
       return helper(head,0,n);
    }
    public static int helper(Node<Integer> head,int index,int n){
        if(head==null)
            return -1;
        if(head.data==n)
            return index;
        int ans= helper(head.next,index+1,n);
        return ans;
    }

    public static void main(String[] args) {
        Node<Integer> node = takeInputBetterApproach();
    //    int index = findNode(node, 2);
        int nodeRecursive = findNodeRecursive(node,4);
        System.out.println(nodeRecursive);
    }
}
