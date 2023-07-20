package recursion;

public class FirstIndex {

    public static int firstIndex(int input[], int x) {

        int index = firstIndex(input, x, 0);
         return index;
    }

    private static int firstIndex(int input[], int x,int startIndex){
        if(startIndex<input.length-1 && input.length>0){
            if(input[startIndex]==x){
                return startIndex;
            }else{
                int firstIndex = firstIndex(input, x, startIndex + 1);
                return firstIndex;
            }
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int []input={4,3,6,3,9};
        int x=3;
        int firstIndex = firstIndex(input, x);
        System.out.println(firstIndex);
    }
}
