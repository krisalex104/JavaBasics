package datastructure.tree.assignment;

import datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AssignmentClass {

    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data ");
        int rootData = sc.nextInt();
        Queue<TreeNode<Integer>> pendingNode = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNode.add(root);
        while (!pendingNode.isEmpty()) {
            TreeNode<Integer> frontNode = pendingNode.poll();
            System.out.println("Enter number of children for " + frontNode.data);
            int numChildren = sc.nextInt();
            for (int i = 0; i < numChildren; i++) {
                System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
                int child = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(child);
                frontNode.children.add(childNode);
                pendingNode.add(childNode);
            }
        }
        return root;
    }
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

        // Write your code here
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        for (TreeNode child : root.children) {
            if (checkIfContainsX(child, x)) {
                return true;
            }
        }
        return false;

    }
    private static TreeNode maxNode;
    private static int maxSum = Integer.MIN_VALUE;

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        // Write your code here


        if (root == null) {
            return null;
        }
        int sum = root.data;
        for (TreeNode child : root.children) {
            int childData=(int)child.data;
            sum =sum + childData;
        }
        if (sum > maxSum) {
            maxSum = sum;
            maxNode = root;
        }
        for (TreeNode child : root.children) {
            maxSumNode(child);
        }
        return maxNode;
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

        // Write your code here
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.children.size() != root2.children.size()) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < root1.children.size(); i++) {
            if (root1.children.get(i).data != root2.children.get(i).data) {
                return false;
            }
            result &= checkIdentical(root1.children.get(i), root2.children.get(i));
        }
        return result;
    }

    static TreeNode nextLargerNode = null;
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){

        // Write your code here
        if (root == null) {
            return nextLargerNode;
        }
        if (root.data > n && (nextLargerNode == null || root.data < (int)nextLargerNode.data)) {
            nextLargerNode = root;
        }
        for (TreeNode child : root.children) {
            findNextLargerNode(child, n);
        }
        return nextLargerNode;

    }

    static TreeNode nextLargerNode1 = null;
    static TreeNode nextLargerNode2 = null;
    public static TreeNode<Integer>  findSecondNextLargerNode(TreeNode<Integer> root, int x){
        if (root == null) {
            return nextLargerNode2;
        }
        if (root.data > x) {
            if (nextLargerNode1 == null || root.data < (int)nextLargerNode1.data) {
                nextLargerNode2 = nextLargerNode1;
                nextLargerNode1 = root;
            } else if (nextLargerNode2 == null || root.data < (int)nextLargerNode2.data) {
                nextLargerNode2 = root;
            }
        }
        for (TreeNode child : root.children) {
            findNextLargerNode(child, x);
        }
        return nextLargerNode2;
    }


    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

        if(root.children.size() == 0) {

            return null;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> fl=root,sl=null;
        int data = 0;
        queue.add(root);

        while(!queue.isEmpty()) {

            TreeNode<Integer> frontNode = queue.poll();

            for(int i=0;i<frontNode.children.size();i++){

                queue.add(frontNode.children.get(i));
            }
            if(frontNode.data >  data) {

                if(frontNode.data > fl.data) {

                    sl = fl;
                    data = fl.data;
                    fl = frontNode;
                }
                else if (frontNode.data < fl.data) {

                    sl = frontNode;
                    data = sl.data;
                }
            }
        }
        return sl;
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root){

        // Write your code here
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> currNode = queue.poll();
                currNode.data = depth;
                for (TreeNode child : currNode.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }
      //replaceWithDepthHelper(root,0);
    }


    private static void replaceWithDepthHelper(TreeNode<Integer> node, int depth) {
        if (node == null) {
            return;
        }
        node.data = depth;
        for (TreeNode child : node.children) {
            replaceWithDepthHelper(child, depth + 1);
        }
    }

    public static void main(String[] args) {

    }
}
