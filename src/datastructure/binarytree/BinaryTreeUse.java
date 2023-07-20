package datastructure.binarytree;

import java.util.*;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeInput(Scanner scanner){
        int rootData;
        System.out.println("Enter root data.");
        rootData=scanner.nextInt();
        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
        root.left=takeInput(scanner);
        root.right=takeInput(scanner);
        return root;
    }

    public static void printBinaryTree(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }

        String toBePrinted=root.data + " ";
        if(root.left!=null){
            toBePrinted+= "L:"+ root.left.data + ",";
        }

        if(root.right!=null){
            toBePrinted+="R:"+ root.right.data + ",";
        }
        System.out.println(toBePrinted);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc=new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();
        System.out.println("Enter root data.");
        int rootData=sc.nextInt();
        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
            System.out.println("Enter left child of " +frontNode.data);
            int leftChild= sc.nextInt();
            if(leftChild!=-1){
                BinaryTreeNode<Integer> leftChildNode=new BinaryTreeNode<>(leftChild);
                pendingNodes.add(leftChildNode);
                frontNode.left=leftChildNode;
            }
            System.out.println("Enter right child of " +frontNode.data);
            int rightChild= sc.nextInt();
            if(rightChild!=-1){
                BinaryTreeNode<Integer> rightChildNode=new BinaryTreeNode<>(rightChild);
                pendingNodes.add(rightChildNode);
                frontNode.right=rightChildNode;
            }
        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.data + ":");

            if (node.left != null) {
                System.out.print("L:" + node.left.data);
                queue.add(node.left);
            } else {
                System.out.print("L:-1");
            }

            if (node.right != null) {
                System.out.print(",R:" + node.right.data);
                queue.add(node.right);
            } else {
                System.out.print(",R:-1");
            }

            System.out.println();
        }
    }

    public static int countNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int count=1;
        count+=countNodes(root.left);
        count+=countNodes(root.right);
        return count;
    }

    public static int getSum(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null){
            return 0;
        }
        int ans=root.data;
        ans+=getSum(root.left);
        ans+=getSum(root.right);
        return ans;
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }

        return isNodePresent(root.left,x) || isNodePresent(root.right,x);

    }

    public static int height(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null){
            return 0;
        }

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return 1+ Math.max(leftHeight, rightHeight);
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if(root==null){
            return 0;
        }

        int count=0;
        if(root.data>x){
            count++;
        }

        count +=countNodesGreaterThanX(root.left,x);
        count +=countNodesGreaterThanX(root.right,x);
        return count;
    }

    public static int numberOfLeafNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }

        if(root.left==null&& root.right==null){
            return 1;
        }
        return numberOfLeafNodes(root.left)+ numberOfLeafNodes(root.right);
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root,int k){
        if(root==null){
            return;
        }

        if(k==0){
            System.out.println(root.data);
            return;
        }
        printAtDepthK(root.left,k-1);
        printAtDepthK(root.right,k-1);
    }

    public static BinaryTreeNode<Integer> replaceNodeWithDepth(BinaryTreeNode<Integer> root){
       changeToDepthTree(root,0);
       return root;
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root,int depth) {
        //Your code goes here
        if(root==null){
            return;
        }
        root.data=depth;
        changeToDepthTree(root.left,depth+1);
        changeToDepthTree(root.right,depth+1);

    }

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
        } else if (root.left != null) {
            System.out.print(root.left.data + " ");
            printNodesWithoutSibling(root.left);
        } else if (root.right != null) {
            System.out.print(root.right.data + " ");
            printNodesWithoutSibling(root.right);
        }
    }

    class Pair{
        public int height;
        public int diameter;
    }
    public  int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        //Your code goes here
        Pair output=findDiameter(root);
        return output.diameter +1;
    }

    public  Pair findDiameter(BinaryTreeNode<Integer> root){
        Pair output=new Pair();
        if(root==null){
            output.height=0;
            output.diameter=0;
            return output;
        }

        Pair leftOutput=findDiameter(root.left);
        Pair rightOutput=findDiameter(root.right);
        int height= 1+Math.max(leftOutput.height, rightOutput.height);
        int option1= leftOutput.height+rightOutput.height;
        int option2= leftOutput.diameter;
        int option3= rightOutput.diameter;
        int diameter=Math.max(option1, Math.max(option2, option3));
        output.height=height;
        output.diameter=diameter;
        return output;

    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        //Your code goes here
        if (root == null) {
            return;
        }

        // Swap the left and right children of the current node
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively mirror the left and right subtrees
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

    }

    public static void preOrder(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public void inorderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    //build tree using preorder and inorder

    public static BinaryTreeNode<Integer> buildTreePreIn(int[] preOrder, int[] inOrder) {
        //Your code goes here
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inorderMap.put(inOrder[i], i);
        }

        // Construct the tree using preorder and inorder arrays
        return buildTreeHelperPreIn(preOrder, inOrder, 0, 0, inOrder.length - 1, inorderMap);
    }

    private static BinaryTreeNode buildTreeHelperPreIn(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd,
                                                  HashMap<Integer, Integer> inorderMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        // Create the root node using the current element from the preorder array
        BinaryTreeNode root = new BinaryTreeNode(preorder[preStart]);

        // Find the index of the root node in the inorder array
        int inIndex = inorderMap.get(root.data);

        // Construct the left and right subtrees recursively
        root.left = buildTreeHelperPreIn(preorder, inorder, preStart + 1, inStart, inIndex - 1, inorderMap);
        root.right = buildTreeHelperPreIn(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd, inorderMap);

        return root;
    }

    //
    public static BinaryTreeNode<Integer> buildTreePostIn(int[] postOrder, int[] inOrder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inorderMap.put(inOrder[i], i);
        }

        // Construct the tree using postorder and inorder arrays
        return buildTreeHelperPostIn(inOrder, postOrder, 0, inOrder.length - 1, postOrder.length - 1, inorderMap);
    }

    private static BinaryTreeNode buildTreeHelperPostIn(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd,
                                                  HashMap<Integer, Integer> inorderMap) {
        if (inStart > inEnd || postEnd < 0) {
            return null;
        }

        // Create the root node using the current element from the postorder array
        BinaryTreeNode root = new BinaryTreeNode(postorder[postEnd]);

        // Find the index of the root node in the inorder array
        int inIndex = inorderMap.get(root.data);

        // Construct the right and left subtrees recursively
        root.right = buildTreeHelperPostIn(inorder, postorder, inIndex + 1, inEnd, postEnd - 1, inorderMap);
        root.left = buildTreeHelperPostIn(inorder, postorder, inStart, inIndex - 1, postEnd - (inEnd - inIndex) - 1, inorderMap);

        return root;
    }



    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root==null)
            return;

        BinaryTreeNode<Integer> duplicateNode = new BinaryTreeNode<Integer>(root.data);
        //duplicateNode.data=root.data;
        BinaryTreeNode<Integer> temp=root.left;
        root.left=duplicateNode;
        duplicateNode.left=temp;
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
    }

    public static class Pair1<T, U> {
        T minimum;
        U maximum;

        public Pair1(T minimum, U maximum) {
            this.minimum = minimum;
            this.maximum = maximum;
        }

    }
    private static Pair1<Integer,Integer> maxMin=new Pair1<Integer,Integer>(Integer.MAX_VALUE,Integer.MIN_VALUE);


    public static Pair1<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        //Your code goes here
        getMinAndMaxHelper(root);
        return maxMin;
    }

    private static void getMinAndMaxHelper(BinaryTreeNode<Integer> root)
    {
        if (root==null)
        {
            return;
        }

        int rootData=root.data;
        int maxVal=maxMin.maximum;
        if (rootData>maxVal)
        {
            maxMin.maximum=root.data;
        }

        int minVal=maxMin.minimum;
        if (rootData<minVal)
        {
            maxMin.minimum=root.data;
        }
        getMinAndMaxHelper(root.left);
        getMinAndMaxHelper(root.right);
    }

    public static void printLevelWise2(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {

            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode current = queue.poll();
                System.out.print(current.data + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            System.out.println();
        }
    }


    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        //Your code goes here
        String arr="";
        rootToLeafPathsSumToK(root,k,arr);
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k,String arr)
    {
        if (root==null)
        {
            return;
        }

        int rootData=root.data;

        arr=arr+rootData+" ";
        if(k==rootData && root.left==null && root.right==null)
        {

            System.out.println(arr);
            return;
        }

        rootToLeafPathsSumToK(root.left,k-rootData,arr);
        rootToLeafPathsSumToK(root.right,k-rootData,arr);
    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        //Your code goes here
        print(root, node, k);
    }
    private static int print(BinaryTreeNode<Integer> root, int node, int k)
    {
        //If tree is empty return -1
        if (root==null)
            return -1;

        int rootData=root.data;
        if (rootData==node)
        {
            printNodesAtDistanceK(root, k);
            return 0;
        }

        int leftSubTreeDist=0,rightSubTreeDist=0;

        leftSubTreeDist=print(root.left,node,k);
        if (leftSubTreeDist!=-1)
        {
            if(leftSubTreeDist+1==k)
            {
                System.out.println(rootData);
            }
            else
            {
                rightSubTreeDist=k-(leftSubTreeDist+1)-1;
                printNodesAtDistanceK(root.right, rightSubTreeDist);
            }
            return leftSubTreeDist+1;
        }

        rightSubTreeDist=print(root.right,node,k);
        if (rightSubTreeDist!=-1)
        {
            if(rightSubTreeDist+1==k)
            {
                System.out.println(rootData);
            }
            else
            {
                leftSubTreeDist=k-(rightSubTreeDist+1)-1;
                printNodesAtDistanceK(root.left, leftSubTreeDist);
            }
            return rightSubTreeDist+1;
        }
        return -1;
    }

    private static void printNodesAtDistanceK(BinaryTreeNode<Integer> root, int k)
    {
        if (root==null || k<0)
            return;

        if (k == 0)
        {
            System.out.println(root.data);
            return;
        }

        printNodesAtDistanceK(root.left,k-1);
        printNodesAtDistanceK(root.right,k-1);
    }

    static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

        if(root==null){
            return -1;
        }
        if(root.data==a || root.data==b){
            return  root.data;
        }
        int lca = getLCA(root.left, a, b);
        int lca1 = getLCA(root.right, a, b);

        if(lca==-1 && lca1==-1){
            return -1;
        } else if (lca==-1) {
            return lca1;
        } else if (lca1==-1) {
            return lca;
        }else{
            return root.data;
        }
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

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
        // Write your code here
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(root.data);
            return ans;
        }

        ArrayList<Integer> leftAns = longestRootToLeafPath(root.left);
        ArrayList<Integer> rightAns = longestRootToLeafPath(root.right);

        if(leftAns == null){
            rightAns.add(root.data);
            return rightAns;
        }

        if(rightAns == null){
            leftAns.add(root.data);
            return leftAns;
        }

        if(leftAns.size() > rightAns.size()){
            leftAns.add(root.data);
            return leftAns;
        }else{
            rightAns.add(root.data);
            return rightAns;
        }

    }

    public static void main(String[] args) {
//      BinaryTreeNode<Integer> root=new BinaryTreeNode<>(2);
//      BinaryTreeNode<Integer> leftChild=new BinaryTreeNode<>(3);
//      root.left=leftChild;
//      BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<>(4);
//      root.right=rightChild;

       // BinaryTreeNode<Integer> binaryTreeNode = takeInput(new Scanner(System.in));
        BinaryTreeNode<Integer> binaryTreeNode = takeInputLevelWise();
        printBinaryTree(binaryTreeNode);
        System.out.println();
        int nodes = countNodes(binaryTreeNode);
        System.out.println(nodes);
        int sum = getSum(binaryTreeNode);
        System.out.println(sum);

    }
}
