package datastructure.graphs;

import java.util.Scanner;

public class PrimsAlgorithm {

    public static int findMinVertex(int[] weight,boolean []visited){
        int minVertex=-1;
        for(int i=0;i<weight.length;i++){
            if(!visited[i] && (minVertex==-1 || weight[i]<weight[minVertex])){
                minVertex=i;
            }
        }
        return minVertex;
    }
    public static  void prims(int [][]matrix){
        int n=matrix.length;
        boolean []visited=new boolean[n];
        int []parent=new int[n];
        int []weight=new int[n];
        weight[0]=0;
        parent[0]=-1;
        for(int i=1;i<n;i++){
            weight[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            //pick vertex with min weight
            int minVertex=findMinVertex(weight,visited);
            visited[minVertex]=true;
            //explore all unvisited neighbours
            for(int j=0;j<n;j++){
                if(matrix[minVertex][j]!=0 && !visited[j]){
                    if(matrix[minVertex][j]<weight[j]){
                        weight[j]=matrix[minVertex][j];
                        parent[j]=minVertex;
                    }
                }
            }

        }
        for(int k=1;k<n;k++){
            if(parent[k]<k){
                System.out.println(parent[k]+ " "+k+ " "+weight[k]);
            }else{
                System.out.println(k+ " "+parent[k]+ " "+weight[k]);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int e= sc.nextInt();
        int [][]adjacencyMatrix=new int[n][n];
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int w=sc.nextInt();
            adjacencyMatrix[v1][v2]=w;
        }
        prims(adjacencyMatrix);
    }
}
