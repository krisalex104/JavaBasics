package arrays_2d;

public class Demo1 {
    public static void main(String[] args) {
        int[][] arr = new int [2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        int[][] arr1 = { { 1, 2 }, { 3, 4 } };
        System.out.println(arr1[0][0]+arr1[1][1]);

        int arr2[][]=new int [4][];
        System.out.print(arr2[2].length);
    }
}
