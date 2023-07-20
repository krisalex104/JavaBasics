package test2;


import java.util.Scanner;

/*Given a 2D integer array with n rows and m columns.
Print the 0th row from input n times, 1st row n-1 times…..(n-1)th row will be printed 1 time.


Input format :
Line 1 : No of rows (n) and no of columns (m) (separated by single space)
Line 2 : Row 1 elements (separated by space)
Line 3 : Row 2 elements (separated by space)
Line 4 : and so on

Sample Input 1:
3 3
1 2 3
4 5 6
7 8 9

Sample Output 1 :
1 2 3
1 2 3
1 2 3
4 5 6
4 5 6
7 8 9

*/
public class Print2DArray {

    public static int[][] takeInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("number of rows");
        int rows=sc.nextInt();
        System.out.println("number of columns");
        int columns=sc.nextInt();
        int[][] input =new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.println("Enter element at "+i+" row "+j+" column");
                input[i][j]=sc.nextInt();
            }
        }
        return input;
    }

    public static void print2DArray(int input[][]) {
        // Write your code here
        if(input.length==0){
            return;
        }
        int rows= input.length;;
        int cols=input[0].length;
        for(int i=0;i<rows;i++){
            int n=input.length-i;
            for(int k=0;k<n;k++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(input[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int[][] ints = takeInput();
        print2DArray(ints);
    }
}
