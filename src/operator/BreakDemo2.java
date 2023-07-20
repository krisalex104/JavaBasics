package operator;

public class BreakDemo2 {
    public static void main(String[] args) {
        for(int i=1;;i++)
        {   if(i==5)
            break;
            System.out.print(i);
        }

        System.out.println();

        for(int i=1;;i++)
        {   if(i<5)
            System.out.print(i);
        else
            break;
        }

        System.out.println();

        int i = 1;
        while(i < 5) {
            if(i == 3) {
                break;
            }
            System.out.print(i + " ");
            i++;
        }

        System.out.println();

         i = 1;
        while(i < 3) {
            int j = 0;
            while(j < 5) {
                j++;
                if(j == 3) {
                    continue;
                }
                System.out.print(j + " ");
            }
            i++;
        }
    }
}
