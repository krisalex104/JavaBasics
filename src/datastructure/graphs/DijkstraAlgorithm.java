package datastructure.graphs;

import java.util.Scanner;

public class DijkstraAlgorithm {

    public static int findMinDistance(int[] distance, boolean[] visited) {
        int minDistance = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minDistance == -1 || distance[i] < distance[minDistance])) {
                minDistance = i;
            }
        }
        return minDistance;
    }

    public static void dijkstra(int[][] matrix) {
        int n = matrix.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        distance[0] = 0;
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            //pick vertex with min weight
            int minDistance = findMinDistance(distance, visited);
            visited[minDistance] = true;
            //explore all unvisited neighbours
            for (int j = 0; j < n; j++) {
                if (matrix[minDistance][j] != 0 && !visited[j] && distance[minDistance] != Integer.MAX_VALUE) {
                    int newDistance = distance[minDistance] + matrix[minDistance][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
        }

        for(int k=0;k<n;k++){
                System.out.println(k+ " "+distance[k]);
            }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            adjacencyMatrix[v1][v2] = w;
        }
        dijkstra(adjacencyMatrix);
    }
}
