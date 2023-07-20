package arrays.assignment;

import java.util.*;

public class IntersectionWithAscendingOrder {
    public static void intersection(int[] arr1, int[] arr2) {
        //Your code goes here
        List<Integer> intersectionList = new ArrayList<>();

        // Sorting the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;

        // Finding intersection of the two arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                intersectionList.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }

        }

        Integer []intersection=intersectionList.toArray(new Integer[0]);

        for(int k=0;k<intersection.length;k++){
            System.out.print(intersection[k] +" ");
        }

    }

    public static void main(String[] args) {

    }
}
