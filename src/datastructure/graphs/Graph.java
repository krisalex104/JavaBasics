package datastructure.graphs;

import java.util.*;

public class Graph {

    public static void printDfs(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printDfsHelper(edges, i, visited);
            }
        }
    }

    public static void printDfsHelper(int[][] edges, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;
        int edge = edges.length;
        for (int i = 0; i < edge; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                printDfsHelper(edges, i, visited);
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            if (map.containsKey(sv)) {
                map.put(sv, map.get(sv) + 1);
            } else {
                map.put(sv, 0);
            }
        }
    }

    public static void printBfs(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printBfsHelper(edges, i, visited);
            }
        }
    }

    public static void printBfsHelper(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        int n = edges.length;
        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.println(front);
            for (int i = 0; i < n; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static boolean hasPath(int[][] edges, int v1, int v2, HashMap<Integer, Integer> map) {
        if (!map.containsKey(v1) || !map.containsKey(v2)) {
            return false;
        }
        boolean[] visited = new boolean[edges.length];
        return hasPathDfs(edges, v1, v2, visited);
    }

    public static boolean hasPathDfs(int[][] edges, int start, int end, boolean[] visited) {
        if (edges[start][end] == 1) {
            return true;
        }
        visited[start] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[start][i] == 1 && !visited[i]) {
                if (hasPathDfs(edges, i, end, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathBfs(int[][] edges, int V1, int V2, boolean[] visited) {
        if (V1 > edges.length || V2 > edges.length) {
            return false;
        }
        if (edges[V1][V2] == 1)
            return true;
        Queue<Integer> q = new LinkedList<>();
        q.add(V1);
        visited[V1] = true;
        while (!q.isEmpty()) {
            int n = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (edges[n][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        if (visited[V2] == true)
            return true;
        else
            return false;
    }

    public static ArrayList<Integer> getPathDfs(int[][] edges, int start, int end, boolean[] visited) {
        if (start == end) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            visited[start] = true;
            arrayList.add(start);
            return arrayList;
        }
        visited[start] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[start][i] == 1 && !visited[i]) {
                ArrayList<Integer> pathHelper
                        = getPathDfs(edges, i, end, visited);
                if (!pathHelper.isEmpty()) {
                    pathHelper.add(start);
                    visited[i] = true;
                    return pathHelper;
                }
            }
        }
        return null;
    }

    public static ArrayList<Integer> getPathBfs(int[][] edges, int start, int end, boolean[] visited) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (start == end) {
            visited[start] = true;
            arrayList.add(start);
            return arrayList;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> pendingVertices = new LinkedList<>();
        visited[start] = true;
        pendingVertices.add(start);
        while (!pendingVertices.isEmpty()) {
            Integer currentVertex = pendingVertices.poll();
            for (int i = 0; i < edges.length; i++) {
                if (edges[currentVertex][i] == 1 && !visited[i]) {
                    pendingVertices.add(i);
                    visited[i] = true;
                    map.put(i, currentVertex);

                    if (i == end) {
                        arrayList.add(i);
                        while (!arrayList.contains(start)) {
                            Integer value = map.get(i);
                            arrayList.add(value);
                            i = value;
                        }
                        return arrayList;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isConnectedDfs(){
        int v;
        int e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        if(v==0){
            return true;
        }
        int edges[][] = new int[v][v];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
            if (map.containsKey(fv)) {
                map.put(fv, map.get(fv) + 1);
            } else {
                map.put(fv, 0);
            }
            if (map.containsKey(sv)) {
                map.put(sv, map.get(sv) + 1);
            } else {
                map.put(sv, 0);
            }
        }
        boolean[] visited = new boolean[edges.length];
        boolean b1=	isConnectedDfsHelper(edges,0,visited);
        return b1;
    }

    public static boolean isConnectedDfsHelper(int [][]edges,int sv,boolean[] visited){
        visited[sv] = true;
        int edge = edges.length;
        for (int i = 0; i < edge; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                isConnectedDfsHelper(edges, i, visited);
            }
        }
        for(int i=0;i< visited.length;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public static void connectedComponents(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        ArrayList<Integer> arrayList =new ArrayList<>();
        ArrayList<ArrayList<Integer>> components =new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                arrayList =new ArrayList<>();
                arrayList=connectedComponentsHelper(edges, i, visited,arrayList);
                Collections.sort(arrayList);
                components.add(arrayList);
            }
        }

        for(int j=0;j<components.size();j++){
            ArrayList<Integer> arr=components.get(j);
            for(Integer num:arr){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static ArrayList<Integer> connectedComponentsHelper(int [][]edges,int sv,boolean[] visited,ArrayList<Integer> arrayList){
        arrayList.add(sv);
        visited[sv] = true;
        int edge = edges.length;
        for (int i = 0; i < edge; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                connectedComponentsHelper(edges, i, visited,arrayList);
            }
        }
        return arrayList;
    }

    public static int numConnected(int[][] edges, int n) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        boolean[] visited = new boolean[edges.length];
        ArrayList<Integer> arrayList =new ArrayList<>();
        ArrayList<ArrayList<Integer>> components =new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                arrayList =new ArrayList<>();
                arrayList=connectedComponentsHelper(edges, i, visited,arrayList);
                components.add(arrayList);
            }
        }

        return components.size();
    }

    /**
     * Given a NxM matrix containing Uppercase English Alphabets only.
     * Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
     * There is a path from any cell to all its neighbouring cells. For a particular cell,
     * neighbouring cells are those cells that share an edge or a corner with the cell.
     *
     */

    int solve(String[] Graph , int N, int M)
    {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        String searchingString = "CODINGNINJA";
        boolean[][] visited = new boolean[Graph.length][];
        for(int i = 0; i < Graph.length; i++) { //Graph.length gives the number of rows, Graph[i].length give sthe number of columns per row
            visited[i] = new boolean[Graph[i].length()];
        }
        for(int i = 0; i < Graph.length; i++) {
            for(int j = 0; j < Graph[i].length(); j++) {
                if(Graph[i].charAt(j) == 'C' ) {

                    boolean ans =  dfs( Graph,visited,searchingString.substring(1),i,j);
                    if(ans) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean dfs(String[] graph, boolean[][] visited, String searchString,int i,int j) {
        if(searchString.length() == 0) {
            visited[i][j] = true;
            return true;
        }
        visited[i][j] = true;
        // To traverse in 8 different directions
        int[] X_Dir = {-1, 1, 0, 0, 1, -1, 1, -1 };
        int[] Y_Dir = {0, 0, -1, 1, 1, -1, -1, 1 };
        for(int k = 0; k < X_Dir.length; k++) {
            int x = i + X_Dir[k];
            int y = j + Y_Dir[k];
            if( x >= 0 && y >= 0 && x < graph.length &&
                    y < graph[x].length() &&
                    graph[x].charAt(y) == searchString.charAt(0) && !visited[x][y]  ) {


                boolean smallAns = dfs(graph, visited, searchString.substring(1), x, y);
                if(smallAns) {
                    return smallAns;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    /**
     * 3 CYCLE
     *
     * Given a graph with N vertices (numbered from 0 to N-1) and M undirected edges,
     * then count the distinct 3-cycles in the graph.
     * A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.
     */

    public static int solve(boolean[][] graph, int n) {
        /*
         * Your class should be named Solution
         * You may write your code here
         */
        int count = 0;
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph.length; j++) {
                if(graph[i][j] == true) {
                    for(int k = 0; k < graph.length; k++) {
                        if(k != i && graph[k][j] == true && graph[i][k] == true ) {
                            count++;
                        }
                    }
                }
            }
        }
        return count/6;
    }

    /**
     * LARGEST PIECE
     *
     * It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's .
     * But Gary wants the biggest piece of '1's and no '0's .
     * A piece of cake is defined as a part which consist of only '1's, and all '1's share an
     * edge with each other on the cake.
     * Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
     */
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int dfs(String[] edge, int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        boolean[][] visited = new boolean[n][n];
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && edge[i].charAt(j) == '1' ){
                    int ans = max1s( edge, visited, i, j, n);
                    if(max < ans){
                        max = ans;
                    }
                }
            }
        }
        return max;
    }
    public static int max1s(String[] edge, boolean[][] visited, int x, int y, int n){
        int[] X_dir = {0, 1, -1, 0}; //we are moving in all 4 directions, top, right, down ,left, these are coordinates for these only
        int[] Y_dir = {1, 0, 0, -1}; //these are y coordinates for mo
        int max = 0;
        visited[x][y] = true;
        for(int i=0; i<X_dir.length; i++){


            int a = X_dir[i] + x;
            int b = Y_dir[i] + y;


            if(a >= 0 && b >= 0 && a < n &&
                    b < n && edge[a].charAt(b) =='1'
                    && !visited[a][b] ){


                int ans = max1s(edge, visited, a, b, n);
                max = max + ans;
            }
        }
        return max + 1;
    }


    /**
     * CONNECTING DOTS
     *
     * Gary has a board of size NxM. Each cell in the board is a coloured dot.
     * There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z).
     * Now Gary is getting bored and wants to play a game. The key of this game is to find a
     * cycle that contain dots of same colour.
     * Formally, we call a sequence of dots d1,d2,...,dk
     * a cycle if and only if it meets the following condition:
     */

    int connectingDots(String[] board , int n, int m)
    {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    if(hasCycle(board, -1, -1, i, j, visited) == 1) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    public static int hasCycle(String[] board, int fromX, int fromY, int i, int j, boolean[][] visited) {
        if(visited[i][j]) {
            return 1;
        }
        int[] X_dir = {1, 0, 0, -1};
        int[] Y_dir = {0, 1, -1, 0};
        visited[i][j] = true;
        for(int l = 0; l < X_dir.length; l++) {
            int x = X_dir[l] + i;
            int y = Y_dir[l] + j;
            if(x == fromX && y == fromY) {
                continue;
            }
            if(x >= 0 && y >= 0 && x < board.length && y < board[x].length() && board[x].charAt(y) == board[i].charAt(j)) {
                int ans = hasCycle(board, i, j, x, y, visited);
                if(ans == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {


        int v;
        int e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        int edges[][] = new int[v][v];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
            if (map.containsKey(fv)) {
                map.put(fv, map.get(fv) + 1);
            } else {
                map.put(fv, 0);
            }
            if (map.containsKey(sv)) {
                map.put(sv, map.get(sv) + 1);
            } else {
                map.put(sv, 0);
            }
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        boolean[] visited = new boolean[edges.length];
        if (!map.containsKey(v1) || !map.containsKey(v2)) {
            return;
        }
        boolean path = hasPathBfs(edges, v1, v2, visited);
        System.out.println(path);

        ArrayList<Integer> pathHelper = getPathDfs(edges, v1, v2, visited);
        if (pathHelper != null) {
            for (Integer num : pathHelper) {
                System.out.print(num + " ");
            }
        }

        ArrayList<Integer> pathBfs = getPathBfs(edges, v1, v2, visited);
        if (pathBfs != null) {
            for (Integer num : pathBfs) {
                System.out.print(num + " ");
            }
        }

       connectedComponents(edges);


    }
}
