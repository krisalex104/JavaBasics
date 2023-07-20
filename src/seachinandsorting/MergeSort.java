package seachinandsorting;

import java.util.Scanner;

public class MergeSort {
//for sorted arrays
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public  static int[] mergeSort(int[] arr1,int[] arr2){
        int length=arr1.length+ arr2.length;
        int[] arr3=new int[length];
        int i=0;
        int j=0;
        int k=0;
        while(i< arr1.length && j< arr2.length){
            if(arr1[i]<arr2[j]){
                arr3[k]=arr1[i];
                i++;
                k++;
            }else{
                arr3[k]=arr2[j];
                k++;
                j++;
            }
        }
        while(i< arr1.length){
            arr3[k]=arr1[i];
            k++;
            i++;
        }

        while(j<arr2.length){
            arr3[k]=arr2[j];
            k++;
            j++;
        }
        return arr3;
    }

    public static void main(String[] args) {
        int[] arr1 = takeInput();
        int[] arr2=takeInput();
        int[] sort = mergeSort(arr1, arr2);
        for(int i=0;i< sort.length;i++){
            System.out.print(sort[i] + " ");
        }
    }
}
