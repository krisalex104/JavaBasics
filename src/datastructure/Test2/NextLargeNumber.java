package datastructure.Test2;

public class NextLargeNumber {
    public static Node<Integer> nextLargeNumber(Node<Integer> head) {
        Node<Integer> temp;
        Node<Integer> prev =null;
        Node<Integer> curr=head;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        Node<Integer> tem=prev;
        int extra=0;
        Node<Integer> a= new Node<Integer>(1);
        while(tem!=null){
            if(tem.data==9){
                tem.data=0;
                extra=1;
                if(tem.next==null){
                    tem.next=a;
                }
            }else{
                if(extra==1){
                    int d=tem.data+1;
                    if(d==10){
                        tem.data=0;
                        extra=1;
                    }else{
                        extra=0;
                    }
                }else{
                    tem.data=tem.data+1;
                    break;
                }}
            tem=tem.next;
        }
        Node<Integer> temp1;
        Node<Integer> prev1 =null;
        Node<Integer> curr1=prev;
        while(curr1!=null){
            temp1=curr1.next;
            curr1.next=prev1;
            prev1=curr1;
            curr1=temp1;
        }
        return prev1;
    }
}
