package test2;

/*A leader element is an element in the array such that all the elements to its right are smaller than it.*/
public class LeadersInAnArray {
    public static void leaders(int[] input) {
        int i;
        int j;

        for(i=0;i<input.length-1;i++){
            for(j=i+1;j<input.length;j++){
                if(input[i]<input[j]){
                    break;
                }
            }
            if(j==input.length){
                System.out.print(input[i]+" ");
            }
        }
        System.out.print(input[input.length-1]);

    }
    public static void main(String[] args) {
        int[] arr={13,24,4,5,6,7};
        leaders(arr);
    }
}
