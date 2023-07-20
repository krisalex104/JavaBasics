package recursion.assignment;

public class QuickSort {


    public static void quickSort(int[] input) {
       quickSort(input,0, input.length-1);
    }
    private static void quickSort(int[] input,int startIndex,int endIndex) {
        if(startIndex>=endIndex){
            return;
        }
        int pivotElementPosition = partition(input, startIndex, endIndex);
        quickSort(input,startIndex,pivotElementPosition-1);
        quickSort(input,pivotElementPosition+1,endIndex);

    }

   private static int partition(int[] input,int startIndex,int endIndex){
        int p=input[startIndex];
        int count=0;
        for(int i=startIndex+1;i<=endIndex;i++){
            if (input[i] <= p) {
                count++;
            }
        }

        int pivotPosition=startIndex+count;
        int temp=input[startIndex];
        input[startIndex]=input[pivotPosition];
        input[pivotPosition]=temp;
        int i=startIndex;
        int j=endIndex;

        while (i<pivotPosition && j>pivotPosition){
            if (input[i] <= input[pivotPosition]) {
              i++;
            } else if (input[j]>input[pivotPosition]) {
                j--;
            }else{
                int temp1=input[i];
                input[i]=input[j];
                input[j]=temp1;
                i++;j--;
            }
        }
      return pivotPosition;
   }
    public static void main(String[] args) {
      int []arr={10,4,5,6,3,7,9,19};
      quickSort(arr);
      for (int i=0;i<arr.length;i++){
          System.out.print(arr[i] +" ");
      }
    }
}
