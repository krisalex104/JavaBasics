package functions;

public class NcR2 {
    public static double add(int a,int b)
    {
        float c=a+b;
        return c;
    }

    public static void main (String[] args) {
        int n=10,r=6;
        int factn=1,factr=1,factnr=1;
        for(int i=2;i<=n;i++)
        {
            factn*=i;
            if(i<=r)
                factr*=i;
            if(i<=n-r)
                factnr*=i;
        }
        int ncr=factn/(factr*factnr);
        System.out.println(ncr);
        int x=7;
        System.out.println(x+12);

        System.out.println(add(10,3));
    }
}
