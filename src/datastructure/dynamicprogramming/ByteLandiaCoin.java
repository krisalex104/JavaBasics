package datastructure.dynamicprogramming;

/*
*Byteland has a very strange monetary system.
*Each Bytelandian gold coin has an integer number written on it.
*A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4.
*But these numbers are all rounded down (the banks have to make a profit).
*You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1.
* But you can not buy Bytelandian coins.
*You have one gold coin. What is the maximum amount of American dollars you can get for it?*/

import java.util.HashMap;

public class ByteLandiaCoin {

    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        // Write your code here
        if (n<=1)
        {
            memo.put(n,n);
            return n;
        }

        if (!memo.containsKey(n))
        {
            long ans1=bytelandian(n/2,memo);
            long ans2=bytelandian(n/3,memo);
            long ans3=bytelandian(n/4,memo);

            long currVal=ans1+ans2+ans3;
            if (currVal>n)
                memo.put(n,currVal);
            else
                memo.put(n,n);

        }

        return memo.get(n);
    }

    public static long bytelandianM(long n, HashMap<Long, Long> memo) {
        memo.put((long)0,(long)0);
        memo.put((long)1,(long)1);

        for (int i=2;i<=n;i++)
        {
            long ans1=memo.get(i/2);
            long ans2=memo.get(i/3);
            long ans3=memo.get(i/4);

            long currentVal=ans1+ans2+ans3;
            if (currentVal>i)
            {
                memo.put((long)i,currentVal);
            }
            else
            {
                memo.put((long)i,(long)i);
            }
        }

        return memo.get(n);
    }

    public static void main(String[] args) {

    }
}
