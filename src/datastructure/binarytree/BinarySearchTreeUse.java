package datastructure.binarytree;

import java.util.ArrayList;

public class BinarySearchTreeUse {
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return false;
        }

        if (root.data == k) {
            return true;
        }

        boolean dataPresent;
        if (root.data > k) {
            dataPresent = searchInBST(root.left, k);
        } else {
            dataPresent = searchInBST(root.right, k);
        }
        return dataPresent;
    }

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null) {
            return;

        }


        if (root.data > k1) {
            elementsInRangeK1K2(root.left, k1, k2);
        }

        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }

        if (root.data < k2) {
            elementsInRangeK1K2(root.right, k1, k2);
        }

    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.data > root.data) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.data < root.data) {
                return false;
            }
        }
        return isBST(root.left) && isBST(root.right);
    }


    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return constructBST(arr, 0, arr.length - 1);
    }

    private static BinaryTreeNode<Integer> constructBST(int[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(sortedArray[mid]);

        root.left = constructBST(sortedArray, start, mid - 1);
        root.right = constructBST(sortedArray, mid + 1, end);

        return root;
    }

    public static class PassNode<T> {
        T head;
        T tail;
    }

   public static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        PassNode<LinkedListNode<Integer>> passNode = constructLinkedListHelper(root);
        return passNode.head;
    }

    public static PassNode<LinkedListNode<Integer>> constructLinkedListHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new PassNode<LinkedListNode<Integer>>();
        }

        if (root.left == null && root.right == null) {
            PassNode<LinkedListNode<Integer>> passNode = new PassNode<LinkedListNode<Integer>>();
            passNode.head = new LinkedListNode<Integer>(root.data);
            passNode.tail = null;
            return passNode;
        }

        PassNode<LinkedListNode<Integer>> passNodeLeft = constructLinkedListHelper(root.left);
        PassNode<LinkedListNode<Integer>> passNodeRight = constructLinkedListHelper(root.right);
        PassNode<LinkedListNode<Integer>> passNode = new PassNode<LinkedListNode<Integer>>();
        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);

        if (passNodeLeft.head == null) {
            passNode.head = newNode;
            //passNode.tail=newNode;
        } else {
            passNode.head = passNodeLeft.head;
        }

        if (passNodeLeft.tail == null) {
            passNode.head.next = newNode;
            passNode.tail = newNode;
        } else {
            passNodeLeft.tail.next = newNode;
            passNode.tail = newNode;
        }

        if (passNodeRight.head != null) {
            passNode.tail.next = passNodeRight.head;
            passNode.tail = passNodeRight.head;
        }

        if (passNodeRight.tail != null) {
            passNode.tail = passNodeRight.tail;
        }

        return passNode;

    }

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
        if(root==null){
            return null;
        }
        ArrayList<Integer> output=new ArrayList<>();
        if(root.data==data){
            output.add(root.data);
            return output;
        }

        if(data<root.data){
            output=getPath(root.left, data);
            if(output!=null){
                output.add(root.data);
            }
        }else{
            output=getPath(root.right, data);
            if(output!=null){
                output.add(root.data);
            }
        }
        return output;
    }

    public static int getLCA(BinaryTreeNode<Integer> root, int n1, int n2) {
        if (root == null)
            return -1;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.data > n1 && root.data > n2)
            return getLCA(root.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.data < n1 && root.data < n2)
            return getLCA(root.right, n1, n2);

        return root.data;


    }

    public static void main(String[] args) {

    }
}
