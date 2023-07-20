package datastructure.graphs;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{

    public int source;
    public int destination;
    public int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}
public class KruskalAlgorithm {

    //for minimum spanning tree :- which don't have cycle and have n-1 edges

    public static  int findParent(int v,int []parent){
        if(parent[v]==v){
            return v;
        }
        return findParent(parent[v],parent);
    }
    public static void kruskals(Edge[] input,int n){
        Arrays.sort(input);
        Edge []output=new Edge[n-1];
        int []parent=new int[n];
        //let parent[i] be the same as i
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int count=0;
        int i=0;
        while(count!=n-1){
            Edge currentEdge=input[i];
            int sourceParent=findParent(currentEdge.source,parent);
            int destinationParent=findParent(currentEdge.destination,parent);
            if(sourceParent!=destinationParent){
                output[count]=currentEdge;
                count++;
                parent[sourceParent]=destinationParent;
            }
            i++;
        }
        for(int j=0;j<n-1;j++){
            if(output[j].source<output[j].destination){
                System.out.println(output[j].source+ " " +output[j].destination+ " "+output[j].weight);
            }else{
                System.out.println(output[j].destination+ " " +output[j].source+ " "+output[j].weight);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int e= sc.nextInt();
        Edge[] input=new Edge[e];
        for(int i=0;i<e;i++){
            Edge edge=new Edge();
            edge.source=sc.nextInt();
            edge.destination=sc.nextInt();
            edge.weight=sc.nextInt();
            input[i]=edge;
        }
        kruskals(input,n);
    }
}
