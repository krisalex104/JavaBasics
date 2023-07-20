package datastructure.binarytree;

import java.util.ArrayList;
import java.util.Collections;

class LargestBst{
    Integer min;
    Integer max;
    Integer height;
    Boolean isBst;

}
public class BinarySearchTree {
    BinaryTreeNode<Integer> root;

    public static LargestBst findLargestBst(BinaryTreeNode<Integer> root){
        if(root==null){
            LargestBst output=new LargestBst();
            output.min=Integer.MAX_VALUE;
            output.max=Integer.MIN_VALUE;
            output.isBst=true;
            output.height=0;
            return output;
        }

        LargestBst leftLargest = findLargestBst(root.left);
        LargestBst rightLargest = findLargestBst(root.right);

        Integer min=Math.min(root.data,Math.min(leftLargest.min,rightLargest.min));
        Integer max=Math.min(root.data,Math.min(leftLargest.max,rightLargest.max));

        boolean finalBst=(root.data> leftLargest.max && root.data<= rightLargest.min && leftLargest.isBst && rightLargest.isBst);
        LargestBst output=new LargestBst();
        output.min=min;
        output.max=max;
        output.isBst=finalBst;
        if(finalBst){
            output.height= 1+ Math.max(leftLargest.height,rightLargest.height);
        }else{
            output.height= Math.max(leftLargest.height,rightLargest.height);
        }
        return output;

    }

    public boolean hasData(int data) {
        return hasData(root, data);
    }

    private boolean hasData(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        } else if (root.data > data) {
            return hasData(root.left, data);

        } else {
            return hasData(root.right, data);
        }
    }

    public void insert(int data){
        root=insert(root,data);
    }

    private  BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root,int data){
        if(root==null){
            BinaryTreeNode<Integer> newNode=new BinaryTreeNode<>(data);
            return newNode;
        }

        if(root.data>data){
           root.left=insert(root.left,data);
        }else{
            root.right=insert(root.right,data);
        }
        return root;
    }

    public void deleteNode(int data){
        root=deleteNode(root,data);
    }

    private BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root,int data){
        if(root==null){
            return null;
        }
        if(data< root.data){
            root.left=deleteNode(root.left,data);
            return root;
        } else if (data> root.data) {
            root.right=deleteNode(root.right,data);
            return root;
        }else {
            if(root.left==null && root.right==null){
                return null;
            } else if (root.left==null) {
                return root.right;
            } else if (root.right==null) {
                return root.left;
            }else{
                //getting minimum from the right node side
                BinaryTreeNode<Integer> minNode=root.right;
                while (minNode!=null){
                    minNode=minNode.left;
                }
                root.data=minNode.data;
                root.right=deleteNode(root.right,minNode.data);
                return root;
            }
        }
    }

    public void printTree() {
        //Implement the printTree() function
        printTreeDetailed(root);
    }

    private static void printTreeDetailed(BinaryTreeNode<Integer> root)
    {
        if (root==null)
        {
            return;
        }
        System.out.print(root.data+":");
        if (root.left!=null)
        {
            System.out.print("L:"+root.left.data+",");
        }
        if (root.right!=null)
        {
            System.out.print("R:"+root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    static void pairSum(BinaryTreeNode<Integer> root, int sum) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (root==null)
            return;
        else
        {
            ArrayList<Integer> arr = convertToArray(root);
            Collections.sort(arr);
            printPairSum(arr, sum);
        }
    }


    private static void printPairSum(ArrayList<Integer> arr, int s)
    {
        int i=0,j=arr.size()-1;
        while(i<j)
        {
            int val1=arr.get(i);
            int val2=arr.get(j);
            if (val1+val2>s)
            {
                j=j-1;
            }
            else if(val1+val2<s)
            {
                i=i+1;
            }
            else
            {
                System.out.println(val1+" "+val2);
                i=i+1;
                j=j-1;
            }

        }
    }
    private static ArrayList<Integer> convertToArray(BinaryTreeNode<Integer> root)
    {
        if (root==null)
        {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            return arr;
        }


        ArrayList<Integer> currArr = new ArrayList<Integer>();
        ArrayList<Integer> leftArr = convertToArray(root.left);
        if (!leftArr.isEmpty())
        {
            currArr.addAll(leftArr);
        }

        currArr.add(root.data);

        ArrayList<Integer> rightArr = convertToArray(root.right);
        if (!rightArr.isEmpty())
        {
            currArr.addAll(rightArr);
        }
        return currArr;
    }

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        // Write your code here

        return !isSiblings(root, p, q) && level(root, 0, p) == level(root, 0, q);


    }
    public static boolean isSiblings(BinaryTreeNode<Integer> root,int node1,int node2) {

        if(root==null) {
            return false;
        }
        if(root.left!=null && root.right!=null) {

            if(root.left.data == node1 && root.right.data == node2) {
                return true;
            }

        }
        return isSiblings(root.left, node1, node2) || isSiblings(root.right, node1, node2);

    }
    public static int level(BinaryTreeNode<Integer> root,int k,int node1) {

        if(root==null)
            return -1;
        if(root.data == node1) {
            return k;
        }
        int left  = level(root.left, k+1, node1);
        int right = level(root.right, k+1, node1);
        if(left==-1) {
            return right;
        }
        if(right==-1) {
            return left;
        }

        return -1;

    }
}
