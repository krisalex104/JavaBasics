package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeNodeUse {

    public static TreeNode<Integer> takeInput(Scanner scanner) {
        int n;
        System.out.println("Enter next node data");
        n = scanner.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter number of children for parent/root " + n);
        int childCount = scanner.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(scanner);
            root.children.add(child);
        }
        return root;
    }

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

    public static void print(TreeNode<Integer> root) {
        String s = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }
    }

    public static void printLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        //added 1st level here
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode<Integer> frontNode = queue.remove();
            if (frontNode == null) {
                if (queue.isEmpty()) {
                    break;
                }
                System.out.println();
                queue.add(null);
            } else {
                System.out.print(frontNode.data + " ");
                for (int i = 0; i < frontNode.children.size(); i++) {
                    queue.add(frontNode.children.get(i));
                }
            }
        }
    }

    public static int numNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count += numNodes(root.children.get(i));
        }
        return count;
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.data > x) {
            count++;
        }
        for (int i = 0; i < root.children.size(); i++) {
            count += numNodeGreater(root.children.get(i), x);
        }
        return count;
    }

    public static int findLargest(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int childLargest = findLargest(root.children.get(i));
            if (childLargest > ans) {
                ans = childLargest;
            }
        }
        return ans;
    }

    public static int sumOfAllNodes(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        //added 1st level here
        queue.add(root);
        queue.add(null);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode<Integer> frontNode = queue.remove();
            if (frontNode == null) {
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            } else {
                sum += frontNode.data;
                for (int i = 0; i < frontNode.children.size(); i++) {
                    queue.add(frontNode.children.get(i));
                }
            }
        }
        return sum;
    }

    public static int getHeight(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int maxHeight = 0;
        for (TreeNode child : root.children) {
            int height = getHeight(child);
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight + 1;
    }

    public static void printAtK(TreeNode<Integer> root, int k) {
        if (k < 0 || root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.data);
        }
        for (TreeNode child : root.children) {
            printAtK(child, k - 1);
        }

    }

    public static int countOfLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.children.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (TreeNode child : root.children) {
            count += countOfLeafNodes(child);

        }
        return count;
    }

    public static void preOrderTraversal(TreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        for(TreeNode child: root.children){
            preOrderTraversal(child);
        }
    }

    public static void postOrderTraversal(TreeNode<Integer> root){
        if(root==null){
            return;
        }
        for(TreeNode child: root.children){
            postOrderTraversal(child);
        }
        System.out.print(root.data + " ");
    }

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        if (root == null)
            return null;

        if (root.children.isEmpty()) {
            // If the current node is a leaf node, return null to remove it.
            return null;
        }

        ArrayList<TreeNode<Integer>> newChildren = new ArrayList<>();
        for (TreeNode child : root.children) {
            // Recursively remove leaf nodes from each child.
            TreeNode<Integer> newChild = removeLeafNodes(child);
            if (newChild != null) {
                newChildren.add(newChild);
            }
        }

        // Update the children of the current node.
        root.children = newChildren;

        return root;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //TreeNode<Integer> nodes = takeInput(scanner);
        TreeNode<Integer> levelWise = takeInputLevelWise();
        //printLevelWise(levelWise);
        //print(nodes);
        System.out.println();
        int nodes = numNodes(levelWise);
        System.out.println(nodes);
        int sumOfAllNodes = sumOfAllNodes(levelWise);
        System.out.println(sumOfAllNodes);
        int largest = findLargest(levelWise);
        System.out.println(largest);
        int numNodeGreater = numNodeGreater(levelWise, 5);
        System.out.println(numNodeGreater);
        int countOfLeafNodes = countOfLeafNodes(levelWise);
        System.out.println(countOfLeafNodes);
        preOrderTraversal(levelWise);
        System.out.println();
        postOrderTraversal(levelWise);


    }
}
