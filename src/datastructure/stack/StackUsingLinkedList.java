package datastructure.stack;

public class StackUsingLinkedList<T> {
    private Node<T> head;
    private  int size;

    public StackUsingLinkedList(){
        head=null;
        size=0;
    }

    public int size(){
       return size;
    }
     public boolean isEmpty(){
       return size()==0;
     }

     T top() throws StackEmptyException {
         if(size()==0){
             StackEmptyException e=new StackEmptyException();
             throw e;
         }
        return head.data;
     }

     void push(T element){
       Node<T> newNode=new Node<>(element);
       newNode.next=head;
       head=newNode;
       size++;
     }

     T pop() throws StackEmptyException {
         if(size()==0){
             StackEmptyException e=new StackEmptyException();
             throw e;
         }
        T temp=head.data;
        head= head.next;
        size--;
       return temp;
     }
}
