package recursion.assignment;

public class MergeSort {
    public static void mergeSort(int[] input){
       mergeSort(input,0,input.length-1);
    }

    private static void mergeSort(int[] input,int sI,int eI ){
        if(sI>=eI){
            return;
        }
        int mid=(sI+eI)/2;
        mergeSort(input,sI,mid);
        mergeSort(input,mid+1,eI);
        merge(input,sI,eI);

    }

    private static void merge(int[] input,int sI,int eI ){
        int mid=(sI+eI)/2;

        int[] arr3=new int[eI-sI+1];
        int i=sI;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=eI){
            if(input[i]<input[j]){
                arr3[k]=input[i];
                i++;
                k++;
            }else{
                arr3[k]=input[j];
                k++;
                j++;
            }
        }
        while(i<= mid){
            arr3[k]=input[i];
            k++;
            i++;
        }

        while(j<=eI){
            arr3[k]=input[j];
            k++;
            j++;
        }
        for(int l=0;l<arr3.length;l++){
            input[sI+l]=arr3[l];
        }
    }
    public static void main(String[] args) {
        int []arr={4,5,2,3,4,5,8,9,1,4};
        mergeSort(arr);
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i] +"");
        }

    }
}
