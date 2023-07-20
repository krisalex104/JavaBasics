package string;

public class HighestOccuringCharacter {
    public static char highestOccuringCharacter(String inputString) {
        int freq[]=new int[256];

        for(int i=0;i<inputString.length();i++)
        {
            int ch=inputString.charAt(i);
            freq[ch]=freq[ch]+1;
        }


        int largest =0;
        char indexToChar=inputString.charAt(0);
        for(int i=0;i<inputString.length();i++)
        {
            int index = inputString.charAt(i);
            if(freq[index] > largest){
                indexToChar = inputString.charAt(i);
                largest = freq[index];
            }
        }
        return indexToChar;
    }

    public static  char highestOccuringChar(String str){
        int[] freq=new int[256];
        for(int i=0;i<str.length();i++){
            int ch=str.charAt(i);
            freq[ch]=freq[ch]+1;
        }
        char ans=str.charAt(0);
        int count=freq[ans];
        for(int j=1;j<str.length();j++){
            int index=str.charAt(j);
            if(freq[index]>count){
                count=freq[index];
                ans=str.charAt(index);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
       String str="ababsbcdfa";
        char c = highestOccuringCharacter(str);
        System.out.println(c);
        char c1 = highestOccuringChar(str);
        System.out.println(c1);
    }
}
