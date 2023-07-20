package recursion;

public class GeometricSum {
    public static double findGeometricSum(int k){
        // Write your code here
        if(k==0){
            return 1;
        }
        double smallAnswer = findGeometricSum(k - 1) + (1/Math.pow(2,k)) ;
        return smallAnswer;

    }
    public static void main(String[] args) {
        double geometricSum = findGeometricSum(3);
        System.out.println(geometricSum);
    }
}
